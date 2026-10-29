public class LinkedQueue<T> implements QueueInterface<T>
{
    private Node<T> front;
    private Node<T> back;
    private int size;

    private static class Node<T>
    {
        private T data;
        private Node<T> next;

        public Node(T data)
        {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedQueue()
    {
        front = null;
        back = null;
        size = 0;
    }

    public int size()
    {
        return size;
    }

    public boolean empty()
    {
        return size == 0;
    }

    public T add(T item)
    {
        Node<T> newNode = new Node<T>(item);

        if (empty())
        {
            front = newNode;
            back = newNode;
        }
        else
        {
            back.next = newNode;
            back = newNode;
        }

        size++;
        return item;
    }

    public T peek() throws QueueUnderflowException
    {
        if (empty())
        {
            throw new QueueUnderflowException("Queue is empty.");
        }

        return front.data;
    }

    public T remove() throws QueueUnderflowException
    {
        if (empty())
        {
            throw new QueueUnderflowException("Queue is empty.");
        }

        T item = front.data;
        front = front.next;
        size--;

        if (empty())
        {
            back = null;
        }

        return item;
    }

    public void clear()
    {
        front = null;
        back = null;
        size = 0;
    }
}