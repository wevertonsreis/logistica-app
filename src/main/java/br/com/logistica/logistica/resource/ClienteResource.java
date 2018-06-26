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

import br.com.logistica.logistica.entity.Cliente;
import br.com.logistica.logistica.repository.ClienteRepository;

@CrossOrigin
@RestController
@RequestMapping("api/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/")
	public List<Cliente> list() {
		return clienteRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
		clienteRepository.save(cliente);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
	}
	
}