import java.util.prefs.Preferences;
public class Page16{
	public static void main(String[] args){
    Preferences pre=Preferences.userNodeForPackage(Page16.class);
        System.out.println("Old value: "+pre.get("data1", "No Value"));
        pre.put("data1", "value"+System.currentTimeMillis());
        System.out.println("New value = "+pre.get("data1", "No Value"));
    }
}