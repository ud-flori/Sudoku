package sudoku;

import java.util.ArrayList;
import java.util.List;

/**
 * The Table class.
 * Represents one table in sudoku game.
 * This Class includes basic logic in Sudoku to one table and gives you opportunity
 * to make different maps using the Table class.
 */
public class Table {

    /**
     * The Squares in one table.
     * Each Square in Array represents Square object.
     */
    public Square [] squares;

    /**
     * Creates the table and fill up with Squares.
     *
     */
    public Table(){
        this.squares = new Square[9];
        for(int i=0;i<9;i++){
            this.squares[i] = new Square();
        }
    }

    /**
     * Get the {@code squares} array.
     * @return Object's @{@code squares} array.
     */
    public Square[] getSquares(){
        return this.squares;
    }

    /**
     * Get indexed column.
     * @param index indexes the column.
     * @return List with the squares in indexed column.
     */
    public List<Square> getColumn(int index){
        List<Square> column = new ArrayList<>();
        column.add(this.squares[index-1]);
        column.add(this.squares[index+2]);
        column.add(this.squares[index+5]);

       return column;
    }

    /**
     * Get indexed row.
     * @param index indexes the row.
     * @return List with the squares in indexed row.
     */
    public List<Square> getRow(int index){
        List<Square> row = new ArrayList<>();

        row.add(this.squares[(index-1)*3]);
        row.add(this.squares[(((index-1)*3)+1)]);
        row.add(this.squares[(((index-1)*3)+2)]);

        return row;
    }

    /**
     * Check the possibility of the value if it can be placed in the table.
     * @param value The value need to be checked.
     * @param rowIndex The index of the row.
     * @param columnIndex The index of the column
     * @return boolean value if the value can be placed or not.
     */
    private boolean checkPossibility(int value, int rowIndex, int columnIndex) {
        List<Square> row;
        row = getRow(rowIndex);
        List<Square> column;
        column = getColumn(columnIndex);
        return checkPossibilityInRow(row, value) &&
                checkPossibilityInColumn(column, value) &&
                checkPossibilityInTable(this.squares, value);
    }

    /**
     * Check the possibility in row if the value can be placed on the table.
     * @param list List with the values of the row.
     * @param value The value which needs to be checked.
     * @return boolean about the possibility.
     */
    private boolean checkPossibilityInRow(List<Square> list,int value) {
        Square[] row = new Square[3];
        list.toArray(row);
        for (int i = 0; i < 3; i++) {
            if (row[i].value == value) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check the possibility in column if the value can be placed on the table.
     * @param list List with the values of the column.
     * @param value The value which needs to be checked.
     * @return boolean about the possibility.
     */
    private boolean checkPossibilityInColumn(List<Square> list,int value) {
        Square[] column = new Square[3];
        list.toArray(column);
        for (int i = 0; i < 3; i++) {
            if (column[i].value == value) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check the values possibility in table.
     * @param table The field for checking.
     * @param value The checked value.
     * @return boolean about the possibility
     */
    public boolean checkPossibilityInTable(Square[] table, int value){
        for(int i=0;i<9;i++){
            if(table[i].value == value){
                System.out.println("checkTable: "+false);

                return false;
            }
        }
        System.out.println("checkTable: "+true);
        return true;
    }

    /**
     * Allows the user to set the value int the table with indexed parameters.
     * @param value The value needs to be placed.
     * @param row The indexed row.
     * @param column The indexed Column
     * @return The value if the possibility was valid or non-null zero value.
     */
    public int setValue(int value, int row, int column) {
            if (checkPossibility(value, row, column)) {
                this.squares[getPosition(row,column)-1].value = value;
                return value;
            }

            this.squares[getPosition(row,column)-1].value = 0;
            return 0;

        }

    /**
     * Get the position int the {@code squares} by index.
     * @param row The index of the row.
     * @param column The index of the column
     * @return The position in @{@code squares} array.
     */
    public int getPosition(int row, int column){
        switch(row) {
            case 1:
                return column;
            case 2:
                return 3+column;
            case 3:
                return 6+column;
            default:
                return 0;
        }
    }

}
