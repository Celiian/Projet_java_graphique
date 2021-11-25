package com.example.demo2.Controller;

import com.example.demo2.classes.Livre;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ConversionsController implements Initializable {

    @FXML
    private TextField Romaintrad;

    @FXML
    private TextField binaireATrad;

    @FXML
    private TextField binaireGlobal;

    @FXML
    private TextField binaireTrad;

    @FXML
    private TextField chiffreRomainATrad;

    @FXML
    private TextField chiffreToHexa;

    @FXML
    private TextField decimalGlobal;

    @FXML
    private Label errorBinaire;

    @FXML
    private Label errorGlobal;

    @FXML
    private Label errorHexa;

    @FXML
    private TextField hexaGlobal;

    @FXML
    private TextField hexaToChiffre;

    @FXML
    private Text imc;

    @FXML
    private TextField poid;

    @FXML
    private TextField romainGlobal;

    @FXML
    private TextField taille;

    int poidEntre = 0;
    int tailleEntre = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Calcul d'imc en fonction de la taille et du poid (entrés dans deux champs séparéments)
        poid.setOnKeyReleased(action -> {
            try {
                poidEntre = Integer.parseInt(poid.getText());
                double tailleFinale = (double) tailleEntre / 100;
                System.out.println(tailleFinale);
                double imcCalc = poidEntre / (tailleFinale * tailleFinale);
                if (imcCalc >= 16.5 && imcCalc <= 18.5) {
                    imc.setText(imcCalc + "Vous avez un imc maigre, votre niveau de maigreur est léger ce qui amène un risque élevé de problèmes d'ostéoporose et d'anémie (plus grand risque de mortalité que l'obésité classe 1 et 2");
                }
                if (imcCalc >= 19 && imcCalc <= 25) {
                    imc.setText(imcCalc + "Vous avez un poids normal, votre poids est idéal ce qui amène un risque faible de comorbidité");
                }
                if ((imcCalc >= 25) && (imcCalc <= 30)) {
                    imc.setText(imcCalc + "Vous êtes en Surpoids, votre niveau d'obésité amène un risque moyen de comorbidité");
                }
                if ((imcCalc >= 30) && (imcCalc <= 35)) {
                    imc.setText(imcCalc + "Vous êtes obèse de classe 2, votre niveau d'obésité amène un risque élevé de comorbidité*");
                }
                if (imcCalc >= 35 && imcCalc <= 40) {
                    imc.setText(imcCalc + "Vous êtes obèse de classe 2 , votre niveau d'obésité amène un risque très élevé de comorbidité");
                }
                if (imcCalc > 40) {
                    imc.setText(imcCalc + "Vous êtes supceptible d'atteindre l'obésité morbide ,votre niveau d'obésité amène un risque extrêmement élevé de comorbidité");
                }
            }
            catch (Exception e){

            }
        });
        taille.setOnKeyReleased(action -> {
            try {
                tailleEntre = Integer.parseInt(taille.getText());
                double tailleFinale = (double) tailleEntre / 100;
                System.out.println(tailleFinale);
                double imcCalc = poidEntre / (tailleFinale * tailleFinale);
                imcCalc = (int) imcCalc;
                if (imcCalc >= 16.5 && imcCalc <= 18.5) {
                    imc.setText(imcCalc + "Vous avez un imc maigre, votre niveau de maigreur est léger ce qui amène un risque élevé de problèmes d'ostéoporose et d'anémie (plus grand risque de mortalité que l'obésité classe 1 et 2");
                }
                if (imcCalc >= 19 && imcCalc <= 25) {
                    imc.setText(imcCalc + "Vous avez un poids normal, votre poids est idéal ce qui amène un risque faible de comorbidité");
                }
                if ((imcCalc >= 25) && (imcCalc <= 30)) {
                    imc.setText(imcCalc + "Vous êtes en Surpoids, votre niveau d'obésité amène un risque moyen de comorbidité");
                }
                if ((imcCalc >= 30) && (imcCalc <= 35)) {
                    imc.setText(imcCalc + "Vous êtes obèse de classe 2, votre niveau d'obésité amène un risque élevé de comorbidité*");
                }
                if (imcCalc >= 35 && imcCalc <= 40) {
                    imc.setText(imcCalc + "Vous êtes obèse de classe 2 , votre niveau d'obésité amène un risque très élevé de comorbidité");
                }
                if (imcCalc > 40) {
                    imc.setText(imcCalc + "Vous êtes supceptible d'atteindre l'obésité morbide ,votre niveau d'obésité amène un risque extrêmement élevé de comorbidité");
                }
            }
            catch (Exception e){

            }
        });

        //PERMET DE CONVERTIR UN CHIFFRE DECIMAL EN CHIFFRE ROMAIN (PAS OPTI)
        //Découpe le chiffre en chaine de charactère puis compare les charactere un a un a des valeures de
        //chiffres romains; lorsqu'une valeure correspond, elle est réduite du chiffre décimale et un charactere
        //est ajouté a la string finale
        //Ici la comparaison est faite a l'aide de nombreuses conditions.. Peut etre raccourcie avec un tableau
        chiffreRomainATrad.setOnKeyReleased(action -> {
           try {
               int numEntre = Integer.parseInt(chiffreRomainATrad.getText());
               StringBuilder strRomain = new StringBuilder();

               for (int i = 0; i < 13; i++) {
                   if (numEntre >= 1000) {
                       numEntre -= 1000;
                       strRomain.append("M");
                   } else if (numEntre >= 900) {
                       numEntre -= 900;
                       strRomain.append("CM");
                   } else if (numEntre >= 500) {
                       numEntre -= 500;
                       strRomain.append("D");
                   } else if (numEntre >= 400) {
                       numEntre -= 400;
                       strRomain.append("CD");
                   } else if (numEntre >= 100) {
                       numEntre -= 100;
                       strRomain.append("C");
                   } else if (numEntre >= 90) {
                       numEntre -= 90;
                       strRomain.append("XC");
                   } else if (numEntre >= 50) {
                       numEntre -= 50;
                       strRomain.append("L");
                   } else if (numEntre >= 40) {
                       numEntre -= 40;
                       strRomain.append("XL");
                   } else if (numEntre >= 10) {
                       numEntre -= 10;
                       strRomain.append("X");
                   } else if (numEntre >= 9) {
                       numEntre -= 9;
                       strRomain.append("IX");
                   } else if (numEntre >= 5) {
                       numEntre -= 5;
                       strRomain.append("V");
                   } else if (numEntre >= 4) {
                       numEntre -= 4;
                       strRomain.append("IV");
                   } else if (numEntre >= 1) {
                       numEntre -= 1;
                       strRomain.append("I");
                   }
               }
               Romaintrad.setText(String.valueOf(strRomain));
           }
           catch (Exception ignored){

           }
        });

        //PERMET DE CONVERTIR UN CHIFFRE ROMAIN EN DECIMAL (PAS OPTI)
        //Meme principe qu'au dessus, liste de condition non optimisé
        Romaintrad.setOnKeyReleased(action -> {
            int chiffreFinal = 0;
            try {
                String romEntre = Romaintrad.getText();
                chiffreFinal = 0;
                int x = 0;
                ArrayList list = new ArrayList();
                while (true) {
                    try {
                        list.add(romEntre.charAt(x));
                        x++;
                    } catch (Exception e) {
                        break;
                    }
                }
                char prochainChar = 'n';
                for (int i = 0; i < list.size(); i++) {
                    char charActuel = romEntre.charAt(i);
                    if(i < (list).size()-1) {
                        prochainChar = romEntre.charAt(i + 1);
                    }
                    if (charActuel == 'M') {
                        chiffreFinal += 1000;
                    } else if (charActuel == 'D') {
                        chiffreFinal += 500;
                    } else if (charActuel == 'C') {
                        if (prochainChar == 'M') {
                            chiffreFinal += 900;
                            i++;
                        } else if (prochainChar == 'D') {
                            chiffreFinal += 400;
                            i++;
                        } else {
                            chiffreFinal += 100;
                        }
                    } else if (charActuel == 'X') {
                        if (prochainChar == 'C') {
                            chiffreFinal += 90;
                            i++;
                        } else if (prochainChar == 'L') {
                            chiffreFinal += 40;
                            i++;
                        } else {
                            chiffreFinal += 10;
                        }
                    } else if (charActuel == 'L') {
                        chiffreFinal += 50;
                    } else if (charActuel == 'V') {
                        chiffreFinal += 5;
                    } else if (charActuel == 'I') {
                        if (prochainChar == 'X') {
                            chiffreFinal += 9;
                            i++;
                        } else if (prochainChar == 'V') {
                            chiffreFinal += 4;
                            i++;
                        } else {
                            chiffreFinal += 1;
                        }
                    }
                }
            } catch (Exception ignored) {
            }
            chiffreRomainATrad.setText(String.valueOf(chiffreFinal));
        });

        //PERMET DE CONVERTIR UN DECIMAL EN CHIFFRE BINAIRE
        //Divise par 2 le chiffre entré et stock le reste (formule pour obtenir un nombre binaire)
        //jusqu'a ce que le chiffre soit nul
        binaireATrad.setOnKeyReleased(action -> {
            StringBuilder str = new StringBuilder();
            try {
                ArrayList<Integer> listeBinaire = new ArrayList<Integer>();
                int chiffre = Integer.parseInt(binaireATrad.getText());

                while (chiffre != 0) {
                    int reste = chiffre % 2;
                    chiffre = chiffre / 2;
                    listeBinaire.add(reste);
                }
                for (int i = listeBinaire.size()-1; i > 0; i--) {
                    str.append(listeBinaire.get(i));
                }
                str.append(listeBinaire.get(0));
            }
            catch (Exception ignore){}
            binaireTrad.setText(String.valueOf(str));
        });

        //PERMET DE CONVERTIR UN CHIFFRE BINAIRE EN CHIFFRE DECIMAL
        //Verifie si le nombre entré est bien binaire et affiche un message d'erreur sinon
        //Effectue ensuite une formule mathématique pour recuperer un nombre binaire a partir d'un chiffre (utilise maths .pow)
        binaireTrad.setOnKeyReleased(action -> {
            int chiffreFinal = 0;
            try {
                ArrayList<Integer> listeBinair = new ArrayList<Integer>();
                int binaire = Integer.parseInt(binaireTrad.getText());
                String binaireStr = String.valueOf(binaire);
                if(binaireStr.contains("2") || binaireStr.contains("3") || binaireStr.contains("4") || binaireStr.contains("5") || binaireStr.contains("6") || binaireStr.contains("7") || binaireStr.contains("8") || binaireStr.contains("9")){
                    errorBinaire.setText("ERREUR : Veuillez entrer un nombre binaire (Composé de 0 ou de 1)");
                }
                else {
                    int x = 0;
                    int add = 0;
                    while (true) {
                        try {
                            add = Integer.parseInt(String.valueOf(binaireStr.charAt(x)));
                            listeBinair.add(add);
                            x++;
                        } catch (Exception e) {
                            break;
                        }
                    }
                    chiffreFinal += Math.pow(add, listeBinair.size());
                    int y = 0;
                    for (int i = listeBinair.size() - 1; i >= 0; i--) {
                        int pow = listeBinair.get(y);
                        chiffreFinal += pow * Math.pow(2, i);
                        y++;
                    }
                    binaireATrad.setText(String.valueOf(chiffreFinal));
                    errorBinaire.setText("");
                }
            }
            catch (Exception ignore){}
        });

        //PERMET DE CONVERTIR UN CHIFFRE DECIMAL ET UN CHIFFRE HEXADECIMAL
        //
        chiffreToHexa.setOnKeyReleased(action -> {
            //decimal to hexa
            try {

                int nombre = Integer.parseInt(chiffreToHexa.getText());
                int modulo_hexa;
                String hexa = "";

                char hex[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

                while (nombre > 0) {
                    modulo_hexa = nombre % 16;
                    hexa = hex[modulo_hexa] + hexa;
                    nombre = nombre / 16;
                }
                hexaToChiffre.setText(hexa);
            }
            catch (Exception ignore){}
        });

        //PERMET DE CONVERTIR HEXADECIMAL EN UN CHIFFRE DECIMAL
        hexaToChiffre.setOnKeyReleased(action -> {
            //hexa to decimal
            try {
                String hexadecimal;
                int decimal = 0;
                int i;
                int len = 0;
                int j = 0;
                hexadecimal = hexaToChiffre.getText();
                if (!hexadecimal.contains("A") && !hexadecimal.contains("B") && !hexadecimal.contains("C") &&
                        !hexadecimal.contains("D") && !hexadecimal.contains("E") && !hexadecimal.contains("F") &&
                        !hexadecimal.contains("1") && !hexadecimal.contains("2") && !hexadecimal.contains("3") &&
                        !hexadecimal.contains("4") && !hexadecimal.contains("5") && !hexadecimal.contains("6") &&
                        !hexadecimal.contains("7") && !hexadecimal.contains("8") && !hexadecimal.contains("9")){
                    errorHexa.setText("ERREUR : Veuillez entrer un nombre Hexadécimal");
                }
                len = hexadecimal.length();
                for (i = len - 1; i >= 0; i--) {
                    if (hexadecimal.charAt(i) >= '0' && hexadecimal.charAt(i) <= '9') {
                        decimal += ((hexadecimal.charAt(i) - 48) * Math.pow(16, j));
                        j++;
                    } else if (hexadecimal.charAt(i) >= 'A' && hexadecimal.charAt(i) <= 'F') {
                        decimal += ((hexadecimal.charAt(i) - 55) * Math.pow(16, j));
                        j++;
                    }
                }
            chiffreToHexa.setText(hexadecimal);
                errorHexa.setText("");
            }
            catch (Exception ignore){}
        });


        //---------------------------------------------------------------------------------------------------------------------------
        //PERMET DANS LE CHAMP GLOBAL DE CONVERTIR LES CHIFFRES DECIMAUX EN ROMAINS / HEXA ET BINAIRE A LA FOI (CODE PRECEDENT REUTILISE PAS OPTI)
        decimalGlobal.setOnKeyReleased(action -> {
            try {
                int numEntre = Integer.parseInt(decimalGlobal.getText());
                StringBuilder strRomain = new StringBuilder();

                for (int i = 0; i < 13; i++) {
                    if (numEntre >= 1000) {
                        numEntre -= 1000;
                        strRomain.append("M");
                    } else if (numEntre >= 900) {
                        numEntre -= 900;
                        strRomain.append("CM");
                    } else if (numEntre >= 500) {
                        numEntre -= 500;
                        strRomain.append("D");
                    } else if (numEntre >= 400) {
                        numEntre -= 400;
                        strRomain.append("CD");
                    } else if (numEntre >= 100) {
                        numEntre -= 100;
                        strRomain.append("C");
                    } else if (numEntre >= 90) {
                        numEntre -= 90;
                        strRomain.append("XC");
                    } else if (numEntre >= 50) {
                        numEntre -= 50;
                        strRomain.append("L");
                    } else if (numEntre >= 40) {
                        numEntre -= 40;
                        strRomain.append("XL");
                    } else if (numEntre >= 10) {
                        numEntre -= 10;
                        strRomain.append("X");
                    } else if (numEntre >= 9) {
                        numEntre -= 9;
                        strRomain.append("IX");
                    } else if (numEntre >= 5) {
                        numEntre -= 5;
                        strRomain.append("V");
                    } else if (numEntre >= 4) {
                        numEntre -= 4;
                        strRomain.append("IV");
                    } else if (numEntre >= 1) {
                        numEntre -= 1;
                        strRomain.append("I");
                    }
                }
                romainGlobal.setText(String.valueOf(strRomain));
            }
            catch (Exception ignored){}

            StringBuilder str = new StringBuilder();
            try {
                ArrayList<Integer> listeBinaire = new ArrayList<Integer>();
                int chiffre = Integer.parseInt(decimalGlobal.getText());

                while (chiffre != 0) {
                    int reste = chiffre % 2;
                    chiffre = chiffre / 2;
                    listeBinaire.add(reste);
                }
                for (int i = listeBinaire.size()-1; i > 0; i--) {
                    str.append(listeBinaire.get(i));
                }
                str.append(listeBinaire.get(0));
            }
            catch (Exception ignore){}
            binaireGlobal.setText(String.valueOf(str));


            try {

                int nombre = Integer.parseInt(decimalGlobal.getText());
                int modulo_hexa;
                String hexa = "";

                char hex[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

                while (nombre > 0) {
                    modulo_hexa = nombre % 16;
                    hexa = hex[modulo_hexa] + hexa;
                    nombre = nombre / 16;
                }
                hexaGlobal.setText(hexa);
            }
            catch (Exception ignore){}
        });

        binaireGlobal.setOnKeyReleased(action -> {
            int chiffreFinal = 0;
            try {
                ArrayList<Integer> listeBinair = new ArrayList<Integer>();
                int binaire = Integer.parseInt(binaireGlobal.getText());
                String binaireStr = String.valueOf(binaire);
                if(binaireStr.contains("2") || binaireStr.contains("3") || binaireStr.contains("4") || binaireStr.contains("5") || binaireStr.contains("6") || binaireStr.contains("7") || binaireStr.contains("8") || binaireStr.contains("9")){
                    errorGlobal.setText("ERREUR : Veuillez entrer un nombre binaire (Composé de 0 ou de 1)");
                }
                else {
                    int x = 0;
                    int add = 0;
                    while (true) {
                        try {
                            add = Integer.parseInt(String.valueOf(binaireStr.charAt(x)));
                            listeBinair.add(add);
                            x++;
                        } catch (Exception e) {
                            break;
                        }
                    }
                    chiffreFinal += Math.pow(add, listeBinair.size());
                    int y = 0;
                    for (int i = listeBinair.size() - 1; i >= 0; i--) {
                        int pow = listeBinair.get(y);
                        chiffreFinal += pow * Math.pow(2, i);
                        y++;
                    }
                    decimalGlobal.setText(String.valueOf(chiffreFinal));
                    errorGlobal.setText("");
                }
            }
            catch (Exception ignore){}

            try {

                int nombre = chiffreFinal;
                int modulo_hexa;
                String hexa = "";

                char hex[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

                while (nombre > 0) {
                    modulo_hexa = nombre % 16;
                    hexa = hex[modulo_hexa] + hexa;
                    nombre = nombre / 16;
                }
                hexaGlobal.setText(hexa);
            }
            catch (Exception ignore){}

            try {
                int numEntre = chiffreFinal;
                StringBuilder strRomain = new StringBuilder();

                for (int i = 0; i < 13; i++) {
                    if (numEntre >= 1000) {
                        numEntre -= 1000;
                        strRomain.append("M");
                    } else if (numEntre >= 900) {
                        numEntre -= 900;
                        strRomain.append("CM");
                    } else if (numEntre >= 500) {
                        numEntre -= 500;
                        strRomain.append("D");
                    } else if (numEntre >= 400) {
                        numEntre -= 400;
                        strRomain.append("CD");
                    } else if (numEntre >= 100) {
                        numEntre -= 100;
                        strRomain.append("C");
                    } else if (numEntre >= 90) {
                        numEntre -= 90;
                        strRomain.append("XC");
                    } else if (numEntre >= 50) {
                        numEntre -= 50;
                        strRomain.append("L");
                    } else if (numEntre >= 40) {
                        numEntre -= 40;
                        strRomain.append("XL");
                    } else if (numEntre >= 10) {
                        numEntre -= 10;
                        strRomain.append("X");
                    } else if (numEntre >= 9) {
                        numEntre -= 9;
                        strRomain.append("IX");
                    } else if (numEntre >= 5) {
                        numEntre -= 5;
                        strRomain.append("V");
                    } else if (numEntre >= 4) {
                        numEntre -= 4;
                        strRomain.append("IV");
                    } else if (numEntre >= 1) {
                        numEntre -= 1;
                        strRomain.append("I");
                    }
                }
                romainGlobal.setText(String.valueOf(strRomain));
            }
            catch (Exception ignored){}
        });

        hexaGlobal.setOnKeyReleased(action -> {
            //hexa to decimal
            int chiffreFinal = 0;
            try {
                String hexadecimal;
                int decimal = 0;
                int i;
                int len = 0;
                int j = 0;
                hexadecimal = hexaGlobal.getText();
                if (!hexadecimal.contains("A") && !hexadecimal.contains("B") && !hexadecimal.contains("C") &&
                        !hexadecimal.contains("D") && !hexadecimal.contains("E") && !hexadecimal.contains("F") &&
                        !hexadecimal.contains("1") && !hexadecimal.contains("2") && !hexadecimal.contains("3") &&
                        !hexadecimal.contains("4") && !hexadecimal.contains("5") && !hexadecimal.contains("6") &&
                        !hexadecimal.contains("7") && !hexadecimal.contains("8") && !hexadecimal.contains("9")){
                    errorGlobal.setText("ERREUR : Veuillez entrer un nombre Hexadécimal");
                }
                len = hexadecimal.length();
                for (i = len - 1; i >= 0; i--) {
                    if (hexadecimal.charAt(i) >= '0' && hexadecimal.charAt(i) <= '9') {
                        decimal += ((hexadecimal.charAt(i) - 48) * Math.pow(16, j));
                        j++;
                    } else if (hexadecimal.charAt(i) >= 'A' && hexadecimal.charAt(i) <= 'F') {
                        decimal += ((hexadecimal.charAt(i) - 55) * Math.pow(16, j));
                        j++;
                    }
                }
                decimalGlobal.setText(hexadecimal);
                chiffreFinal = Integer.parseInt(hexadecimal);
                errorGlobal.setText("");
            }
            catch (Exception ignore){}

            try {
                int numEntre = chiffreFinal;
                StringBuilder strRomain = new StringBuilder();

                for (int i = 0; i < 13; i++) {
                    if (numEntre >= 1000) {
                        numEntre -= 1000;
                        strRomain.append("M");
                    } else if (numEntre >= 900) {
                        numEntre -= 900;
                        strRomain.append("CM");
                    } else if (numEntre >= 500) {
                        numEntre -= 500;
                        strRomain.append("D");
                    } else if (numEntre >= 400) {
                        numEntre -= 400;
                        strRomain.append("CD");
                    } else if (numEntre >= 100) {
                        numEntre -= 100;
                        strRomain.append("C");
                    } else if (numEntre >= 90) {
                        numEntre -= 90;
                        strRomain.append("XC");
                    } else if (numEntre >= 50) {
                        numEntre -= 50;
                        strRomain.append("L");
                    } else if (numEntre >= 40) {
                        numEntre -= 40;
                        strRomain.append("XL");
                    } else if (numEntre >= 10) {
                        numEntre -= 10;
                        strRomain.append("X");
                    } else if (numEntre >= 9) {
                        numEntre -= 9;
                        strRomain.append("IX");
                    } else if (numEntre >= 5) {
                        numEntre -= 5;
                        strRomain.append("V");
                    } else if (numEntre >= 4) {
                        numEntre -= 4;
                        strRomain.append("IV");
                    } else if (numEntre >= 1) {
                        numEntre -= 1;
                        strRomain.append("I");
                    }
                }
                romainGlobal.setText(String.valueOf(strRomain));
            }
            catch (Exception ignored){}

            StringBuilder str = new StringBuilder();
            try {
                ArrayList<Integer> listeBinaire = new ArrayList<Integer>();
                int chiffre = chiffreFinal;

                while (chiffre != 0) {
                    int reste = chiffre % 2;
                    chiffre = chiffre / 2;
                    listeBinaire.add(reste);
                }
                for (int i = listeBinaire.size()-1; i > 0; i--) {
                    str.append(listeBinaire.get(i));
                }
                str.append(listeBinaire.get(0));
            }
            catch (Exception ignore){}
            binaireGlobal.setText(String.valueOf(str));

        });

        romainGlobal.setOnKeyReleased(action -> {
                    int chiffreFinal = 0;
                    try {
                        String romEntre = romainGlobal.getText();
                        chiffreFinal = 0;
                        int x = 0;
                        ArrayList list = new ArrayList();
                        while (true) {
                            try {
                                list.add(romEntre.charAt(x));
                                x++;
                            } catch (Exception e) {
                                break;
                            }
                        }
                        char prochainChar = 'n';
                        for (int i = 0; i < list.size(); i++) {
                            char charActuel = romEntre.charAt(i);
                            if (i < (list).size() - 1) {
                                prochainChar = romEntre.charAt(i + 1);
                            }
                            if (charActuel == 'M') {
                                chiffreFinal += 1000;
                            } else if (charActuel == 'D') {
                                chiffreFinal += 500;
                            } else if (charActuel == 'C') {
                                if (prochainChar == 'M') {
                                    chiffreFinal += 900;
                                    i++;
                                } else if (prochainChar == 'D') {
                                    chiffreFinal += 400;
                                    i++;
                                } else {
                                    chiffreFinal += 100;
                                }
                            } else if (charActuel == 'X') {
                                if (prochainChar == 'C') {
                                    chiffreFinal += 90;
                                    i++;
                                } else if (prochainChar == 'L') {
                                    chiffreFinal += 40;
                                    i++;
                                } else {
                                    chiffreFinal += 10;
                                }
                            } else if (charActuel == 'L') {
                                chiffreFinal += 50;
                            } else if (charActuel == 'V') {
                                chiffreFinal += 5;
                            } else if (charActuel == 'I') {
                                if (prochainChar == 'X') {
                                    chiffreFinal += 9;
                                    i++;
                                } else if (prochainChar == 'V') {
                                    chiffreFinal += 4;
                                    i++;
                                } else {
                                    chiffreFinal += 1;
                                }
                            }
                        }
                    } catch (Exception ignored) {
                    }
                    decimalGlobal.setText(String.valueOf(chiffreFinal));
                    //decimal to hexa
                    try {

                        int nombre = chiffreFinal;
                        int modulo_hexa;
                        String hexa = "";

                        char hex[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

                        while (nombre > 0) {
                            modulo_hexa = nombre % 16;
                            hexa = hex[modulo_hexa] + hexa;
                            nombre = nombre / 16;
                        }
                        hexaGlobal.setText(hexa);
                    } catch (Exception ignore) {}

            StringBuilder str = new StringBuilder();
            try {
                ArrayList<Integer> listeBinaire = new ArrayList<Integer>();
                int chiffre = chiffreFinal;

                while (chiffre != 0) {
                    int reste = chiffre % 2;
                    chiffre = chiffre / 2;
                    listeBinaire.add(reste);
                }
                for (int i = listeBinaire.size()-1; i > 0; i--) {
                    str.append(listeBinaire.get(i));
                }
                str.append(listeBinaire.get(0));
            }
            catch (Exception ignore){}
            binaireGlobal.setText(String.valueOf(str));
        });

    }
}
