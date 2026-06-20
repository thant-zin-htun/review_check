//interface MakingSound {
//	int NUM = 10; // static final
//
//	void madeSound(); // public abstract
//
//	// method defination
//	static void method() {
//		System.out.println("Hello"); // method implementation
//	}
//
//	// method defination
//	default void method1() {
//		System.out.println("Hello"); // method implementation
//	}
//}
//
//class Dog implements MakingSound {
//
//	public void bark() {
//		System.out.println(this.getClass().getSimpleName() + "---> Woke Woke ....");
//	}
//
//	@Override
//	public void madeSound() {
//		bark(); // method propagation => kox method htl hmr ta chr method ko khw thone tr
//
//	}
//}
//
//class Bird implements MakingSound {
//
//	public void sing() {
//		System.out.println(this.getClass().getSimpleName() + "---> Que Que ....");
//	}
//
//	@Override
//	public void madeSound() {
//		sing();
//
//	}
//}
//
//class Person implements MakingSound {
//
//	public void speak() {
//		System.out.println(this.getClass().getSimpleName() + "---> Hello ....");
//	}
//
//	@Override
//	public void madeSound() {
//		speak();
//
//	}
//}
//
//public class Sound {
//
//	public static void main(String[] args) {
//		MakingSound dog = new Dog();
//		MakingSound bird = new Bird();
//		MakingSound person = new Person();
//
//		System.out.println(dog.NUM); // static final mox lox
//
//		MakingSound[] sounds = { dog, bird, person };
//
//		for (MakingSound sound : sounds) {
//			sound.madeSound();
//		}
//		
//		MakingSound.method();	// static mox lox
//		dog.method1();	// default
//	}
//
//}




