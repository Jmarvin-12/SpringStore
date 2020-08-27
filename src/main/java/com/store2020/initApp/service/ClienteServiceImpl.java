package com.store2020.initApp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store2020.initApp.dao.ClienteDao;
import com.store2020.initApp.model.Cliente;

@Service
@Transactional
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private ClienteDao dao;
	
	@Override
	public List<Cliente> findAllClients() {

		return dao.findAllClients();
	}

	@Override
	public void save(Cliente cliente) {
		dao.save(cliente);
	}

	@Override
	public Cliente findOne(Long id) {
		
		return dao.findOne(id);
	}

	@Override
	public void deleteClient(Long id) {
		dao.deleteClient(id);
	}

}
