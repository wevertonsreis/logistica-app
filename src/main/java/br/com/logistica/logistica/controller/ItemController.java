package br.com.logistica.logistica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.logistica.logistica.entity.Item;
import br.com.logistica.logistica.repository.ItemRepository;

@Controller
@RequestMapping("/itens")
public class ItemController {

	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping("/")
	public ModelAndView list() {
		List<Item> itens = itemRepository.findAll();
		return new ModelAndView("itens/list", "itens", itens);
	}
	
}