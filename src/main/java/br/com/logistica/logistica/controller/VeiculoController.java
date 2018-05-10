package br.com.logistica.logistica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.logistica.logistica.entity.Veiculo;
import br.com.logistica.logistica.repository.VeiculoRepository;

@Controller
@RequestMapping("/veiculos")
public class VeiculoController {

	private final String VEICULO_URI = "veiculos/";
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@GetMapping("/")
	public ModelAndView list() {
		List<Veiculo> veiculos = this.veiculoRepository.findAll();
		return new ModelAndView(VEICULO_URI + "list", "veiculos", veiculos);
	}
	
}
