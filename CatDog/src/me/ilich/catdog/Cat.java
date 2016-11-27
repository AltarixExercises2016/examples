package me.ilich.catdog;

/**
 * Created by ilich on 25.11.16.
 */
public class Cat extends Animal implements Catable {

    public static Cat createNewcat(Cat mother, Cat father) {
        Cat result = new Cat(0, mother.color, father.tailLegth);
        return result;
    }

    private final String color;
    private final int tailLegth;

    private String age = "100";

    public Cat(int age, String color, int tailLength) {
        super(age);
        this.color = color;
        this.tailLegth = tailLength;
    }

    @Override
    void walk() {
        System.out.println("cat walk");
    }

    @Override
    public void meow() {
        System.out.println("cat say meow");
    }

    @Override
    public void scratch() {
        System.out.println("scratch");
    }

    public void describeSelf() {
        System.out.println(super.age + " " + color + " " + tailLegth);
    }
}
