package br.gov.fatec.sprintbootapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin//para poder acessar de qualquer site, ou seja acesso externo
public class HomeController {

    @GetMapping
	public String welcome() {
		return"Hello World!";
	}
    
}