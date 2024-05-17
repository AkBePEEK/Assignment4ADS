import hashTable.MyHashTable;
import BinaryTree.BST;
import HashTableTest.*;

public class Main {
    public static void main(String[] args) {
        BST<Integer, Integer> bst = new BST<>();
        bst.put(4,5);
        bst.put(6,3);
        bst.put(7,5);
        bst.put(8,4);
        bst.put(1,2);
        bst.put(9,10);

        System.out.println(bst);
        bst.put(8,7);
        System.out.println(bst);
        System.out.println(bst.get(5));
        bst.remove(1);
        System.out.println(bst);

        MyKey key1 = new MyKey(1);
        MyKey key2 = new MyKey(2);
        MyKey key3 = new MyKey(5);

        System.out.println(key1.hashCode() + " ");
        System.out.println(key2.hashCode() + " ");
        System.out.println(key3.hashCode() + " ");

        MyHashTable<Integer, Integer> hashTable = new MyHashTable<>();

        hashTable.put(4, 1);
        hashTable.put(7, 8);
        hashTable.put(5, 4);

        System.out.println(hashTable.contains(5));
        System.out.println(hashTable.contains(8));
        System.out.println(hashTable.contains(4));
        System.out.println(hashTable.get(4));
        System.out.println(hashTable.remove(4));
        System.out.println(hashTable.get(4));

        MyHashTable<String, Integer> hashTable1 = new MyHashTable<>(200);

        for (int i = 0; i < 1000; i++){
            double f = Math.random();
            hashTable1.put(String.valueOf((char)(65 * (1.0 - f) + 122 * f)), i);
        }

        System.out.println(hashTable1);

        MyTestingClass.testing();
    }
}