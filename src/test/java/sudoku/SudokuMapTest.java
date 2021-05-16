package sudoku;

import org.junit.Test;
import static org.junit.Assert.*;

public class SudokuMapTest {


    private Object SudokuMap;

    @Test
    public void testingSettersAndGetters(){
        SudokuMap test = new SudokuMap();
        int[][] testmatrix = new int[5][5];
        assertNotNull(test);
        test.setTitle("example");
        test.setAuthor("John Doe");
        test.setVersion("1.0-alpha");
        test.setMatrix(testmatrix);
        assertEquals(test.getTitle(),"example");
        assertEquals(test.getAuthor(),"John Doe");
        assertEquals(test.getVersion(),"1.0-alpha");
        assertNotNull(test.getMatrix());

    }

    @Test
    public void testingLombokGeneratedMethods(){
        SudokuMap test = new SudokuMap();
        assertEquals(true,test.equals(test));
        SudokuMap test2 = new SudokuMap("example","example","example",new int[9][9]);
        assertNotNull(test2);
    }


}
