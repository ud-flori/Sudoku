package sudoku;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class TableTest{

    @Test
    public void testConstructorCorrectness(){
       Table table = new Table();
       assertEquals(0,table.squares[4].value);
    }

    //@Test
    /*public void testGetColumnFunctionCorrection(){
        Table table = new Table();
        table.squares[3].value= 5;
        table.squares[0].value= 7;
        Square[] column = new Square[3];
        column = table.getColumn(1);
        assertEquals(5,column[1].value);
        assertEquals(7,column[0].value);
        assertEquals(0,column[2].value);

    }
*/
    @Test
    public void testGetRowFunctionCorrection(){
        Table table = new Table();
        table.squares[4].value= 5;
        table.squares[5].value= 7;
        Square[] row = new Square[3];
        row = table.getRow(2);
        assertEquals(5,row[1].value);
        assertEquals(0,row[0].value);
        assertEquals(7,row[2].value);

    }

    @Test
    public void testcheckPossibilityFunction(){
    Table table = new Table();
    table.setValue(3,1,1);
    assertEquals(false,table.checkPossibility(3,2,1));
    assertEquals(true,table.checkPossibility(4,1,1));
    assertEquals(5,table.setValue(5,1,1));
    assertEquals(false,table.checkPossibility(5,3,1));
    }
}