package sudoku;

import com.google.common.annotations.VisibleForTesting;

import java.util.ArrayList;

import java.util.List;

/**
 *  Sudoku Class implement Table Objects.
 */

public class Sudoku{
    /**
     * Array of Tables.
     */
    public Table[] tables;

    /**
     * Fill up the {@code tables} array with empty Table objects.
     */
    public Sudoku() {
        this.tables = new Table[9];
        for (int i = 0; i < 9; i++) {
            this.tables[i] = new Table();
        }
    }

    public boolean isGameWon(){
        for(int i=0;i<9;i++){
            for(int j =1; j<=3;j++){
                for(int k=0;k<=3;k++){
                    if(!(this.tables[i].checkPossibilityInTable(this.tables[i].squares,0)))
                        return false;
                }
            }
        }
        return true;
    }

    private Square[] getColumn(int columnIndex){
        List<Square> column = new ArrayList<>();
        int tableGetColumnIndex;
        if(columnIndex%3 == 0){
            tableGetColumnIndex = 3;
        }
        else{
            tableGetColumnIndex = columnIndex % 3;
        }
        column.addAll(this.tables[(columnIndex-1)/3].getColumn(tableGetColumnIndex));
        column.addAll(this.tables[((columnIndex-1)/3)+3].getColumn(tableGetColumnIndex));
        column.addAll(this.tables[((columnIndex-1)/3+6)].getColumn(tableGetColumnIndex));
        Square[] returnValue = new Square[column.size()];
        column.toArray(returnValue);
        return returnValue;
    }

    @VisibleForTesting
    private Square[] getRow(int rowIndex){
        List<Square> row = new ArrayList<>();
        int tableGetRowIndex;
        if(rowIndex%3 == 0){
            tableGetRowIndex = 3;
        }
        else{
            tableGetRowIndex = rowIndex % 3;
        }
        if(rowIndex%9 == 0) {
            rowIndex = 6;
        }
        else if(rowIndex%6 == 0){
            rowIndex = 3;
        }
        else if(rowIndex%3 == 0){
            rowIndex = 0;
        }
        else{
            rowIndex = (rowIndex / 3) * 3;
        }
        row.addAll(this.tables[rowIndex].getRow(tableGetRowIndex));
        row.addAll(this.tables[rowIndex+1].getRow(tableGetRowIndex));
        row.addAll(this.tables[rowIndex+2].getRow(tableGetRowIndex));
        Square[] returnValue = new Square[row.size()];
        row.toArray(returnValue);
        return returnValue;
    }

    /**
     * Check the possibility if the indexed value can be placed on the table.
     * @param value The value which needs to be placed.
     * @param rowIndex The index of the row.
     * @param columnIndex The index of the column.
     * @return boolean about the possibility.
     */
    private boolean isValid(int value, int rowIndex, int columnIndex){
        Square[] row;
        row = getRow(rowIndex);
        Square[] column;
        column = getColumn(columnIndex);
        return checkColumn(value, column) &&
                checkRow(value, row) &&
                checkTable(value, rowIndex, columnIndex);
    }

    /**
     * Allows the user to set the value int the table with indexed parameters.
     * @param value The value needs to be placed.
     * @param rowIndex The indexed row.
     * @param columnIndex The indexed Column
     * @return The value if the possibility was valid or non-null zero value.
     */
    public int setValue(int value, int rowIndex, int columnIndex) {
        if (value < 0 || value > 9) {
            return 0;
        }
        int tableIndex;
        if (isValid(value, rowIndex, columnIndex)) {
            tableIndex = whichTable(rowIndex, columnIndex);
            if (rowIndex == 9 || rowIndex == 6 || rowIndex == 3) {
                rowIndex = 3;
            } else {
                rowIndex = rowIndex % 3;
            }
            if (columnIndex == 9 || columnIndex == 6 || columnIndex == 3) {
                columnIndex = 3;
            } else {
                columnIndex = columnIndex % 3;
            }
            this.tables[tableIndex].setValue(value, rowIndex, columnIndex);
            return value;
        }
        else {
            tableIndex = whichTable(rowIndex, columnIndex);
            if (rowIndex == 9 || rowIndex == 6 || rowIndex == 3) {
                rowIndex = 3;
            } else {
                rowIndex = rowIndex % 3;
            }
            if (columnIndex == 9 || columnIndex == 6 || columnIndex == 3) {
                columnIndex = 3;
            } else {
                columnIndex = columnIndex % 3;
            }
            this.tables[tableIndex].setValue(value, rowIndex, columnIndex);
            return 0;
        }
    }


    /**
     * Check the possibility in row if the value can be placed on the table.
     * @param value The value which needs to be checked.
     * @param row The row which needs to be checked.
     * @return boolean about the possibility.
     */
    private boolean checkRow(int value, Square[] row) {

        for (int i = 0; i < 9; i++) {
            if (row[i].value == value) {

                return false;
            }
        }
        return true;
    }

    /**
     * Check the possibility in column if the value can be placed on the table.
     * @param value The value which needs to be checked.
     * @param column The column which needs to be checked.
     * @return boolean about the possibility.
     */
    private boolean checkColumn(int value, Square[] column) {

        for (int i = 0; i < 9; i++) {
            if (column[i].value == value) {

                return false;
            }
        }
        return true;
    }

    /**
     * Check the possibility in the table if the value can be placed in the game.
     * @param value The value which needs to be checked.
     * @param row The row which needs to be checked.
     * @param column The column which needs to be checked.
     * @return boolean about the possibility.
     */
    private boolean checkTable(int value, int row, int column) {
        int table = whichTable(row,column);

        return tables[table].checkPossibilityInTable(this.tables[table].squares, value);
    }

    /**
     * Identify the table using row and column indexes.
     * @param row The row index.
     * @param column The column index
     * @return which table contains the parameters.
     */
    private int whichTable(int row, int column) {
        int table = 0;
        if (row > 0 && row < 4) {
            if (column > 0 && column < 4) table = 0;
            else if (column > 3 && column < 7) table = 1;
            else table = 2;
        } else if (row > 3 && row < 7) {
            if (column > 0 && column < 4) table = 3;
            else if (column > 3 && column < 7) table = 4;
            else table = 5;
        } else if (row>6){
            if (column > 0 && column < 4) table = 6;
            else if (column > 3 && column < 7) table = 7;
            else {
                table = 8;
            }
        }
        return table;
    }
}