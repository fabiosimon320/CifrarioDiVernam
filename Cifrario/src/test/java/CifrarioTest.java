import org.esame.cifrario.app.Cifratore;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CifrarioTest {

    @Test
    public void testocifratoTest(){
        Cifratore cifratore = new Cifratore();


        String stringaTest = "Esecuzione del test";

        cifratore.cifratura(stringaTest);
        assertNotEquals(cifratore.getTestoCifrato(), stringaTest);

        assertEquals(cifratore.getTestoDecifrato(), "Testo decifrato: " + stringaTest);


    }

}
