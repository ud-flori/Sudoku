package sudoku;


public class SudokuMap {
    private String title;
    private String author;
    private String version;
    public int[][] matrix;


    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getVersion() {
        return version;
    }

    public int[][] getMatrix() {
        return matrix;
    }
}
