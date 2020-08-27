package com.store2020.initApp.service;

import java.util.List;

import com.store2020.initApp.model.Cliente;

public interface IClienteService {

	public List<Cliente> findAllClients();

	public void save(Cliente cliente);

	public Cliente findOne(Long id);

	public void deleteClient(Long id);
}
