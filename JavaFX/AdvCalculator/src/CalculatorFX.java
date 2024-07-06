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

public class CalculatorFX extends Application {
    private TextField display;
    private double num1, num2, result;
    private String operator;

    @Override
    public void start(Stage primaryStage) {
        // Create the display panel
        display = new TextField();
        display.setFont(Font.font("Raleway Semibold", 20));
        display.setPrefWidth(180);
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

        String[] buttons = {"[+]", "[-]", "[*]", "[/]", "[1]", "[2]", "[3]", "[C]", "[4]", "[5]", "[6]", "[=]", "[7]", "[8]", "[9]", "[.]"};
        int row = 0, col = 0;
        for (String button : buttons) {
            Button b = new Button(button);
            b.setFont(Font.font("Raleway Semibold", 16));
            b.setPrefWidth(50);
            b.setPrefHeight(50);
            b.setStyle("-fx-background-color: #12121b; -fx-text-fill: white;");
            b.setOnAction(e -> handleButtonClick(e.getSource().toString().substring(e.getSource().toString().indexOf("text=") + 5, e.getSource().toString().indexOf("]"))));
            buttonPane.add(b, col, row);
            col++;
            if (col > 3) {
                col = 0;
                row++;
            }
        }

        // Add the panels to the main layout
        BorderPane root = new BorderPane();
        root.setTop(displayPane);
        root.setCenter(buttonPane);
        root.setStyle("-fx-background-color: #12121b;");

        Scene scene = new Scene(root, 300, 400);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleButtonClick(String command) {
        switch (command) {
            case "[+]":
                num1 = Double.parseDouble(display.getText());
                operator = "+";
                display.clear();
                break;
            case "[-]":
                num1 = Double.parseDouble(display.getText());
                operator = "-";
                display.clear();
                break;
            case "[*]":
                num1 = Double.parseDouble(display.getText());
                operator = "*";
                display.clear();
                break;
            case "[/]":
                num1 = Double.parseDouble(display.getText());
                operator = "/";
                display.clear();
                break;
            case "[=]":
                num2 = Double.parseDouble(display.getText());
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
                        result = num1 / num2;
                        break;
                }
                display.setText(String.format("%.2f", result));
                num1 = 0;
                num2 = 0;
                operator = null;
                break;
            case "[C]":
                display.clear();
                num1 = 0;
                num2 = 0;
                operator = null;
                break;
            case "[1]":
                display.setText(display.getText() + "1");
                break;
            case "[2]":
                display.setText(display.getText() + "2");
                break;
            case "[3]":
                display.setText(display.getText() + "3");
                break;
            case "[4]":
                display.setText(display.getText() + "4");
                break;
            case "[5]":
                display.setText(display.getText() + "5");
                break;
            case "[6]":
                display.setText(display.getText() + "6");
                break;
            case "[7]":
                display.setText(display.getText() + "7");
                break;
            case "[8]":
                display.setText(display.getText() + "8");
                break;
            case "[9]":
                display.setText(display.getText() + "9");
                break;
            case "[.]":
                display.setText(display.getText() + ".");
                break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}