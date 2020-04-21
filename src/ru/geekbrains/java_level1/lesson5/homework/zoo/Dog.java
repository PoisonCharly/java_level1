package ru.geekbrains.java_level1.lesson5.homework.zoo;

public class Dog extends Animal {
    public Dog() {
        super();
        this.runDistance = RANDOM.nextFloat() + RANDOM.nextInt(499);
        this.jumpHigh = (float) RANDOM.nextInt(50) / 100;
        this.swimDistance = RANDOM.nextFloat() + RANDOM.nextInt(9);
        this.sort = "Пёс";
    }

}
