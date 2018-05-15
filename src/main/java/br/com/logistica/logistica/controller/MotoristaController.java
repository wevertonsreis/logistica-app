package br.com.logistica.logistica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping("/{id}")
	public ModelAndView view(@PathVariable("id") Motorista motorista) {
		return new ModelAndView(MOTORISTA_URI + "view", "motorista", motorista);
	}
	
	@GetMapping("/novo")
	public String createForm(@ModelAttribute Motorista motorista) {
		return MOTORISTA_URI + "form";
	}
	
	@GetMapping("alterar/{id}")
	public ModelAndView alterarForm(@PathVariable("id") Motorista motorista) {
		return new ModelAndView(MOTORISTA_URI + "form", "motorista", motorista);
	}
	
	@PostMapping(params = "form")
	public ModelAndView create(Motorista motorista, RedirectAttributes redirect) {
		motorista = this.motoristaRepository.save(motorista);
		redirect.addFlashAttribute("globalMessage", "Motorista gravado com sucesso");
		
		return new ModelAndView("redirect:/" + MOTORISTA_URI +"{motorista.id}", "motorista.id", motorista.getId());	
	}
	
	@GetMapping("remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id, RedirectAttributes redirect) {
		this.motoristaRepository.deleteById(id);
		
		List<Motorista> motorista = this.motoristaRepository.findAll();
		
		ModelAndView mv = new ModelAndView(MOTORISTA_URI + "list", "motoristas", motorista);
		mv.addObject("globalMessage", "Motorista removido com sucesso");
		
		return mv;
	}
	
}
