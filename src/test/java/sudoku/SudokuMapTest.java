package sudoku;

import org.junit.Test;
import static org.junit.Assert.*;

public class SudokuMapTest {


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


}
