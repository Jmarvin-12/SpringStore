package com.store2020.initApp.dao;

import java.util.List;

import com.store2020.initApp.model.Cliente;

public interface IClienteDao {

	public List<Cliente> findAllClients();
	
	public void save(Cliente cliente);
}
