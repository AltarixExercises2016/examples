package me.ilich.catdog;

public class Main {

    public static void main(String[] args) {
        Cat cat1 = new Cat(2, "black", 15);
        cat1.describeSelf();
        Cat cat2 = new Cat(2, "white", 20);
        cat2.describeSelf();
        Cat cat = Cat.createNewcat(cat1, cat2);
        cat.describeSelf();
        Fish fish = new Fish(1233);
    }
}
