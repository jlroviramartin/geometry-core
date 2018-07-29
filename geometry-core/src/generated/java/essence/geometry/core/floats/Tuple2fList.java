package essence.geometry.core.floats;

import java.util.logging.Logger;
import java.util.Collection;
import java.util.AbstractList;
import java.util.function.Predicate;
import java.util.function.Consumer;
import essence.geometry.core.Tuple;

/**
 * Basic implementation of a 2 dimension tuple list. Null tuples are not admitted.
 *
 * @param <T> Type of the tuple.
 */
public class Tuple2fList <T extends Tuple2f> extends AbstractList<T> {

//<editor-fold defaultstate="collapsed" desc="fields">
    private final ConstructorFunction<T> constructor;
    private float[] array;
    /* Number of tuples in the list. */
    private int size;
    /* Number of components in the list. */
    private int realSize;
    private static final int INC_SIZE = 2 * 10;
    private static final Logger LOG = Logger.getLogger(Tuple2fList.class.getName());
//</editor-fold>

    /**
     * Empty constructor.
     */
    public Tuple2fList() {
        this(INC_SIZE, null);
    }

    /**
     * Constructor including a tuple constructor.
     *
     * @param constructor Tuple constructor.
     */
    public Tuple2fList(ConstructorFunction<T> constructor) {
        this(INC_SIZE, constructor);
    }

    /**
     * Constructor including the size.
     *
     * @param size Initial size of the list.
     */
    public Tuple2fList(int size) {
        this(size, null);
    }

    /**
     * Constructor including the size and a tuple constructor.
     *
     * @param size Initial size of the list.
     * @param constructor Tuple constructor.
     */
    public Tuple2fList(int size, ConstructorFunction<T> constructor) {
        array = new float[size * 2];
        this.constructor = constructor;
    }

