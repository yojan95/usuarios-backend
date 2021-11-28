package com.codesa.service;

import java.util.List;

import com.codesa.model.Usuario;

public interface IUsuarioService extends ICRUD<Usuario, Integer> {
	
	List<Usuario> findByUsernameLike(String nombre);
	
	Usuario findBynombre(String nombre);

}
