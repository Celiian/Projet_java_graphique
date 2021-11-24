package com.example.demo2;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable{
    @FXML
    private VBox global;

    @FXML
    private VBox test;

    @FXML
    private VBox test2;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       global.getChildren().removeAll(test);

    }
}