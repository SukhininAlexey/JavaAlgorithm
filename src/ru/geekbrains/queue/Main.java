package ru.geekbrains.queue;

public class Main {
    public static void main(String[] args) {
        MyArrayDeque<Character> deque = new MyArrayDeque<>();

        String text = "I can make my own double-ended queue!";

        // Вводим символы каждый раз с начала
        for(int i = 0; i < text.length(); ++i){
            deque.insertLeft(text.charAt(i));
        }

        // Дополнительные пояснения для красоты
        System.out.println("Original and reversed string:");
        System.out.println(text);

        // Выводим символы так же сначала, чтобы добиться эфекта раверса
        while(!deque.isEmpty()){
            System.out.print(deque.removeLeft());
        }
    }
}
