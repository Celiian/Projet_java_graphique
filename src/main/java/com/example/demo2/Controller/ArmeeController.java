package com.example.demo2.Controller;


import com.example.demo2.classes.General;
import com.example.demo2.classes.Humain;
import com.example.demo2.classes.Soldat;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
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

    TreeItem<Humain> rootItem = new TreeItem<Humain>();
    TreeView<Humain> tree = new TreeView<Humain>(rootItem);
    int index = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rootItem.setExpanded(true);
        tree.setMaxHeight(300);

        paneTree.getChildren().add(tree);

        boxFormArmee.setVisible(false);

        tree.setOnMouseClicked(action -> {

            if(tree.getSelectionModel().isSelected(0)){
                boxFormArmee.setVisible(true);
                boxFormArmee.getChildren().removeAll(boxPv, boxGrade, boxNom, boxNbSoldat, validFormArmee);
                boxFormArmee.getChildren().addAll(boxNom, boxNbSoldat, validFormArmee);
            }


            index = tree.getSelectionModel().getSelectedIndex();
            System.out.println(index);
            if(index != 0) {
                boxFormArmee.setVisible(true);
                boxFormArmee.getChildren().removeAll(boxNbSoldat, boxNom, boxPv, boxGrade, validFormArmee);
                boxFormArmee.getChildren().addAll(boxNom, boxPv, boxGrade, validFormArmee);
            }
            index = index -1;
            System.out.println(index);
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
                System.out.println(index);
                TreeItem<Humain> item = rootItem.getChildren().get(index);
                item.getChildren().add(humain);
                }


            else {
                General general = new General(nomSoldat);
                TreeItem<Humain> humain = new TreeItem<Humain>(general);
                humain.setExpanded(true);
                rootItem.getChildren().add(humain);
            }

            nbPv.setText("");
            nom.setText("");
            grade.setText("");
        });


    }
}