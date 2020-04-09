package ru.geekbrains.java_level1.lesson2.homework;

import java.util.Arrays;

public class homework {
    public static void main(String[] args) {

        int[] arr1 = {1, 0, 0, 1, 0, 1, 1};
        System.out.println(Arrays.toString(changeZeroOne(arr1)));

        int[] arr2 = new int[8];
        System.out.println(Arrays.toString(pushIntoArr(arr2)));

        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(incDouble(arr3)));

        int[] arr4 = {1, 5, 0, 2, -2, 4, 5, 16, 4, 8, 9, 1};
        System.out.println(minArr(arr4));
        System.out.println(maxArr(arr4));

        /*
        Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
        заполнить его диагональные элементы единицами, используя цикл(ы)
        */
        int arrSize = 5;
        int[][] arr5 = new int[arrSize][arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr5[i][i] = 1;
            arr5[arrSize - 1 - i][i] = 1;
        }
        System.out.println(Arrays.deepToString(arr5));

        int[] arr6 = {10, 1, 2, 3, 4};
        System.out.println(checkBalance(arr6));

        System.out.println(Arrays.toString(shiftArray(arr3,5)));
    }

    /*
    Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
    */
    private static int[] changeZeroOne(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 1) arr[i] = 0;
            else arr[i] = 1;
        }
        return arr;
    }

    /*Задать пустой целочисленный массив размером 8.
    Написать метод, который помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22
    */
    private static int[] pushIntoArr(int[] arr){
        arr[0] = 1;
        for(int i = 1 ; i < arr.length; i++) arr[i] = arr[i - 1] + 3;
        return arr;
    }

    /*Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],
    написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
    */
    private static int[] incDouble(int[] arr){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < 6) arr[i] *= 2;
        }
        return arr;
    }

    /*
    Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента
    */
    private static int minArr(int[] arr){
        int minArr = arr[0];
        for (int i = 0; i < arr.length; i++){
            if(arr[i] < minArr) minArr = arr[i];
        }
        return minArr;
    }
    private static int maxArr(int[] arr){
        int maxArr = arr[0];
        for (int i = 0; i < arr.length; i++){
            if(arr[i] > maxArr) maxArr = arr[i];
        }
        return maxArr;
    }

    /*
    Написать метод, в который передается не пустой одномерный целочисленный массив,
    метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
    Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
    checkBalance ([10, || 1, 2, 3, 4]) → true. Абстрактная граница показана символами ||, эти символы в массив не входят.
    */
    private static boolean checkBalance(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int j = 0; j < i; j++) leftSum += arr[j];
            for (int j = i; j < arr.length; j++) rightSum += arr[j];

            if (leftSum == rightSum) return true;
        }
        return false;
    }

    /*
    Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным, или отрицательным),
    при этом метод должен циклически сместить все элементы массива на n позиций.
    Не пользоваться вспомогательным массивом при решении задачи
    */
    public static int[] shiftArray(int[] arr, int shift) {
        if (shift > 0) {
            for (int i = 0; i < shift; i++) {
                //ставим вместо первого элемента массива последний
                int tmp = arr[0];
                arr[0] = arr[arr.length - 1];
                //каждому следующему элементу присваиваем предыдущий
                for (int j = 1; j < arr.length - 1; j++)
                    arr[arr.length - j] = arr[arr.length - j - 1];
                //и ставим первый элемент на второе место
                arr[1] = tmp;
                //цикл повторять число раз, равное сдвигу
            }
        }
        else { //аналогично положительному сдвигу, только ход идёт с конца к началу
            for (int i = 0; i > shift; i--) {
                int tmp = arr[arr.length - 1];
                arr[arr.length - 1] = arr[0];

                for (int j = 1; j < arr.length - 1; j++)
                    arr[j - 1] = arr[j];

                arr[arr.length - 2] = tmp;
            }
        }
        return arr;
    }

}
