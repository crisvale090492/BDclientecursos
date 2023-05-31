package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.CursosDao;
import com.curso.model.Curso;

@Service
public class CursosServiceImpl implements CursosService {
	
	@Autowired
	CursosDao dao;

	@Override
	public List<Curso> cursos() {	
		return dao.findAll();
	}

	@Override
	public Curso buscarCurso(int codigoCurso) {
		return dao.findById(codigoCurso).orElse(null);
	}

	@Override
	public List<Curso> nuevoCurso(Curso curso) {
		dao.save(curso);
		return dao.findAll();
	}

	@Override
	public void actualizarCurso(Curso curso) {
		dao.save(curso);
	}

	@Override
	public List<Curso> eliminarCurso(int codigoCurso) {
		dao.deleteById(codigoCurso);
		return dao.findAll();
	}

	@Override
	public void actualizacionDuracion(Integer codigocurso, Integer duracion) {
		dao.actualizacionDuracion(codigocurso, duracion);
		
	}

	@Override
	public List<Curso> cursosRangoPrecio(Integer preciominimo, Integer preciomaximo) {
		return dao.cursosRangoPrecio(preciominimo, preciomaximo);
		
	}
	
	

}
