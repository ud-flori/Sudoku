package sudoku;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SudokuTest {


    @Test
    public void testTheConstructor() {
        Sudoku sudoku = new Sudoku();

        Assertions.assertEquals(0, sudoku.tables[0].squares[0].getValue());
    }

    @Test
    public void testSudokuGameBlind(){
        Sudoku sudoku = new Sudoku();

        Assertions.assertEquals(2, sudoku.setValue(2,4,6));
        Assertions.assertEquals(0, sudoku.setValue(2,4,3));
        Assertions.assertEquals(0, sudoku.setValue(2,5,5));
        Assertions.assertEquals(7, sudoku.setValue(7,5,5));
        Assertions.assertEquals(8, sudoku.setValue(8,5,6));
        Assertions.assertEquals(0, sudoku.setValue(8,4,4));
        Assertions.assertEquals(0, sudoku.setValue(8,1,6));
        Assertions.assertEquals(0, sudoku.setValue(7,9,5));
        Assertions.assertEquals(8, sudoku.setValue(8,6,1));



    }

}
