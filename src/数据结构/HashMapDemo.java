package 数据结构;

public class HashMapDemo {

        static int a = 0, b = 0;

        public static void main(String[] args) throws InterruptedException {
            while (true) {
                int result = a();
                if (result != 2) {
                    System.out.println("a + b = " + result);
                    break;
                }
            }
        }

        public static int a() throws InterruptedException {
            Thread one = new Thread(new Runnable() {
                public void run() {
                    a = 1;
                }
            });

            Thread other = new Thread(new Runnable() {
                public void run() {
                    b = 1;
                }
            });
            one.start();
            other.start();
            one.join();
            other.join();
            return a + b;
        }
}
