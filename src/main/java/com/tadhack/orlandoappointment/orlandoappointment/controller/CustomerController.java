package com.tadhack.orlandoappointment.orlandoappointment.controller;

import com.tadhack.orlandoappointment.orlandoappointment.flowroute.*;
import com.tadhack.orlandoappointment.orlandoappointment.model.Customer;
import com.tadhack.orlandoappointment.orlandoappointment.service.ICustomerService;
import com.tadhack.orlandoappointment.orlandoappointment.util.ObjectToJsonEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.core.MultivaluedMap;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RestOperations restOperations;

    @Autowired
    private ObjectToJsonEx objectToJsonEx;

    @Autowired
    private HomeController homeController;

    @RequestMapping(value = "/newcustomer", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void handleNewCustomer(@RequestBody RecivedSMS recivedSMS) {
        System.out.println("Welcome Text sent");
        String message = "Welcome, would you like to tell as your name? " + "\n send" + "\n Name : FirstName LastName";
        String url = "https://api.flowroute.com/v2.1/messages";


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.add("Authorization", "Basic " + );

/*        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("username", "17437865");
        map.add("password", "aFFgSWUUeWVpIoMUOEdnL26GBQB3uR05");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);*/

/*        Data data = new Data();

        SendSMS sms = new SendSMS();
        sms.setType("message");
        Attributes attributes = new Attributes(recivedSMS.getFrom(),recivedSMS.getTo(), "Hello");
        sms.setAttributes(attributes);
        data.setData(sms);*/

        SMSSENT  smssent = new SMSSENT();
        smssent.setBody(message);
        smssent.setFrom(recivedSMS.getTo());
        smssent.setTo(recivedSMS.getFrom());
        smssent.setType("message");
        //ResponseEntity x = restOperations.exchange(url, HttpMethod.POST, request, String.class);
        String jsonString = objectToJsonEx.convertToJson(smssent);
        System.out.println(jsonString);

        SendSMS y = restOperations.postForObject(url, smssent, SendSMS.class);

        //ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        System.out.println(y);

    }

    @RequestMapping(value = "/returningcustomer", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void handleOldCustomer(@Param("recivedSMS") RecivedSMS recivedSMS, @Param("customer") Customer customer) {
        Customer customer1 = customerService.findCustomerByPhoneNumber(recivedSMS.getFrom());
        String message = "Welcome back " + customer1.getFirstName();

        homeController.sendSMSOut(recivedSMS, message, "https://api.flowroute.com/v2.1/messages");

    }
}
