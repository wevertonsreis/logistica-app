package br.com.logistica.logistica.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.logistica.logistica.entity.Cliente;
import br.com.logistica.logistica.repository.ClienteRepository;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	private final String CLIENTE_URI = "clientes/";
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/")
	public ModelAndView list() {
		List<Cliente> clientes = this.clienteRepository.findAll();
		return new ModelAndView(CLIENTE_URI + "list", "clientes", clientes);
	}
	
	@GetMapping("/{id}")
	public ModelAndView view(@PathVariable("id") Cliente cliente) {
		return new ModelAndView(CLIENTE_URI + "view", "cliente", cliente);
	}
	
	@GetMapping("/novo")
	public String createForm(@ModelAttribute Cliente cliente) {
		return CLIENTE_URI + "form";
	}
	
	@PostMapping(params = "form")
	public ModelAndView create(@Valid Cliente cliente, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors())
			return new ModelAndView(CLIENTE_URI + "form","formErrors",result.getAllErrors()); 
			
		cliente = this.clienteRepository.save(cliente);
		redirect.addFlashAttribute("globalMessage", "Cliente gravado com sucesso");
		
		return new ModelAndView("redirect:/" + CLIENTE_URI +"{cliente.id}", "cliente.id", cliente.getId());	
	}
	
	@GetMapping("alterar/{id}")
	public ModelAndView alterarForm(@PathVariable("id") Cliente cliente) {
		return new ModelAndView(CLIENTE_URI + "form", "cliente", cliente);
	}
	
	@GetMapping("remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id, RedirectAttributes redirect) {
		this.clienteRepository.deleteById(id);
		
		List<Cliente> clientes = this.clienteRepository.findAll();
		
		ModelAndView mv = new ModelAndView(CLIENTE_URI + "list", "clientes", clientes);
		mv.addObject("globalMessage", "Cliente removido com sucesso");
		
		return mv;
	}
	
}
