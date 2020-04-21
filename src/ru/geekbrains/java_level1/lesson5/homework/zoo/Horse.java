package ru.geekbrains.java_level1.lesson5.homework.zoo;

public class Horse extends Animal {
    public Horse() {
        super();
        this.runDistance = RANDOM.nextFloat() + RANDOM.nextInt(1499);
        this.jumpHigh = RANDOM.nextFloat() + RANDOM.nextInt(2);
        this.swimDistance = RANDOM.nextFloat() + RANDOM.nextInt(99);
        this.sort = "Лошадь";
    }

}
