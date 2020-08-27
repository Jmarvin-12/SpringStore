package com.store2020.initApp.controller;

import java.util.Map;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import com.store2020.initApp.model.Cliente;
import com.store2020.initApp.service.IClienteService;

@Controller
@RequestMapping
@SessionAttributes("cliente")
public class ClienteController {

	@Autowired
	private IClienteService service;
	
	@GetMapping("/ClientList")
	public String getAllClients(Model model) {
		
		model.addAttribute("title", "Listado de clientes");
		model.addAttribute("clientList", service.findAllClients());
		
		return "ClientList";
	}
	
	@GetMapping("/clientForm")
	public String createClient(Map<String, Object> model, Cliente cliente) {
		model.put("cliente", cliente= new Cliente());
		model.put("formTitle", "Formulario de clientes");
		return "clientForm";
	}
	
	@RequestMapping(value="/updateClient/{id}")
	public String updateClient(@PathVariable(value="id") Long id, Map<String, Object> model, Cliente cliente) {
		
		if(id>0) {
			cliente= service.findOne(id);
		}else {
			return "redirect:ClientList";
		}
		
		model.put("cliente", cliente);
		model.put("formTitle", "Editar cliente");
		return "clientForm";
	}
	
	@PostMapping("/saveClient")
	public String saveClient(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status) {
		
		if(result.hasErrors()) {
			model.addAttribute("formTitle", "Formulario de clientes");
			return "clientForm";
		}
		
		service.save(cliente);
		status.isComplete();
		return "redirect:ClientList";
	}
	
	@GetMapping("/deleteClient/{id}")
	public String deleteClient(@PathVariable(value="id") Long id){
		
		if(id>0) {
			service.deleteClient(id);
		}
		
		return "redirect:/ClientList";
	}
	
}
