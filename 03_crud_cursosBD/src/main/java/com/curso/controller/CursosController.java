package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.service.CursosService;

@RestController
public class CursosController {
	
	@Autowired
	CursosService service;
	
			//http://localhost:8080/cursos
			@GetMapping(value="cursos", produces=MediaType.APPLICATION_JSON_VALUE)
			public List<Curso> cursos() {
				return service.cursos();
			}
			//http://localhost:8080/curso/1
			@GetMapping(value="curso/{codigocurso}", produces=MediaType.APPLICATION_JSON_VALUE)
			public Curso buscarCurso(@PathVariable int codigocurso) {
				return service.buscarCurso(codigocurso);
			}
			//http://localhost:8080/curso
			@PostMapping(value="curso", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
			public List<Curso> nuevoCurso(@RequestBody Curso curso) {
				service.nuevoCurso(curso);
				return service.cursos();
			}
			//http://localhost:8080/curso
			@PutMapping(value="curso", produces=MediaType.APPLICATION_JSON_VALUE)
			void actualizarCurso(@RequestBody Curso curso) {
				service.actualizarCurso(curso);
			}
			//http://localhost:8080/curso/1
			@DeleteMapping(value="curso/{codigocurso}", produces=MediaType.APPLICATION_JSON_VALUE)
			public List<Curso> eliminarCurso(@PathVariable int codigocurso) {
				service.eliminarCurso(codigocurso);
				return service.cursos();
			}
			//http://localhost:8080/cursos/1/10
			@PutMapping(value="cursos/{codigocurso}/{duracion}", produces=MediaType.APPLICATION_JSON_VALUE)
			void actualizacionDuracion(@PathVariable int codigocurso, @PathVariable int duracion) {
			}
			//http://localhost:8080/cursos/10.0/20.0
			@GetMapping(value="cursos/{preciominimo}/{preciomaximo}", produces=MediaType.APPLICATION_JSON_VALUE)
			public List<Curso> cursosRangoPrecio(@PathVariable int preciominimo, @PathVariable int preciomaximo) {
				return service.cursosRangoPrecio(preciominimo,preciomaximo);
			}
			

}
