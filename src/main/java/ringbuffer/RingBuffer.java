package ringbuffer;

public class RingBuffer<T> {

    T[] buffer;
    private int capacity;
    private int reader;
    private int writer;

    public RingBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = (T[]) new Object[this.capacity];
        this.reader = 0;
        this.writer = -1;
    }

    public boolean offer(T element) {

        boolean isFull = size() == capacity;
        if (!isFull) {
            int nextWrite = writer + 1;
            buffer[nextWrite % capacity] = element;
            writer++;
            return true;
        }
        return false;
    }

    public T poll() {

        boolean isEmpty = writer < reader;
        if (!isEmpty) {
            T nextValue = buffer[reader % capacity];
            reader++;
            return nextValue;
        }
        return null;
    }

    public int size() {

        return (writer - reader) + 1;
    }

}

