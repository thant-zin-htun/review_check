class Single{
  private Single() {}
  
  private static class Holder{//inner class
    private static final Single INSTANCE=new Single();
      
  }
  public static Single getIntance() {
    return Holder.INSTANCE;
  }
}
public class Singleton {

  public static void main(String[] args) {
    Single obj=Single.getIntance();
    System.out.println(obj);
    
    Single obj2=Single.getIntance();
    System.out.println(obj2);
  }

}