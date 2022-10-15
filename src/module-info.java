module PreparcialPunto1 {
	requires javafx.base;
	requires javafx.controls;
	requires java.logging;
	requires java.desktop;
	requires javafx.graphics;
	requires javafx.fxml;
	
	opens co.edu.uniquindio.preparcial.application to javafx.graphics, javafx.fxml;
	exports co.edu.uniquindio.preparcial.controllers to javafx.fxml;
	opens co.edu.uniquindio.preparcial.controllers to javafx.fxml;
	exports co.edu.uniquindio.preparcial.model;
	opens co.edu.uniquindio.preparcial.model to javafx.fxml, javafx.graphics;
}
