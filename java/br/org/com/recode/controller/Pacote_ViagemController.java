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
import br.org.com.recode.model.Pacotes;
import br.org.com.recode.repository.Pacote_ViagemRepository;



@Controller
@RequestMapping("/pacotes")


public class Pacote_ViagemController {
	
	@Autowired
	private Pacote_ViagemRepository pacote_viagemRepository;

	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("pacotes/listar.html");

		List<Pacotes> pacotes = pacote_viagemRepository.findAll();
		modelAndView.addObject("pacotes", pacotes);

		return modelAndView;
	}

	// Método cadastrar, chama o objeto vazio

		@GetMapping("/cadastrar")
		public ModelAndView cadastrar() {
			ModelAndView modelAndView = new ModelAndView("pacotes/cadastro.html");

			modelAndView.addObject("pacotes", new Pacotes());

			return modelAndView;
		}
		// Método para retornar o

		@PostMapping("/cadastrar")
		public ModelAndView cadastrar(Pacotes pacotes) throws IOException {

			ModelAndView modelAndView = new ModelAndView("redirect:/pacotes");

			pacote_viagemRepository.save(pacotes);

			return modelAndView;
		}

		@GetMapping("/{id}")
		public ModelAndView detalhar(@PathVariable Long id) {
			ModelAndView modelAndView = new ModelAndView("pacotes/detalhar.html");

			Pacotes pacotes = pacote_viagemRepository.getOne(id);
			modelAndView.addObject("pacotes", pacotes);

			return modelAndView;
		}

		@GetMapping("/{id}/excluir")
		public ModelAndView excluir(@PathVariable Long id) {
			ModelAndView modelAndView = new ModelAndView("redirect:/pacotes");

			pacote_viagemRepository.deleteById(id);

			return modelAndView;
		}

		@GetMapping("/{id}/editar")
		public ModelAndView editar(@PathVariable Long id) {

			ModelAndView modelAndView = new ModelAndView("pacotes/edicao.html");
			Pacotes pacotes = pacote_viagemRepository.getReferenceById(id);
			modelAndView.addObject("pacotes", pacotes);

			return modelAndView;
		}

		@PostMapping("/{id}/editar")
		public ModelAndView editar(Pacotes pacotes) throws IOException {

			ModelAndView modelAndView = new ModelAndView("redirect:/pacotes");

			pacote_viagemRepository.save(pacotes);

			return modelAndView;
		}
	}
