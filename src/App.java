import java.util.*;

import coordinates.Coordinates;
import players.Players;
import dice.Dice;
import jumper.Jumper;
import board.Board;
import game.Game;

public class App {
    public static void main(String[] args) throws Exception {

        Players p1 = new Players();
        p1.set_players_detail_from_user_input(1, p1);
        System.out.println();
        Players p2 = new Players();
        p2.set_players_detail_from_user_input(2, p2);

        System.out.println();
        p1.get_Player_Details();
        System.out.println();
        p2.get_Player_Details();
        System.out.println();

        // Dice dice = new Dice();
        // System.out.println("Number on your dice is: "+dice.Dice_roll());

        HashMap<String, Jumper> map = new HashMap<>();
        map.put("6",new Jumper(new Coordinates(9,5), new Coordinates(6,6)));
        map.put("20",new Jumper(new Coordinates(0,1), new Coordinates(9,9)));
        map.put("46",new Jumper(new Coordinates(2,4), new Coordinates(6,3)));
        map.put("91",new Jumper(new Coordinates(8,5), new Coordinates(1,3)));

        Board b = new Board(10,map);
        b.print_board();

        // Jumper j = new Jumper(s,e);
        // System.out.println(j.get_jumper_name());

        System.out.println();

        Game game = new Game(b, new Players[] {p1,p2}, new Dice());
        game.play();

    }
}
