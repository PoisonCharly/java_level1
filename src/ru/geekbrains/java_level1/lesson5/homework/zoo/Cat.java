package ru.geekbrains.java_level1.lesson5.homework.zoo;

public class Cat extends Animal {
    public Cat() {
        super();
        this.runDistance = RANDOM.nextFloat() + RANDOM.nextInt(199);
        this.jumpHigh = RANDOM.nextFloat() + RANDOM.nextInt(1);
        this.sort = "Кот";
    }

    public void refuseToSwim(){
        System.out.println("Кот не умеет плавать");
    }
}
