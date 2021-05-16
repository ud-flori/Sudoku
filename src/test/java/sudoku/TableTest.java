package sudoku;

import org.junit.Test;
import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;



public class TableTest{

    @Test
    public void testTheConstructor(){
       Table test = new Table();

       assertEquals(0,test.squares[4].value);
    }

    @Test
    public void testGetSquaresMethod(){
        Table test = new Table();

        assertEquals(0, test.getSquares()[3].getValue());
    }


    @Test
    public void testGetRowFunctionCorrection(){
        Table table = new Table();
        List<Square> row1;
        List<Square> row2;
        List<Square> row3;
        List<Square> pattern = new ArrayList<>();

        pattern.add(new Square());
        pattern.add(new Square(5));
        pattern.add(new Square(7));
        pattern.add(new Square(2));
        pattern.add(new Square(1));
        pattern.add(new Square(8));
        pattern.add(new Square(9));
        pattern.add(new Square(1));
        pattern.add(new Square(0));
        table.squares[0].value= 0;
        table.squares[1].value= 5;
        table.squares[2].value= 7;
        table.squares[3].value= 2;
        table.squares[4].value= 1;
        table.squares[5].value= 8;
        table.squares[6].value= 9;
        table.squares[7].value= 1;
        row1 = table.getRow(1);
        row2 = table.getRow(2);
        row3 = table.getRow(3);

        assertEquals(pattern.get(1).getValue(),row1.get(1).getValue());
        assertEquals(pattern.get(4).getValue(),row2.get(1).getValue());
        assertEquals(pattern.get(8).getValue(),row3.get(2).getValue());



    }

    @Test
    public void testGetColumnFunctionCorrection(){

        Table table = new Table();
        List<Square> column1;
        List<Square> column2;
        List<Square> column3;
        List<Square> pattern = new ArrayList<>();

        pattern.add(new Square());
        pattern.add(new Square(5));
        pattern.add(new Square(7));
        pattern.add(new Square(2));
        pattern.add(new Square(1));
        pattern.add(new Square(8));
        pattern.add(new Square(9));
        pattern.add(new Square(1));
        pattern.add(new Square(0));
        table.squares[0].value= 0;
        table.squares[1].value= 5;
        table.squares[2].value= 7;
        table.squares[3].value= 2;
        table.squares[4].value= 1;
        table.squares[5].value= 8;
        table.squares[6].value= 9;
        table.squares[7].value= 1;
        column1 = table.getColumn(1);
        column2 = table.getColumn(2);
        column3 = table.getColumn(3);

        assertEquals(pattern.get(3).getValue(),column1.get(1).getValue());
        assertEquals(pattern.get(1).getValue(),column2.get(0).getValue());
        assertEquals(pattern.get(8).getValue(),column3.get(2).getValue());

    }

    @Test
    public void testCheckPossibilityInTable(){
            Table test = new Table();

            test.squares[1].setValue(1);
            assertFalse(test.checkPossibilityInTable(test.squares,1));

    }

    @Test
    public void testSetValueMethod(){

        Table test = new Table();

        assertEquals(2,test.setValue(2,1,2));
        assertEquals(0,test.setValue(2,1,1));
        assertEquals(3,test.setValue(3,1,1));
    }



}