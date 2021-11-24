/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TreatU.treatUDoctor;

import com.TreatU.treatUDoctor.entity.Consultation;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author innovative
 */
@Transactional
@Repository
public interface ReportRepository extends JpaRepository<Consultation, Long>{
    Consultation findConsultationByReportUuid(String reportUUID);
    
    @Modifying
    @Query(value = "UPDATE consultation set update_date = NOW(), id_consultation_status = 4, report_uuid = :new_uuid, result = :result where report_uuid = :old_uuid", nativeQuery = true)
    void finishConsultation(@Param("new_uuid") String newUUID, @Param("result") String result, @Param("old_uuid") String oldUUID);
}
