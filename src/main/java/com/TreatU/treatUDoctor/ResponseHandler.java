/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TreatU.treatUDoctor;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author innovative
 */
public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String inquiryStatus, String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("inquiryStatus", inquiryStatus);
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj);

        return new ResponseEntity<Object>(map, status);
    }
    
    public static ResponseEntity<Object> generateResponse(String inquiryStatus, String message, HttpStatus status){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("inquiryStatus", inquiryStatus);
        map.put("message", message);
        map.put("status", status.value());
        return new ResponseEntity<Object>(map, status);
    }
}
