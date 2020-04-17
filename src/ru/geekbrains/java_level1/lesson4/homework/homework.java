package ru.geekbrains.java_level1.lesson4.homework;

public class homework {
    public static void main(String[] args) {
        staff staff1 = new staff("Иванов Иван Иванович", 22, 40000);
        //Вывести при помощи методов ФИО и возраст
        System.out.printf("Сотруднику %s %d лет\n", staff1.getFIO(), staff1.getAge());

        //Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        staff[] staffArray = new staff[5];
        staffArray[0] = new staff("Александров Александр Александрович", 54, 65000);
        staffArray[1] = new staff("Васильев Василий Васильевич", 32, 112000);
        staffArray[2] = new staff("Михайлов Михаил Михайлович", 42, 32000);
        staffArray[3] = new staff("Егоров Егор Егорович", 29, 36000);
        staffArray[4] = new staff("Романов Роман Романович", 46, 51000);

        for (int i = 0; i < staffArray.length; i++)
            if(staffArray[i].getAge() > 40)
                printStaffData(staffArray[i]);

        //самопроверка задания "Подсчитать средние арифметические зарплаты и возраста"
        System.out.println(averageAge(staffArray));
        System.out.println(averageSalary(staffArray));

        //самопроверка задания "Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000"
        for (int i = 0; i < staffArray.length; i++) {
            float tmp = staffArray[i].getSalary();
            staffArray[i].ageBonusToSalary();
            if(staffArray[i].getSalary() != tmp)
                printStaffData(staffArray[i]);
        }
    }

    public static void printStaffData(staff staff){
        System.out.printf("ID %d: сотруднику %s %d лет, его зарплата %f рублей\n", staff.getId(), staff.getFIO(), staff.getAge(), staff.getSalary());
    }

    //Подсчитать средние арифметические зарплаты и возраста
    public static int averageAge(staff[] staff){
        int averageAge = 0;
        for (int i = 0; i < staff.length; i++){
            averageAge += staff[i].getAge();
        }
        averageAge /= staff.length;
        return averageAge;
    }

    public static float averageSalary(staff[] staff){
        float averageSalary = 0;
        for (int i = 0; i < staff.length; i++){
            averageSalary += staff[i].getSalary();
        }
        averageSalary /= staff.length;
        return averageSalary;
    }
}
