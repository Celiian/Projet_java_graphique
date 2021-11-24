package com.example.demo2.Controller;

import com.example.demo2.Livre;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BibliothequeController implements Initializable {

    @FXML
    private Button boutonValider;

    @FXML
    private TextField champAuteur;

    @FXML
    private TextField champColonne;

    @FXML
    private TextField champParution;

    @FXML
    private TextField champRange;

    @FXML
    private TextArea champResume;

    @FXML
    private TextField champTitre;

    @FXML
    private TableView<Livre> tabLivre;

    @FXML
    private Button boutonAjouter;

    @FXML
    private Button boutonSupprimer;

    @FXML
    private Button boutonModifier;

    @FXML
    private VBox boxForm;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        TableColumn auteurColonne = new TableColumn("auteur");
        auteurColonne.setCellValueFactory(new PropertyValueFactory<>("auteur"));

        TableColumn titreColonne = new TableColumn("titre");
        titreColonne.setCellValueFactory(new PropertyValueFactory<>("titre"));

        TableColumn parutionColonne = new TableColumn("parution");
        parutionColonne.setCellValueFactory(new PropertyValueFactory<>("parution"));

        TableColumn colonneColonne = new TableColumn("colonne");
        colonneColonne.setCellValueFactory(new PropertyValueFactory<>("colonne"));

        TableColumn rangeeColonne = new TableColumn("range");
        rangeeColonne.setCellValueFactory(new PropertyValueFactory<>("range"));

        TableColumn resumeColonne = new TableColumn("resume");
        resumeColonne.setCellValueFactory(new PropertyValueFactory<>("resume"));

        tabLivre.getColumns().addAll(titreColonne, auteurColonne, resumeColonne, colonneColonne, rangeeColonne, parutionColonne);




        boutonValider.setOnMouseClicked(action -> {
            String titre = champTitre.getText();
            String auteur = champAuteur.getText();
            int parution = Integer.parseInt(champParution.getText());
            int range = Integer.parseInt(champRange.getText());
            int colonne = Integer.parseInt(champColonne.getText());
            String resume = champResume.getText();
            Livre livre = new Livre(titre, auteur, resume, colonne, range, parution, (tabLivre.getItems().size()+1));
            tabLivre.getItems().add(livre);
            boxForm.setVisible(false);
            boutonValider.setVisible(false);
        });

        tabLivre.setOnMouseClicked(action -> {
            try {
                int index = tabLivre.getSelectionModel().getSelectedIndex();
                Livre actualLivre = tabLivre.getItems().get(index);
                champTitre.setText(actualLivre.getTitre());
                champAuteur.setText(actualLivre.getAuteur());
                champColonne.setText(String.valueOf(actualLivre.getColonne()));
                champParution.setText(String.valueOf(actualLivre.getParution()));
                champRange.setText(String.valueOf(actualLivre.getRange()));
                champResume.setText(actualLivre.getResume());
                boxForm.setVisible(true);
                boutonModifier.setVisible(true);
            }
            catch (Exception e){
            }
        });

        boutonAjouter.setOnMouseClicked(action -> {
            boxForm.setVisible(true);
            boutonValider.setVisible(true);
            boutonModifier.setVisible(false);
        });

        boutonModifier.setOnMouseClicked(action -> {
            String titre = champTitre.getText();
            String auteur = champAuteur.getText();
            int parution = Integer.parseInt(champParution.getText());
            int range = Integer.parseInt(champRange.getText());
            int colonne = Integer.parseInt(champColonne.getText());
            String resume = champResume.getText();
            int index = tabLivre.getSelectionModel().getSelectedIndex();
            Livre actualLivre = tabLivre.getItems().get(index);
            actualLivre.setAuteur(auteur);
            actualLivre.setTitre(titre);
            actualLivre.setParution(parution);
            actualLivre.setColonne(colonne);
            actualLivre.setResume(resume);
            actualLivre.setRange(range);

            ArrayList<Livre> list = new ArrayList<Livre>();
            for (int i = 0; i < tabLivre.getItems().size(); i ++){
                list.add(tabLivre.getItems().get(i));
            }
            for(int i = list.size() - 1 ; i >= 1; i--){
                for(int j = 0 ; j<i ; j++)
                    if(list.get(j).getIndex() > list.get(j+1).getIndex()){
                        Livre livre = list.get(j+1);
                        list.set(j+1, list.get(j));
                        list.set(j, livre);
                    }
            }

            tabLivre.getItems().clear();
            for (int i = 0; i < list.size(); i ++) {
                tabLivre.getItems().add(list.get(i));
            }
            boutonModifier.setVisible(false);
            boxForm.setVisible(false);
        });


    }
}
