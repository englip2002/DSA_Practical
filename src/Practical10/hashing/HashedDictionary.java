/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashing;

/**
 *
 * @author tzeha
 */
import java.io.Serializable;
 
public class HashedDictionary<K, V> implements DictionaryInterface<K, V>, Serializable {
 
  private TableEntry<K, V>[] hashTable;
  private int numberOfEntries;
  private int locationsUsed;
  private static final int DEFAULT_SIZE = 101;
  private static final double MAX_LOAD_FACTOR = 0.5;
 
  public HashedDictionary() {
    this(DEFAULT_SIZE);
  }
 
  public HashedDictionary(int tableSize) {
    int primeSize = getNextPrime(tableSize);
 
    hashTable = new TableEntry[primeSize];
    numberOfEntries = 0;
    locationsUsed = 0;
  }
 
  public String toString() {
    String outputStr = "";
    for (int index = 0; index < hashTable.length; index++) {
      outputStr += String.format("%4d. ", index);
      if (hashTable[index] == null) {
        outputStr += "null\n";
      } else if (hashTable[index].isRemoved()) {
        outputStr += "notIn\n";
      } else {
        outputStr += hashTable[index].getKey() + " " + hashTable[index].getValue() + "\n";
      }
    }
    outputStr += "\n";
    return outputStr;
  }
 
  public V add(K key, V value) {
    V oldValue;
 
    if (isHashTableTooFull()) {
      rehash();
    }
 
    int index = getHashIndex(key);
    index = probe(index, key);
 
    if ((hashTable[index] == null) || hashTable[index].isRemoved()) {
      hashTable[index] = new TableEntry<K, V>(key, value);
      numberOfEntries++;
      locationsUsed++;
      oldValue = null;
    } else {
      oldValue = hashTable[index].getValue();
      hashTable[index].setValue(value);
    }
 
    return oldValue;
  }
 
  public V remove(K key) {
    V removedValue = null;
 
    int index = getHashIndex(key);
    index = locate(index, key);
 
    if (index != -1) {
      removedValue = hashTable[index].getValue();
      hashTable[index].setToRemoved();
      numberOfEntries--;
    }
 
    return removedValue;
  }
 
  public V getValue(K key) {
    V result = null;
 
    int index = getHashIndex(key);
    index = locate(index, key);
 
    if (index != -1) {
      result = hashTable[index].getValue();
    }
 
    return result;
  }
 
  /**
   * CHANGES 1 
   */
  private int probe(int index, K key) {
    boolean found = false;
    int removedStateIndex = -1;
    int increment = getSecondHashIndex(key);
 
    while (!found && (hashTable[index] != null)) {
      if (hashTable[index].isIn()) {
        if (key.equals(hashTable[index].getKey())) {
          found = true;
        } else {
          index = (index + increment) % hashTable.length; // double hashing
        }
      } else { // skip entries that were removed 
        // save index of first location in removed state
        if (removedStateIndex == -1) {
          removedStateIndex = index;
        }
 
        index = (index + increment) % hashTable.length; // double hashing
      }
    }
 
    if (found || (removedStateIndex == -1)) {
      return index;
    } else {
      return removedStateIndex;
    }
  }
 
  /**
   * CHANGES 2
   */
  private int locate(int index, K key) {
    boolean found = false;
    int increment = getSecondHashIndex(key);
    while (!found && (hashTable[index] != null)) {
      if (hashTable[index].isIn() && key.equals(hashTable[index].getKey())) {
        found = true;
      } else {
        index = (index + increment) % hashTable.length; // double hashing
      }
    }
 
    int result = -1;
    if (found) {
      result = index;
    }
 
    return result;
  }
 
  public boolean contains(K key) {
    return getValue(key) != null;
  }
 
  public boolean isEmpty() {
    return numberOfEntries == 0;
  }
 
  public boolean isFull() {
    return false;
  }
 
  public int getSize() {
    return numberOfEntries;
  }
 
  public final void clear() {
    for (int index = 0; index < hashTable.length; index++) {
      hashTable[index] = null;
    }
 
    numberOfEntries = 0;
    locationsUsed = 0;
  }
 
  private int getHashIndex(K key) {
    int hashIndex = key.hashCode() % hashTable.length;
 
    if (hashIndex < 0) {
      hashIndex = hashIndex + hashTable.length;
    }
 
    return hashIndex;
  }
 
  /**
   * CHANGES 3.
   */
  private int getSecondHashIndex(K key) {
    return 7 - key.hashCode() % 7;
  }
 
  /**
   * Task: Increases the size of the hash table to a prime > twice its old size.
   */
  private void rehash() {
    TableEntry<K, V>[] oldTable = hashTable;
    int oldSize = hashTable.length;
    int newSize = getNextPrime(oldSize + oldSize);
    hashTable = new TableEntry[newSize]; // increase size of array
    numberOfEntries = 0; // reset number of dictionary entries, since
    // it will be incremented by add during rehash
    locationsUsed = 0;
 
    // rehash dictionary entries from old array to the new and bigger 
    // array; skip both null locations and removed entries
    for (int index = 0; index < oldSize; index++) {
      if ((oldTable[index] != null) && oldTable[index].isIn()) {
        add(oldTable[index].getKey(), oldTable[index].getValue());
      }
    } // end for
  } // end rehash
 
  /**
   * @return true if lambda > MAX_LOAD_FACTOR for hash table; otherwise returns
   * false.
   */
  private boolean isHashTableTooFull() {
    return locationsUsed > MAX_LOAD_FACTOR * hashTable.length;
  } // end isHashTableTooFull
 
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
 
  // 20.09
  private class TableEntry<S, T> implements Serializable {
 
    private S key;
    private T value;
    private boolean inTable; // true if entry is in table
 
    private TableEntry(S searchKey, T dataValue) {
      key = searchKey;
      value = dataValue;
      inTable = true;
    } // end constructor
 
    private S getKey() {
      return key;
    } // end getKey
 
    private T getValue() {
      return value;
    } // end getValue
 
    private void setValue(T newValue) {
      value = newValue;
    } // end setValue
 
    private boolean isIn() {
      return inTable;
    } // end isIn
 
    private boolean isRemoved() { // opposite of isIn
      return !inTable;
    } // end isRemoved
 
    // state = true means entry in use; false means entry not in use, ie deleted
    private void setToRemoved() {
      key = null;
      value = null;
      inTable = false;
    } // end setToRemoved
 
    private void setToIn() { // not used
      inTable = true;
    } // end setToIn
  } // end TableEntry
} // end HashedDictionary
 