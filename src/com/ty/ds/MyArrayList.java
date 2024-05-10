package com.ty.ds;

public class MyArrayList<E> {

  private static final int DEFAULT_CAPACITY = 16;
  private E[] data;
  private int size = 0;

  public MyArrayList() {
    this(DEFAULT_CAPACITY);
  }

  public MyArrayList(int capacity) {
    data = (E[]) new Object[capacity];
    size = capacity;
  }

  public void add(E e) {
    int length = data.length;
    if (size == length) {
      resize(length * 2);
    }
    data[size] = e;
    size++;
  }

  public void add(E e, int index) {
    checkPositionIndex(index);
    int length = data.length;
    if (size == length) {
      resize(length * 2);
    }
    for (int j = size - 1; j >= index; j--) {
      data[j + 1] = data[j];
    }
    data[index] = e;
    size++;
  }

  public E remove(int index) {
    checkElementIndex(index);
    E eval = data[index];
    for (int i = index; i < size - 1; i++) {
      data[i] = data[i+1];
    }
    data[size] = null;
    size--;
    int length = data.length;
    if (size <= length / 4) {
      resize(length / 2);
    }
    return eval;
  }

  public E get(int index) {
    checkElementIndex(index);
    return data[index];
  }

  public E set(int index, E e) {
    checkElementIndex(index);
    E oldValue = data[index];
    data[index] = e;
    return oldValue;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void resize(int newCapacity) {
    //we must keep the existing data
    if (size > newCapacity) {
      return;
    }
    E[] temp = (E[]) new Object[newCapacity];
    if (size >= 0) {
      System.arraycopy(data, 0, temp, 0, size);
    }
    data = temp;
  }

  private void checkElementIndex(int index) {
    if (!(index >= 0 && index < size)) {
      throw new ArrayIndexOutOfBoundsException(
          "Index: " + index + ", Size: " + size + " is out of bounds");
    }
  }

  private void checkPositionIndex(int index) {
    if (!(index >= 0 && index <= size)) {
      throw new ArrayIndexOutOfBoundsException(
          "Index: " + index + ", Size: " + size + " is out of bounds");
    }
  }

  public static void main(String[] args) {
    MyArrayList<Integer> arr = new MyArrayList<>(3);

    // 添加 5 个元素
    for (int i = 1; i <= 5; i++) {
      arr.add(i);
    }

    arr.remove(3);
    arr.add(9, 1);
    arr.add(100, 0);
    int val = arr.remove(arr.size() - 1);

    for (int i = 0; i < arr.size(); i++) {
      System.out.println(arr.get(i));
    }
  }
}
