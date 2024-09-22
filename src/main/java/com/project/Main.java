package com.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Calculadora.fxml"));

        // Cargar el ícono desde los recursos

        Image icon = new Image(getClass().getResourceAsStream("/images/icono.png"));

        // Establecer el ícono en la ventana
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(new Scene(root, 318, 490));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(icon);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

