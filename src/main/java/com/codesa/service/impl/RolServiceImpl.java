package com.codesa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codesa.model.Rol;
import com.codesa.repo.IGenericRepo;
import com.codesa.repo.IRolRepo;
import com.codesa.service.IRolService;

@Service
public class RolServiceImpl extends CRUDImpl<Rol, Integer> implements IRolService{
	
	@Autowired
	private IRolRepo repo;

	@Override
	protected IGenericRepo<Rol, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

}
