package co.edu.uniquindio.preparcial.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import co.edu.uniquindio.preparcial.exceptions.*;
import co.edu.uniquindio.preparcial.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class FormularioViewController implements Initializable, Serializable{

	private static final long serialVersionUID = -7128055332073913477L;
	
	//Declaración atributos sección Estudiantes
	@FXML
	private TextField txtCodigoEstudiante;
	@FXML
	private TextField txtNombreEstudiante;
	@FXML
	private TextField txtNota1;
	@FXML
	private TextField txtNota2;
	@FXML
	private TextField txtNota3;
	@FXML
	private TextField txtCodigoEstudianteABuscar;
	@FXML
	private Label lblInfoEstudiante;
	
	//Declaración atributos sección Programas
	@FXML
	private TextField txtCodigoPrograma;
	@FXML
	private TextField txtNombrePrograma;
	@FXML
	private TextField txtCodigoProgramaABuscar;
	@FXML
	private ChoiceBox<String> cboxModalidad;
	@FXML
	private Label lblInfoPrograma;
	
	
	//Lógica Sección Estudiantes
	/**
	 * Método que guarda los estudiantes en el archivo de estudiantes
	 * @param event
	 */
	@FXML
	public void guardarEstudiante(ActionEvent event) throws GradeGreaterThan5Exception{
			int codigo = Integer.parseInt(txtCodigoEstudiante.getText());
			String nombre = txtNombreEstudiante.getText();
			double nota1 = Double.parseDouble(txtNota1.getText());
			double nota2 = Double.parseDouble(txtNota2.getText());
			double nota3 = Double.parseDouble(txtNota3.getText());
			if (verificarNotas(nota1, nota2, nota3)) {
				Estudiante estudiante = new Estudiante(codigo,nombre,nota1,nota2,nota3);
				ModelFactoryController.getInstance().universidad.getEstudiantes().add(estudiante);
				ModelFactoryController.getInstance().guardarEstudiantes();
				ModelFactoryController.getInstance().guardarLog("Se guarda un estudiante", 1,  "El estudiante con código: " + codigo + " ha sido agregado ");
				JOptionPane.showMessageDialog(null, "Se ha guardado con éxito el estudiante");
				vaciarTxtFieldsEstudiantes();
			}else {
				ModelFactoryController.getInstance().guardarLog("No se pudo guardar el estudiante", 2,  "El estudiante con código: " + codigo + " no pudo ser agregado porque alguna nota es mayor a 5");
				JOptionPane.showMessageDialog(null, "Las notas no pueden ser mayores a 5");
				throw new GradeGreaterThan5Exception("Las notas no deben ser mayores a 5");
			}		
	}
	
	/**
	 * Método que busca a un estudiante mediante un codigo en especifico
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void buscarEstudiante(ActionEvent event) throws IOException{
		int codigoABuscar = Integer.parseInt(txtCodigoEstudianteABuscar.getText());
		for (Estudiante estudiante : ModelFactoryController.getInstance().universidad.getEstudiantes()) {
			if (estudiante.getCodigo() == codigoABuscar) {
				JOptionPane.showMessageDialog(null, "El estudiante ha sido encontrado");
				lblInfoEstudiante.setText(estudiante.toStringtoShowView());
			}else {
				lblInfoEstudiante.setText("Estudiante no encontrado");
				txtCodigoEstudianteABuscar.setText("");
			}
		}
	}
	
	/**
	 * Método usado para vaciar los TextFields de la seccion de estudiantes
	 */
	@FXML
	public void vaciarTxtFieldsEstudiantes() {
		txtCodigoEstudiante.setText("");
		txtNombreEstudiante.setText("");
		txtNota1.setText("");
		txtNota2.setText("");
		txtNota3.setText("");
	}
	
	/**
	 * Método que vérifica si las notas son mayores a 5
	 * @param nota1 nota a verificar
	 * @param nota2 nota a verificar
	 * @param nota3 nota a verificar
	 * @return retorna true si son válidas o false si no lo son
	 */
	public boolean verificarNotas(double nota1, double nota2, double nota3) {
		boolean notasValidas = true;
		if (nota1 > 5 || nota2 > 5 || nota3 > 5) {
			notasValidas = false;
		}
		return notasValidas;
	}
	
	//Lógica Sección Programas
	
	/**
	 * Método que obtiene los datos del formulario y guarda un programa
	 * @param event
	 */
	@FXML
	public void guardarPrograma(ActionEvent event) {
		int codigo = Integer.parseInt(txtCodigoPrograma.getText());
		String nombre = txtNombrePrograma.getText();
		String modalidad = cboxModalidad.getValue();
		Programa programa = new Programa(codigo, nombre, modalidad);
		ModelFactoryController.getInstance().universidad.getProgramas().add(programa);
		ModelFactoryController.getInstance().serializarUniversidadXML();
		JOptionPane.showMessageDialog(null, "El programa ha sido agregado");
		vaciarTxtFieldsProgramas();
	}
	
	/**
	 * Método que busca un programa en específico en base a un código
	 * @param event
	 */
	@FXML
	public void buscarPrograma(ActionEvent event) {
		int codigoABuscar = Integer.parseInt(txtCodigoProgramaABuscar.getText());
		for (Programa programa : ModelFactoryController.getInstance().universidad.getProgramas()) {
			if (programa.getCodigo() == codigoABuscar) {
				JOptionPane.showMessageDialog(null, "El programa ha sido encontrado");
				lblInfoPrograma.setText(programa.toStringtoShowView());
			}else {
				lblInfoPrograma.setText("Programa no encontrado");
				txtCodigoProgramaABuscar.setText("");
			}
		}
	}
	
	/**
	 * Método usado para vaciar los TextFields de la seccion de programas
	 */
	@FXML
	public void vaciarTxtFieldsProgramas() {
		txtCodigoPrograma.setText("");
		txtNombrePrograma.setText("");	
	}
	
	/**
	 * Sobreescritura del método initialize que carga las modalidades 
	 * desde el archivo properties al iniciar la ventana
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ModelFactoryController.getInstance().cargarPropiedades();
		cboxModalidad.getItems().add(ModelFactoryController.getInstance().modalidades[0]);
		cboxModalidad.getItems().add(ModelFactoryController.getInstance().modalidades[1]);
	}
}
