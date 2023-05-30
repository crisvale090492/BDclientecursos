package com.curso.service;

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
	
	private String url="http://localhost:8080/";
	
	@Override
	public List<Formacion> cursosExistentes() {
		List<Formacion> formacion = Arrays.asList(template.getForObject(url+"cursos", Formacion[].class));
		for (Formacion formacion1:formacion)
		if (formacion1.getAsignaturas()*10 >= 50) {
			formacion1.setAsignaturas(10);
		}else {
			formacion1.setAsignaturas(5);}
		return formacion;
	}
	@Override
	public void altaCurso(Formacion formacion) {
		
		AuxiliarCurso auxiliar = new AuxiliarCurso();
		auxiliar.setDuracion(formacion.getAsignaturas()*10);
		auxiliar.setCodigoCurso(5);
		auxiliar.setNombre(formacion.getCurso());
		auxiliar.setPrecio(formacion.getPrecio());
		template.postForLocation(url+"curso", AuxiliarCurso.class);
	}
	

}
