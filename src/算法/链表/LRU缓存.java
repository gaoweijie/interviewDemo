package 算法.链表;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU缓存 extends LinkedHashMap {

    private static final int MAX_ENTRIES = 100;

    public LRU缓存(int initialCapacity, float loadFactor) {
        // 第三个参数为accessOrder
        super(initialCapacity, loadFactor, true);
    }

    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRIES;
    }
}