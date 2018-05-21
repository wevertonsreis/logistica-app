package br.com.logistica.logistica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.logistica.logistica.entity.Cliente;
import br.com.logistica.logistica.entity.Pedido;
import br.com.logistica.logistica.repository.ClienteRepository;
import br.com.logistica.logistica.repository.PedidoRepository;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {
	
	private static final String PAGINA_LIST = "pedidos/list";
	private static final String PAGINA_FORM = "pedidos/form";
	
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/")
	public ModelAndView list() {
		List<Pedido> pedidos = pedidoRepository.findAll();
		return new ModelAndView(PAGINA_LIST, "pedidos", pedidos);
	}
	
	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Pedido pedido) {
		List<Cliente> clientes = clienteRepository.findAll();
		
		ModelAndView mv = new ModelAndView(PAGINA_FORM);
		mv.addObject("clientes", clientes);
		
		return mv;
	}
	
}
