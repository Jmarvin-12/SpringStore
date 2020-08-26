package com.store2020.initApp.controller;

import java.util.Map;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.store2020.initApp.dao.IClienteDao;
import com.store2020.initApp.model.Cliente;

@Controller
@RequestMapping
public class ClienteController {

	@Autowired
	private IClienteDao clienteDao;
	
	@GetMapping("/ClientList")
	public String getAllClients(Model model) {
		
		model.addAttribute("title", "Listado de clientes");
		model.addAttribute("clientList", clienteDao.findAllClients());
		
		return "ClientList";
	}
	
	@GetMapping("/clientForm")
	public String createClient(Map<String, Object> model, Cliente cliente) {
		model.put("cliente", cliente= new Cliente());
		model.put("formTitle", "Formulario de clientes");
		return "clientForm";
	}
	
	@PostMapping("/saveClient")
	public String saveClient(@Valid  Cliente cliente, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("formTitle", "Formulario de clientes");
			return "clientForm";
		}
		
		clienteDao.save(cliente);
		return "redirect:ClientList";
	}
	
}
