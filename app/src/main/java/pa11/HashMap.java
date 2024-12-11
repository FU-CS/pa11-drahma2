package pa11;

import java.util.LinkedList;

public class HashMap {

    private LinkedList<Pair<String, String>>[] data;
    private int capacity = 101;

    /**
     *  Constructor for the map
     */
    public HashMap() {
        this.data = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++){
            this.data[i] = new LinkedList<>();
        }
    }
    
    /** 
     *  Size of the map
     *  @return the number of elements in the map
     */
    public int size() {
        int count = 0;
        for (LinkedList<Pair<String, String>> list : data) {
            count += list.size();
        }
        return count;
    }

    /**
     *  Check if the map is empty
     *  @return a boolean indicating whether the map is empty
     */
    public boolean isEmpty() {
        for(LinkedList<Pair<String, String>> list : data){
            if(!list.isEmpty()){
                return false;
            }
        }
        return true;
    }

    /**
     *  Get the value associated with the key
     *  @param key the key to get the value for
     *  @return the value associated with the key, or null if no such entry exists
     */
    public String get(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++){
            char ch = key.charAt(i);
            int ascii = (int) ch;
            sum = sum + ascii;
        }
        int location = sum % capacity;

        for (Pair<String, String> pair : data[location]){
            if(pair.key == key){
                return pair.value;
            }
        }
        return null;
    }
    

    /**
     *  Add an entry to the map
     *  @param key the key to add
     *  @param value the value to add
     *  @return the old value associated with the key, or null if no such entry exists
     */
    public String put(String key, String value) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++){
            char ch = key.charAt(i);
            int ascii = (int) ch;
            sum = sum + ascii;
        }
        int location = sum % capacity;

        LinkedList<Pair<String, String>> list = data[location];

        for(int i = 0; i < list.size(); i++){
            Pair<String, String> pair = list.get(i);
            if (pair.key == key){
                String old = pair.value;
                list.remove(i);
                list.add(i, new Pair<>(key, value));
                return old;
            }
        }

        list.add(new Pair<>(key, value));

        return null;

    }

    /**
     *  Remove an entry from the map
     *  @param key the key to remove
     *  @return the value associated with the key, or null if no such entry exists
     */
    public String remove(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++){
            char ch = key.charAt(i);
            int ascii = (int) ch;
            sum = sum + ascii;
        }
        int location = sum % capacity;

        LinkedList<Pair<String, String>> list = data[location];

        // loops through list until the desired key is found, then removes the old value and replaces with a new value
        for (int i = 0; i < list.size(); i++){
            Pair<String, String> pair = list.get(i);
            if (pair.key == key){
                String removedVal = pair.value;
                list.remove(i);
                return removedVal;
            }
        }
        return null;
    }

    /**
     *  Get all the keys in the map
     *  @return all the keys stored in the map
     */
    public String[] keySet() {
        String[] keys = new String[size()];
        int i = 0;
        // loops through all the keys, adds to array, increments i
        for (LinkedList<Pair<String, String>> list : data){
            for (Pair<String, String> pair : list){
                keys[i] = pair.key;
                i += 1;
            }
        }
        return keys;
    }

    /**
     *  Get all the values in the map
     *  @return all the values stored in the map
     */
    public String[] values() {
        String[] value = new String[size()];
        int i = 0;
        for (LinkedList<Pair<String, String>> list : data){
            for (Pair<String, String> pair : list){
                value[i] = pair.value;
                i += 1;
            }
        }
        return value;
    }
}
