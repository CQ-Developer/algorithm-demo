package io.huhu.gokking.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GreedyAlgorithm {

    private GreedyAlgorithm() {}

    public static Set<String> cover() {
        // 州
        Set<String> remainingStates = new HashSet<>();
        remainingStates.add("mt");
        remainingStates.add("wa");
        remainingStates.add("or");
        remainingStates.add("id");
        remainingStates.add("nv");
        remainingStates.add("ut");
        remainingStates.add("ca");
        remainingStates.add("az");
        // 电台及覆盖的州
        Map<String, Set<String>> stations = new HashMap<>();
        stations.put("kone", Set.of("id", "nv", "ut"));
        stations.put("ktwo", Set.of("wa", "id", "mt"));
        stations.put("kthree", Set.of("or", "nv", "ca"));
        stations.put("kfour", Set.of("nv", "ut"));
        stations.put("kfive", Set.of("ca", "az"));
        // 贪婪算法，找出能覆盖最多州的电台组合
        Set<String> finalStations = new HashSet<>();
        while (!remainingStates.isEmpty()) {
            String bestStation = null;
            Set<String> coveredStates = new HashSet<>();
            for (String station : stations.keySet()) {
                Set<String> covered = new HashSet<>(remainingStates);
                covered.retainAll(stations.get(station));
                if (covered.size() > coveredStates.size()) {
                    bestStation = station;
                    coveredStates = covered;
                }
            }
            finalStations.add(bestStation);
            remainingStates.removeAll(coveredStates);

        }
        return finalStations;
    }

}
