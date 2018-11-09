package ru.geekbrains.linked;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class MyLinkedList<Item> implements Iterable<Item> {

    private class LinkedListIterator implements Iterator<Item>{
        private  Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedListIterator();
    }

    private class Node {
        Item item;
        Node next;
        Node previous;

        public Node(Item item, Node next, Node previous) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }

    private int size = 0;
    private Node first = null;
    private Node last = null;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insertFirst(Item item) {
        Node oldFirst = first;
        first = new Node(item, oldFirst, null);
        if(isEmpty()){
            last = first;
        } else {
            oldFirst.previous = first;
        }
        size++;
    }

    public Item deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = first.item;
        first = first.next;
        first.previous = null;
        size--;
        if(isEmpty()){
            last = null;
        }
        return item;
    }

    public Item getFirst() {
        if (isEmpty()) {
            throw  new NoSuchElementException();
        }
        return first.item;
    }

    public void insertLast(Item item){
        Node oldLast = last;
        last = new Node(item, null, oldLast);
        if(isEmpty()) {
            first = last;
        }else{
            oldLast.next = last;
        }
        size++;
    }

    public Item deleteLast() {
        if (isEmpty()) {
            throw  new NoSuchElementException();
        }
        Item item = last.item;
        Node previous = last.previous;
        last.previous = null;
        last = previous;
        size--;
        if(isEmpty()){
            first = null;
        } else {
            last.next = null;
        }
        return item;
    }

    public Item getLast(){
        if (isEmpty()) {
            throw  new NoSuchElementException();
        }
        return last.item;
    }

    public void insert(int index, Item item){
        if (index < 0 || index > size){
            throw  new IllegalArgumentException();
        }
        if (index == 0) {
            this.insertFirst(item);
            return;
        } else if (index == size){
            this.insertLast(item);
            return;
        }
        int indexCurrent = 0;
        Node current = first;
        while (indexCurrent < index){
            indexCurrent++;
            current = current.next;
        }
        Node newNode = new Node(item, current, current.previous);
        current.previous.next = newNode;
        current.previous = newNode;
        size++;
    }

    public Item delete(Item item){
        Node current = first;

        while(current != null && !current.item.equals(item)){
            current = current.next;
        }
        if(current == null){
            return null;
        }
        if(current == first){
            return deleteFirst();
        }
        if (current == last){
            return deleteLast();
        }
        current.previous.next = current.next;
        current.next.previous = current.previous;
        size--;
        current.next = null;
        current.previous = null;
        return current.item;
    }

    public boolean find(Item item){
        Node current = first;

        while(current != null && !current.item.equals(item)){
            current = current.next;
        }
        if(current == null){
            return false;
        } else {
            return true;
        }
    }

    public Item get(int index){
        if (index < 0 || index > size){
            throw  new IllegalArgumentException();
        }
        int currentIndex = 0;
        Node current = first;
        while(currentIndex < index){
            currentIndex++;
            current = current.next;
        }
        return  current.item;
    }

    public void set(int index, Item item){
        if (index < 0 || index > size){
            throw  new IllegalArgumentException();
        }
        int currentIndex = 0;
        Node current = first;
        while(currentIndex < index){
            currentIndex++;
            current = current.next;
        }
        current.item = item;
    }
}
