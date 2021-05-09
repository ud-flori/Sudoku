package sudoku;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import sudoku.Square;

import static org.junit.Assert.*;

public class SquareTest {

    @Test
    public void testOfConstructor(){

        Square square = new Square();
        assertNotNull(square);
        Square test = new Square(4);
        assertEquals(1,test);
    }

    @Test
    public void testOfGetValue(){

        Square test = new Square(5);
        assertEquals(5,test.getValue());
    }

    @Test
    public void tesingSetValueMethod(){

        Square test = new Square();
        assertEquals(3,test.setValue(3));
    }
}
