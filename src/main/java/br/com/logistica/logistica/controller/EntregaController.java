package br.com.logistica.logistica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.logistica.logistica.entity.Entrega;
import br.com.logistica.logistica.repository.EntregaRepository;

@Controller
@RequestMapping("/entregas")
public class EntregaController {
	
	private static final String PAGINA_LIST = "entregas/list";
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	@GetMapping("/")
	public ModelAndView list() {
		List<Entrega> entregas = entregaRepository.findAll();
		return new ModelAndView(PAGINA_LIST, "entregas", entregas);
	}
	
}