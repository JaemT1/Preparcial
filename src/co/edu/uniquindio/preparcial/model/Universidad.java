package co.edu.uniquindio.preparcial.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Universidad implements Serializable{
	
	private static final long serialVersionUID = -6414197579162246426L;
	
	//Attributes
	private ArrayList<Estudiante> estudiantes;
	private ArrayList<Programa> programas;
	
	//Constructors
	public Universidad(ArrayList<Estudiante> estudiantes, ArrayList<Programa> programas) {
		super();
		this.estudiantes = estudiantes;
		this.programas = programas;
	}
	public Universidad() {
	}
	public Universidad(ArrayList<Programa> programas) {
		super();
		this.programas = programas;
	}
	
	
	//Getters y Setters
	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	public ArrayList<Programa> getProgramas() {
		return programas;
	}
	public void setProgramas(ArrayList<Programa> programas) {
		this.programas = programas;
	}
	
}