package me.ilich.catdog;

/**
 * Created by ilich on 25.11.16.
 */
abstract public class Animal {

    protected final int age;

    protected Animal(int age) {
        this.age = age;
    }

    abstract void walk();

    public int getAge(){
        return age;
    }

}
