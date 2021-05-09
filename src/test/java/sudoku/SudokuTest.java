package sudoku;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class SudokuTest {

    @Test
    public void testOfGetColumnFunction(){
        Sudoku sudoku = new Sudoku();
        assertEquals(2, sudoku.setValue(2,4,6));
        assertEquals(0, sudoku.setValue(2,4,3));
        assertEquals(0, sudoku.setValue(2,5,5));
        assertEquals(7, sudoku.setValue(7,5,5));
        assertEquals(8, sudoku.setValue(8,5,6));
        assertEquals(0, sudoku.setValue(8,4,4));
        assertEquals(0, sudoku.setValue(8,1,6));
        assertEquals(0, sudoku.setValue(7,9,5));



    }

}
