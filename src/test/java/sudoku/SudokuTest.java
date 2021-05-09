package sudoku;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class SudokuTest {

    @Test
    public void testOfGetColumnFunction(){
        Sudoku sudoku = new Sudoku();
        sudoku.tables[2].setValue(6,1,3);
        Square[] test = new Square[9];
        test[0] = new Square(2);
        test[1] = new Square(4);
        test[2] = new Square(5);
        test[3] = new Square(1);
        test[4] = new Square(0);
        test[5] = new Square(6);
        test[6] = new Square(8);
        test[7] = new Square(9);
        test[8] = new Square(3);
        assertEquals(0,sudoku.getColumn(8)[2].value);

    }

}
