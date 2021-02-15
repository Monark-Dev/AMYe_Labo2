import java.io.*;
import java.text.NumberFormat;
import java.util.Locale;

public class Exercice2 {
    public static void main(String[] args) throws Exception {

        final int SENTINELLE = -1;
        double totalDesBonis = 0;
        double nombreHeuresTravailleesAnnee = 0;

        BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Nombre d'heures travaillées par l'employé dans l'année? Entrez -1 pour terminer : ");
        nombreHeuresTravailleesAnnee = Double.parseDouble(clavier.readLine());

        while (nombreHeuresTravailleesAnnee != SENTINELLE){  
            
            double nombreHeuresSemaineNormale;
            System.out.print("Catégorie de l'employé? C = cadre, P = professeur, S = secrétaire, A = autre : ");
            char categorie = clavier.readLine().toUpperCase().charAt(0);
            switch(categorie){
                case 'C':
                    nombreHeuresSemaineNormale = 35;
                    break;
                case 'P':
                    nombreHeuresSemaineNormale = 45;
                    break;
                case 'S':
                    nombreHeuresSemaineNormale = 37.5;
                    break;
                case 'A':
                    nombreHeuresSemaineNormale = 32.5;
                    break;
                default:
                    nombreHeuresSemaineNormale = 0;
            }

            double heuresSupplementairesAccumuleeAnnee = nombreHeuresTravailleesAnnee - nombreHeuresSemaineNormale * 52;

            if(nombreHeuresSemaineNormale == 0){
                System.out.println("Erreur de catégorie ");
            }
            else if(nombreHeuresSemaineNormale >= 40 || heuresSupplementairesAccumuleeAnnee > 50){
                System.out.println("L'employé a droit à un bonis de Noël de 100$!");
                totalDesBonis += 100;
            }
            else{
                System.out.println("L'employé n'a pas droit au bonis de Noël :-(");
            }

            System.out.print("Nombre d'heures travaillées par l'employé dans l'année? Entrez -1 pour terminer : ");
            nombreHeuresTravailleesAnnee = Double.parseDouble(clavier.readLine());
            
        }

        String totalDollarCanadien = NumberFormat.getCurrencyInstance(Locale.CANADA_FRENCH).format(totalDesBonis); 

        System.out.println("TOTAL DES BONIS : " + totalDollarCanadien);
        System.exit(0);

    }
}
