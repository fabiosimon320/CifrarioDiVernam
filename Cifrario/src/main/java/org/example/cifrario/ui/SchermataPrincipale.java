package org.example.cifrario.ui;

import org.example.cifrario.app.Cifratore;

import java.util.Scanner;


public class SchermataPrincipale {
    Scanner scanner = new Scanner(System.in);
    Cifratore cifratore = new Cifratore();
    public void start(){

     int choice;

     do {
         stampascelte();
         choice = scanner.nextInt();
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


     }while (choice != 2);
    }

    public void stampascelte(){
        System.out.println("1) Inserimento testo che si vuole cifrare");
        System.out.println("2) Esci");
    }

    public void testoDaCifrare(){
        System.out.println("Inserisci il testo che vuoi cifrare:");

        String testo = scanner.next();
    }

}
