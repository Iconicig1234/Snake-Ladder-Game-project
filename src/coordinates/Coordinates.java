package coordinates;

public class Coordinates {
    int row;
    int col;

    public Coordinates(int row, int col){
        this.row = row;
        this.col = col;
    }
    
    public String Print_Coord(){
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(this.row).append(',').append(this.col).append(']');
        return sb.toString();
    }

    public int get_row(){
        return this.row;
    }

    public int get_col(){
        return this.col;
    }
}
