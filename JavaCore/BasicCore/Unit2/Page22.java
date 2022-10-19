import java.io.IOException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import static java.util.Calendar.DATE;
import java.util.Comparator;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.prefs.Preferences;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class Page22{
	public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        IntStream stream = IntStream.range(0, 10);
        stream.forEach(value -> {
            if (builder.length() > 0) {
                builder.append(',');
            }
            builder.append(value);
        });
        System.out.println("Text value = " + builder);
    }
}