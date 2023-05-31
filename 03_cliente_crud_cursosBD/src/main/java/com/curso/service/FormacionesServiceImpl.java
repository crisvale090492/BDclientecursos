package com.curso.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.AuxiliarCurso;
import com.curso.model.Formacion;

@Service
public class FormacionesServiceImpl implements FormacionesService {

	@Autowired
	RestTemplate template;

	private String url = "http://localhost:8080/";

	@Override
	public List<Formacion> cursosExistentes() {
		List<AuxiliarCurso> auxiliar = Arrays.asList(template.getForObject(url + "cursos", AuxiliarCurso[].class));
		List<Formacion> formacion = new ArrayList<Formacion>();

		for (AuxiliarCurso auxiliar1 : auxiliar) {
			Formacion formacion2 = new Formacion();
			formacion2.setCurso(auxiliar1.getNombre());
			formacion2.setPrecio(auxiliar1.getPrecio());
			if (auxiliar1.getDuracion() >= 50) {
				formacion2.setAsignaturas(10);
			} else {
				formacion2.setAsignaturas(5);
			}
			formacion.add(formacion2);
		}
		return formacion;
	}

	@Override
	public void altaCurso(Formacion formacion) {

		AuxiliarCurso auxiliar = new AuxiliarCurso();
		auxiliar.setDuracion(formacion.getAsignaturas() * 10);
		auxiliar.setCodigoCurso(8);
		auxiliar.setNombre(formacion.getCurso());
		auxiliar.setPrecio(formacion.getPrecio());
		template.postForLocation(url + "curso", auxiliar);
	}

}
