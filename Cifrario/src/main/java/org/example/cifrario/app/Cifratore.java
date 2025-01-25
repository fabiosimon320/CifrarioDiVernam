package org.example.cifrario.app;

import java.security.SecureRandom;

public class Cifratore {

    private String testoInchiaro;
    private int dimKey;
    private byte[] key;

    public void cifratura(String testoInchiaro){

        this.dimKey = testoInchiaro.length(); //Otteniamo la dimensione della chiave

        key = generateKey();
        byte[] testoInByte = testoInchiaro.getBytes();

        xorOperation(key, testoInByte);



    }

    public byte[] generateKey(){
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[this.dimKey];
        secureRandom.nextBytes(key);
        return key;
    }

    public byte[] xorOperation(byte[] key, byte[] testo){

        //Controllo per vedere se hanno dimensione uguale

        byte[] testoCifrato = new byte[testo.length];

        for(int i = 0; i < testo.length; i++){
            testoCifrato[i] = (byte) (testo[i] ^ key[i]); // Il simbolo ^ corrisponde allo XOR
                                                          // Eseguiamo comunque il cast
        }
        return testoCifrato;
    }

}
