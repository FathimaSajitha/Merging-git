package com.sgic.internal.defecttracker.defect.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.common.api.enums.RestApiResponseStatus;
import com.sgic.common.api.response.ApiResponse;
import com.sgic.internal.defecttracker.defect.controller.dto.DefectTypeDto;
import com.sgic.internal.defecttracker.defect.controller.dto.mapper.DefectTypeMapper;
import com.sgic.internal.defecttracker.defect.services.impl.DefectTypeServiceImpl;


@RestController
@CrossOrigin(origins="http://localhost:3000")
public class DefectTypeController {
	private static Logger logger = LogManager.getLogger(DefectTypeServiceImpl.class);

	@Autowired
	private DefectTypeMapper defectTypeMapper;

	// Create Defect Type
	@PostMapping(value = "/defecttype")
	public ResponseEntity<Object> createDefectType(@RequestBody DefectTypeDto defectTypeDto) {
		BasicConfigurator.configure();
		if (defectTypeMapper.createDefectType(defectTypeDto)) {
			logger.info("Defect Type created");
			return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.OK), HttpStatus.OK);
		} else {
			logger.error("Defect Type Create Fail");
			return new ResponseEntity<>("Defect Type Added Failure", HttpStatus.BAD_REQUEST);
		}
	}

	// Get All Defect Types
	@GetMapping(value = "/defecttypes")
	public List<DefectTypeDto> getAllDefectType() {
		BasicConfigurator.configure();
		logger.info("Defect Types Listed");
		return defectTypeMapper.getAllDefectType();
	}

	// Get Defect Type By Id
	
	@GetMapping(value = "/defecttype/{id}")
	public DefectTypeDto getDefectById(@PathVariable Long id) {
		BasicConfigurator.configure();
		logger.info("Defect Type Get By Id Listed");
		return defectTypeMapper.getDefectTypeById(id);
	}

	// Delete Defect Type	
	
	@DeleteMapping("/defecttype/{id}")
	public ResponseEntity<Object> deleteDefectType(@PathVariable Long id, @RequestBody DefectTypeDto defectTypeDto) {
		BasicConfigurator.configure();
		defectTypeMapper.deleteDefectType(id);
		logger.info("Defect Type Deleted");
		return new ResponseEntity<>("Defect Type Deleted Successfully", HttpStatus.OK);
	}

	// Defect Type Updated
	@PutMapping(value = "/defecttype/{id}")
	public ResponseEntity<Object> updateDefectType(@RequestBody DefectTypeDto defectTypeDto, @PathVariable Long id) {
		BasicConfigurator.configure();
		defectTypeMapper.updateDefectType(id, defectTypeDto);
		logger.info("Defect Type Updated");
		return new ResponseEntity<>(new ApiResponse(RestApiResponseStatus.OK), HttpStatus.OK);
	}
	
	// Count Defect Type 
	@GetMapping("/countdefecttype")
	public int getDefectTypeCount() {
		BasicConfigurator.configure();
		logger.info("Defect Type Counted");
		return defectTypeMapper.getDefectTypeCount();
	}
}
