package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExpressionEvaulatorTest {
    /**
     * Uslov: 5 testova
     */
    @Test
    public void ispitajIzraz(){
        Double d = -9.0;
        assertEquals(d, new ExpressionEvaluator().evaluate("( ( 2 - 3 ) * ( 4 + 5 ) )"));
    }
    @Test
    public void ispitajIzrazSaKorijenom(){
        assertEquals(3, new ExpressionEvaluator().evaluate("( 1 + sqrt ( ( 1 + 3 ) ) )"));
    }
    @Test
    public void nepravilanUnosSaRazmacima() throws RuntimeException {
        assertThrows(RuntimeException.class, () ->{
            new ExpressionEvaluator().evaluate("( 1 +2 )");
        });
    }
    @Test
    public void nepravilanUnosSaSlovima() throws RuntimeException {
        assertThrows(RuntimeException.class, () ->{
            new ExpressionEvaluator().evaluate("( 1 +7k )");
        });
    }
    @Test
    public void nepravilanUnosSaOperandima() throws RuntimeException {
        assertThrows(RuntimeException.class, () ->{
            new ExpressionEvaluator().evaluate("( 1 +*2 )");
        });
    }

}
