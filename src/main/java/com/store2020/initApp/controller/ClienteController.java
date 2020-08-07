package com.store2020.initApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.store2020.initApp.dao.IClienteDao;

@Controller
@RequestMapping
public class ClienteController {

	@Autowired
	private IClienteDao clienteDao;
	
	@GetMapping("/getAllClients")
	public String getAllClients(Model model) {
		
		model.addAttribute("title", "Listado de clientes");
		model.addAttribute("clientList", clienteDao.findAllClients());
		
		return "ClientList";
	}
	
}
