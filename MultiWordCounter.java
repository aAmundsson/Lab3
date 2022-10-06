package L3;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MultiWordCounter implements TextProcessor {
    private String[] words;
    Map<String, Integer> m = new HashMap<String, Integer>();

    public MultiWordCounter(String[] words) {
        this.words = words;
        for (String word : words) {
            m.put(word, 0);
        }
    }

    public void process(String w) {
        for (String key : m.keySet()) {
            if (w.equals(key))
                m.put(key, m.get(key) + 1);
        }
    }

    public void report() {
        for (String key : m.keySet()) {
            System.out.println(key + ": " + m.get(key));
        }
    }

}
