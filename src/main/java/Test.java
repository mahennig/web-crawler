import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class Test {

    public static void main(String[] args) {
        DateTime date = DateTime.now();
        DateTimeFormatter fmt = ISODateTimeFormat.ordinalDateTime();
        System.out.println(date.toString(fmt));
        fmt = ISODateTimeFormat.dateTime().withZoneUTC();
        System.out.println(date.toString(fmt));

    }
}
