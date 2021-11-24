package com.example.demo2.Controller;

import com.example.demo2.Livre;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.net.URL;
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
            Livre livre = new Livre(titre, auteur, resume, colonne, range, parution);


            tabLivre.getItems().add(livre);
        });
    }
}
