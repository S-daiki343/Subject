public class SingletonTest{
  public static void main(String[] args) {
    Renban r1 = Renban.getInstance();
    Renban r2 = Renban.getInstance();
    Renban r3 = Renban.getInstance();
    System.out.println(String.format("%04d", r1.getNumber()));
      System.out.println(String.format("%04d", r2.getNumber()));
      System.out.println(String.format("%04d", r3.getNumber()));
  }

}
 class Renban{
   private  static Renban renban = new Renban();
   private  int num = 0;

   private Renban(){}
     public static Renban getInstance(){
       return renban;
     }
     public int getNumber(){
       num = num + 1;
       return num;
     }
}

 /*class Renban2{
  private static Renban2 Instance = new Renban2();
     private Renban2(){
      int n=2; {
         System.out.println("+-----------------------------+");
        System.out.println(String.format("製造番号%03d", n));
        System.out.println("ボルト");
      }
    }
    public static Renban2 getInstance(){
        return Instance;
   }
 }*/
