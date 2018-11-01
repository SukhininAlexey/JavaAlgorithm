package ru.geekbrains.sort;

import java.sql.SQLOutput;
import java.util.DoubleSummaryStatistics;
import java.util.Random;

public class Main {
    public static final int ITEMS_QTTY = 70000;
    public static final int TESTS_QTTY = 20;
    public static final Random rnd = new Random();

    public static void main(String[] args) {

        long insertionTimeSum = 0, selectionTimeSum = 0,
            insertionTimeStart, selectionTimeStart,
            insertionTimeCurrent, selectionTimeCurrent;

        System.out.println("ТЕСТ СОРТИРОВОК ВСТАВКОЙ И ВЫБОРОМ");
        System.out.println("---------------------------------------------------");
        System.out.println("УСЛОВИЯ ТЕСТА");
        System.out.println("Значений в списке: " + ITEMS_QTTY);
        System.out.println("Итераций: " + TESTS_QTTY);
        System.out.println("---------------------------------------------------");
        System.out.println("ХОД ТЕСТА");
        for(int q = 0; q < TESTS_QTTY; ++q) {
            MyArrayList<Integer> listIns = new MyArrayList<>();
            MyArrayList<Integer> listSel = new MyArrayList<>();

            for (int i = 0; i < ITEMS_QTTY; ++i) {
                int nextInt = rnd.nextInt();
                listIns.insert(nextInt);
                listSel.insert(nextInt);
            }

            insertionTimeStart = System.currentTimeMillis();
            listIns.insertionSort();
            insertionTimeCurrent = System.currentTimeMillis() - insertionTimeStart;
            insertionTimeSum += insertionTimeCurrent;

            selectionTimeStart = System.currentTimeMillis();
            listSel.selectionSort();
            selectionTimeCurrent = System.currentTimeMillis() - selectionTimeStart;
            selectionTimeSum +=  selectionTimeCurrent;

            System.out.println("Результат теста номер " + (q+1) + ": вставкой за " + insertionTimeCurrent + " мс, выбором за " + selectionTimeCurrent + " мс.");
        }

        System.out.println("---------------------------------------------------");
        System.out.println("УСРЕДНЕННЫЕ РЕЗУЛЬТАТЫ");
        System.out.println("Среднее время сортировки вставкой: " + (insertionTimeSum / TESTS_QTTY + " мс"));
        System.out.println("Среднее время сортировки выбором: " + (selectionTimeSum/ TESTS_QTTY + " мс"));
    }
}
