package com.store2020.initApp.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.store2020.initApp.model.Cliente;

@Repository
public class ClienteDao implements IClienteDao {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findAllClients() {
		
		return em.createQuery("from Cliente").getResultList();
	}

	@Override
	public void save(Cliente cliente) {
		
		if(cliente.getId() !=null && cliente.getId()>0){
			em.merge(cliente);
		}else {
			em.persist(cliente);	
		}
		
	}

	@Override
	public Cliente findOne(Long id) {
		return em.find(Cliente.class, id);
	}

	@Override
	public void deleteClient(Long id) {
		em.remove(findOne(id));
	}

}
