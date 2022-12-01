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


import br.org.com.recode.model.Passagens;
import br.org.com.recode.repository.PassagemRepository;

@Controller
@RequestMapping("/passagens")

public class PassagemController {

	@Autowired
	private PassagemRepository passagemRepository;


	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("passagens/listar.html");

		List<Passagens> passagens = passagemRepository.findAll();
		modelAndView.addObject("passagens", passagens);

		return modelAndView;
	}

	// Método cadastrar, chama o objeto vazio

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("passagens/cadastro.html");

		modelAndView.addObject("passagens", new Passagens());

		return modelAndView;
	}

	// Método para retornar o

	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Passagens passagens) throws IOException {

		ModelAndView modelAndView = new ModelAndView("redirect:/passagens");

		passagemRepository.save(passagens);

		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("passagens/detalhar.html");

		Passagens passagens = passagemRepository.getOne(id);
		modelAndView.addObject("passagens", passagens);

		return modelAndView;
	}

	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/passagens");

		passagemRepository.deleteById(id);

		return modelAndView;
	}

	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {

		ModelAndView modelAndView = new ModelAndView("passagens/edicao.html");
		Passagens passagens = passagemRepository.getReferenceById(id);
		modelAndView.addObject("passagens", passagens);

		return modelAndView;
	}

	@PostMapping("/{id}/editar")
	public ModelAndView editar(Passagens passagens) throws IOException {

		ModelAndView modelAndView = new ModelAndView("redirect:/passagens");

		passagemRepository.save(passagens);

		return modelAndView;
	}
}

	


