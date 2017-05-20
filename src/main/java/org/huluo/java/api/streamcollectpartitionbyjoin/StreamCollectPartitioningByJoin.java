package org.huluo.java.api.streamcollectpartitionbyjoin;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectPartitioningByJoin {
    public static void main(String[] args) {
        streamPartitioningBy();
        collectorsJoining();
    }

    //stream api  collect收集器 partitioningBy demo
    private static void streamPartitioningBy() {
        // 分割数据块
        Map<Boolean, List<Integer>> collectParti = Stream.of(1, 2, 3, 4)
                .collect(Collectors.partitioningBy(it -> it % 2 == 0));
        System.out.println(collectParti);
        Map<Boolean, Integer> mapSize = new HashMap<>();
        collectParti.entrySet()
                .forEach(entry -> mapSize.put(entry.getKey(), entry.getValue().size()));
        System.out.println(mapSize);
    }
    //stream api  collect收集器 join  demo
    private static void collectorsJoining() {
        String strJoin = Stream.of("1", "2", "3", "4")
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println(strJoin);
    }

}
