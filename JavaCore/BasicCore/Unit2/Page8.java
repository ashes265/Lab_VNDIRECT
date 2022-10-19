import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static java.util.Calendar.DATE;
import java.util.Locale;
public class Page8{
	public static void main(String[] args) {
        DateFormat fm = new SimpleDateFormat("EEEEE, dd MMMMM yyyy");
        String message = MessageFormat.format("Hello{0}! Today is {1}.", args[0],
                fm.format(Calendar.getInstance().getTime()));
        System.out.println(message);
    }
}