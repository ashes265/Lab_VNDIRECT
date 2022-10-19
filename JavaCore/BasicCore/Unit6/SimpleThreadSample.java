import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleThreadSample {
    public static void main(String[] args) {
        new Thread(() -> {
            Arrays.stream(args).forEach(ele -> {
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException ex) {
                    Logger.getLogger(SimpleThreadSample.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(ele);
            });
        }).start();
        ;

        // Callable<Object> value=Executors.callable(action)
        // new Thread(() -> {
        // x.stream().forEach(ele -> {
        // System.out.println(ele);
        // try {
        // Thread.sleep(1000);
        // } catch (InterruptedException ex) {
        // Logger.getLogger(SimpleThreadSample.class.getName()).log(Level.SEVERE, null,
        // ex);
        // }

        // });
        // });

        // for (int i = 0; i < args.length; i++) {
        // System.out.println("My " + args[i]);
        // }
    }
}