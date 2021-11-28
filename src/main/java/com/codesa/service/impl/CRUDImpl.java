package com.codesa.service.impl;

import java.util.List;

import com.codesa.repo.IGenericRepo;
import com.codesa.service.ICRUD;

public abstract  class CRUDImpl<T,ID> implements ICRUD<T, ID> {
	
	protected abstract IGenericRepo<T, ID> getRepo();

	@Override
	public T create(T t) throws Exception {
		return getRepo().save(t);
	}

	@Override
	public T update(T t) throws Exception {
		return getRepo().save(t);
	}

	@Override
	public List<T> findAll() throws Exception {
		return getRepo().findAll();
	}

	public T findById(ID id) throws Exception {
		return (T) getRepo().findById(id).orElse(null);
	}

	
	public void delete(ID id) throws Exception {
				getRepo().deleteById(id);
	}
	
	

}
