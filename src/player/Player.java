package player;

public class Player {
     private String name;
     private char sym;
     private String addr;
     private long contNum;
     private String email;
     private int age;
   

     public void setDetails(String name,char sym,String addr,long contNum,String email,int age){
      this.name=name;
      this.sym=sym;
      this.addr=addr;
      this.contNum=contNum;
      this.email=email;
      this.age=age;
     }
        // u can also write constructor with desired inputs only
     public void setNameSym(String name,char sym){
      this.name=name;
      this.sym=sym;
     }

 // retrieving names
   public String getName(){
    return this.name;
   }
   public char getSym(){
    return this.sym;
   }
   public void changeNameSym(String name,char sym){
    this.name=name;
    this.sym=sym;
   }
// also written as 
  public void getNameSym(){
    System.out.println("player name: "+ this.name);
    System.out.println("Player symbol: "+this.sym);
  }

} 
