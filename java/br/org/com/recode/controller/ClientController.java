package br.org.com.recode.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.org.com.recode.model.Clients;
import br.org.com.recode.repository.ClientRepository;

@Controller
@RequestMapping("/clients")

public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("clients/listar.html");

		List<Clients> clients = clientRepository.findAll();
		modelAndView.addObject("clients", clients);

		return modelAndView;
	}

	// Método cadastrar, chama o objeto vazio

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("clients/cadastro.html");

		modelAndView.addObject("clients", new Clients());

		return modelAndView;
	}

	// Método para retornar o

	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Clients clients) throws IOException {

		ModelAndView modelAndView = new ModelAndView("redirect:/clients");

		clientRepository.save(clients);

		return modelAndView;
	}

	@GetMapping("/{id_cliente}")
	public ModelAndView detalhar(@PathVariable Long id_cliente) {
		ModelAndView modelAndView = new ModelAndView("clients/detalhar.html");

		Clients clients = clientRepository.getOne(id_cliente);
		modelAndView.addObject("clients", clients);

		return modelAndView;
	}

	@GetMapping("/{id_cliente}/excluir")
	public ModelAndView excluir(@PathVariable Long id_cliente) {
		ModelAndView modelAndView = new ModelAndView("redirect:/clients");

		clientRepository.deleteById(id_cliente);

		return modelAndView;
	}

	@GetMapping("/{id_cliente}/editar")
	public ModelAndView editar(@PathVariable Long id_cliente) {

		ModelAndView modelAndView = new ModelAndView("clients/edicao.html");
		Clients clients = clientRepository.getReferenceById(id_cliente);
		modelAndView.addObject("clients", clients);

		return modelAndView;
	}

	@PostMapping("/{id_cliente}/editar")
	public ModelAndView editar(Clients clients) throws IOException {

		ModelAndView modelAndView = new ModelAndView("redirect:/clients");

		clientRepository.save(clients);

		return modelAndView;
	}
}
