package com.tadhack.orlandoappointment.orlandoappointment.controller;

import com.tadhack.orlandoappointment.orlandoappointment.constants.Commands;
import com.tadhack.orlandoappointment.orlandoappointment.flowroute.RecivedSMS;
import com.tadhack.orlandoappointment.orlandoappointment.flowroute.SMSSENT;
import com.tadhack.orlandoappointment.orlandoappointment.flowroute.SendSMS;
import com.tadhack.orlandoappointment.orlandoappointment.model.Customer;
import com.tadhack.orlandoappointment.orlandoappointment.service.ICustomerService;
import com.tadhack.orlandoappointment.orlandoappointment.util.ObjectToJsonEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ObjectToJsonEx objectToJsonEx;

    @Autowired
    private RestOperations restOperations;

    private int count = 1;

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String routerRedirect(@RequestBody RecivedSMS recivedSMS) {
        if(count % 2 != 0) {
            System.out.println("Home Endpoint hit");
            count++;
            findRoute(recivedSMS);
            return "Ok";
        }
        count++;
        System.out.println(count);
        return "NOT OK";
        //return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

    void findRoute(RecivedSMS recivedSMS) {
        String command =  recivedSMS.getBody().trim();
        String name = checkNameCommandRecived(recivedSMS);
        boolean categoryCommand = checkCategoryCommand(command);

        if(name == null && Commands.Hello == Commands.valueOf(command)) {
            String customerNumber = recivedSMS.getFrom();
            Customer customer = customerService.findCustomerByPhoneNumber(customerNumber);

            if(customer != null) {
                // Is Returning Customer
                String url = "http://localhost:80/returningcustomer";
                Map<String, Object> params = new HashMap<>();
                params.put("recivedSMS", recivedSMS);
                params.put("customer", customer);

                restTemplate.postForEntity(url, params, String.class);
            } else {
                // Is New Customer
                String url  = "http://localhost:80/newcustomer";
                Map<String,Object> params = new HashMap<>();
                params.put("recivedSMS", recivedSMS);

                restTemplate.postForObject(url, recivedSMS,String.class);
            }
        }
        //String name = checkNameCommandRecived(recivedSMS);
        else if (name != null) {
            Customer customer = new Customer();
            customer.setFirstName(name);
            customer.setPhoneNumber(recivedSMS.getFrom());
            customerService.saveCustomer(customer);

            String url = "http://localhost:80/category";
            Map<String,Object> params = new HashMap<>();
            params.put("recivedSMS", recivedSMS);
            //params.put("firstTime", true);

            restTemplate.postForObject(url, recivedSMS,String.class);
        }
        else if (categoryCommand) {
            String url = "http://localhost:80/category/selected";
            Map<String, Object> params = new HashMap<>();
            params.put("recivedSMS", recivedSMS);
            restTemplate.postForObject(url, recivedSMS, String.class);
        }
    }

    private String checkNameCommandRecived(RecivedSMS recivedSMS) {
        String command = recivedSMS.getBody();
        if(command.trim().length() < 1) {
            return sendWrongInput(recivedSMS);
        } else {
            if(command.toUpperCase().contains("NAME")) {
                String s = command.substring(4).toUpperCase();
                int start = command.indexOf(":");

                return command.substring(start+1, command.length());

            } else {
                return null;
            }

        }
    }

    private boolean checkCategoryCommand(String command){
        String c = command.substring(0);
        if(c.equalsIgnoreCase("C")) {
            return true;
        }
        return false;
    }

    private String sendWrongInput(RecivedSMS recivedSMS) {
        sendSMSOut(recivedSMS, "Wrong Input Selection", "https://api.flowroute.com/v2.1/messages");
        return "AOK";
    }

    public void sendSMSOut(RecivedSMS recivedSMS, String message, String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        SMSSENT smssent = new SMSSENT();
        smssent.setBody(message);
        smssent.setFrom(recivedSMS.getTo());
        smssent.setTo(recivedSMS.getFrom());
        smssent.setType("message");

        String jsonString = objectToJsonEx.convertToJson(smssent);
        System.out.println(jsonString);

        SendSMS y = restOperations.postForObject(url, smssent, SendSMS.class);
        System.out.println(y);

    }


}
