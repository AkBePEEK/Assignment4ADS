package hashTable;

public class MyHashTable<K,V> {
    private static class HashNode<K, V>{
        final K key;
        V value;
        private HashNode<K, V> next;
        public HashNode(K key, V value){
            this.key = key;
            this.value = value;

            this.next = null;
        }
        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }
    private HashNode<K, V>[] chainArray;
    private static final int  M = 11;
    private int size;
    public MyHashTable(){
        chainArray = createArray(M);
    }
    public MyHashTable(int M){
        if (M <= 0){
            throw new IllegalArgumentException("Size must be positive value!");
        }
       chainArray = createArray(M);
    }

    public void put(K key, V value){
        increaseSize();

        int index = getIndex(key);
        HashNode<K, V> newNode = new HashNode<>(key, value);

        if (chainArray[index] == null){
            chainArray[index] = newNode;
            size++;
            return;
        }

        HashNode<K, V> node = chainArray[index];
        while(node != null){
            if (node.key.equals(key)){
                node.value = value;
                return;
            }
            if (node.next == null){
                break;
            }
            node = node.next;
        }

        if (node == null){
            throw new NullPointerException("Node element cannot be null!");
        }
        node.next = newNode;
        size++;
    }
    public V get(K key){
        int index = getIndex(key);
        HashNode<K, V> node = chainArray[index];
        while (node != null){
            if (node.key.equals(key)) return node.value;
            node = node.next;
        }

        return null;
    }
    public V remove(K key){
        int index = getIndex(key);

        HashNode<K, V> node = chainArray[index];
        if (node == null) return null;
        V value;


        if (node.key.equals(key)) {
            value = chainArray[index].value;
            chainArray[index] = null;
            return value;
        }

        while (node.next != null) {
            if (node.next.key.equals(key)) {
                value = node.next.value;
                node.next = node.next.next;
                return value;
            }
            node = node.next;
        }

        return null;
    }
    public boolean contains(V value){
        return getKey(value) != null;
    }
    public K getKey(V value){
        for (HashNode<K, V> node : chainArray)
            while (node != null) {
                if (node.value.equals(value)) return node.key;
                node = node.next;
            }
        return null;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("MyHashTable{");
        for (HashNode<K, V> node : chainArray)
            while (node != null) {
                builder.append(node).append(",");
                node = node.next;
            }
        builder.append("}");
        return builder.toString();
    }
    private int hash(K key){
        return key.hashCode();
    }
    @SuppressWarnings("unchecked")
    private HashNode<K, V>[] createArray(int M){
        return new HashNode[M];
    }
    private int getIndex(K key){
        int hash = hash(key);
        return (hash >= 0 ? hash: -1 * hash) % chainArray.length;
    }
    private void increaseSize(){
        if (size < chainArray.length * 3 / 4) return;

        HashNode<K, V>[] oldChain = chainArray;
        chainArray = createArray(chainArray.length * 2);
        reIndex(oldChain);
    }
    private void reIndex(HashNode<K, V>[] oldchain){
        for (HashNode<K, V> node : oldchain) {
            while (node != null) {
                put(node.key, node.value);
                node = node.next;
            }
        }
    }
}
