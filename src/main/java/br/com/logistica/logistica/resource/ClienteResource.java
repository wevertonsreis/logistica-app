package br.com.logistica.logistica.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.logistica.logistica.entity.Cliente;
import br.com.logistica.logistica.repository.ClienteRepository;

@RestController
@RequestMapping("api/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/")
	public List<Cliente> list() {
		return clienteRepository.findAll();
	}
	
}