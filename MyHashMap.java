
public class MyHashMap<K,V>{
    private Object[] keys;
    private Object[] values;
    private int size;
    public MyHashMap() {
        keys = new Object[10];
        values = new Object[10];
        size = 0;
    }
    public V get(K key) {
        if(keys.length == 0)
            return null;
        int count = 0;
        while(!keys[count].equals(key))
            count++;
        return (V) values[count];
    }
    public void put(K key ,V value) {
        if (size == keys.length) {
            expandSize();
        }
        int tmp = 0;
        while(keys[tmp] != null) {
            if(tmp== keys.length-1)
                break;
            tmp++;
        }

        keys[tmp] = key;
        values[tmp] = value;
        size++;
    }
    public V remove(K key) {
        int tmp =0;
        while(!keys[tmp].equals(key))
            tmp++;
        V dummy = (V) values[tmp];
        for(int i=tmp; i< keys.length-1; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
        size--;
        return dummy;
    }
    public void expandSize() {
        int new_size = keys.length + 10;
        Object[] new_keys = new Object[new_size];
        Object[] new_values = new Object[new_size];

        for (int i = 0; i < keys.length; i++) {
            new_keys[i] = keys[i];
            new_values[i] = values[i];
        }

        this.keys = new_keys;
        this.values = new_values;
    }

    public void print() {
        for(int i=0; i<size; i++) {
            System.out.println(keys[i] + " "+ values[i]);
        }
    }
}
