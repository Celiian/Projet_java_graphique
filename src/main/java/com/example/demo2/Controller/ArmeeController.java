package com.example.demo2.Controller;


import com.example.demo2.classes.General;
import com.example.demo2.classes.Humain;
import com.example.demo2.classes.Soldat;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ArmeeController implements Initializable{

    @FXML
    private Button boutonGeneral;

    @FXML
    private Button boutonSoldat;

    @FXML
    private VBox boxArmee;

    @FXML
    private VBox boxFormArmee;

    @FXML
    private HBox boxGrade;

    @FXML
    private HBox boxNbSoldat;

    @FXML
    private HBox boxNom;

    @FXML
    private HBox boxPv;

    @FXML
    private TextField grade;

    @FXML
    private TextField nbPv;

    @FXML
    private TextField nom;

    @FXML
    private Pane paneTree;

    @FXML
    private Button validFormArmee;

    @FXML
    private Label errorMsg;

    @FXML
    private Label lblNbSoldat;

    TreeItem<Humain> rootItem = new TreeItem<Humain>();
    TreeView<Humain> tree = new TreeView<Humain>(rootItem);
    int index = 0;
    int taille = -1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rootItem.setExpanded(true);
        tree.setMaxHeight(515);
        tree.setMaxWidth(400);

        paneTree.getChildren().add(tree);

        boxFormArmee.setVisible(false);


        tree.setOnMouseClicked(MouseEvent -> {
            int count = MouseEvent.getClickCount();

            if (count == 1) {
                if (tree.getSelectionModel().isSelected(0)) {
                    boxFormArmee.setVisible(true);
                    boxFormArmee.getChildren().removeAll(boxPv, boxGrade, boxNom, boxNbSoldat, validFormArmee);
                    boxFormArmee.getChildren().addAll(boxNom, boxNbSoldat, validFormArmee);
                }

                if (!tree.getSelectionModel().isSelected(0)) {
                    boxFormArmee.setVisible(true);
                    boxFormArmee.getChildren().removeAll(boxNbSoldat, boxNom, boxPv, boxGrade, validFormArmee);
                    boxFormArmee.getChildren().addAll(boxNom, boxPv, boxGrade, validFormArmee);
                }
            }
            else {
                if(tree.getSelectionModel().getSelectedItem().expandedProperty().get()){
                    boxFormArmee.setVisible(true);
                    boxFormArmee.getChildren().removeAll(boxPv, boxGrade, boxNom, boxNbSoldat, validFormArmee);
                    boxFormArmee.getChildren().addAll(boxNom, boxNbSoldat, validFormArmee);
                }
                else if (!tree.getSelectionModel().getSelectedItem().expandedProperty().get()) {
                    boxFormArmee.setVisible(true);
                    boxFormArmee.getChildren().removeAll(boxNbSoldat, boxNom, boxPv, boxGrade, validFormArmee);
                    boxFormArmee.getChildren().addAll(boxNom, boxPv, boxGrade, validFormArmee);
                }
            }
        });



        validFormArmee.setOnMouseClicked(action -> {
            errorMsg.setText("");

            boolean isSoldat = false;
            int nombrePv = 0;
            String gradeSoldat = "";
            String nomSoldat = nom.getText();
            if (!grade.getText().equals("")){
                gradeSoldat = grade.getText();
            }
            if (!nbPv.getText().equals("")){
                nombrePv = Integer.parseInt(nbPv.getText());
                isSoldat = true;
            }
            if (isSoldat){
                Soldat soldat = new Soldat(nomSoldat, nombrePv, gradeSoldat);
                TreeItem<Humain> humain = new TreeItem<Humain>(soldat);
                if(tree.getSelectionModel().getSelectedItem().expandedProperty().get()){
                    TreeItem<Humain> item = tree.getSelectionModel().getSelectedItem();
                    item.getChildren().add(humain);
                }
                else {
                    errorMsg.setText("Veuillez choisir un noeud Géneral");
                }

            }
            else {
                General general = new General(nomSoldat);
                TreeItem<Humain> humain = new TreeItem<Humain>(general);
                humain.setExpanded(true);
                rootItem.getChildren().add(humain);
                taille ++;
            }

            nbPv.setText("");
            nom.setText("");
            grade.setText("");
        });
    }
}