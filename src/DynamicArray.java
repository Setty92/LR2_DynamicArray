import java.util.Arrays;

public class DynamicArray<T> {
    private static final int DEFAULT_SIZE = 8;
    private Object[] array;
    private int size;


    public DynamicArray() {
        this.array = new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    public DynamicArray(int initialSize) {
        if (initialSize < 0) {
            throw new IllegalArgumentException("Initial size cannot be negative: " + initialSize);
        }
        this.array = new Object[initialSize];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public void add(T element) {
        ensureCapacity();
        array[size++] = element;
    }

    public T get(int index) {
        if (index >= size || index < -size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        if (index < 0) {
            index = size + index;
        }
        return (T) array[index];
    }

    public void set(int index, T element) {
        if (index >= size || index < -size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        if (index < 0) {
            array[size + index] = element;
        }
        array[index] = element;
    }

    public void delete(int index) {
        if (index >= size || index < -size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        if (index < 0) {
            index = size + index;
        }
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            int newCapacity = array.length + 1;
            array = Arrays.copyOf(array, newCapacity);
        }
    }


}
