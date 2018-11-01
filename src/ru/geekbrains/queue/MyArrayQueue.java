package ru.geekbrains.queue;

import java.util.NoSuchElementException;

public class MyArrayQueue<Item> {
    private Object[] queue = new Object[2];
    private int start = 0;
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

    public void enqueue(Item item) {
        if (size == queue.length) {
            resize(2 * queue.length);
        }
        queue[end++] = item;
        end %= queue.length;
        //if (end == queue.length) end = 0;
        size++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = (Item) queue[start];
        size--;
        start++;
        start %= queue.length;
        if (size > 0 && size == queue.length / 4) {
            resize(queue.length / 2);
        }
        return item;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return  (Item) queue[start];
    }

    private void resize(int capacity) {
        Object[] temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = queue[(start + i) % size];
        }
        queue = temp;
        start = 0;
        end = size;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s = s + queue[(start + i)%queue.length] + ", ";
        }
        return s;
    }
}
