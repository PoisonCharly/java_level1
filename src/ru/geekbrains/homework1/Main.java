package ru.geekbrains.homework1;

public class Main {

    public static void main(String[] args) {

        int a = 2;
        int b = 6;
        int c = 11;
        int d = 4;
        int year = 800;
        String name = "Ксения";

        mathFunction(a,b,c,d);
        isInRange(c,d);
        plusOrMinus(a);
        helloName(name);
        isYearLeap(year);
    }

    /*
    Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат с плавающей точкой,
    где a, b, c, d – целочисленные входные параметры этого метода
    */
    private static void mathFunction(int a, int b, int c, int d){
        double result =  (double)a * ((double)b + ((double)c / (double)d));
        System.out.println("Результат вычисления функции a*(b+(c/d)): " + result);
    }

    /*
    Написать метод, принимающий на вход два целых числа,
    и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
    если да – вернуть true, в противном случае – false
    */
    private static void isInRange(int a, int b){
        int leftBorder = 10;
        int rightBorder = 20;
        int formula = a + b;

        boolean result = (formula >= leftBorder) && (formula <= rightBorder);
        System.out.println("Сумма чисел " + a + " и " + b + " находится в пределах " + leftBorder + " и " + rightBorder + " (включительно)? " + result);
    }

    /*
    Написать метод, которому в качестве параметра передается целое число,
    метод должен проверить положительное ли число передали, или отрицательное.
    Замечание: ноль считаем положительным числом. Результат работы метода вывести в консоль
    */
    private static void plusOrMinus(int a){
        if(a >= 0) System.out.println(a + " является положительным числом");
        else System.out.println(a + " является отрицательным числом");
    }

    /*
    Написать метод, которому в качестве параметра передается строка, обозначающая имя,
    метод должен вернуть приветственное сообщение «Привет, переданное_имя!»; Вывести приветствие в консоль.
    */
    private static void helloName(String name){
        System.out.println("Привет, " + name + "!");
    }

    /*
    Написать метод, который определяет является ли год високосным.
    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    Для проверки работы вывести результаты работы метода в консоль
    */
    private static void isYearLeap(int year){
        if((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)))
            System.out.println("Год " + year + " является високосным");
        else System.out.println("Год " + year + " не является високосным");
    }
}