    /**
     * This method gets the item in the position {@code index} and sets it into {@code item}.
     *
     * @param index Index of the item.
     * @param item Item where to set the result.
     */
    public void getInto(int index, T item) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int j = index * 2;
        item.set(array[j++], array[j++]);

    }

    /**
     * This method finds the first index of the item that accepts the predicate
     * {@code predicate}, starting in {@code start}.
     *
     * @param predicate Predicate.
     * @param start Where to start.
     * @return Index.
     */
    public int find(Predicate<? super T> predicate, int start) {
        T item = newTuple(0, 0);
        for (int i = start * 2; i < realSize;) {
            item.set(array[i++], array[i++]);
            if (predicate.test(item)) {
                return i / 2 - 1;
            }
        }
        return -1;
    }

    /**
     * This method finds the last index of the item that accepts the predicate
     * {@code predicate}, starting in {@code start} (from the end).
     *
     * @param predicate Predicate.
     * @param start Where to start (from the end).
     * @return Index.
     */
    public int findLast(Predicate<? super T> predicate, int start) {
        T item = newTuple(0, 0);
        for (int i = (start + 1) * 2 - 1; i >= 0;) {
            float y = array[i--];
            float x = array[i--];
            item.set(x, y);
            if (predicate.test(item)) {
                return (i + 1) / 2;
            }
        }
        return -1;
    }

    /**
     * This method removes the last item.
     */
    public void removeLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        size--;
        realSize -= 2;
    }

    /**
     * This method removes the item in the position {@code index}.
     *
     * @param index Index.
     */
    public void removeFast(int index) {
        if (size == 0 || index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int j = index * 2;
        System.arraycopy(array, j, array, j + 2, realSize - j - 2);
        size--;
        realSize -= 2;
    }

    /**
     * This method removes the item {@code item}.
     *
     * @param item Item.
     */
    public void remove(T item) {
        int index = indexOf(item);
        if (index > 0) {
            removeFast(index);
        }
    }

    /**
     * This method builds a new tuple.
     *
     * @return A new tuple.
     */
    protected T newTuple(float x, float y) {
        if (constructor == null) {
            throw new UnsupportedOperationException();
        }
        return constructor.invoke(x, y);
    }

    /**
     * This method converts a tuple into another one compatible with this class.
     *
     * @param tuple Tuple to convert.
     * @return Converted tuple.
     */
    protected static Tuple2_Float toTuple(Tuple tuple) {
        if (tuple instanceof Tuple2_Float) {
            return (Tuple2_Float)tuple;
        }
        Tuple2f aux = new Tuple2f();
        tuple.getInto(aux);
        return aux;
    }


//<editor-fold defaultstate="collapsed" desc="AbstractList<T>">
    /**
     * This method removes a range of items, from {@code fromIndex} to {@code toIndex}.
     *
     * @param fromIndex Initial index.
     * @param toIndex Last index (non including).
     */
    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        if (size == 0 || fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }
        if (fromIndex == toIndex) {
            return;
        }
        int num = toIndex - fromIndex;
        int j = fromIndex * 2;
        System.arraycopy(array, j + num * 2, array, j, realSize - j - num * 2);
        size -= num;
        realSize -= num * 2;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="List<T>">
    /**
     * Number of tuples in the list.
     *
     * @return Size of the list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * This method gets the item in the position {@code index}.
     *
     * @param index Index of the item.
     * @return Item.
     */
    @Override
    public T get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int j = index * 2;
        return newTuple(array[j++], array[j++]);
    }

    /**
     * This method sets the item in the position {@code index} to {@code item}.
     *
     * @param index Index of the item.
     * @param item Item to set.
     * @return Item setted.
     */
    @Override
    public T set(int index, T item) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int j = index * 2;
        array[j++] = item.getX();
        array[j++] = item.getY();
        return item;
    }

    /**
     * This method gets the index of the item {@code item}.
     *
     * @param item Item.
     * @return Index.
     */
    @Override
    public int indexOf(Object item) {
        return find(x -> x.equals((T)item), 0);
    }

    /**
     * This method gets the last index of the item {@code item}.
     *
     * @param item Item.
     * @return Index.
     */
    @Override
    public int lastIndexOf(Object item) {
        return findLast(x -> x.equals((T)item), size() - 1);
    }

    /**
     * This method adds the item {@code item} at the end.
     *
     * @param item Item.
     * @return True if item has been properly removed. False otherwise.
     */
    @Override
    public boolean add(T item) {
        int j = realSize;
        if (realSize + 2 >= array.length) {
            float[] aux = new float[array.length + INC_SIZE];
            System.arraycopy(array, 0, aux, 0, realSize);
            array = aux;
        }
        array[j++] = item.getX();
        array[j++] = item.getY();
        size++;
        realSize += 2;
        return true;
    }

    /**
     * This method inserts the item {@code item} in the position {@code index}.
     *
     * @param item Item.
     * @param index Index.
     */
    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        int j = index * 2;
        int requieredSize = realSize + 2;
        if (realSize + 2 >= array.length) {
            int proposedSize = array.length + INC_SIZE;
            int newSize = ((requieredSize > proposedSize) ? requieredSize : proposedSize);
            float[] aux = new float[newSize];
            System.arraycopy(array, 0, aux, 0, j);
            System.arraycopy(array, j, aux, j + 2, realSize - j);
            array = aux;
        } else {
            System.arraycopy(array, j, array, j + 2, realSize - j);
        }
        array[j++] = item.getX();
        array[j++] = item.getY();
        size++;
        realSize += 2;
    }

    /**
     * This method inserts the items {@code c} in the position {@code index}.
     *
     * @param c Items.
     * @param index Index.
     * @return True if item has been properly removed. False otherwise.
     */
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        int j = index * 2;
        int csize = c.size();
        int requieredSize = realSize + csize * 2;
        if (requieredSize >= array.length) {
            int proposedSize = array.length + INC_SIZE;
            int newSize = ((requieredSize > proposedSize) ? requieredSize : proposedSize);
            float[] aux = new float[newSize];
            System.arraycopy(array, 0, aux, 0, j);
            System.arraycopy(array, j, aux, j + csize * 2, realSize - j);
            array = aux;
        } else {
            System.arraycopy(array, j, array, j + csize * 2, realSize - j);
        }
        for (T item : c) {
            array[j++] = item.getX();
            array[j++] = item.getY();
        }
        size += csize;
        realSize += csize * 2;
        return true;
    }

    /**
     * This method removes the item in the position {@code index}.
     *
     * @param index Index.
     * @return Item removed.
     */
    @Override
    public T remove(int index) {
        if (size == 0 || index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T ret = get(index);
        int j = index * 2;
        System.arraycopy(array, j + 2, array, j, realSize - j - 2);
        size--;
        realSize -= 2;
        return ret;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Iterator<T>">
    /**
     * This method applies the action {@code action} to all items in {@code this} list.
     *
     * @param action Acion.
     */
    @Override
    public void forEach(Consumer<? super T> action) {
        T item = newTuple(0, 0);
        for (int i = 0; i < realSize;) {
            item.set(array[i++], array[i++]);
            action.accept(item);
            i -= 2;
            array[i++] = item.getX();
            array[i++] = item.getY();
        }
    }
//</editor-fold>

    /**
     * This interface is used to build tuples.
     *
     * @param <T> Type of the tuple.
     */
    @FunctionalInterface
    protected static interface ConstructorFunction<T extends Tuple2f> {
        T invoke(float x, float y);
    }
}







