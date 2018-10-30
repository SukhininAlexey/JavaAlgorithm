package ru.geekbrains.sort;

public class MyArrayList<Item extends Comparable<Item>> {
    private Object[] list;
    private int size = 0;

    public MyArrayList(){
        list = new Object[1];
    }

    private void resize(int capacity){
        Object[] newList = new Object[capacity];
        for(int i = 0; i < size; ++i){
            newList[i] = list[i];
        }
        list = newList;
    }

    public int size(){
        return size;
    }

    public void insert(Item item){
        if(size >= list.length){
            resize(list.length * 2);
        }
        list[size++] = item;
    }

    public boolean delete (Item item){
        int i = 0;
        while(i < size && !list[i].equals(item)){
            ++i;
        }

        if(i >= size) return false;

        for(int j = i + 1; j < size; ++j){
            list[j-1] = list[j];
        }

        size--;

        if(size <= list.length / 4 && size > 0){
            resize(list.length / 2);
        }
        return true;
    }

    public void set(int index, Item item){
        if(index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException();
        list[index] = item;
    }

    public Item get(int index){
        if(index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException();
        return (Item) list[index];
    }

    public boolean find(Item item){
        for(int i = 0; i < size; ++i){
            if(list[i].equals(item)){
                return true;
            }
        }
        return false;
    }

    private boolean less(Item item1, Item item2){
        return item1.compareTo(item2) < 0;
    }

    private void exchange(int i, int j){
        Item tmp = (Item) list[i];
        list[i] = list[j];
        list[j] = tmp;
    }

    public void selectionSort(){
        for(int i = 0; i < size - 1; i++){
            int min = i;
            for(int j = i + 1; j < size; ++j){
                if(less( (Item) list[j], (Item) list[min] ) ){
                    min = j;
                }
            }
            exchange(i, min);
        }
    }

    public void insertionSort(){
        for (int i = 0; i < size; ++i){
            for(int j = i; j > 0; --j){
                if(less((Item) list[j], (Item) list[j - 1])){
                    exchange(j, j - 1);
                }else{
                    break;
                }
            }
        }
    }


    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < size; ++i){
            s = s + list[i] + " ";
        }
        return s;
    }
}
