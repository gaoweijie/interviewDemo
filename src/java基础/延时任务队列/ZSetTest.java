//package java基础.延时任务队列;
//
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//
//public class ZSetTest {
//
//    private JedisPool jedisPool = null;
//    // Redis服务器IP
//    private String ADDR = "10.23.22.42";
//    // Redis的端口号
//    private int PORT = 6379;
//
//    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//    public void initJedis() {
//        jedisPool = new JedisPool(ADDR, PORT);
//    }
//
//    public static void main(String[] args) {
//
//        ZSetTest zsetTest = new ZSetTest();
//        zsetTest.initJedis();
//
//        zsetTest.addItem();
//        zsetTest.getItem();
//
//        zsetTest.deleteZSet();
//    }
//
//    public void deleteZSet() {
//        Jedis jedis = jedisPool.getResource();
//        jedis.del("zset_test");
//    }
//
//    public void addItem() {
//        Jedis jedis = jedisPool.getResource();
//
//        Calendar cal1 = Calendar.getInstance();
//        cal1.add(Calendar.SECOND, 10);
//        int second10later = (int) (cal1.getTimeInMillis() / 1000);
//
//        Calendar cal2 = Calendar.getInstance();
//        cal2.add(Calendar.SECOND, 20);
//        int second20later = (int) (cal2.getTimeInMillis() / 1000);
//
//        Calendar cal3 = Calendar.getInstance();
//        cal3.add(Calendar.SECOND, 30);
//        int second30later = (int) (cal3.getTimeInMillis() / 1000);
//
//        Calendar cal4 = Calendar.getInstance();
//        cal4.add(Calendar.SECOND, 40);
//        int second40later = (int) (cal4.getTimeInMillis() / 1000);
//
//        Calendar cal5 = Calendar.getInstance();
//        cal5.add(Calendar.SECOND, 50);
//        int second50later = (int) (cal5.getTimeInMillis() / 1000);
//
//        jedis.zadd("zset_test", second50later, "e");
//        jedis.zadd("zset_test", second10later, "a");
//        jedis.zadd("zset_test", second30later, "c");
//        jedis.zadd("zset_test", second20later, "b");
//        jedis.zadd("zset_test", second40later, "d");
//
//        System.out.println(sdf.format(new Date()) + " add finished.");
//    }
//
//    public void getItem() {
//
//        Jedis jedis = jedisPool.getResource();
//
//        while (true) {
//            try {
//
//                Set<Tuple> set = jedis.zrangeWithScores("zset_test", 0, 0);
//
//                String value = ((Tuple) set.toArray()[0]).getElement();
//                int score = (int) ((Tuple) set.toArray()[0]).getScore();
//
//                Calendar cal = Calendar.getInstance();
//                int nowSecond = (int) (cal.getTimeInMillis() / 1000);
//
//                if (nowSecond >= score) {
//                    jedis.zrem("zset_test", value);
//                    System.out.println(sdf.format(new Date()) + " removed value:" + value);
//                }
//
//                if (jedis.zcard("zset_test") <= 0)
//                {
//                    System.out.println(sdf.format(new Date()) + " zset empty ");
//                    return;
//                }
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//    }
//
//}