package com.example.demo2.Controller;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable{
    @FXML
    private VBox boxArmee;

    @FXML
    private VBox boxBibli;

    @FXML
    private VBox boxGlobal;

    @FXML
    private Button boutonBibliotheque;

    @FXML
    private Button boutonArmee;

    @FXML
    private Button boutonChiffreRomain;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        boxGlobal.getChildren().removeAll(boxArmee, boxBibli);

        boutonArmee.setOnMouseClicked(action -> {
            boxGlobal.getChildren().addAll(boxArmee);
            boxGlobal.getChildren().removeAll(boxBibli);

        });
        boutonBibliotheque.setOnMouseClicked(action ->{
            boxGlobal.getChildren().add(boxBibli);
            boxGlobal.getChildren().removeAll(boxArmee);

        });

    }
}