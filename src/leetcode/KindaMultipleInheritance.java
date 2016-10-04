package leetcode;

public class KindaMultipleInheritance {
	
interface A {
  void a();
}

interface B {
  void b();
}  

public static class AImpl implements A {

  public void a() {
    System.out.println("a");
  }
}

public static class BImpl implements B {

  public void b() {
    System.out.println("b");
  }
}

public static class C implements A, B {
  private A a = new AImpl();
  private B b = new BImpl();
  public void a() {
    a.a();
  }
  
  public void b() {
    b.b();
  }
}
}
