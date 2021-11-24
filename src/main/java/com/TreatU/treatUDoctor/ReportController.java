/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TreatU.treatUDoctor;

import com.TreatU.treatUDoctor.entity.Consultation;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author innovative
 */
@RestController
@RequiredArgsConstructor
public class ReportController {
    private final ReportRepository repository;
    
    @GetMapping("/report/{reportUUID}")
    public ResponseEntity<Object> getUserByEmail(@PathVariable String reportUUID){
        Consultation consultation = repository.findConsultationByReportUuid(reportUUID);
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("consultation_date", consultation.getDate().toString());
        map.put("consultation_time", consultation.getIdSession().getStartTime() +" - "+ consultation.getIdSession().getEndTime());
        map.put("employee_name", consultation.getIdEmployee().getFirstName() +" "+consultation.getIdEmployee().getLastName());
        map.put("status_consultation", consultation.getIdConsultationStatus().getNameConsultationStatus());
        
        try {
            return ResponseHandler.generateResponse("00", "Successfully retrieved data!", HttpStatus.OK, map);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("01", e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
    
    @PutMapping("/report/create/{report_uuid}")
    public ResponseEntity<Object> finishConsultation(@RequestBody Map<String, ?> input, @PathVariable("report_uuid") String oldUUID) {
        String report = (String) input.get("report");
        UUID uuid = UUID.randomUUID();
        String newUUID = uuid.toString();

        
        try {
            repository.finishConsultation(newUUID, report, oldUUID);
            return ResponseHandler.generateResponse("00", "Success", HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("01", e.getMessage(), HttpStatus.MULTI_STATUS);
        }

    }
}
