import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class Client {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 8000);
        Hello stub = (Hello) registry.lookup("Hello");
        System.out.println("Response: " + stub.say(args[0]));
    }
}
