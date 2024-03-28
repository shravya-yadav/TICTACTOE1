import board.Board;
import game.Game;
import player.Player;
import java.util.*;
public class App1 {
    public static void main(String[] args) throws Exception {
       // System.out.println("Hello, World!");
       Scanner s=new Scanner(System.in);
        System.out.println("first project-> Tic Tac Toe");
        Board b=new Board(3,'-');
       // b.printBoardConfig();
        Player p1=new Player();
       // p1.setNameSym("ram",'X');
     //   p1.getNameSym();
       // p1.changeNameSym("bhim",'O');
       // p1.getNameSym();
       System.out.println("Enter the player name");
        String name=s.nextLine();
        System.out.println("enter the player symbol");             //user-defined
        char sym=s.nextLine().charAt(0);
          p1.setNameSym(name,sym);
           p1.getNameSym();
       Player p2=new Player();
        p2.setNameSym("bhim",'O');                        //pre-defined
        p2.getNameSym();
        Game g= new Game (new Player[] {p1,p2}, b);     
        g.play();
       // b.setDefaultSymbol('#'); when method is initialised..
     //  PLayer p2=new Player();  p2.set(name,sym) or p2.set("ram",'#')
       // "Folder and package means SAME"
      //  b.printBoardConfig();
    } 
}
/* for taking inputs from user     import java.util.Scanner;
 * Scanner s =new Scaner(System.in);
 * String name=s.nextLine();
 * char sym=s.nextLine.charAt(0);
 * p1.setNameSym(name,sym);
 * p1.getNameSym();
 * p2.setNameSym("sitha",'#')
 */
