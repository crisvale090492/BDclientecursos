package com.curso.model;



public class AuxiliarCurso {
	
	
	private int codigoCurso;
	private String nombre;
	private int duracion;
	private double precio;
	
	public AuxiliarCurso() {
		super();
	}

	public AuxiliarCurso(int codigoCurso, String nombre, int duracion, double precio) {
		super();
		this.codigoCurso = codigoCurso;
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
	}

	public int getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(int codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	

}
