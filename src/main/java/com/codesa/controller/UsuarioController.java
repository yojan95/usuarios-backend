package com.codesa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codesa.model.Usuario;
import com.codesa.service.IUsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService service;
	
	@PostMapping
	public ResponseEntity<Void> createUser(@RequestBody Usuario usuario) throws Exception{
			Usuario userUnique;
			userUnique = service.findBynombre(usuario.getNombre());
			if(userUnique == null) {
				service.create(usuario);				
				return new ResponseEntity<>( HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
	}
	
	@PutMapping
	public ResponseEntity<Usuario> updateUser(@RequestBody Usuario usuario) throws Exception{
		return new ResponseEntity<>(service.update(usuario), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAllUsers() throws Exception{
		return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id")Integer id)throws Exception{
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/buscar/filtro")
	public ResponseEntity<List<Usuario>> filterAllUser(@RequestParam String filtro ) throws Exception{
		return new ResponseEntity<>(service.findByUsernameLike(filtro),HttpStatus.OK);
	}
	
	
}
