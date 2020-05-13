package java基础.动态代理;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalDemo {

    static final ThreadLocal<Map<String, String>> threadLocalString = new ThreadLocal();

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a1");
        map.put("b", "b1");
        threadLocalString.set(map);

        String a = threadLocalString.get().get("a");
        System.out.println(a);
    }


}
