package sudoku;

/**
 * The Square Class
 * Represents one cube in sudoku table
 */
public class Square {

    /**
     * The value of the square.
     */
    public int value;

    /**
     * Sets the {@code value} field to non-null value, if one Square implemented
     * without parameter.
     */
    public Square(){
        this.value = 0;
    }

    /**
     * Sets the {@code value} field's value to the parameter.
     */
    public Square(int value){

        if (value > 0 && value < 10) {
                this.value = value;
            }

    }


    /**
     * Gets the Squares {@code value}'s field.
     * @return Squares value
     */
    public int getValue(){
        return this.value;
    }

    /**
     * Set the Square {@code value} field, if the parameter is not null.
     * @param value an integer value to set the Object's value field.
     * @return return the value has been set.
     */
    public int setValue(int value){
        if(value>0 && value<10) {
            return this.value = value;
        }
        return this.value;
    }
}
