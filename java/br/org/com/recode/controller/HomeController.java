package br.org.com.recode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")

public class HomeController {
	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/dnacionais")
	public String dnacionais() {
		return "dnacionais";
	}

	@GetMapping("/dinternacionais")
	public String dinternacionais() {
		return "dinternacionais";
	}

	@GetMapping("/promocoes")
	public String promocoes() {
		return "promocoes";
	}

	@GetMapping("/quemsomos")
	public String quemsomos() {
		return "quemsomos";
	}

	@GetMapping("/contato")
	public String contato() {
		return "contato";
	}

	@GetMapping("/login")
	public String login() {
		return "usuario/login";
	}

	@GetMapping("/perfil")
	public String perfil() {
		return "perfil";
	}

	@GetMapping("/cadastro")
	public String cadastro() {
		return "cadastro";
	}
}
