package co.edu.uniquindio.preparcial.model;

import java.io.Serializable;

public class Estudiante implements Serializable{
	
	private static final long serialVersionUID = -753682343663348476L;
	
	//Attributes 
	private int codigo;
	private String nombre;
	private double nota1;
	private double nota2;
	private double nota3;
	
	//Constructors
	public Estudiante(int codigo, String nombre, double nota1, double nota2, double nota3) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
	}
	
	public Estudiante() {
		super();
	}
	
	//Getters and Setters
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
	public double getNota1() {
		return nota1;
	}
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	public double getNota2() {
		return nota2;
	}
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	public double getNota3() {
		return nota3;
	}
	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}
	
	//Métodos toString
	@Override
	public String toString() {
		return codigo + "," + nombre + "," + nota1 + "," + nota2 + "," + nota3;
	}	
	
	public String toStringtoShowView() {
		return "Código: " + codigo + "\n" + "Nombre: " + nombre + "\n" + "Nota 1: " + nota1 + "\n" + "Nota 2: " + nota2 + "\n" + "Nota 3: " + nota3;
	}	
}
