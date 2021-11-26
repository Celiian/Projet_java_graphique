package com.example.demo2.Controller;


import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import javafx.scene.input.DragEvent;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
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
    private VBox boxConv;

    @FXML
    private Button boutonBibliotheque;

    @FXML
    private Button boutonArmee;

    @FXML
    private Button boutonConversions;

    @FXML
    private Button quit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        boxGlobal.getChildren().removeAll(boxArmee, boxBibli, boxConv);

        boutonArmee.setOnMouseClicked(action -> {
            boxGlobal.getChildren().addAll(boxArmee);
            boxGlobal.getChildren().removeAll(boxBibli);
            boxGlobal.getChildren().remove(boxConv);
        });
        boutonBibliotheque.setOnMouseClicked(action ->{
            boxGlobal.getChildren().add(boxBibli);
            boxGlobal.getChildren().removeAll(boxArmee);
            boxGlobal.getChildren().remove(boxConv);
        });

        boutonConversions.setOnMouseClicked(action -> {
            boxGlobal.getChildren().removeAll(boxBibli);
            boxGlobal.getChildren().removeAll(boxArmee);
            boxGlobal.getChildren().add(boxConv);
        });


        quit.setOnAction(action -> {
            Platform.exit();

        });

    }

}