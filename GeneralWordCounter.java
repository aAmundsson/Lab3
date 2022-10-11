package L3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GeneralWordCounter implements TextProcessor {
    Map<String, Integer> m = new TreeMap<String, Integer>();
    Set<String> s = new HashSet<>();
    Set<String> keys = new HashSet<>();
    Set<Map.Entry<String, Integer>> wordSet = m.entrySet();

    public GeneralWordCounter(Set<String> s) {
        this.s = s;
    }

    public List <Map.Entry<String, Integer>> getWordList() {
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>();
        list.addAll(m.entrySet());

        return list;
    }

    public void process(String w) {
        if (s.contains(w)) {
        }
        else {
            if (!keys.contains(w)) {
                keys.add(w);
                m.put(w, 1);
            }
            else {
                m.put(w, m.get(w) + 1);
            }
        }
    }

    public void report() {

        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
        wordList.sort((o1, o2) -> {
            if ((o2.getValue()- o1.getValue()) == 0) {
                return o1.getKey().compareTo(o2.getKey());
            }
            else {
                return o2.getValue() - o1.getValue();
            }

        });
        for (int i = 0; i <= 10; i++) {
            System.out.println(wordList.get(i));
        }
    }
}
