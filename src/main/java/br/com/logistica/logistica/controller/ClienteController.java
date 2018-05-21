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
	
	private static final String PAGINA_LIST = "clientes/list";
	private static final String PAGINA_FORM = "clientes/form";
	private static final String PAGINA_VIEW = "clientes/view";
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/")
	public ModelAndView list() {
		List<Cliente> clientes = this.clienteRepository.findAll();
		return new ModelAndView(PAGINA_LIST, "clientes", clientes);
	}
	
	@GetMapping("/{id}")
	public ModelAndView view(@PathVariable("id") Cliente cliente) {
		return new ModelAndView(PAGINA_VIEW, "cliente", cliente);
	}
	
	@GetMapping("/novo")
	public String createForm(@ModelAttribute Cliente cliente) {
		return PAGINA_FORM;
	}
	
	@PostMapping(params = "form")
	public ModelAndView create(@Valid Cliente cliente, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors())
			return new ModelAndView(PAGINA_FORM,"formErrors",result.getAllErrors()); 
			
		cliente = this.clienteRepository.save(cliente);
		redirect.addFlashAttribute("globalMessage", "Cliente gravado com sucesso");
		
		return new ModelAndView("redirect:/clientes/{cliente.id}", "cliente.id", cliente.getId());	
	}
	
	@GetMapping("alterar/{id}")
	public ModelAndView alterarForm(@PathVariable("id") Cliente cliente) {
		return new ModelAndView(PAGINA_FORM, "cliente", cliente);
	}
	
	@GetMapping("remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id, RedirectAttributes redirect) {
		this.clienteRepository.deleteById(id);
		
		List<Cliente> clientes = this.clienteRepository.findAll();
		
		ModelAndView mv = new ModelAndView(PAGINA_LIST, "clientes", clientes);
		mv.addObject("globalMessage", "Cliente removido com sucesso");
		
		return mv;
	}
	
}
