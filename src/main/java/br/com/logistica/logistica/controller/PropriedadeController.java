package br.com.logistica.logistica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.logistica.logistica.entity.Propriedade;
import br.com.logistica.logistica.repository.PropriedadeRepository;

@RestController
@RequestMapping("/api")
public class PropriedadeController {
	
	@Autowired
	private PropriedadeRepository  propriedadeRepository;
	
	@RequestMapping(value = "/find/{filtro}", method = RequestMethod.GET)
	public List<Propriedade> findByFiltro(@PathVariable("filtro") String filtro) {
		return propriedadeRepository.findByFiltro(filtro);
	}
	
}