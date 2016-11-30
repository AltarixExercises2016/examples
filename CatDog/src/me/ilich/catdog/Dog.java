package me.ilich.catdog;

/**
 * Created by ilich on 25.11.16.
 */
public class Dog extends Animal implements Dogable {
    public Dog(int age) {
        super(age);
    }

    @Override
    void walk() {
        System.out.println("dog walk");
    }

    @Override
    public void bark() {
        System.out.println("woof-woof");
    }

    public void foo(){
        new Class1();
        new Class2();
    }

    public static void bar(){
        new Class1();
        new Class2();
    }

    static class Class1{

    }

    class Class2{

    }

}
