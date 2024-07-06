package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {
    private TextField display;
    private double num1, num2, result;
    private String operator;

    @Override
    public void start(Stage primaryStage) {
        // Create the display panel
        display = new TextField();
        display.setFont(Font.font("Raleway Semibold", 20));
        display.setPrefWidth(300);
        display.setPrefHeight(50);
        display.setEditable(false);
        display.setStyle("-fx-background-color: #23242c; -fx-text-fill: white;");

        HBox displayPane = new HBox(display);
        displayPane.setAlignment(Pos.CENTER);
        displayPane.setPadding(new Insets(20));
        displayPane.setStyle("-fx-background-color: #12121b;");

        // Create the button panel
        GridPane buttonPane = new GridPane();
        buttonPane.setHgap(5);
        buttonPane.setVgap(5);
        buttonPane.setPadding(new Insets(20));
        buttonPane.setStyle("-fx-background-color: #12121b;");

        String[] buttons = {"(", ")", "sin", "cos", "tan", "1", "2", "3", "+", "-", "4", "5", "6", "*", "/", "7", "8", "9", ".", "C", "0", "="};
        int row = 0, col = 0;
        for (String button : buttons) {
            Button b = new Button(button);
            b.setId(button);
            b.setFont(Font.font("Raleway Semibold", 16));
            b.setPrefWidth(50);
            b.setPrefHeight(50);
            b.setStyle("-fx-background-color: #12121b; -fx-text-fill: white;");
            b.setOnAction(e -> handleButtonClick(((Button)e.getSource()).getId()));
            buttonPane.add(b, col, row);
            col++;
            if (col > 4) {
                col = 0;
                row++;
            }
        }

        // Add the panels to the main layout
        BorderPane root = new BorderPane();
        root.setTop(displayPane);
        root.setCenter(buttonPane);
        root.setStyle("-fx-background-color: #12121b;");

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleButtonClick(String command) {
        if (command.matches("[0-9.]")) {
            display.setText(display.getText() + command);
        } else {
            switch (command) {
                case "C":
                    display.clear();
                    num1 = 0;
                    num2 = 0;
                    operator = null;
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    num1 = Double.parseDouble(display.getText());
                    operator = command;
                    display.clear();
                    break;
                case "=":
                    try {
                        num2 = Double.parseDouble(display.getText());
                    } catch (NumberFormatException e) {
                        num2 = 0;
                    }
                    switch (operator) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "/":
                            if (num2 != 0) {
                                result = num1 / num2;
                            } else {
                                display.setText("Error: Division by zero");
                                return;
                            }
                            break;
                        case "sin":
                            result = Math.sin(Math.toRadians(num1));
                            break;
                        case "cos":
                            result = Math.cos(Math.toRadians(num1));
                            break;
                        case "tan":
                            result = Math.tan(Math.toRadians(num1));
                            break;
                        default:
                            result = 0;
                            break;
                    }
                    display.setText(String.format("%.2f", result));
                    num1 = 0;
                    num2 = 0;
                    operator = null;
                    break;
                case "sin":
                case "cos":
                case "tan":
                    num1 = Double.parseDouble(display.getText());
                    operator = command;
                    display.setText(String.format("%.2f", result));
                    break;
                case "(":
                case ")":
                    display.setText(display.getText() + command);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
