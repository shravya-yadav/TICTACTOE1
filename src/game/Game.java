package game;
import board.Board;
import player.Player;
import java.util.*;
public class Game {
    Player []players;
    Board board;
    int turns;
    int moves;
    boolean gameOver;
    String zero;   // here zero is a variable
    String cross;

    public Game(Player[] players,Board board){
    this.board=board;
    this.players=players;
    this.turns=0;
    this.moves=0;
    this.gameOver=false;

    StringBuilder z=new StringBuilder(); //sb are used to manipulatee strings without creating objects hence "effective" ..sb are used to change accordinglyy 
    StringBuilder c=new StringBuilder();
    for(int i=0;i<board.size;i++){       //if board size is 2 then loop repeats for 2 times and hence "00" wil be the format and for 3 size it is "000"
      z.append('O');
      c.append('X');
    }
      this.zero=z.toString();   // assigning the value of "00" or "xx" from above to zero variable ..since zero is string we are converting to string..
      this.cross=c.toString();
   }
public void printBoardConfig(){   // method overloading...there wil be no dfrncr with or without this method
  int sz=this.board.size;
  for(int i=0;i<sz;i++){
    for(int j=0;j<sz;j++){
       System.out.print(board.matrix[i][j]+" ");
  }
  System.out.println();
}
}


 public void play(){
  printBoardConfig(); 
  int sz=board.size;
  while(!gameOver){
    moves++;
  int index=getIndex();
   int row=index/sz;
   int col=index%sz;
    board.matrix[row][col]=players[turns].getSym(); 
    if(moves==sz*sz){
      System.out.println("Draw");
      return;
      
    }
   if(moves>=2*sz-1 && checkComb()== true){
    gameOver=true;
    printBoardConfig();
    System.out.println("winner "+players[turns].getName());
    return;
   }
   turns=(turns+1)%2;

   printBoardConfig();
 }
}
 public int getIndex(){
  while(true){
    System.out.println(players[turns].getName());
    Scanner s=new Scanner(System.in);
    int pos=s.nextInt()-1;

    int sz=board.size;
    int row=pos/sz;
    int col=pos%sz;

    if(row<0 || row>=sz || col<0 || col>=sz){
      System.out.println("Invalid");
      continue;
    }
    if(board.matrix[row][col]!='-'){
      System.out.println("Already occupied re- enter another");
      continue;
    }
   return pos;
  }
 }

 public boolean checkComb(){
  int sz=board.size;
  // row wise
   for (int i=0;i<sz;i++){
    StringBuilder sb=new StringBuilder();
    for(int j=0;j<sz;j++){
      sb.append(board.matrix[i][j]); // append like 00 01 01 
    }
      String pattern=sb.toString();
    
    if(pattern.equals(zero) || pattern.equals(cross)){
      return true;
   }
 }
    // column wise
   for (int i=0;i<sz;i++){
    StringBuilder sb=new StringBuilder();
    for(int j=0;j<sz;j++){
      sb.append(board.matrix[j][i]);  // 00 10 20 format becoz first it is incrementing by j hence written as j i ..it wil be 01 actually but in appending we wrote ji kada soo reverse
    }
   String pattern=sb.toString();
  
    if(pattern.equals(zero) || pattern.equals(cross)){
      return true;
   }
  }
  // diagonal 
  int i=0,j=0;
    StringBuilder sb=new StringBuilder();
    while(i<sz){
      sb.append(board.matrix[i][j]); // why while is used becoz we are incrementing both i and j at a time to achieve 00 11 22 which is <3(sz)
      i++;
      j++;                           // if for ,i is incremented after evry j only hence not used 
    }
   String pattern=sb.toString();
  
    if(pattern.equals(zero) || pattern.equals(cross)){
      return true;
   }
  // anti-daigonal
   i=0;
   j=sz-1;
    sb=new StringBuilder();
    while(i<sz){
      sb.append(board.matrix[i][j]); 
      i++;
      j--;
    }
   pattern=sb.toString();
  
    if(pattern.equals(zero) || pattern.equals(cross)){
      return true;
   }
  

   return false;
 }

}
