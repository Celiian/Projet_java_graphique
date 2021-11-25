package com.example.demo2.Controller;

import com.example.demo2.classes.Livre;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
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
    private Button boutonRetirer;

    @FXML
    private Button boutonModifier;


    @FXML
    private VBox boxForm;



    @FXML
    private ImageView img;

    @FXML
    private Pane paneBoutons;

    @FXML
    private TextField urlImg;

    boolean titreBon = false;
    boolean auteurBon = false;
    boolean parutionBon = false;
    boolean colonneBon = false;
    boolean rangeBon = false;
    boolean resumeBon = false;
    boolean imgurlBon = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //CREER DES COLONNES DANS LE TABLEAU QUI VONT PERMETTRE D'AFFICHER UN OBJET LIVRE FACILEMENT
        TableColumn auteurColonne = new TableColumn("auteur");
        auteurColonne.setCellValueFactory(new PropertyValueFactory<>("auteur"));

        TableColumn titreColonne = new TableColumn("titre");
        titreColonne.setCellValueFactory(new PropertyValueFactory<>("titre"));

        TableColumn resumeColonne = new TableColumn("resume");
        resumeColonne.setCellValueFactory(new PropertyValueFactory<>("resume"));

        TableColumn parutionColonne = new TableColumn("parution");
        parutionColonne.setCellValueFactory(new PropertyValueFactory<>("parution"));

        TableColumn colonneColonne = new TableColumn("colonne");
        colonneColonne.setCellValueFactory(new PropertyValueFactory<>("colonne"));

        TableColumn rangeeColonne = new TableColumn("range");
        rangeeColonne.setCellValueFactory(new PropertyValueFactory<>("range"));

        TableColumn urlColonne = new TableColumn("url");
        resumeColonne.setCellValueFactory(new PropertyValueFactory<>("url"));

        //AJOUTE LES COLONNES AU TABLEAU
        tabLivre.getColumns().addAll(titreColonne, auteurColonne, resumeColonne, colonneColonne, rangeeColonne, parutionColonne, urlColonne);



        //PERMET DE CREER UN LIVRE PUIS DE L'AJOUTER DANS LE TABLEAU APRES AVOIR CORRECTEMENT REMPLI LES CHAMPS REQUIS
        //recupere les données entrés / crée un objet livre / ajoute l'objet livre au tableau / vide les champs /
        // cache le formulaire et le bouton
        boutonValider.setOnMouseClicked(action -> {
            String titre = champTitre.getText();
            String auteur = champAuteur.getText();
            int parution = Integer.parseInt(champParution.getText());
            int range = Integer.parseInt(champRange.getText());
            int colonne = Integer.parseInt(champColonne.getText());
            String resume = champResume.getText();
            System.out.println(resume);
            String urlImage =  urlImg.getText();
            Livre livre = new Livre(titre, auteur, resume, colonne, range, parution, (tabLivre.getItems().size()+1), urlImage);
            tabLivre.getItems().add(livre);
            boxForm.setVisible(false);
            boutonValider.setVisible(false);
            img.setVisible(false);
            champResume.setText("");
            champRange.setText("");
            champParution.setText("");
            champColonne.setText("");
            champTitre.setText("");
            champAuteur.setText("");
        });

        //AFFICHE LE FORMULAIRE DE MODIFICATION PREREMPLI ET LE BOUTON MODIFIER AFIN DE MODIFIER UN LIVRE
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

        //AFFICHE LE FORMULAIRE DE CREATION DE LIVRE
        boutonAjouter.setOnMouseClicked(action -> {
            boxForm.setVisible(true);
            boutonModifier.setVisible(false);
        });

        //PERMET DE MODIFIER UN ELEMENT
        //utilise un algorythme de tri par index afin de pouvoir réaranger les livres dans le bon
        //ordre une fois un livre modifié création d'une nouvelle version modifié / suppression de l'ancienne /
        //ajout de la nouvelle / tri des livres
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
                for(int j = 0 ; j<i ; j++){
                    if(list.get(j).getIndex() > list.get(j+1).getIndex()) {
                        Livre livre = list.get(j + 1);
                        list.set(j + 1, list.get(j));
                        list.set(j, livre);
                    }
                }
            }
            tabLivre.getItems().clear();
            for (int i = 0; i < list.size(); i ++) {
                tabLivre.getItems().add(list.get(i));
            }
            boutonModifier.setVisible(false);
            boxForm.setVisible(false);
            champResume.setText("");
            champRange.setText("");
            champParution.setText("");
            champColonne.setText("");
            champTitre.setText("");
            champAuteur.setText("");
        });

        //PERMET DE RETIRER UN LIVRE DU TABLEAU PUIS DE REAFFECTER LES LIVRES AU BON EMPLACEMENT
        //CELA PERMET D'EVITER D'AVOIR UN VIDE DANS LE TABLEAU
        //Utilise l'index de l'objet livre qui leur à été attribué a leur création et qui leur permet de bien se positionner
        //index modifiés si nécessaire
        boutonRetirer.setOnMouseClicked(action -> {
            int index = tabLivre.getSelectionModel().getSelectedIndex();
            Livre actualLivre = tabLivre.getItems().get(index);
            tabLivre.getItems().remove(actualLivre);

            ArrayList<Livre> list = new ArrayList<Livre>();
            int newIndex = 0;
            for (int i = 0; i < tabLivre.getItems().size(); i ++){
                list.add(tabLivre.getItems().get(i));
                tabLivre.getItems().get(i).setIndex(i);
            }
            tabLivre.getItems().clear();
            for (int i = 0; i < list.size(); i ++) {
                tabLivre.getItems().add(list.get(i));
            }
        });

        //PERMET AVEC UN LIEN D'IMAGE D'AFFICHER UNE PREVIEW DE L'IMAGE DANS LA BALISE IMAGEVIEW
        // (DISPARAIT QUAND LE FORMULAIRE EST VALIDE)
        urlImg.setOnKeyReleased(action -> {
            String urlImage =  urlImg.getText();
            Image imageUrl = new Image(urlImage);
            img.setImage(imageUrl);
            img.setVisible(true);
        });


        //EFFECTUE LES VERIFICATIONS POSITIVES (MET LES CHAMPS EN VERT SI BIENS REMPLIS)
        //SI TOUS LES CHAMPS SONT BIEN REMPLIS, FAIS APPARRAITRE LE BOUTON VALIDER
        champTitre.setOnKeyReleased(verif_bon->{
            String titre = champTitre.getText();
            champTitre.equals(titre);
            champTitre.onKeyTypedProperty().getValue();
            champTitre.setStyle("-fx-border-color: green;");
            titreBon = true;
            if(auteurBon && titreBon && colonneBon && rangeBon && parutionBon && resumeBon){
                boutonValider.setVisible(true);
            }

        });

        champAuteur.setOnKeyReleased((verif_bon->{
            String auteur = champAuteur.getText();
            champAuteur.equals(auteur);
            champAuteur.onKeyTypedProperty().getValue();
            champAuteur.setStyle("-fx-border-color: green;");
            auteurBon = true;
            if(auteurBon && titreBon && colonneBon && rangeBon && parutionBon && resumeBon){
                boutonValider.setVisible(true);
            }
        }));

        champParution.setOnKeyReleased(verif_bon->{
            int parution = Integer.parseInt(champParution.getText());
            champParution.equals(parution);
            champParution.onKeyTypedProperty().getValue();
            champParution.setStyle("-fx-border-color: green;");
            parutionBon = true;
            if(auteurBon && titreBon && colonneBon && rangeBon && parutionBon && resumeBon){
                boutonValider.setVisible(true);
            }
        });

        champRange.setOnKeyReleased(verif_bon->{
            int range = Integer.parseInt(champRange.getText());
            champRange.equals(range);
            champRange.onKeyTypedProperty().getValue();
            champRange.setStyle("-fx-border-color: green;");
            rangeBon = true;
            if(auteurBon && titreBon && colonneBon && rangeBon && parutionBon && resumeBon){
                boutonValider.setVisible(true);
            }
        });

        champColonne.setOnKeyReleased(verif_bon->{
            int colonne = Integer.parseInt(champColonne.getText());
            champColonne.equals(colonne);
            champColonne.onKeyTypedProperty().getValue();
            champColonne.setStyle("-fx-border-color: green;");
            colonneBon = true;
            if(auteurBon && titreBon && colonneBon && rangeBon && parutionBon && resumeBon){
                boutonValider.setVisible(true);
            }
        });

        champResume.setOnKeyReleased(verif_bon->{
            String resume = champResume.getText();
            champResume.equals(resume);
            champResume.onKeyTypedProperty().getValue();
            champResume.setStyle("-fx-border-color: green;");
            resumeBon = true;
            if(auteurBon && titreBon && colonneBon && rangeBon && parutionBon && resumeBon){
                boutonValider.setVisible(true);
            }
        });


        //_________________
        //EFFECTUE LES VERIFICATION D'ERREUR DES CHAMPS NECESSITANTS UN ENTIER EN PARAMETTRE
        //MET LA BORDURE DU CHAMP EN ROUGE SI AUTRE CHOSE QU'UN ENTIER EST TAPPE
        champRange.setOnKeyTyped(verif_error->{
            String range = champRange.getText();
            champRange.equals(range);
            champRange.setStyle("-fx-border-color: red;");
            rangeBon = false;
            if(!rangeBon){
                boutonValider.setVisible(false);
            }
        });

        champColonne.setOnKeyTyped(verif_error->{
            String colonne = champColonne.getText();
            champColonne.equals(colonne);
            champColonne.setStyle("-fx-border-color: red;");
            colonneBon = false;
            if(!colonneBon){
                boutonValider.setVisible(false);
            }
        });

        champParution.setOnKeyTyped(verif_error->{
            String parution_string = champParution.getText();
            champParution.equals(parution_string);
            champParution.setStyle("-fx-border-color: red;");
            parutionBon = false;
            if(!parutionBon){
                boutonValider.setVisible(false);
            }

        });


    }
}
