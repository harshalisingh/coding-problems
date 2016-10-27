package leetcode;

public class UseAnimal {
	public static void main(String[] args){
		Animal a = new Animal();
		Horse h = new Horse();
		Animal aToHRef = new Horse();
		
		a.doStuff(a);
		a.doStuff(h);
		a.doStuff(aToHRef);
		aToHRef.doStuff(a);
		aToHRef.doStuff(h);
		aToHRef.doStuff(aToHRef);
		
		System.out.println("--------------------");
		h.doStuff(h);
		h.doStuff(a);
		h.doStuff(aToHRef);
	}
}

class Animal{
	public void doStuff(Animal obj){
		System.out.println("Animal Class");
	}
}

class Horse extends Animal{
	public void doStuff(Horse obj){
		System.out.println("Horse Class");
	}
	
	public void doStuff(Animal Obj){
		System.out.println("In Horse Class but with Animal Obj");
	}
}
