package co.edu.uniquindio.preparcial.persistence;

import java.io.IOException;
import java.util.ArrayList;

import co.edu.uniquindio.preparcial.model.*;

public class Persistencia {
	//Declaración de rutas archivos
	public static final String RUTA_ARCHIVO_ESTUDIANTES = "src/co/edu/uniquindio/preparcial/resources/DatosEstudiantes.txt";
	public static final String RUTA_ARCHIVO_UNIVERSIDAD_XML = "src/co/edu/uniquindio/preparcial/resources/DatosUniversidad.xml";
	public static final String RUTA_ARCHIVO_UNIVERSIDAD_BINARIO = "src/co/edu/uniquindio/preparcial/resources/DatosUniversidadBinario.dat";
	public static final String RUTA_ARCHIVO_ESTUDIANTES_LOG = "src/co/edu/uniquindio/preparcial/resources/EstudiantesLog.txt";
	public static final String RUTA_ARCHIVO_MODALIDADES_PROPERTIES = "src/co/edu/uniquindio/preparcial/resources/modalidades.properties";
	
	//Métodos Sección Estudiantes
	/**
	 * Método que guarda los estudiantes en el archivo de datos de estudiantes
	 * @param estudiantes Los estudiantes a guardar
	 * @throws IOException
	 */
	public static void guardarEsdtudiantes(ArrayList<Estudiante> estudiantes) throws IOException {
		String contenido = "";
		for (Estudiante estudiante : estudiantes) {
			contenido += estudiante.toString() + "\n"; 
		}
		ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_ESTUDIANTES, contenido, false);
	}
	
	/**
	 * Método que guarda en el archivo log los registros de operaciones 
	 * @param mensaje Mensaje de para el registro
	 * @param nivel Nivel de registro
	 * @param accion Acción que se realizó para registrar en el log
	 * @throws IOException
	 */
	public static void guardarLog(String mensaje, int nivel, String accion) throws IOException{
		ArchivoUtil.guardarRegistroLog(mensaje, nivel, accion, RUTA_ARCHIVO_ESTUDIANTES_LOG);
	}
	
	/**
	 * Método que lee el archivo de datos de los estudiantes y los carga en un ArrayList
	 * @return Retorna el ArrayList de los estudiantes almacenados en el archivo
	 * @throws IOException
	 */
	public static ArrayList<Estudiante> cargarEstudiantes() throws IOException{
		ArrayList<String> estudiantesTxt = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_ESTUDIANTES);
		ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
		for (String estudiante : estudiantesTxt) {
			String[] estudianteSeparado = estudiante.split(",");
			int codigo = Integer.parseInt(estudianteSeparado[0]);
			String nombre = estudianteSeparado[1];
			double nota1 = Double.parseDouble(estudianteSeparado[2]);
			double nota2 = Double.parseDouble(estudianteSeparado[3]);
			double nota3 = Double.parseDouble(estudianteSeparado[4]);
			Estudiante estudianteAuxiliar = new Estudiante(codigo,nombre,nota1,nota2,nota3);
			estudiantes.add(estudianteAuxiliar);
		}
		return estudiantes;
	}
	
	//Métodos Sección Programas
	
	/**
	 * Método que llama al método que carga las propiedades
	 * @return
	 */
	public static String[] cargarModalidades() {
		String[] modalidades = new String[2];
		modalidades = ArchivoUtil.leerArchivoProperties(RUTA_ARCHIVO_MODALIDADES_PROPERTIES);
		return modalidades;
	}
	
	/**
	 * Método que serializa el objeto universidad en formato XML
	 * @param universidad objeto a serializar
	 */
	public static void serializarUniversidadXML(Universidad universidad) {

		ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_UNIVERSIDAD_XML, universidad);

	}
	
	/**
	 * Método que carga los datos desde el archivo XML 
	 * y lo transforma en un objeto universidad
	 * @return retorna el objeto ya cargado con la información
	 */
	public static Universidad cargarDatos() {
		Universidad universidad = null;
		try {
			universidad = (Universidad)ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_UNIVERSIDAD_XML);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return universidad;
	}

	public static void serializarUniversidadBinario(Universidad universidad) {
		try {
			ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_UNIVERSIDAD_BINARIO, universidad);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Universidad cargarDatosBinario(){
		Universidad universidad = null;
		try {
			universidad = (Universidad)ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_UNIVERSIDAD_BINARIO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return universidad;
	}
	
	
}
