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
    private TextField binaireATrad;

    @FXML
    private TextField binaireTrad;
    @FXML
    private TextField Romaintrad;

    @FXML
    private TextField chiffreRomainATrad;

    @FXML
    private Text imc;

    @FXML
    private TextField poid;

    @FXML
    private TextField taille;

    int poidEntre = 0;
    int tailleEntre = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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

        binaireTrad.setOnKeyReleased(action -> {
            int chiffreFinal = 0;
            try {
                ArrayList<Integer> listeBinair = new ArrayList<Integer>();
                int binaire = Integer.parseInt(binaireTrad.getText());
                String binaireStr = String.valueOf(binaire);
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
                    chiffreFinal += pow* Math.pow(2, i);
                    y ++;
                }
                binaireATrad.setText(String.valueOf(chiffreFinal));
            }
            catch (Exception ignore){}
        });
    }
}
