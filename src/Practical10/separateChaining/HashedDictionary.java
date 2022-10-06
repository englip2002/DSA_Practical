package separateChaining;

import java.io.Serializable;

/**
 * A class that implements the ADT dictionary by using hashing and separate
 * chaining to resolve collisions.
 *
 * The dictionary is not sorted and has distinct search keys. Note: Has a
 * display method for illustration and testing
 *
 * @author Frank M. Carrano
 * @version 2.0
 */
public class HashedDictionary<K, V> implements DictionaryInterface<K, V>, Serializable {

  private Node<K, V>[] hashTable;							       // dictionary entries
  private int numberOfEntries;
  private static final int DEFAULT_SIZE = 101; 		   // default size of hash table - must be prime 
  private static final double MAX_LOAD_FACTOR = 0.9; // fraction of hash table that can be filled

  public HashedDictionary() {
    this(DEFAULT_SIZE);
  } // end default constructor

  public HashedDictionary(int tableSize) {
    int primeSize = getNextPrime(tableSize);

    hashTable = new Node[primeSize];
    numberOfEntries = 0;
  } // end constructor

  public String toString() {
    String outputStr = "";
    for (int index = 0; index < hashTable.length; index++) {
      if (hashTable[index] == null) {
        outputStr += "null\n";
      } else {
        Node<K, V> currentNode = hashTable[index];
        while (currentNode != null) {
          outputStr += currentNode.key + " " + currentNode.value + ", ";
          currentNode = currentNode.next;
        } // end while

        outputStr += "\n";
      } // end if
    } // end for

    outputStr += "\n";
    return outputStr;
  } 

  public V add(K key, V value) {
    // assumes key and value are not null
    V oldValue = null; // value to return

    if (isHashTableTooFull()) {
      rehash();
    } // end if

    int index = getHashIndex(key);

    // index always in range due to mod of hash fn
    if (hashTable[index] == null) {
      // key not found, so insert new entry

      hashTable[index] = new Node<K, V>(key, value);
      numberOfEntries++;
    } else { // search chain beginning at hashTable[index] for a node that contains key

      Node<K, V> currentNode = hashTable[index];
      Node<K, V> nodeBefore = null;

      while ((currentNode != null) && !key.equals(currentNode.key)) {
        nodeBefore = currentNode;
        currentNode = currentNode.next;
      } // end while

      if (currentNode == null) {
        // key not in chain; add new entry to end of chain
        Node<K, V> newNode = new Node<K, V>(key, value);
        nodeBefore.next = newNode;
        numberOfEntries++;
      } else {
        // key found; get old value for return and then replace it
        oldValue = currentNode.value;
        currentNode.value = value;
      } // end if
    } // end if

    return oldValue;
  } // end add

  public V remove(K key) {
    V removedValue = null;

    int index = getHashIndex(key);

    // search chain beginning at hashTable[index] for a node that contains key
    Node<K, V> nodeBefore = null;
    Node<K, V> currentNode = hashTable[index];

    while ((currentNode != null) && !key.equals(currentNode.key)) {
      nodeBefore = currentNode;
      currentNode = currentNode.next;
    } // end while

    if (currentNode != null) {
      // key found; get value for return and then remove entry
      removedValue = currentNode.value;

      if (nodeBefore == null) {
        // remove first node
        hashTable[index] = currentNode.next;
      } else {
        nodeBefore.next = currentNode.next;
      }

      numberOfEntries--;
    } // end if
    // else removedValue is null if key not found

    return removedValue;
  } // end remove

  public V getValue(K key) {
    V result = null;

    int index = getHashIndex(key);

    // search chain beginning at hashTable[index] for a node that contains key
    Node<K, V> currentNode = hashTable[index];

    while ((currentNode != null) && !key.equals(currentNode.key)) {
      currentNode = currentNode.next;
    } // end while

    if (currentNode != null) {
      // key found; get value for return
      result = currentNode.value;
    } // end if
    // else not found; result is null

    return result;
  } // end getValue

// rehash changes a bit from open addressing
  /**
   * Task: Increases the size of the hash table to a prime > twice its old size.
   */
  private void rehash() {
    Node<K, V>[] oldTable = hashTable;
    int oldSize = oldTable.length;
    int newSize = getNextPrime(oldSize + oldSize);

    hashTable = new Node[newSize];    // increase size of array

    numberOfEntries = 0; // reset number of dictionary entries, since
    // it will be incremented by add during rehash

    // rehash dictionary entries from old array to new, bigger array.
    for (int index = 0; index < oldSize; ++index) {
      // rehash chain in old table
      Node<K, V> currentNode = oldTable[index];

      while (currentNode != null) { // skip empty lists

        add(currentNode.key, currentNode.value);
        // easy, but deallocates entry and reallocates it **********************
        currentNode = currentNode.next;
      } // end while
    } // end for
  } // end rehash

  public final void clear() {
    for (int index = 0; index < hashTable.length; index++) {
      hashTable[index] = null;
    }

    numberOfEntries = 0;
  } // end clear

  /**
   * @return true if lambda > MAX_LOAD_FACTOR for hash table; otherwise returns
   * false.
   */
  private boolean isHashTableTooFull() {
    return numberOfEntries > MAX_LOAD_FACTOR * hashTable.length;
  } // end isHashTableTooFull

// the following methods that appear between the dashed lines
// are the same as for open addressing
// ----------------------------------------------------------
  public boolean contains(K key) {
    return getValue(key) != null;
  } // end contains

  public boolean isEmpty() {
    return numberOfEntries == 0;
  } // end isEmpty

  public boolean isFull() {
    return false;
  } // end isFull

  public int getSize() {
    return numberOfEntries;
  } // end getSize

  private int getHashIndex(K key) {

    int hashIndex = key.hashCode() % hashTable.length;

    if (hashIndex < 0) {
      hashIndex = hashIndex + hashTable.length;
    } // end if

    return hashIndex;
  } // end getHashIndex

  private int getNextPrime(int integer) {
    // if even, add 1 to make odd
    if (integer % 2 == 0) {
      integer++;
    } // end if

    // test odd integers
    while (!isPrime(integer)) {
      integer = integer + 2;
    } // end while

    return integer;
  } // end getNextPrime

  private boolean isPrime(int integer) {
    boolean result;
    boolean done = false;

    // 1 and even numbers are not prime
    if ((integer == 1) || (integer % 2 == 0)) {
      result = false;
    } // 2 and 3 are prime
    else if ((integer == 2) || (integer == 3)) {
      result = true;
    } else { // integer is odd and >= 5
      // a prime is odd and not divisible by every odd integer up to its square root
      result = true; // assume prime
      for (int divisor = 3; !done && (divisor * divisor <= integer); divisor = divisor + 2) {
        if (integer % divisor == 0) {
          result = false; // divisible; not prime
          done = true;
        } // end if
      } // end for
    } // end if

    return result;
  } // end isPrime
// ----------------------------------------------------------

  private class Node<S, T> implements java.io.Serializable {

    private S key;
    private T value;
    private Node<S, T> next;

    private Node(S searchKey, T dataValue) {
      key = searchKey;
      value = dataValue;
      next = null;
    } // end constructor

    private Node(S searchKey, T dataValue, Node<S, T> nextNode) {
      key = searchKey;
      value = dataValue;
      next = nextNode;
    } // end constructor

  } // end Node
} // end HashedDictionary

