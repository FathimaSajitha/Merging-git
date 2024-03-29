package com.sgic.internal.defecttracker.defect.repositories;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sgic.internal.defecttracker.defect.entities.Defect;
import com.sgic.internal.defecttracker.project.entities.Module;
import com.sgic.internal.defecttracker.project.entities.Project;

public interface DefectRepository extends JpaRepository<Defect, String >{

Defect getByDefectId(String defectId);

@Query(value ="FROM Defect WHERE project_id =:projectId") 
List<Defect>getByProjectId(@Param("projectId")String projectId); 

@Query(value ="FROM Defect WHERE module_id =:moduleId") 
List<Defect>getByModuleId(@Param("moduleId")String moduleId);


@Query(value ="FROM Defect WHERE date_and_time =:dateAndTime") 
List<Defect>getByDefectDate(@Param("dateAndTime")Date dateAndTime);


@Query(value ="FROM Defect WHERE available_in =:availableIn") 
List<Defect>getByAvailableIn(@Param("availableIn")String availableIn);

//@Modifying
//@Query("UPDATE Defect d SET d.statusId = :status_id WHERE d.defect_id = :defectId")
//int updateStatusId(@Param("defectId") Long defectId, @Param("statusId") int statusId);

@Query(value ="FROM Defect WHERE found_in =:foundIn") 
List<Defect>getByFoundIn(@Param("foundIn")String foundIn);

@Query(value ="FROM Defect WHERE fixed_in =:fixedIn") 
List<Defect>getByFixedIn(@Param("fixedIn")String fixedIn);


List<Defect> findDefectByModule(Module module);

}