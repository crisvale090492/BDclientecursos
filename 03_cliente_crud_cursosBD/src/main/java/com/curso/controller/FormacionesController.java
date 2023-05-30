package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Formacion;
import com.curso.service.FormacionesService;

@RestController
public class FormacionesController {
	
	@Autowired
	FormacionesService service;
	
	//http://localhost:9090/formacion
	@GetMapping(value="formacion", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Formacion> cursosExistentes() {
		return service.cursosExistentes();
	}
	
	//http://localhost:9090/formacion
	@PostMapping(value="formacion", produces=MediaType.APPLICATION_JSON_VALUE)
	void nuevoCurso(@RequestBody Formacion formacion) {
		service.altaCurso(formacion);
	}
}

