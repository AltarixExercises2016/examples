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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;

        if (tailLegth != cat.tailLegth) return false;
        if (!color.equals(cat.color)) return false;
        return age.equals(cat.age);
    }

    @Override
    public int hashCode() {
        int result = color.hashCode();
        result = 31 * result + tailLegth;
        result = 31 * result + age.hashCode();
        return result;
    }

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
