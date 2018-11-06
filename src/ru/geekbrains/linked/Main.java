package ru.geekbrains.linked;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.insertLast(7);
        list.insertLast(8);
        list.insertLast(9);
        list.insertLast(10);
        list.insert(3, 4);
        list.insert(4, 5);
        list.insert(5, 6);

        Iterator<Integer> iterator = list.iterator();

        System.out.println("Iterator variant: ");
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.print('\n');

        System.out.println("Fore each variant: ");
        for( Integer item: list){
            System.out.print(item + " ");
        }
    }
}
