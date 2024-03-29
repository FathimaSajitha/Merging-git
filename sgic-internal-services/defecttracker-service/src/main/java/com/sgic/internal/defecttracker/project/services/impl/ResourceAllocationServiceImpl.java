package com.sgic.internal.defecttracker.project.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.internal.defecttracker.project.entities.ResourceAllocation;
import com.sgic.internal.defecttracker.project.repositories.ResourceAllocationRepository;
import com.sgic.internal.defecttracker.project.services.ResourceAllocationService;

@Service
public class ResourceAllocationServiceImpl implements ResourceAllocationService{

	@Autowired
	private  ResourceAllocationRepository resourceAllocationRepository;
	
	
	@Override
	public ResourceAllocation saveresource(ResourceAllocation resourceAllocation) {
		return resourceAllocationRepository.save(resourceAllocation);
	}

	@Override
	public List<ResourceAllocation> gettAllResource() {
		return resourceAllocationRepository.findAll();
	}

	
	
}
