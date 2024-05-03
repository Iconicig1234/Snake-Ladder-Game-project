package players;
import java.util.*;

public class Players {
    String name;
    int age;
    String email;

    public void Set_Player_Details(String name, int age, String email){
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public void Set_Player_Name(String name){
        this.name = name;
    }

    public void get_Player_Details(){
        System.out.println("Player details are:-");
        System.out.println("Name:" + this.name);
        System.out.println("Age:" + this.age);
        System.out.println("Email:" + this.email);
    }

    public String get_Player_Name(){
        return this.name;
    }

    public static void set_players_detail_from_user_input(int x, Players p){
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter Player " + x + " Details:");

        System.out.println("Enter name:");
        String name = scn.nextLine();

        System.out.println("Enter age:");
        int age = scn.nextInt();

        System.out.println("Enter Email Address:");
        String email = scn.next();

        p.Set_Player_Details(name, age, email);

    }
}
