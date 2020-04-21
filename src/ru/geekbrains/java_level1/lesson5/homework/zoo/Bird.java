package ru.geekbrains.java_level1.lesson5.homework.zoo;

public class Bird extends Animal {
    public Bird() {
        super();
        this.runDistance = RANDOM.nextFloat() + RANDOM.nextInt(4);
        this.jumpHigh = (float) RANDOM.nextInt(20)/100;
        this.sort = "Птица";
    }

    public void refuseToSwim(){
        System.out.println("Птица не умеет плавать");
    }
}
