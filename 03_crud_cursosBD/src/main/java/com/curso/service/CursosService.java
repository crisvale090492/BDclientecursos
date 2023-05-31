package com.curso.service;

import java.util.List;

import com.curso.model.Curso;

public interface CursosService {
	
	List<Curso> cursos();
	Curso buscarCurso(int codigoCurso);
	List<Curso> nuevoCurso(Curso curso);
	void actualizarCurso(Curso curso);
	List<Curso> eliminarCurso(int codigoCurso);
	void  actualizacionDuracion( Integer codigocurso,Integer duracion);
	List<Curso> cursosRangoPrecio(Integer preciominimo, Integer preciomaximo);

}
