package sudoku;

import org.junit.Test;


import static org.junit.Assert.*;

public class SquareTest {

    @Test
    public void testTheConstructor(){

        Square firstTest = new Square();
        Square secondTest = new Square(4);
        Square thirdTest = new Square(-5);
        Square fourthTest = new Square(12);
        assertEquals(0, firstTest.value);
        assertEquals(4, secondTest.value);
        assertEquals(0, thirdTest.value);
        assertEquals(0, fourthTest.value);
    }

    @Test
    public void testTheGetValueMethod(){

        Square test = new Square(5);
        assertEquals(test.value,test.getValue());
    }

    @Test
    public void testTheSetValueMethod(){

        Square test = new Square();
        assertEquals(3,test.setValue(3));
    }
}
