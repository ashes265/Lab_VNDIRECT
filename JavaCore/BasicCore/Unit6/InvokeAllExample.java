import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public class InvokeAllExample {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newWorkStealingPool();
        List<CallableSample> callables = Arrays.asList(new CallableSample(), new CallableSample(),
                new CallableSample());
        Stream<Future<Integer>> stream = executor.invokeAll(callables).stream();
        Stream<Integer> resultStream = stream.map(future -> {
            try {
                return future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
                return 1;
            } catch (ExecutionException e) {
                e.printStackTrace();
                return 1;
            }
        });
        Integer[] results = resultStream.toArray(Integer[]::new);
        Arrays.stream(results).forEach(System.out::println);
    }
}
