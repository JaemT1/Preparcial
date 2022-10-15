package co.edu.uniquindio.preparcial.exceptions;

public class GradeGreaterThan5Exception extends Exception{

	private static final long serialVersionUID = 3071300785466574198L;
	
	public GradeGreaterThan5Exception(String mensaje) {
		super(mensaje);
	}
}
