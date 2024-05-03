package game;

import coordinates.Coordinates;
import players.Players;
import dice.Dice;
import jumper.Jumper;
import board.Board;

public class Game {
    Board board;
    Players[] playr;
    boolean [] is_Allowed;
    int turn;
    Coordinates [] places;
    Dice dice;

    public Game(Board board, Players[] playr, Dice dice){
        this.board = board;
        this.playr = playr;
        this.dice = dice;
        turn = 0;
        is_Allowed = new boolean[playr.length];
        places = new Coordinates[playr.length];

        int r = board.get_board_size()-1;
        for(int i=0;i<playr.length;i++){
            places[i] = new Coordinates(r, 0);
        }
    }

    public void play(){
        while(true){
            int num = dice.Dice_roll();
            System.out.println(playr[turn].get_Player_Name()+" rolled-> "+num + " "+ "[" + places[turn].get_row()+ "," + places[turn].get_col()+"]");

            if(!is_Allowed[turn]){
                if(num!=1){
                    turn = 1-turn;
                    continue;
                }
                else{
                    is_Allowed[turn] = true;
                }
            }

            Coordinates new_coordinates = get_new_coordinates(places[turn], num);
            if(new_coordinates.get_row()<0){
                System.out.println("congractulations!! " + playr[turn].get_Player_Name()+", you won the game.");
                return;
            }

            places[turn] = new_coordinates;
            turn = 1-turn;
        }
    }

    private Coordinates get_new_coordinates(Coordinates old_coord, int num){
        int row = old_coord.get_row();
        int col = old_coord.get_col();

        while(num>0){
            if(row%2 != 0){
                if(col == board.get_board_size()-1){
                    row--;
                }
                else{
                    col++;
                }
            }
            else{
                if(col == 0){
                    row--;
                }
                else{
                    col--;
                }
            }
            num--;
        }
        

        if(row<0) return new Coordinates(row, col);
            if(check_jumper_exist(row,col)){
                Jumper jumper = board.jumpers.get(board.board[row][col]);
                return jumper.end;
            }
        
        return new Coordinates(row, col);
    }

    private boolean check_jumper_exist(int row, int col){
        return board.jumpers.containsKey(board.board[row][col]);
    }  
}