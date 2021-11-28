package com.codesa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codesa.model.Usuario;
import com.codesa.repo.IGenericRepo;
import com.codesa.repo.IUsuarioRepo;
import com.codesa.service.IUsuarioService;

@Service
public class UsuarioServiceImpl extends CRUDImpl<Usuario, Integer> implements IUsuarioService{
	
	@Autowired
	private IUsuarioRepo repo;
	
	@Override
	protected IGenericRepo<Usuario, Integer> getRepo() {
		return repo;
	}

	@Override
	public List<Usuario> findByUsernameLike(String nombre) {
		// TODO Auto-generated method stub
		return repo.findByNombreLike(nombre);
	}

	@Override
	public Usuario findBynombre(String nombre) {
		// TODO Auto-generated method stub
		return repo.findByNombre(nombre);
	}
	
	

}
