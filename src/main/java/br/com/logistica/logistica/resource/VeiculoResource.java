package br.com.logistica.logistica.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.logistica.logistica.entity.Veiculo;
import br.com.logistica.logistica.repository.VeiculoRepository;

@CrossOrigin
@RestController
@RequestMapping("api/veiculos")
public class VeiculoResource {

	@Autowired
	private VeiculoRepository veiculoRepository;
	
	@GetMapping("/")
	public List<Veiculo> list() {
		return veiculoRepository.findAll();
	}
	
	@PostMapping("/")
	public ResponseEntity<Veiculo> save(@RequestBody Veiculo veiculo) {
		veiculoRepository.save(veiculo);
		return new ResponseEntity<Veiculo>(veiculo, HttpStatus.CREATED);
	}
	
}