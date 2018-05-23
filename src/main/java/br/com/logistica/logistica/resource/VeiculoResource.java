package br.com.logistica.logistica.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.logistica.logistica.entity.Veiculo;
import br.com.logistica.logistica.repository.VeiculoRepository;

@RestController
@RequestMapping("api/veiculos")
public class VeiculoResource {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@GetMapping("/")
	public List<Veiculo> list() {
		return veiculoRepository.findAll();
	}
	
}