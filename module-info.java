module Graphss {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.base;
	requires javafx.fxml;
	
	opens gui to javafx.graphics, javafx.fxml;
}