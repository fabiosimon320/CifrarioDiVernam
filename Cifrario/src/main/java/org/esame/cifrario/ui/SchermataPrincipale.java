package org.esame.cifrario.ui;

import org.esame.cifrario.app.Cifratore;

import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.Scanner;


public class SchermataPrincipale {
    Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
    Cifratore cifratore = new Cifratore();
    public void start(){



     int choice = 0;

     do {
         stampascelte();
         try {
             choice = scanner.nextInt();
             scanner.nextLine();
             switch (choice){
                 case 1:
                     testoDaCifrare();
                     break;
                 case 2:
                     System.out.println("Uscita...");
                     break;
                 default:
                     System.out.println("Valore errato, inserisci un valore valido");
                     break;
             }
         }catch (InputMismatchException e){
             System.out.println("Valore inserito non valido");
             scanner.nextLine();
         }




     }while (choice != 2);
    }

    public void stampascelte(){
        System.out.println("Scelte:");
        System.out.println("1) Inserimento testo che si vuole cifrare");
        System.out.println("2) Esci");
    }

    public void testoDaCifrare() {
        System.out.println("Inserisci il testo che vuoi cifrare:");

        String testo = scanner.nextLine();


        cifratore.cifratura(testo);
        cifratore.stampa();
    }

}
