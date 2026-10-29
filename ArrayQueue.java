public class ArrayQueue<T> implements QueueInterface<T>{
    private T[] queue;
    private int size;
    private int front;
    private int startingCap = 4;

    public ArrayQueue(){
        queue = (T[]) new Object[startingCap];
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
            int end = (front + size) % queue.length;

            queue[end] = item;
            size++;

            return item;
    }

    public void newSize(int newSize){
        T[] newQueue = (T[]) new Object[newSize];

        for(int i = 0; i < size; i++){
            newQueue[i] = queue[(front + i) % queue.length];
        }
        queue = newQueue;
        front = 0;
    }

    public T peek() throws QueueUnderflowException{
        if (empty())
        {
            throw new QueueUnderflowException("Queue is empty.");
        }

        return queue[front];
    }

    public T remove() throws QueueUnderflowException{
        if (empty())
        {
            throw new QueueUnderflowException("Queue is empty.");
        }

        T item = queue[front];
        queue[front] = null;

        front = (front + 1) % queue.length;
        size--;

        if (queue.length > startingCap && size <= queue.length / 4)
        {
            newSize(Math.max(startingCap, queue.length / 2));
        }

        return item;

    }

    public void clear(){
        T[] newQueue = (T[]) new Object[startingCap];
        queue = newQueue;
        size = 0;
        front = 0;
    }
}