package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

	@FXML
	private RadioButton penRadio;

	@FXML
	private RadioButton eraserRadio;

	@FXML
	private Pane drawingAreaPane;

	@FXML
	void clearButtonPressed(ActionEvent event) {
	    drawingAreaPane.getChildren().clear();
	}

	@FXML
	void drawingAreaMouseDragged(MouseEvent event) {
	    Circle newCircle;

	    // Kiểm tra chế độ vẽ hay tẩy
	    if (eraserRadio.isSelected()) {
	        // Tẩy: vẽ bằng màu nền (trắng)
	        newCircle = new Circle(event.getX(), event.getY(), 4);
	        newCircle.setFill(javafx.scene.paint.Color.WHITE);
	    } else {
	        // Vẽ: mặc định là đen
	        newCircle = new Circle(event.getX(), event.getY(), 4);
	        newCircle.setFill(javafx.scene.paint.Color.BLACK);
	    }

	    drawingAreaPane.getChildren().add(newCircle);
	}
}
