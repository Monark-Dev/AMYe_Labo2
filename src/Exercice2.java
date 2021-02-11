import java.io.*;

public class Exercice2 {
    public static void main(String[] args) throws Exception {
        BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Nombre d'heures travaillées par l'employé dans l'année? : ");
        double nombreHeuresTravailleesAnnee = Double.parseDouble(clavier.readLine());
        
        double nombreHeuresSemaineNormale;
        System.out.print("Catégorie de l'employé? C = cadre, P = professeur, S = secrétaire, A = autre : ");
        char categorie = (clavier.readLine().toUpperCase().charAt(0));
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
            System.out.println("Vous avez droit à un bonis de Noël de 100$!");
        }
        else{
            System.out.println("Vous n'avez pas de bonis de Noël :-(");
        }
        System.exit(0);
    }
}
