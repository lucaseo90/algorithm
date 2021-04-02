package com.github.lucaseo90;

import java.util.*;
import java.util.stream.Collectors;

public class No0692 {

    public List<String> topKFrequent(String[] words, int k) {
        List<String> topKFrequentStrings = new ArrayList<>();

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String string = words[i];
            if (!hashMap.containsKey(words[i])) {
                hashMap.put(string, 1);
            } else {
                hashMap.put(string, hashMap.get(string) + 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(hashMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return -1;
                } else if (o1.getValue().equals(o2.getValue())) {
                    if (o1.getKey().compareTo(o2.getKey()) > 0) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
                return 1;
            }
        });

        for (int i = 0; i < k; i++) {
            topKFrequentStrings.add(list.get(i).getKey());
        }
        return topKFrequentStrings;
    }

    public List<String> topKFrequentStream(String[] words, int k) {
        List<String> topKFrequentStrings = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String string = words[i];
            if (!map.containsKey(words[i])) {
                map.put(string, 1);
            } else {
                map.put(string, map.get(string) + 1);
            }
        }

        Map<String, Integer> sortedMap = map.entrySet().stream()
                .sorted(Collections
                        .reverseOrder(
                                Map.Entry.<String, Integer>comparingByValue())
                        .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        int i = 0;
        for (Map.Entry entry : sortedMap.entrySet()) {
            if (i == k) {
                break;
            }
            topKFrequentStrings.add(entry.getKey().toString());
            i++;
        }

        return topKFrequentStrings;
    }
}
