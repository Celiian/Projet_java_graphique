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
    private Label errorColonne;

    @FXML
    private Label errorParution;

    @FXML
    private Label errorRange;

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
    private ImageView imgbtnAjouter;

    @FXML
    private ImageView imgBtnSupp;

    @FXML
    private ImageView imgBtnValider;

    @FXML
    private ImageView imgBtnModif;

    @FXML
    private Pane paneBoutons;

    @FXML
    private TextField urlImg;

    @FXML
    private Label errorRetirer;

    boolean titreBon = false;
    boolean auteurBon = false;
    boolean parutionBon = false;
    boolean colonneBon = false;
    boolean rangeBon = false;
    boolean resumeBon = false;
    boolean imgurlBon = false;
    boolean modif = false;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        final String urlBtnAjouter = "https://cdn-icons-png.flaticon.com/512/60/60745.png";
        final Image imgBoutonAjouter = new Image(urlBtnAjouter);
        imgbtnAjouter.setImage(imgBoutonAjouter);
        boutonAjouter.setGraphic(imgbtnAjouter);
        boutonAjouter.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

        final String urlBtnSupp = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxwH8UTatN6YB9TO05F6mn1uB293XRl0B4Fw&usqp=CAU";
        final Image imageBtnSupp = new Image(urlBtnSupp);
        imgBtnSupp.setImage(imageBtnSupp);
        boutonRetirer.setGraphic(imgBtnSupp);
        boutonRetirer.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

        final String urlBtnValid = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR3bjywkSF8Mm-y30t0O5u5Puvn6vVhNjXapjt6B0eqKYt9vo94lEoMLcZdayzLJ_Haypc&usqp=CAU";
        final Image imageBtnValdier = new Image(urlBtnValid);
        imgBtnValider.setImage(imageBtnValdier);
        boutonValider.setGraphic(imgBtnValider);
        boutonValider.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

        final String urlBtnModif = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIcnFzEj5VainEnRAY2Y4P9UgZzfnx4aV7GHs-w7lSwiYSj6Rcc8t6NpTgFvYb4SH58dc&usqp=CAU";
        final Image imageBtnModif = new Image(urlBtnModif);
        imgBtnModif.setImage(imageBtnModif);
        boutonModifier.setGraphic(imgBtnModif);
        boutonModifier.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);




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
            errorRetirer.setText("");
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
                modif = true;
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
            errorRetirer.setText("");
            modif = false;
        });

        //PERMET DE RETIRER UN LIVRE DU TABLEAU PUIS DE REAFFECTER LES LIVRES AU BON EMPLACEMENT
        //CELA PERMET D'EVITER D'AVOIR UN VIDE DANS LE TABLEAU
        //Utilise l'index de l'objet livre qui leur à été attribué a leur création et qui leur permet de bien se positionner
        //index modifiés si nécessaire
        boutonRetirer.setOnMouseClicked(action -> {
            try {
                int index = tabLivre.getSelectionModel().getSelectedIndex();
                Livre actualLivre = tabLivre.getItems().get(index);
                tabLivre.getItems().remove(actualLivre);

                ArrayList<Livre> list = new ArrayList<Livre>();
                int newIndex = 0;
                for (int i = 0; i < tabLivre.getItems().size(); i++) {
                    list.add(tabLivre.getItems().get(i));
                    tabLivre.getItems().get(i).setIndex(i);
                }
                tabLivre.getItems().clear();
                for (int i = 0; i < list.size(); i++) {
                    tabLivre.getItems().add(list.get(i));
                }
                champResume.setText("");
                champRange.setText("");
                champParution.setText("");
                champColonne.setText("");
                champTitre.setText("");
                champAuteur.setText("");
                errorRetirer.setText("");
            }
            catch (Exception e){
                errorRetirer.setText("Aucune ligne sélectionné");
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
            if (!modif) {
                if (auteurBon && titreBon && colonneBon && rangeBon && parutionBon && resumeBon) {
                    boutonValider.setVisible(true);
                }
            }
        });

        champAuteur.setOnKeyReleased((verif_bon->{
            String auteur = champAuteur.getText();
            champAuteur.equals(auteur);
            champAuteur.onKeyTypedProperty().getValue();
            champAuteur.setStyle("-fx-border-color: green;");
            auteurBon = true;
            if (!modif) {
                if (auteurBon && titreBon && colonneBon && rangeBon && parutionBon && resumeBon) {
                    boutonValider.setVisible(true);
                }
            }
        }));


        champRange.setOnKeyReleased(verif_condition->{
            int range = Integer.parseInt(champRange.getText());
            if (range >= 1 && range <= 7){
                champRange.setStyle("-fx-border-color: green;");
                errorRange.setText("");
                rangeBon = true;
                if(auteurBon && titreBon && colonneBon && rangeBon && parutionBon && resumeBon){
                    boutonValider.setVisible(true);
                }
            }
            if(champRange.getText().equals("")){
                champRange.setStyle("-fx-border-color: black");
                errorRange.setText("");
            }
        });

        champColonne.setOnKeyReleased(verif_condition->{
            int colonne = Integer.parseInt(champColonne.getText());
            if (colonne >= 1 && colonne <=5){
                champColonne.setStyle("-fx-border-color: green;");
                errorColonne.setText("");
                colonneBon = true;
                if(auteurBon && titreBon && colonneBon && rangeBon && parutionBon && resumeBon){
                    boutonValider.setVisible(true);
                }
            }
            if(champColonne.getText().equals("")){
                champColonne.setStyle("-fx-border-color: black");
                errorColonne.setText("");
            }
        });

        champParution.setOnKeyReleased(verif_condition->{
            int parution = Integer.parseInt(champParution.getText());
            if (parution >= 2009){
                champParution.setStyle("-fx-border-color: green;");
                errorParution.setText("");
                parutionBon = true;
                if(auteurBon && titreBon && colonneBon && rangeBon && parutionBon && resumeBon){
                    boutonValider.setVisible(true);
                }
            }
            if(champParution.getText().equals("")){
                champParution.setStyle("-fx-border-color: black");
                errorParution.setText("");
            }

        });


        champResume.setOnKeyReleased(verif_bon->{
            String resume = champResume.getText();
            champResume.equals(resume);
            champResume.onKeyTypedProperty().getValue();
            champResume.setStyle("-fx-border-color: green;");
            resumeBon = true;
            if (!modif) {
                if (auteurBon && titreBon && colonneBon && rangeBon && parutionBon && resumeBon) {
                    boutonValider.setVisible(true);
                }
            }

        });


        //_________________
        //EFFECTUE LES VERIFICATION D'ERREUR DES CHAMPS NECESSITANTS UN ENTIER EN PARAMETTRE
        //MET LA BORDURE DU CHAMP EN ROUGE SI AUTRE CHOSE QU'UN ENTIER EST TAPPE
        champRange.setOnKeyTyped(verif_error->{
            String range = champRange.getText();
            champRange.equals(range);
            champRange.setStyle("-fx-border-color: red;");
            errorRange.setText("Veuillez entrer un entier entre 1 et 7");
            rangeBon = false;
            if(!rangeBon){
                boutonValider.setVisible(false);
            }
            if(champRange.getText().equals("")){
                champRange.setStyle("-fx-border-color: black");
                errorRange.setText("");
            }
        });

        champColonne.setOnKeyTyped(verif_error->{
            String colonne = champColonne.getText();
            champColonne.equals(colonne);
            champColonne.setStyle("-fx-border-color: red;");
            errorColonne.setText("Veuillez entrer un entier entre 1 et 5");
            colonneBon = false;
            if(!colonneBon){
                boutonValider.setVisible(false);
            }
            if(champColonne.getText().equals("")){
                champColonne.setStyle("-fx-border-color: black");
                errorColonne.setText("");
            }
        });

        champParution.setOnKeyTyped(verif_error->{
            String parution_string = champParution.getText();
            champParution.equals(parution_string);
            champParution.setStyle("-fx-border-color: red;");
            errorParution.setText("Veuillez entrer une date valide (supérieure à 2009)");
            parutionBon = false;
            if(!parutionBon){
                boutonValider.setVisible(false);
            }
            if(champParution.getText().equals("")){
                champParution.setStyle("-fx-border-color: black");
                errorParution.setText("");
            }

        });


    }
}
