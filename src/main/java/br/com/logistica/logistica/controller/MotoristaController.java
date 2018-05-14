package br.com.logistica.logistica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.logistica.logistica.entity.Motorista;
import br.com.logistica.logistica.repository.MotoristaRepository;

@Controller
@RequestMapping("/motoristas")
public class MotoristaController {

	private final String MOTORISTA_URI = "motoristas/";
	
	@Autowired
	private MotoristaRepository motoristaRepository;
	
	@GetMapping("/")
	public ModelAndView list() {
		List<Motorista> motoristas = motoristaRepository.findAll();
		return new ModelAndView(MOTORISTA_URI + "list", "motoristas", motoristas);
	}
	
	@GetMapping("/novo")
	public String createForm(@ModelAttribute Motorista motorista) {
		return MOTORISTA_URI + "form";
	}
	
	@PostMapping(params = "form")
	public ModelAndView create(Motorista motorista) {
		motorista = this.motoristaRepository.save(motorista);
		return new ModelAndView("redirect:/" + MOTORISTA_URI +"{motorista.id}", "motorista.id", motorista.getId());	
	}
	
}
