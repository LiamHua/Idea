package pers.liam.calculator.controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pers.liam.calculator.Factory.Client;

import java.io.IOException;

public class Calculator extends Application {
    @FXML
    private Button bt_1;
    @FXML
    private Button bt_2;
    @FXML
    private Button bt_3;
    @FXML
    private Button bt_4;
    @FXML
    private Button bt_5;
    @FXML
    private Button bt_6;
    @FXML
    private Button bt_7;
    @FXML
    private Button bt_8;
    @FXML
    private Button bt_9;
    @FXML
    private Button bt_0;
    @FXML
    private Button bt_point;
    @FXML
    private Button bt_add;
    @FXML
    private Button bt_sub;
    @FXML
    private Button bt_mul;
    @FXML
    private Button bt_divide;
    @FXML
    private Button bt_getResult;
    @FXML
    private TextField Result;


    @FXML
    public void onClick_1(ActionEvent actionEvent) {
        Result.appendText("1");
    }

    @FXML
    public void onClick_2(ActionEvent actionEvent) {
        Result.appendText("2");
    }

    @FXML
    public void onClick_3(ActionEvent actionEvent) {
        Result.appendText("3");
    }

    @FXML
    public void onClick_4(ActionEvent actionEvent) {
        Result.appendText("4");
    }

    @FXML
    public void onClick_5(ActionEvent actionEvent) {
        Result.appendText("5");
    }

    @FXML
    public void onClick_6(ActionEvent actionEvent) {
        Result.appendText("6");
    }

    @FXML
    public void onClick_7(ActionEvent actionEvent) {
        Result.appendText("7");
    }

    @FXML
    public void onClick_8(ActionEvent actionEvent) {
        Result.appendText("8");
    }

    @FXML
    public void onClick_9(ActionEvent actionEvent) {
        Result.appendText("9");
    }

    @FXML
    public void onClick_0(ActionEvent actionEvent) {
        Result.appendText("0");
    }

    @FXML
    public void onClick_point(ActionEvent actionEvent) {
        Result.appendText(".");
    }

    @FXML
    public void onClick_add(ActionEvent actionEvent) {
        Result.appendText("+");
    }

    @FXML
    public void onClick_sub(ActionEvent actionEvent) {
        Result.appendText("-");
    }

    @FXML
    public void onClick_mul(ActionEvent actionEvent) {
        Result.appendText("*");
    }

    @FXML
    public void onClick_divide(ActionEvent actionEvent) {
        Result.appendText("/");
    }

    @FXML
    public void onClick_getResult(ActionEvent actionEvent) throws Exception {
        Result.appendText("=");
        Client client = new Client();

        client.str = Result.getText();
        double result = client.calculator();
        Result.setText(Double.toString(result));
    }

    @FXML
    public void onClick_clear() {
        Result.setText("");
    }
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/pers/liam/calculator/view/calculator.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("计算器");
        primaryStage.show();
    }


}
