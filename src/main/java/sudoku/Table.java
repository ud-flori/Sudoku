package sudoku;

import lombok.val;

import java.util.ArrayList;
import java.util.List;

public class Table {

    Square [] squares;


    public Table(){
        this.squares = new Square[9];
        for(int i=0;i<9;i++){
            this.squares[i] = new Square();
        }
    }

    public Square[] getSquares(){
        return this.squares;
    }

    public List<Square> getColumn(int index){
        List<Square> column = new ArrayList<>();
        column.add(this.squares[index-1]);
        column.add(this.squares[index+2]);
        column.add(this.squares[index+5]);

       return column;
    }

    public List<Square> getRow(int index){
        List<Square> row = new ArrayList<>();

        row.add(this.squares[(index-1)*3]);
        row.add(this.squares[(((index-1)*3)+1)]);
        row.add(this.squares[(((index-1)*3)+2)]);

        return row;
    }

    public boolean checkPossibility(int value, int rowIndex, int columnIndex) {
        List<Square> row = new ArrayList<>();
        row = getRow(rowIndex);
        List<Square> column = new ArrayList<>();
        column = getColumn(columnIndex);
        if (    checkPossibilityInRow(row, value) &&
                checkPossibilityInColumn(column, value) &&
                checkPossibilityInTable(this.squares,value)) {

            return true;
        }
        else return false;
    }

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

    public boolean checkPossibilityInTable(Square[] table, int value){
        for(int i=0;i<9;i++){
            if(table[i].value == value){
                return false;
            }
        }
        return true;
    }

    public int setValue(int value, int row, int column) {
            if (checkPossibility(value, row, column)) {
                this.squares[getPosition(row,column)-1].value = value;
                return value;
            }

            return 0;

        }

    private  int getPosition(int row, int column){
        switch(row) {
            case 1:
                return 0+column;
            case 2:
                return 3+column;
            case 3:
                return 6+column;
            default:
                return 0;
        }
    }

}
