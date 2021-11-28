package com.codesa.service;

import java.util.List;

public interface ICRUD <T,ID>{
	
	T create(T t)throws Exception;
	
	T update(T t)throws Exception;
	
	List<T> findAll()throws Exception;
	
	T findById(Integer id)throws Exception;
	
	void delete(Integer id)throws Exception;

}
