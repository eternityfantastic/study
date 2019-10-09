import java.util.Arrays;

public class SeqList {
    private int size ;
    private int capacity ;
    private int [] arr  ;

    public SeqList( int capacity ) {
        this.capacity = capacity;
        this.size = 0;
        this.arr =  new int[capacity];
    }

    public void add(int date){
        if(this.size >= this.capacity){
            this.capacity+=5;
        }
        arr[size]=date;
        this.size++;
    }
    public void insert(int pos ,int date){
        if(0 > pos || pos > size){
            System.out.println("位置不合法");
            return;
        }
        else {
            for (int i = size; i > pos ; i--) {
                arr[i] = arr[i-1];
            }
            arr[pos] = date;
            this.size++;
        }
    }
    public void remove(int date){
        int index=this.GetIndex(date);
        if (index==-1){
            return;
        }else {
            for (int i = index; i < this.size-1 ; i++) {
                arr[i] = arr[i+1];
            }
            this.size--;
        }
    }
    public void change(int index , int date){
        arr[index] = date;
    }
    public int GetIndex(int date){
        for (int i = 0; i < this.size; i++) {
            if(arr[i]==date){
                return i;
            }
        }
        return -1;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
    public void show(){
        System.out.print("[");
        for (int i = 0; i < this.size; i++) {
            System.out.print( arr[i]);
            if(i != this.size-1){
                System.out.print(" ,");
            }
        }
        System.out.println("]");
    }
}
