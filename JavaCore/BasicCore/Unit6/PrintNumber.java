import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phung
 */
public class PrintNumber implements Runnable {

    private int number = 0;
    private Integer number1 = new Integer(1);
    private boolean alive = true;

    public int getNumber() {
        return number;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    // @Override
    // public void run() {
    // //TEST1
    //// Thread current=Thread.currentThread();
    //// while(alive){
    //// number++;
    //// System.out.println(current.getName()+" number is \""+number+"\"");
    //// try {
    //// Thread.sleep(800);
    //// } catch (InterruptedException ex) {
    //// ex.printStackTrace();
    //// }
    //// }
    //// System.out.println(current.getName()+" is stopped!");
    //
    // //TEST2
    //// Thread current=Thread.currentThread();
    //// while(number<10){
    //// number++;
    //// System.out.println(current.getName()+" number is \""+number+"\"");
    //// try {
    //// Thread.sleep(300);
    //// } catch (InterruptedException ex) {
    //// ex.printStackTrace();
    //// }
    //// }
    //// System.out.println(current.getName()+" is stopped!");
    // //TEST3
    //// Thread current = Thread.currentThread();
    //// while (number1 < 30) {
    //// number++;
    //// System.out.println(current.getName() + " number is \"" + number + "\"");
    //// try {
    //// Thread.sleep(300);
    //// } catch (InterruptedException ex) {
    //// ex.printStackTrace();
    //// }
    //// }
    //// System.out.println(current.getName() + " is stopped!");
    // }
    @Override
    public void run() {
        // TEST4
        // Thread current = Thread.currentThread();
        // while(number<30){
        // number++;
        // System.out.println(current.getName()+ " number is \""+number+"\"");
        // try {
        // Thread.sleep(300);
        // } catch (InterruptedException ex) {
        // Logger.getLogger(PrintNumber.class.getName()).log(Level.SEVERE, null, ex);
        // }
        // }
        // System.out.println(current.getName() + " is stopped!");

        // TEST5
        Thread current = Thread.currentThread();
        while (true) {
            number++;
            System.out.println(current.getName() + " number is \"" + number + "\"");
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(PrintNumber.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (number % 10 == 0)
                break;
        }
        System.out.println(current.getName() + " is stopped!");
    }

    public static void main(String[] args) throws InterruptedException {
        // PrintNumber number=new PrintNumber();
        // Thread thread = new Thread(number);
        // thread.setName("Hanoi_Thread");
        // thread.start();
        //
        // Thread.currentThread().join();
        // System.out.println("Main Thread say hello");
        // System.out.println("Main Thread say goodbye");

        // MODIFY
        // PrintNumber number=new PrintNumber();
        // Thread thread = new Thread(number);
        // thread.setName("Fsoft_Thread");
        // thread.setDaemon(true);
        // thread.start();
        //
        // Thread.currentThread().join();
        // System.out.println("Main Thread say hello");
        // System.out.println("Main Thread say goodbye");
        // MODIFY2
        PrintNumber number = new PrintNumber();
        Thread thread = new Thread(number);
        thread.setName("Fsoft_Thread1");
        thread.start();

        Thread thread2 = new Thread(number);
        thread2.setName("Fsoft_Thread2");
        thread2.start();

        // while(thread.isAlive()){
        // if(number.getNumber()%10==0){
        // number.setAlive(false);
        // Thread.sleep(1000);
        // }
        // }
        // thiet lap vo han
        // Thread.currentThread().join();
        // while(thread.isAlive()){
        // if(number.getNumber()%10==0){
        // number.setAlive(false);
        // TimeUnit.SECONDS.sleep(1);
        // }
        // }
    }
}