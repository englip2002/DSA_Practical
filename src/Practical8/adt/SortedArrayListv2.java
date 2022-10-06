package Practical8.adt;

/**
 * SortedArrayList - Implements the ADT Sorted List using an array. - Note: Some
 * methods are not implemented yet and have been left as practical exercises
 *
 * @param <T>
 */
public class SortedArrayListv2<T extends Comparable<T>> implements SortedListInterface<T> {

    private T[] array;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;

    public SortedArrayListv2() {
        this(DEFAULT_CAPACITY);
    }

    public SortedArrayListv2(int initialCapacity) {
        numberOfEntries = 0;
        array = (T[]) new Comparable[initialCapacity];
    }

    @Override
    public boolean add(T newEntry) {
//        while (i < numberOfEntries && newEntry.compareTo(array[i]) > 0) {
//            i++;
//        }
        int i = Math.abs(binarySearch(newEntry));
        makeRoom(i + 1);
        array[i] = newEntry;
        numberOfEntries++;
        return true;
    }

    public boolean remove(T anEntry) {
        int index = binarySearch(anEntry);
        //double check is the correct value
        if (index >= 0 && array[index].equals(anEntry)) {
            removeGap(index + 1);
            numberOfEntries--;
            return true;
        }
        return false;
    }

    public void clear() {
        numberOfEntries = 0;
    }

    public boolean contains(T anEntry) {
        int index = binarySearch(anEntry);
        return (index >= 0 && anEntry.equals(array[index]));
    }

    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public String toString() {
        String outputStr = "";
        for (int index = 0; index < numberOfEntries; ++index) {
            outputStr += array[index] + "\n";
        }

        return outputStr;
    }

    private boolean isArrayFull() {
        return numberOfEntries == array.length;
    }

    private void doubleArray() {
        T[] oldList = array;
        int oldSize = oldList.length;

        array = (T[]) new Object[2 * oldSize];

        for (int index = 0; index < oldSize; index++) {
            array[index] = oldList[index];
        }
    }

    private void makeRoom(int newPosition) {
        int newIndex = newPosition - 1;
        int lastIndex = numberOfEntries - 1;

        for (int index = lastIndex; index >= newIndex; index--) {
            array[index + 1] = array[index];
        }
    }

    private void removeGap(int givenPosition) {
        int removedIndex = givenPosition - 1;
        int lastIndex = numberOfEntries - 1;

        for (int index = removedIndex; index < lastIndex; index++) {
            array[index] = array[index + 1];
        }
    }

    @Override
    public boolean isFull() {
        return false;
    }

    //Utility method
    private int binarySearch(T searchValue) {
        int first = 0;
        int last = numberOfEntries;
        while (first < last) {
            int mid = (first + last) / 2;
            if (searchValue.equals(array[mid])) {
                return mid;
            } else if (searchValue.compareTo(array[mid]) > 0) {
                first = mid + 1;
            } else if (searchValue.compareTo(array[mid]) < 0) {
                last = mid - 1;
            }
        }
        return -(last + 1); //use to add new value
    }

}
