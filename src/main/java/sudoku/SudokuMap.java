package sudoku;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * SudokuMap class to handle JSON format to Java object.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SudokuMap {
    private String title;
    private String author;
    private String version;
    public int[][] matrix;

}
