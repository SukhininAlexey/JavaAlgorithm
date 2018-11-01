package ru.geekbrains.queue;

import java.util.NoSuchElementException;

public class MyArrayDeque<Item> {
    private Object[] deque = new Object[2];
    private int start = 1;
    private int end = 0;
    private int size = 0;
    //0 1 2 3 4 5 6 7 8 9
    //          e s
    //8 7 3 1 4 7 4 6 7 1
    //4 6 7 1
    //(6 + 4) % 10 == 0
    //(6 + 5) % 10 == 1
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Сначала увеличиваем end, потом вставляем. End указывает на последний элемент под собой
    public void insertRight(Item item) {
        if (size == deque.length) {
            resize(2 * deque.length);
        }
        end++;
        end %= deque.length;
        deque[end] = item;
        size++;
    }

    // Сначала уменьшаем start, потом вставляем. Start указывает на первый элемент под собой
    public void insertLeft(Item item) {
        if (size == deque.length) {
            resize(2 * deque.length);
        }
        start--;
        start = start < 0 ? deque.length + start % deque.length : start;
        deque[start] = item;
        size++;
    }

    public Item removeLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = (Item) deque[start];
        size--;
        start++;
        start %= deque.length;
        if (size > 0 && size == deque.length / 4) {
            resize(deque.length / 2);
        }
        return item;
    }

    public Item removeRight() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = (Item) deque[end];
        size--;
        end--;
        end = end < 0 ? deque.length + end % deque.length : end;
        if (size > 0 && size == deque.length / 4) {
            resize(deque.length / 2);
        }
        return item;
    }

    public Item peekLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return  (Item) deque[start];
    }

    public Item peekRight() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return  (Item) deque[end];
    }

    private void resize(int capacity) {
        capacity = capacity < 2 ? 2 : capacity; // Меньше двух не должен быть, иниче всё рухнет.
        Object[] temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = deque[(start + i) % deque.length];
        }
        deque = temp;
        start = 0;
        end = size - 1;
        end = end < 0 ? deque.length + end % deque.length : end;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += deque[(start + i)% deque.length];
            if(i < size - 1){
                s +=  ", ";
            }
        }
        return s;
    }
}
