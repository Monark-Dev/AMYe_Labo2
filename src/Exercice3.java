import java.io.*;
import java.text.NumberFormat;
import java.util.Locale;

public class Exercice3 {
    public static void main(String[] args) throws IOException {

        double totalRouteMunicipale = 0;
        double totalAutoroute = 0;
        double fraisDeCours = 25;
        boolean erreur = false;

        BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Combien de limites de vitesse voulez-vous traiter : ");
        int nbLimites = Integer.parseInt(clavier.readLine());

        for (int compteur = 1; compteur <= nbLimites; compteur++){

            double amendeAPayer = 0;
            System.out.print("Type de route? M = municipale, A = autoroute : ");
            char typeDeRoute = clavier.readLine().toUpperCase().charAt(0);

            System.out.print("Limite de vitesse permise en Km/h? : ");
            int limiteDeVitesse = Integer.parseInt(clavier.readLine());
        
            System.out.print("Vitesse du contrevenant en Km/h? : ");
            int VitesseDuContrevenant = Integer.parseInt(clavier.readLine());

            double kmhExcedentaires = VitesseDuContrevenant - limiteDeVitesse;
            
            if(kmhExcedentaires > 0){
                if(typeDeRoute == 'M'){
                    if(kmhExcedentaires < 25){
                        amendeAPayer += 15 * kmhExcedentaires + fraisDeCours;
                        totalRouteMunicipale += amendeAPayer;
                    }            
                    else{
                        amendeAPayer += 20 * kmhExcedentaires + fraisDeCours;
                        totalRouteMunicipale += amendeAPayer;
                    }
                }
                else if(typeDeRoute == 'A'){
                    amendeAPayer += 20 * kmhExcedentaires + fraisDeCours;
                    totalAutoroute += amendeAPayer;
                }
                else{
                    erreur = true;
                }    
            }
            else{
                fraisDeCours -= 25;
                
                System.out.println("Vous conduisez bien!");
            }
                
            if(kmhExcedentaires > 0 && !(kmhExcedentaires < 5 && limiteDeVitesse < 50)){
                if(amendeAPayer < 100)
                    amendeAPayer = 100 + fraisDeCours;
            }
            String montantDollarCanadien = NumberFormat.getCurrencyInstance(Locale.CANADA_FRENCH).format(amendeAPayer);

            if(erreur){
                System.out.println("Type de route erroné!");
            }
            else{
                System.out.println("Le montant de l'amende à payer est de: " + montantDollarCanadien);
            }
        }
        String montantDollarCanadien;
        montantDollarCanadien = NumberFormat.getCurrencyInstance(Locale.CANADA_FRENCH).format(totalRouteMunicipale);
        System.out.println("TOTAL DES CONTRAVENTIONS POUR UNE ROUTE MUNICIPALE : " + montantDollarCanadien);
        montantDollarCanadien = NumberFormat.getCurrencyInstance(Locale.CANADA_FRENCH).format(totalAutoroute);
        System.out.println("TOTAL DES CONTRAVENTIONS POUR UNE AUTOROUTE : " + montantDollarCanadien);

        System.exit(0);
    }
}