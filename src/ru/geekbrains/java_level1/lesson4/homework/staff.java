package ru.geekbrains.java_level1.lesson4.homework;

//Создать класс "Сотрудник" с полями: ФИО, зарплата, возраст;
public class staff {
    private static int startIDNumber = 0;
    private int id;
    private String FIO;
    private int age;
    private float salary;

    //Конструктор класса должен заполнять эти поля при создании объекта
    public staff(String FIO, int age, int salary){
        //Продумать конструктор таким образом, чтобы при создании каждому сотруднику присваивался личный уникальный идентификационный порядковый номер
        this.id = startIDNumber++;
        this.FIO = FIO;
        this.age = age;
        this.salary = salary;
    }

    //Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля
    public String getFIO(){
        return FIO;
    }

    public int getAge(){
        return age;
    }

    public float getSalary(){
        return salary;
    }

    public int getId(){
        return id;
    }

    //Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000
    void ageBonusToSalary(){
        if(getAge() > 45 ) salary += 5000;
    }

}
