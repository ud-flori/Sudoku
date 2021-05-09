package sudoku;

public class Square {
    int value;

    public Square(){
        this.value = 0;
    }

    public Square(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public int setValue(int value){
        return this.value = value;
    }
}
