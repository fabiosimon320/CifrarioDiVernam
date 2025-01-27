import org.esame.cifrario.app.Cifratore;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CifrarioTest {
    Cifratore cifratore = new Cifratore();
    @Test
    public void testocifratoTest(){



        String stringaTest = "Esecuzione del test";

        cifratore.cifratura(stringaTest);
        assertNotEquals(cifratore.getTestoCifrato(), stringaTest);

        assertEquals(cifratore.getTestoDecifrato(), stringaTest);


    }

    @Test
    public void XORTest(){
        byte[] Testobytes =   {0b01000100};
        byte[] keyBytes =     {0b00110001};
        byte[] valoreAtteso = {0b01110101};
        byte[] valoreEffettivo;
        valoreEffettivo = cifratore.xorOperation(keyBytes, Testobytes);
        assertArrayEquals(valoreAtteso, valoreEffettivo);
    }




}
