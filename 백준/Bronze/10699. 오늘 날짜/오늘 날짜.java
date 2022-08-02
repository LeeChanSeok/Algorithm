import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		Calendar c1 = Calendar.getInstance();
		String Today = sdf.format(c1.getTime());
		System.out.println(Today);
	}

}