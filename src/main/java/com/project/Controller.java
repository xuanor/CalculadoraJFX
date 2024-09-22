package com.project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import java.util.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

// ** Añadir funcionalidades nuevas

public class Controller {

    @FXML
    private TextField display;

    private double num1 = 0;
    private String operator = "";
    private boolean start = true;

    @FXML
    public void handleNumber(javafx.event.ActionEvent event) {
        // Display limpio
        if (start) {
            display.setText("");
            start = false;
        }

        String value = ((Button) event.getSource()).getText();
        if (!value.equals(".")) {
            display.setText(display.getText() + value);
        } else if (!(display.getText().isEmpty()) && !(display.getText().contains(value))) {
            // Si no hay un decimal ya, dejo añadirlo
            display.setText(display.getText() + value);
        }
    }

    @FXML
    public void handleOperation(javafx.event.ActionEvent event) {
        String value = ((Button) event.getSource()).getText();

        if (!"=".equals(value)) {
            if (!operator.isEmpty() || display.getText().isEmpty())
                return;

            operator = value;

            num1 = Double.parseDouble(display.getText());
            display.setText("");

        } else {
            if (operator.isEmpty())
                return;

            double num2 = 0;

            if (!"√".equals(operator)) {
                num2 = Double.parseDouble(display.getText());
            }

            double result = calculate(num1, operator, num2);
            display.setText(String.valueOf(result));
            operator = "";
            start = true;
        }
    }

    private double calculate(double num1, String operator, double num2) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0)
                    return 0;
                return num1 / num2;
            case "%":
                if (num2 == 0)
                    return 0;
                return (num1 * num2) / 100;
            case "√":
                double result = Math.sqrt(num1);
                return result;
            default:
                return 0;
        }
    }

    @FXML
    public void handleClear(javafx.event.ActionEvent event) {
        String value = ((Button) event.getSource()).getText();

        if ("CE".equals(value)) {
            display.setText("");
            operator = "";
            num1 = 0;
            start = true;
        } else {
            String data = display.getText();
            if (!data.isEmpty()) {
                data = data.substring(0, data.length()-1);
                display.setText(data);
            }

        }
    }
}
