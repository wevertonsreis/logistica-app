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

import br.com.logistica.logistica.entity.Veiculo;
import br.com.logistica.logistica.repository.MotoristaRepository;
import br.com.logistica.logistica.repository.VeiculoRepository;

@Controller
@RequestMapping("/veiculos")
public class VeiculoController {

	private static final String PAGINA_LIST = "veiculos/list";
	private static final String PAGINA_FORM = "veiculos/form";
	private static final String PAGINA_VIEW = "veiculos/view";
	private static final String PAGINA_MAPA = "veiculos/mapa";
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	@Autowired
	private MotoristaRepository motoristaRepository;
	
	@GetMapping("/")
	public ModelAndView list() {
		List<Veiculo> veiculos = this.veiculoRepository.findAll();
		return new ModelAndView(PAGINA_LIST, "veiculos", veiculos);
	}
	
	@GetMapping("/{id}")
	public ModelAndView view(@PathVariable("id") Veiculo veiculo) {
		return new ModelAndView(PAGINA_VIEW, "veiculo", veiculo);
	}
	
	@GetMapping("localizar/{id}")
	public ModelAndView localizar(@PathVariable("id") Veiculo veiculo) {
		return new ModelAndView(PAGINA_MAPA, "veiculo", veiculo);
	}
	
	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Veiculo veiculo) {
		ModelAndView modelAndView = new ModelAndView(PAGINA_FORM);
		modelAndView.addObject("motoristas", motoristaRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("alterar/{id}")
	public ModelAndView alterarForm(@PathVariable("id") Veiculo veiculo) {
		return new ModelAndView(PAGINA_FORM, "veiculo", veiculo);
	}
	
	@PostMapping(params = "form")
	public ModelAndView create(Veiculo veiculo, RedirectAttributes redirect) {
		veiculo = this.veiculoRepository.save(veiculo);
		redirect.addFlashAttribute("globalMessage", "Veículo gravado com sucesso");
		
		return new ModelAndView("redirect:/veiculos/{veiculo.id}", "veiculo.id", veiculo.getId());	
	}
	
	@GetMapping("remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id, RedirectAttributes redirect) {
		this.veiculoRepository.deleteById(id);
		
		List<Veiculo> veiculos = this.veiculoRepository.findAll();
		
		ModelAndView mv = new ModelAndView(PAGINA_LIST, "clientes", veiculos);
		mv.addObject("globalMessage", "Veículo removido com sucesso");
		
		return mv;
	}
	
}
