package org.esame.cifrario.app;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

public class Cifratore {

    private int dimKey;

    public void cifratura(String testoInchiaro){

        this.dimKey = testoInchiaro.length(); //Otteniamo la dimensione della chiave
        byte[] testoByte = testoInchiaro.getBytes(StandardCharsets.UTF_8); // Trasforma il testo in un array di byte
        byte[] key = generateKey(testoByte.length);


        byte[] testoCifratoByte = xorOperation(key, testoByte);  // Esegue l'operatore XOR e lo salva in un testo cifrato

        String testoCifrato = ByteToString(testoCifratoByte); // Si converte il testo cifrato in una stringa in moda che l'utente la possa leggere correttamente

        System.out.println("Testo cifrato: " + testoCifrato);   // Lo stampiamo

        testoCifratoByte = xorOperation(key, testoCifratoByte);  // Usando la stessa chiave, con l'operatore XOR, convertiamo il testo cifrato in un testo decifrato

        stampaTestoDecifrato(testoCifratoByte); // Metodo che ci stampa il testo decifrato





    }

    private void stampaTestoDecifrato(byte[] testoCifrato) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < testoCifrato.length; i++) {
            // I caratteri che sono formato da più byte hanno il valore del primo bit assegnato a 1 quindi è possibile
            // fare l'and tra il byte e un valore 0x80 che corrisponde ad un byte che come primo bit un valore uguale a 1
            // e se l'and è uguale a 0x80, significa che il primo bit è uguale a 1 e pertanto è multibyte

            if ((testoCifrato[i] & 0x80) == 0x80) {
                int j = i;
                // Continua a leggere i byte successivi per formare il carattere completo
                while (j < testoCifrato.length && (testoCifrato[j] & 0x80) == 0x80) {
                    j++;
                }

                // Ora, possiamo trattare la sequenza di byte dal punto di inizio fino a j
                byte[] multibyteChar = new byte[j - i];
                System.arraycopy(testoCifrato, i, multibyteChar, 0, j - i); //copia dell'array
                // Converte la sequenza di byte in un carattere
                String decodedChar = new String(multibyteChar, StandardCharsets.UTF_8);
                stringBuilder.append(decodedChar);
                i = j - 1;  // Avanzare l'indice per saltare i byte già processati
            } else {
                // Se il byte è un singolo byte (ASCII standard)
                stringBuilder.append((char) testoCifrato[i]);
            }
        }
        System.out.println("Testo decifrato: " + stringBuilder);
    }


    private byte[] generateKey(int size){
        SecureRandom secureRandom = new SecureRandom();

        byte[] key = new byte[size];
        secureRandom.nextBytes(key);
        return key;
    }

    private byte[] xorOperation(byte[] key, byte[] testo){

        //Controllo per vedere se hanno dimensione uguale

        byte[] testoCifrato = new byte[testo.length];

        for(int i = 0; i < testo.length; i++){
            testoCifrato[i] = (byte) (testo[i] ^ key[i]); // Il simbolo ^ corrisponde allo XOR
                                                          // Eseguiamo comunque il cast
        }
        return testoCifrato;
    }

    private String ByteToString(byte[] testoCifrato){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testoCifrato.length; i++) {

            int result = testoCifrato[i];
            char cifrato = (char) ('a' + ((result % 26 + 26) % 26)); // questo permette di avere valori che vanno da 'a' a 'z' gestendo anche i valori negativi
            sb.append(cifrato);
        }
        return sb.toString();
    }



}
