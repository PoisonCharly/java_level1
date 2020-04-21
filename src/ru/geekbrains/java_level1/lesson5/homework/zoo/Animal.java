package ru.geekbrains.java_level1.lesson5.homework.zoo;

import java.util.Random;

public abstract class Animal {
    protected float jumpHigh;
    protected float runDistance;
    protected float swimDistance;
    protected static Random RANDOM = new Random();
    protected String sort;

    public Animal() {
    }

    public float getJumpHigh() {
        return jumpHigh;
    }
    public float getRunDistance() {
        return runDistance;
    }
    public float getSwimDistance() {
        return swimDistance;
    }

    public void run(float distance){
        System.out.println(sort + " может пробежать " + getRunDistance() + " метров");
        if (runDistance >= distance)
            System.out.println(sort + " пробежал дистанцию");
        else
            System.out.println(sort + " не пробежал дистанцию");
    };

    public void swim(float distance){
        System.out.println(sort + " может проплыть " + getSwimDistance() + " метров");
        if (swimDistance >= distance)
            System.out.println(sort + " проплыл дистанцию");
        else
            System.out.println(sort + " не проплыл дистанцию");
    }

    public void jump(float high){
        System.out.println(sort + " может перепрыгнуть препятствие высотой " + getJumpHigh() + " метров");
        if(jumpHigh > high)
            System.out.println(sort + " перепрыгнул препятствие");
        else
            System.out.println(sort + " не перепыгнул препятствие");
    }

}
