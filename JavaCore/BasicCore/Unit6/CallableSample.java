import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class CallableSample implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        AtomicInteger total = new AtomicInteger(10);

        IntStream.range(0, 10).forEach(number -> {
            System.out.println(Thread.currentThread().getName() + " Running " + total.addAndGet(number));
            Random rd = new Random();
            LongStream longStream = rd.longs(100, 1000);
            Long sleep = longStream.findFirst().getAsLong();
        });
        return total.get();
    }

    public static void main(String[] args) throws Exception {
        CallableSample call = new CallableSample();
        Integer call1 = call.call();
        System.out.println(call1);
    }

}
