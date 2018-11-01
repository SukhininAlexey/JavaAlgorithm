package ru.geekbrains.queue;

import java.util.NoSuchElementException;

public class MyArrayStack<Item> {
    private Object[] stack = new Object[1];
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(Item item) {
        if (size == stack.length) {
            resize(2 * stack.length);
        }
        stack[size++] = item;
    }

    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = (Item) stack[size - 1];
        stack[size - 1] = null;
        size--;
        if (size > 0 && size == stack.length / 4) {
            resize(stack.length / 2);
        }
        return item;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (Item) stack[size - 1];
    }

    private void resize(int capacity) {
        Object[] temp = new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = stack[i];
        }
        stack = temp;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s = s + stack[i] + ", ";
        }
        return s;
    }
}