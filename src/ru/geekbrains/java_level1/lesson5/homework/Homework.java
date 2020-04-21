package ru.geekbrains.java_level1.lesson5.homework;
import ru.geekbrains.java_level1.lesson5.homework.zoo.*;

/*
Создать классы Собака, Лошадь, Птица и Кот с наследованием от класса Животное.
Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).
У каждого животного есть ограничения на действия
(бег: кот 200 м., собака 500 м., Лошадь 1500 м., Птица 5 м.,;
прыжок: кот 2 м., собака 0.5 м., Лошадь 3 м., Птица 0.2 м. ;
плавание: кот и птица не умеет плавать, собака 10 м., лошадь 100 м.).
При попытке животного выполнить одно из этих действий, оно должно сообщить результат.
**** Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.
*/

public class Homework {
    public static void main(String[] args) {
        float runDistance = 30;
        float jumpHigh = 2;
        float swimDistance = 150;

        Animal[] zoo = {
                new Cat(),
                new Cat(),
                new Dog(),
                new Dog(),
                new Horse(),
                new Horse(),
                new Bird(),
                new Bird()
        };

        //Вывод параметров соревнований для самопроверки
        System.out.println("---------------------------------------");
        System.out.printf("Параметры соревнования: бег на %f метров, плавание на %f метров, прыжки через препятствие высотой %f метров\n",
                runDistance, swimDistance, jumpHigh);
        System.out.println("---------------------------------------");

        for(int i = 0; i < zoo.length; i++) {
            zoo[i].run(runDistance);

            if(zoo[i] instanceof Bird)
                ((Bird) zoo[i]).refuseToSwim();
            else if(zoo[i] instanceof Cat)
                ((Cat) zoo[i]).refuseToSwim();
            else zoo[i].swim(swimDistance);

            zoo[i].jump(jumpHigh);
            System.out.println("...................");
        }
    }
}
