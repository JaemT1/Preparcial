package co.edu.uniquindio.preparcial.controllers;

import java.io.IOException;
import java.io.Serializable;

import co.edu.uniquindio.preparcial.model.*;
import co.edu.uniquindio.preparcial.persistence.Persistencia;

public class ModelFactoryController implements Serializable {

	private static final long serialVersionUID = -4040905587180317945L;

	// Declaración de atributos

	private static ModelFactoryController instance;

	Universidad universidad = new Universidad();

	String[] modalidades = new String[2];

	// ------------------------------ SINGLETON
	// ------------------------------------------------
	/**
	 * Método que devuelve la instancia del singleton y verifica si existe la
	 * instancia, si no la crea
	 * 
	 * @return instance
	 */
	public static ModelFactoryController getInstance() {
		if (instance == null) {
			instance = new ModelFactoryController();
		}
		return instance;
	}

	/**
	 * Método constructor
	 */
	private ModelFactoryController() {
		// cargarDatosUniversidad();
		cargarDatosUniversidadBinario();
		// Siempre se debe verificar si la raiz del recurso es null
		if (universidad == null) {
			System.out.println("Universidad está vacío");
		}
	}

//Métodos Sección Estudiantes

	/**
	 * Método que carga los datos de los estudiantes desde el archivo .txt
	 */
	public void cargarDatosEstudiantes() {
		try {
			universidad.setEstudiantes(Persistencia.cargarEstudiantes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método que guarda los estudiantes en el archivo .txt
	 */
	public void guardarEstudiantes() {
		try {
			Persistencia.guardarEsdtudiantes(universidad.getEstudiantes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método que guarda un registro en un archivo log
	 * 
	 * @param mensaje el mensaje a guardar
	 * @param nivel   el nivel del registro
	 * @param accion  la acción que se realizaba
	 */
	public void guardarLog(String mensaje, int nivel, String accion) {
		try {
			Persistencia.guardarLog(mensaje, nivel, accion);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Métodos Sección Estudiantes

	/**
	 * Método que carga las modalidades desde el archivo .properties
	 */
	public void cargarPropiedades() {
		modalidades = Persistencia.cargarModalidades();
	}

	/**
	 * Método que serializa en formato XML el objeto universidad
	 */
	public void serializarUniversidadXML() {
		Persistencia.serializarUniversidadXML(universidad);
	}

	/**
	 * Método que carga los datos de la universidad
	 */
	public void cargarDatosUniversidad() {
		universidad = Persistencia.cargarDatos();

	}

	public void serializarUniversidadBinario() {
		Persistencia.serializarUniversidadBinario(universidad);
	}
	
	private void cargarDatosUniversidadBinario() {
		universidad = Persistencia.cargarDatosBinario();

	}
}
