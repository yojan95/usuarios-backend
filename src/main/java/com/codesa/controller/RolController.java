package com.codesa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codesa.model.Rol;
import com.codesa.service.IRolService;

@RestController
@RequestMapping("/roles")
public class RolController {
	
	@Autowired
	private IRolService service;
	
	@GetMapping
	public ResponseEntity<List<Rol>> findAllRoles() throws Exception{
		return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
	}
	

}
