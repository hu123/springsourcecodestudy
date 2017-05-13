import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CopyOnWriteArrayListTest {
    private static final CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    static {
        copyOnWriteArrayList.add("aaa");
        copyOnWriteArrayList.add("bbb");
        copyOnWriteArrayList.add("ccc");
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //往集合中添加元素
        executorService.execute(() -> {
            for (int i = 0; i < 10; i++) {

                System.out.println("添加的线程");
                copyOnWriteArrayList.add(String.valueOf(i));
                System.out.println("=========================\n");
            }

        });
        //往集合中读取元素
        executorService.execute(() -> {

            for (int i = 0; i < 10; i++) {
                System.out.println("读取的线程");
                System.out.println(copyOnWriteArrayList);
                System.out.println("***********************\n");

            }
        });
        executorService.shutdown();
    }
}
