package sudoku;

import java.util.ArrayList;
import java.util.List;

public class Sudoku{

    Table[] tables;

    public Sudoku() {
        this.tables = new Table[9];
        for (int i = 0; i < 9; i++) {
            this.tables[i] = new Table();
        }

    }



    public Square[] getColumn(int columnIndex){
        List<Square> column = new ArrayList<>();
        for(int i=columnIndex;i<columnIndex+72;i=i+27) {
            column.addAll(
                        this.tables[(columnIndex/3)].getColumn((columnIndex%3)+1));

            }
        Square[] returnValue = new Square[column.size()];
        column.toArray(returnValue);
        return returnValue;
    }

        public  void setTable(){
        ;}

        public boolean isValid(int value, int row, int column){
            if( checkRow(value,row, column)&&
                checkColumn(value, row, column)&&
                checkTable(value, row, column)) {
                return true;
            }
            else return false;
        }

        public void setValue(int value, int row, int column) {
            //if(isValid(int value, int row, int column)){
                //
            }

        private boolean checkRow(int value, int row, int column) {

        return true;
        }
        private boolean checkColumn(int value, int row, int column) {
        return true;
        }
        private boolean checkTable(int value, int row, int column) {
        return true;
        }

    }

