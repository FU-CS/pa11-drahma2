package pa11;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HashMapTest {
    
    @Test
    void testSize(){
        HashMap map = new HashMap();
        assertEquals(map.size(), 0);

        map.put("soda", "coke");
        map.put("hydration", "gatorade");
        map.put("juice", "apple");

        assertEquals(map.size(), 3);
    }

    @Test
    void testEmpty(){
        HashMap map = new HashMap();
        assertEquals(map.isEmpty(), true);

        map.put("soda", "coke");
        map.put("hydration", "gatorade");
        map.put("juice", "apple");

        assertEquals(map.isEmpty(), false);
    }

    @Test
    void testGet(){
        HashMap map = new HashMap();
        map.put("soda", "coke");
        map.put("hydration", "gatorade");
        map.put("juice", "apple");

        assertEquals(map.get("soda"), "coke");
        assertEquals(map.get("hydration"), "gatorade");
        assertEquals(map.get("juice"), "apple");
        assertEquals(map.get("beer"), null);
    }

    @Test
    void testPut(){
        HashMap map = new HashMap();
        map.put("soda", "coke");
        map.put("hydration", "gatorade");
        map.put("juice", "apple");

        assertEquals(map.put("soda", "pepsi"), "coke");
        assertEquals(map.put("hydration", "water"), "gatorade");
        assertEquals(map.put("juice", "orange"), "apple");

        assertEquals(map.get("soda"), "pepsi");
        assertEquals(map.get("hydration"), "water");
        assertEquals(map.get("juice"), "orange");
        assertEquals(map.get("beer"), null);
    }

    @Test
    void testRemove(){
        HashMap map = new HashMap();
        map.put("soda", "coke");
        map.put("hydration", "gatorade");
        map.put("juice", "apple");

        assertEquals(map.size(), 3);
        assertEquals(map.remove("soda"), "coke");
        assertEquals(map.size(), 2);
        assertEquals(map.remove("hydration"), "gatorade");
        assertEquals(map.size(), 1);
        assertEquals(map.remove("juice"), "apple");
        assertEquals(map.size(), 0);
        assertEquals(map.remove("beer"), null);
    }

    @Test
    void testKeySet(){
        HashMap map = new HashMap();
        map.put("soda", "coke");
        map.put("hydration", "gatorade");
        map.put("juice", "apple");

        String[] keys = {"soda", "juice", "hydration"};

        assertArrayEquals(map.keySet(), keys);
    }

    @Test
    void testValuesSet(){
        HashMap map = new HashMap();
        map.put("soda", "coke");
        map.put("hydration", "gatorade");
        map.put("juice", "apple");

        String[] value = {"coke", "apple", "gatorade"};
        assertArrayEquals(map.values(), value);

        map.put("soda", "pepsi");
        map.put("hydration", "water");
        map.put("juice", "orange");


        String[] value1 = {"pepsi", "orange", "water"};
        assertArrayEquals(map.values(), value1);
    }
}

