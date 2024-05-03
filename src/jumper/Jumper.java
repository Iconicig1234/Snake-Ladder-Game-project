package jumper;
import coordinates.Coordinates;

public class Jumper {
    public Coordinates start;
    public Coordinates end;
    public String name;

    public Jumper(Coordinates start, Coordinates end){
        this.start = start;
        this.end = end;

        if(start.get_row() > end.get_row()){
            this.name = "Ladder";
        }
        else{
            this.name = "Snake";
        }
    }

    public String get_jumper_name(){
        return this.name;
    }
}