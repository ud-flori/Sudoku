package sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sudoku{

    Table[] tables;

    public Sudoku() {
        this.tables = new Table[9];
        for (int i = 0; i < 9; i++) {
            this.tables[i] = new Table();
        }

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
        column.addAll(
                        this.tables[(columnIndex-1)/3].getColumn(tableGetColumnIndex)
        );
        column.addAll(
                        this.tables[((columnIndex-1)/3)+3].getColumn(tableGetColumnIndex)
        );
        column.addAll(
                        this.tables[((columnIndex-1)/3+6)].getColumn(tableGetColumnIndex)
        );

        Square[] returnValue = new Square[column.size()];
        column.toArray(returnValue);
        return returnValue;
    }

    public Square[] getRow(int rowIndex){
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
        else{
            rowIndex = (rowIndex/3)*3;
        }

        row.addAll(
                this.tables[rowIndex].getRow(tableGetRowIndex)
        );
        row.addAll(
                this.tables[rowIndex+1].getRow(tableGetRowIndex)
        );
        row.addAll(
                this.tables[rowIndex+2].getRow(tableGetRowIndex)
        );

        Square[] returnValue = new Square[row.size()];
        row.toArray(returnValue);
        return returnValue;

    }


        public  void setTable(){
        ;}

        public boolean isValid(int value, int rowIndex, int columnIndex){
            Square[] row = new Square[9];
            row = getRow(rowIndex);
            Square[] column = new Square[9];
            column = getColumn(columnIndex);
            if( checkColumn(value, column)&&
                checkRow(value, row) &&
                checkTable(value, rowIndex, columnIndex))
            {
                return true;
            }
            else return false;
        }

        public int setValue(int value, int rowIndex, int columnIndex) {
            if(isValid(value, rowIndex, columnIndex)){
                int tableIndex;
                tableIndex = whichTable(rowIndex,columnIndex);

                if(rowIndex == 9 || rowIndex == 6 || rowIndex ==3) {
                    rowIndex = 3;
                }
                else{
                    rowIndex = rowIndex % 3;
                }

                if(columnIndex == 9 || columnIndex == 6 || columnIndex == 3) {
                    columnIndex = 3;
                }
                else{
                    columnIndex= columnIndex % 3;
                }

                this.tables[tableIndex].setValue(value, rowIndex, columnIndex);
                return value;
            }
            return 0;
        }

        private boolean checkRow(int value, Square[] row) {
            for (int i = 0; i < 9; i++) {
                if (row[i].value == value) {
                    return false;
                }
            }
            return true;
        }
        private boolean checkColumn(int value, Square[] column) {
            for (int i = 0; i < 9; i++) {
                if (column[i].value == value) {
                    return false;
                }
            }
            return true;
        }
        private boolean checkTable(int value, int row, int column) {
            int table = whichTable(row,column);
            return tables[table].checkPossibilityInTable(this.tables[table].squares, value);
            }


        private int whichTable(int row, int column) {
            int table;
            if (row > 0 && row < 4) {
                if (column > 0 && column < 4) table = 0;
                if (column > 3 && column < 7) table = 1;
                else table = 2;
            } else if (row > 3 && row < 7) {
                if (column > 0 && column < 4) table = 3;
                if (column > 3 && column < 7) table = 4;
                else table = 5;
            } else {
                if (column > 0 && column < 4) table = 6;
                if (column > 3 && column < 7) table = 7;
                else table = 8;

            }
            return table;
        }

        }

