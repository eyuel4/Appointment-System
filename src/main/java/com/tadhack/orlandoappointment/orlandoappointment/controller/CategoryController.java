package com.tadhack.orlandoappointment.orlandoappointment.controller;

import com.tadhack.orlandoappointment.orlandoappointment.flowroute.RecivedSMS;
import com.tadhack.orlandoappointment.orlandoappointment.model.Category;
import com.tadhack.orlandoappointment.orlandoappointment.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private HomeController homeController;

    //@RequestMapping(value = "/category", method=RequestMethod.POST, headers = "application/json;charset=UTF-8",produces = "application/json", consumes="application/json")


    @RequestMapping(value = "/category", method = RequestMethod.POST)
    @ResponseBody
    public void getAllcategory(@RequestBody RecivedSMS response) {
        System.out.println("Hello World");
        List<Category> categorys = categoryService.getAllCategory();
        String message = "Please Select Category number Office to make appointment";
        String categoryMessage = "";
        int count = 1;
        for(Category c : categorys) {
            categoryMessage += count +". "+c.getName()+"\n";
            count++;
        }
        message += "\n" + categoryMessage;

        String url = "https://api.flowroute.com/v2.1/messages";
        if(true) {
            homeController.sendSMSOut(response, message, url);
        }

        //return categoryService.getCategoryById("0");
        //return "OK";
        //return "Hello World";
    }

    @RequestMapping(value = "/category/selected", method = RequestMethod.POST)
    @ResponseBody
    public Category handleCategorySelected(@Param("recivedSMS") RecivedSMS recivedSMS) {
        System.out.println("category selected");
        Category category = categoryService.getCategoryById("0");

        return category;
    }
}
