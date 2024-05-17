package HashTableTest;

import hashTable.MyHashTable;

public class MyTestingClass {
    public static void testing(){
        MyHashTable<MyKey, MyValue> hashTable = new MyHashTable<>();

        for (int i = 0; i < 100000; i++) {
            MyKey key = new MyKey(i ^ 0xbbbb);
            MyValue value = new MyValue(i);
            hashTable.put(key, value);
        }
    }
}
