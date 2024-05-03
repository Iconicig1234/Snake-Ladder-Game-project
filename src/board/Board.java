package board;

import java.util.*;
import jumper.Jumper;

public class Board {
    int size;
    public String board[][];
    public HashMap<String, Jumper> jumpers;

    public Board(int size, HashMap<String, Jumper> jumpers){
        this.size = size;
        this.jumpers = jumpers;
        board = new String[size][size];
        int count = 1;

        for(int r=size-1;r>=0;r--){
            if(r%2==0){
                for(int c=size-1;c>=0;c--){
                    board[r][c] = count+"";
                    count++;
                }
            }
            else{
                for(int c=0; c<size; c++){
                    board[r][c] = count+"";
                    count++;
                }
            }
        }
    }

    public void print_board(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                String s = board[i][j];
                int x = Integer.parseInt(s);
                if(x>=1 && x<=9){
                    System.out.print("0"+s+" ");
                }
                else System.out.print(s+" ");
            }
            System.out.println();
        }
    }

    public int get_board_size(){
        return this.size;
    }
}
