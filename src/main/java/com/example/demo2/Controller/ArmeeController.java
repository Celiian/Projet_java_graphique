package com.example.demo2.Controller;


import com.example.demo2.classes.General;
import com.example.demo2.classes.Humain;
import com.example.demo2.classes.Soldat;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
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
    private HBox boxButton;

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
    private Button btnSupp;

    @FXML
    private Button btnModif;

    @FXML
    private Label errorMsg;

    @FXML
    private Label lblNbSoldat;

    TreeItem<Humain> rootItem = new TreeItem<Humain>();
    TreeView<Humain> tree = new TreeView<Humain>(rootItem);
    int index = 0;
    int taille = -1;
    boolean isSoldat = false;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rootItem.setExpanded(true);
        tree.setMaxHeight(515);
        tree.setMaxWidth(400);

        paneTree.getChildren().add(tree);

        boxFormArmee.setVisible(false);
        btnModif.setVisible(false);
        btnSupp.setVisible(false);


        tree.setOnMouseClicked(MouseEvent -> {
            MouseButton button = MouseEvent.getButton();
            String buttonStr = String.valueOf(button);


            if (buttonStr.equals("PRIMARY")) {
                if (tree.getSelectionModel().isSelected(0)) {
                    boxFormArmee.setVisible(true);
                    boxFormArmee.getChildren().removeAll(boxPv, boxGrade, boxNom, boxNbSoldat, boxButton);
                    boxFormArmee.getChildren().addAll(boxNom, boxNbSoldat, boxButton);
                    validFormArmee.setVisible(true);
                    btnModif.setVisible(false);
                    btnSupp.setVisible(false);
                    isSoldat = false;
                }

                if (!tree.getSelectionModel().isSelected(0)) {
                    boxFormArmee.setVisible(true);
                    boxFormArmee.getChildren().removeAll(boxNbSoldat, boxNom, boxPv, boxGrade, boxButton);
                    boxFormArmee.getChildren().addAll(boxNom, boxPv, boxGrade, boxButton);
                    validFormArmee.setVisible(true);
                    btnModif.setVisible(false);
                    btnSupp.setVisible(false);
                    isSoldat = true;
                }
            }
            else if(buttonStr.equals("SECONDARY")){
                if (!tree.getSelectionModel().isSelected(0)) {
                    if (tree.getSelectionModel().getSelectedItem().expandedProperty().get()) {
                        boxFormArmee.setVisible(true);
                        boxFormArmee.getChildren().removeAll(boxPv, boxGrade, boxNom, boxNbSoldat, boxButton);
                        boxFormArmee.getChildren().addAll(boxNom, boxNbSoldat, boxButton);
                        nom.setText(tree.getSelectionModel().getSelectedItem().getValue().getNom());
                        lblNbSoldat.setText(String.valueOf(tree.getSelectionModel().getSelectedItem().getValue().getNbSoldat()));
                        validFormArmee.setVisible(false);
                        btnModif.setVisible(true);
                        btnSupp.setVisible(true);
                        isSoldat = false;
                    } else {
                        boxFormArmee.setVisible(true);
                        boxFormArmee.getChildren().removeAll(boxNbSoldat, boxNom, boxPv, boxGrade, boxButton);
                        boxFormArmee.getChildren().addAll(boxNom, boxPv, boxGrade, boxButton);
                        nom.setText(tree.getSelectionModel().getSelectedItem().getValue().getNom());
                        nbPv.setText(String.valueOf(tree.getSelectionModel().getSelectedItem().getValue().getPv()));
                        grade.setText(tree.getSelectionModel().getSelectedItem().getValue().getGrade());
                        validFormArmee.setVisible(false);
                        btnModif.setVisible(true);
                        btnSupp.setVisible(true);
                        isSoldat = true;
                    }
                }
            }
        });


        btnModif.setOnMouseClicked(action -> {
            Humain item_modif = tree.getSelectionModel().getSelectedItem().getValue();
            TreeItem<Humain> ancien_item = tree.getSelectionModel().getSelectedItem();
            if(isSoldat) {
                int nombrePv = item_modif.getPv();
                String gradeSoldat = item_modif.getGrade();
                String nomSoldat = item_modif.getNom();
                if (!grade.getText().equals("")) {
                    item_modif.setGrade(grade.getText());
                }
                if (!nbPv.getText().equals("")) {
                    nombrePv = Integer.parseInt(nbPv.getText());
                    item_modif.setPv(nombrePv);
                }
                if (!nom.getText().equals("")){
                    item_modif.setNom(nom.getText());
                }
                TreeItem<Humain> humain = new TreeItem<Humain>(item_modif);
                tree.getSelectionModel().getSelectedItems().add(humain);
                tree.getSelectionModel().getSelectedItem().getParent().getChildren().remove(ancien_item);
            }
            else {
                String nomSoldat = item_modif.getNom();
                if (!nom.getText().equals("")) {
                    item_modif.setNom(nom.getText());
                }
                ArrayList<TreeItem> list = new ArrayList<TreeItem>();
                for(int i = 0; i < ancien_item.getChildren().size(); i ++){
                    list.add(ancien_item.getChildren().get(i));
                }

                item_modif.setNom(nomSoldat);
                TreeItem<Humain> humain = new TreeItem<Humain>(item_modif);
                for (int i = 0; i < list.size(); i++) {
                    humain.getChildren().add(list.get(i));
                }
                tree.getSelectionModel().getSelectedItems().add(humain);
                tree.getSelectionModel().getSelectedItem().getParent().getChildren().remove(ancien_item);
            }
        });

        btnSupp.setOnMouseClicked(action -> {
            Humain item_modif = tree.getSelectionModel().getSelectedItem().getValue();
            TreeItem<Humain> ancien_item = tree.getSelectionModel().getSelectedItem();
            if(isSoldat) {

                tree.getSelectionModel().getSelectedItem().getParent().getChildren().remove(ancien_item);
            }
            else {
                tree.getSelectionModel().getSelectedItem().getParent().getChildren().remove(ancien_item);
            }
        });


        validFormArmee.setOnMouseClicked(action -> {
            errorMsg.setText("");

            int nombrePv = 0;
            String gradeSoldat = "";
            String nomSoldat = nom.getText();
            if (!grade.getText().equals("")){
                gradeSoldat = grade.getText();
            }
            if (!nbPv.getText().equals("")){
                nombrePv = Integer.parseInt(nbPv.getText());
            }
            if (isSoldat){
                Soldat soldat = new Soldat(nomSoldat, nombrePv, gradeSoldat);
                TreeItem<Humain> humain = new TreeItem<Humain>(soldat);
                if(tree.getSelectionModel().getSelectedItem().expandedProperty().get()){
                    TreeItem<Humain> item = tree.getSelectionModel().getSelectedItem();
                    item.getValue().setNbSoldat(item.getValue().getNbSoldat()+1);
                    item.getChildren().add(humain);
                    if (taille == 2) {
                        item = tri(item);
                    }
                }
                else {
                    errorMsg.setText("Veuillez choisir un Géneral");
                }

            }
            else {
                General general = new General(nomSoldat);
                TreeItem<Humain> humain = new TreeItem<Humain>(general);
                humain.setExpanded(true);
                rootItem.getChildren().add(humain);
                taille ++;
                general.setIndex(taille);
                System.out.println(taille);
            }

            nbPv.setText("");
            nom.setText("");
            grade.setText("");
        });
    }

    public static TreeItem<Humain> tri(TreeItem<Humain> item){
        ArrayList<Humain> listeHumain = new ArrayList<Humain>();
        ArrayList<TreeItem> liste = new ArrayList<TreeItem>();
        int size = item.getChildren().size();

       for(int i = 0; i < size; i += 1){
            TreeItem<Humain> x = item.getChildren().get(i);
            liste.add(item.getChildren().get(i));
            item.getChildren().remove(i);
        }

        for (int i = 0; i < liste.size(); i ++){
            listeHumain.add((Humain) liste.get(i).getValue());
        }

        for(int i = listeHumain.size() - 1 ; i >= 1; i--){
            for(int j = 0 ; j<i ; j++){
                if(listeHumain.get(i).getPv() > listeHumain.get(j+1).getPv()) {
                    Humain humain = listeHumain.get(j + 1);
                    listeHumain.set(j + 1, listeHumain.get(j));
                    listeHumain.set(j, humain);
                }
            }
        }
        for (int i = 0; i < liste.size(); i ++){
            liste.get(i).setValue(listeHumain.get(i));
        }
        for(int i = 0; i <liste.size(); i ++){
            item.getChildren().add(liste.get(i));
        }

        return item;
    }
}