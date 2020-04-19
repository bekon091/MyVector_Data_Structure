public class MyVector<E> extends MyAbstractList<E> implements MyList<E> {
    private int Capacity = 10;
    @SuppressWarnings("unchecked")
    private E[] data;

    private int incrementCapacity = 5;
    @SuppressWarnings("unchecked")
    public MyVector() {
        data = (E[]) new Object[10];
    }

    @SuppressWarnings("unchecked")
    public MyVector(int size){
        Capacity = size;
        data = (E[]) new Object[Capacity];
    }

    @SuppressWarnings("unchecked")
    public MyVector(int size, int increment){
        Capacity = size;
        this.incrementCapacity = increment;
        data = (E[]) new Object[Capacity];
    }

    @SuppressWarnings("unchecked")
    private void checkCapacity(){
        if (size() >= getCapacity()){
            Capacity += incrementCapacity;
            E[] newData = (E[])(new Object[Capacity]);
            for(int i =0; i < size(); i++){
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    public int getIncrement() {
        return incrementCapacity;
    }

    public boolean add(E e){
        return add(size(), e);
    }

    public boolean add(int index, E e) throws IndexOutOfBoundsException{
        checkCapacity();

        for(int i = size() -1; i>= index;i--){
            data[i+1]=data[i];
        }
        data[index] = e;
        size ++;
        return true;
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        data = (E[]) new Object[Capacity];
        size = 0;
    }

    public E get(int index){
        return data[index];
    }

    public E remove(int index){
        E e = data[index];

        for(int j = index; j < size() -1; j++){
            data[j] = data[j+1];
        }
        data[size() -1] = null;
        size--;
        return e;
    }

    @SuppressWarnings("unchecked")
    public void trimToSize(){
        if(size() != Capacity){
            E[] newData = (E[])(new Object[size()]);
            for(int i =0; i < size(); i++){
                newData[i] = data[i];
            }
            data = newData;
            Capacity = size();
        }
    }

    public int getCapacity(){
        return Capacity;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < size(); i++) {
            result.append(data[i]);
            if (i < size() - 1)
                result.append(", ");
        }

        return result.toString() + "]";
    }

}
