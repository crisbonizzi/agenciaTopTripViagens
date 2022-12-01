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


import br.org.com.recode.model.Compras;
import br.org.com.recode.repository.CompraRepository;



@Controller
@RequestMapping("/compras")

public class CompraController {
	
	@Autowired
	private CompraRepository compraRepository;

	// get all compras
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("compras/listar.html");

		List<Compras> compras = compraRepository.findAll();
		modelAndView.addObject("compras", compras);

		return modelAndView;
	}


	// Método cadastrar, chama o objeto vazio

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("compras/cadastro.html");

		modelAndView.addObject("compras", new Compras());

		return modelAndView;
	}

	// Método para retornar o

	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Compras compras) throws IOException {

		ModelAndView modelAndView = new ModelAndView("redirect:/compras");

		compraRepository.save(compras);

		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("compras/detalhar.html");

		Compras	 compras = compraRepository.getOne(id);
		modelAndView.addObject("compras", compras);

		return modelAndView;
	}

	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/compras");

		compraRepository.deleteById(id);

		return modelAndView;
	}

	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {

		ModelAndView modelAndView = new ModelAndView("compras/edicao.html");
		Compras compras = compraRepository.getReferenceById(id);
		modelAndView.addObject("compras", compras);

		return modelAndView;
	}

	@PostMapping("/{id}/editar")
	public ModelAndView editar(Compras compras) throws IOException {

		ModelAndView modelAndView = new ModelAndView("redirect:/compras");

		compraRepository.save(compras);

		return modelAndView;
	}
}
