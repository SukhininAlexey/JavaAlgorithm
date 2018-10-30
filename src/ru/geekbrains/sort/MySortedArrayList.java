package ru.geekbrains.sort;

public class MySortedArrayList<Item extends Comparable<Item>> extends MyArrayList<Item> {
    @Override
    public void insert(Item item){
        super.insert(item);
        int i = this.size() - 1;
        while(i > 0 && this.get(i).compareTo(this.get(i - 1)) < 0){
            Item tmp = this.get(i);
            this.set(i, this.get(i - 1));
            this.set(i - 1, tmp);
            --i;
        }
    }

    public boolean binaryFind(Item item){
        int low = 0,
            hi = this.size() - 1,
            mid;

        while(low <= hi){
            mid = low + (hi - low) / 2;
            if(item.compareTo(this.get(mid)) > 0){
                low = mid + 1;
            } else if(item.compareTo(this.get(mid)) < 0){
                hi = mid - 1;
            }else {
                return true;
            }
        }
        return false;
    }
}
