package co.edu.uniquindio.preparcial.model;

import java.io.Serializable;

public class Programa implements Serializable{

	private static final long serialVersionUID = -3538385494750769680L;
	
	//Attributes
	private int codigo;
	private String nombre;
	private String modalidad;
	
	//Constructors
	public Programa(int codigo, String nombre, String modalidad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.modalidad = modalidad;
	}
	public Programa() {
		super();
	}
	
	//Getters y Setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	
	//Métodos toString
	@Override
	public String toString() {
		return codigo + "," + nombre + "," + modalidad;
	}
	public String toStringtoShowView() {
		return "Código: " + codigo + "\n" + "Nombre: " + nombre + "\n" + "Modalidad: " + modalidad;
	}
	
	
}
