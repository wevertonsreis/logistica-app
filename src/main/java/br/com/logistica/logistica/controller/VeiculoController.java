package br.com.logistica.logistica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.logistica.logistica.entity.Veiculo;
import br.com.logistica.logistica.repository.MotoristaRepository;
import br.com.logistica.logistica.repository.VeiculoRepository;

@Controller
@RequestMapping("/veiculos")
public class VeiculoController {

	private final String VEICULO_URI = "veiculos/";
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	@Autowired
	private MotoristaRepository motoristaRepository;
	
	@GetMapping("/")
	public ModelAndView list() {
		List<Veiculo> veiculos = this.veiculoRepository.findAll();
		return new ModelAndView(VEICULO_URI + "list", "veiculos", veiculos);
	}
	
	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Veiculo veiculo) {
		ModelAndView modelAndView = new ModelAndView(VEICULO_URI + "form", "veiculo", veiculo);
		modelAndView.addObject("motoristas", motoristaRepository.findAll());
		return modelAndView;
	}
	
	@PostMapping(params = "form")
	public ModelAndView create(Veiculo veiculo) {
		veiculo = this.veiculoRepository.save(veiculo);
		return new ModelAndView("redirect:/" + VEICULO_URI +"{veiculo.id}", "veiculo.id", veiculo.getId());	
	}
	
}
