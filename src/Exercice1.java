import java.io.*;
import java.text.NumberFormat;
import java.util.Locale;

public class Exercice1 {
    public static void main(String[] args) throws Exception {
        String nomDuClient;
        int nombreDeJours;
        char categorieOutil;
        int tarifParJour;
        char reponse = 'O';
        double totalDesVentes = 0;
        String facture = "";
        
        do{
            BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Nom du client? : ");
            nomDuClient = clavier.readLine();
    
            System.out.print("Nombre de jours de location? : ");
            nombreDeJours = Integer.parseInt(clavier.readLine());
    
            System.out.print("Catégorie de l'outil? A = Léger, W = Lourd, P = Professionel : ");
            categorieOutil = clavier.readLine().charAt(0);
            
            switch (categorieOutil){
                case 'A' :
                    tarifParJour = 15;
                    break;
                case 'W' :
                    tarifParJour = 42;
                    break;
                case 'P' :
                    tarifParJour = 50;
                    break;
                default :
                    tarifParJour = 0;
            }
    
            double totalAPayer = nombreDeJours * tarifParJour;
    
            if(tarifParJour == 0)
                System.out.println("Erreur de catégorie ");
            
            if(nombreDeJours > 3 && categorieOutil != 'A')
                totalAPayer *= 0.8;
                if(totalAPayer > 200)
                    totalAPayer *= 0.95;
    
            totalDesVentes += totalAPayer;
            
            String montantDollarCanadien = NumberFormat.getCurrencyInstance(Locale.CANADA_FRENCH).format(totalAPayer); 
            facture += "\n" + nomDuClient + " doit payer " + montantDollarCanadien;
            System.out.println(facture);
            

            System.out.print("Voulez-vous continuer ? O / N  : ");
            reponse = clavier.readLine().toUpperCase().charAt(0);

            
    
        } while (reponse != 'N');
        String totalDollarCanadien = NumberFormat.getCurrencyInstance(Locale.CANADA_FRENCH).format(totalDesVentes); 
        System.out.println("TOTAL DES VENTES : " + totalDollarCanadien);

        System.exit(0);

    }
}
