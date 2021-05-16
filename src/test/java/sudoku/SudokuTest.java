package sudoku;
import org.junit.Test;
import static org.junit.Assert.*;


public class SudokuTest {


    @Test
    public void testTheConstructor() {
        Sudoku sudoku = new Sudoku();

        assertEquals(0, sudoku.tables[0].squares[0].getValue());
    }

    @Test
    public void testSudokuGameBlind(){
        Sudoku sudoku = new Sudoku();

        assertEquals(1,sudoku.setValue(1,1,1));
        assertEquals(0,sudoku.setValue(0,1,1));
        assertEquals(1,sudoku.setValue(1,1,1));
        assertEquals(0,sudoku.setValue(1,1,1));
        assertEquals(2, sudoku.setValue(2,4,6));
        assertEquals(0, sudoku.setValue(2,4,3));
        assertEquals(0, sudoku.setValue(2,5,5));
        assertEquals(7, sudoku.setValue(7,5,5));
        assertEquals(8, sudoku.setValue(8,9,1));
        assertEquals(8, sudoku.setValue(8,4,4));
        assertEquals(8, sudoku.setValue(8,1,6));
        assertEquals(0, sudoku.setValue(7,9,5));
        assertEquals(0, sudoku.setValue(8,6,1));



    }


}
