public class ArrayQueue<T> implements QueueInterface<T>{
    private T[] queue;
    private int size;
    private int front;
    private int startingCap = 4;

    public void ArrayQueue(){
        queue = (T[]) new Object(startingCap);
        size = 0;
        front = 0; 
    }

    public int size(){
        return size;
    }

    public boolean empty(){
        return size == 0;
    }

    public T add(T item){
        if(size == queue.length){
            newSize(size * 2);
        }
        else{
            int end = (front + size) % queue/length;

            queue[end] = item;
            size++;

            return 
        }
    }

    public void newSize(int newSize){
        private T[] newQueue = (T[]) new Object[newSize];

        for(int i = 0; i < size; i++){
            newQueue[i] = queue[(front + i) % queue.length];
        }
        queue = newQueue;
        front = 0;
    }

    public T peek() throws QueueUnderFlowException{

    }

    public T remove() throws QueueUnderFlowException{

    }

    public void clear(){
        T[] newQueue = (T[]) new Object[startingCap];
        queue = newQueue;
        size = 4;
        front = 0;
    }
}