public class Main {
  public static void main(String[] args) {
      try {
          System.out.println(StringOperations.concatenate("abc", "xyz"));
          System.out.println(StringOperations.invers("abc"));
          System.out.println(StringOperations.substituie("aba", 'a', 'x'));
          System.out.println(StringOperations.lungime("abc"));
      } catch (Exception e) {
          System.out.println(e.getMessage());
      }
  }
}
