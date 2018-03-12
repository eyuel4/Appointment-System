package com.tadhack.orlandoappointment.orlandoappointment.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ObjectToJsonEx {
    public String convertToJson(Object obj) {
        ObjectMapper mapperObj = new ObjectMapper();
        try {
            String jsonString = mapperObj.writeValueAsString(obj);
            return jsonString;
        }catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
