package com.codesa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.codesa.model.Usuario;

public interface IUsuarioRepo extends IGenericRepo<Usuario, Integer> {
	
	List<Usuario> findByNombreLike(String nombre);
	
	@Query("SELECT u FROM  Usuario u WHERE u.nombre =?1")
	Usuario findByNombre(String nombre); 
	

}
