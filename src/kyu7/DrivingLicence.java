package kyu7;

import java.util.Calendar;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.text.NumberFormat;

/**
 * Introduction
 * 
 * In the United Kingdom, the driving licence is the official document which
 * authorises its holder to operate various types of motor vehicle on highways
 * and some other roads to which the public have access. In England, Scotland
 * and Wales they are administered by the Driver and Vehicle Licensing Agency
 * (DVLA) and in Northern Ireland by the Driver & Vehicle Agency (DVA). A
 * driving licence is required in the UK by any person driving a vehicle on any
 * highway or other road defined in s.192 Road Traffic Act 1988[1] irrespective
 * of ownership of the land over which the road passes, thus including many
 * which allow the public to pass over private land; similar requirements apply
 * in Northern Ireland under the Road Traffic (Northern Ireland) Order 1981.
 * (Source Wikipedia)
 * 
 * Driving Task
 * 
 * The UK driving number is made up from the personal details of the driver. The
 * individual letters and digits can be code using the below information
 * 
 * Rules
 * 
 * 1–5: The first five characters of the surname (padded with 9s if less than 5
 * characters)
 * 
 * 6: The decade digit from the year of birth (e.g. for 1987 it would be 8)
 * 
 * 7–8: The month of birth (7th character incremented by 5 if driver is female
 * i.e. 51–62 instead of 01–12)
 * 
 * 9–10: The date within the month of birth
 * 
 * 11: The year digit from the year of birth (e.g. for 1987 it would be 7)
 * 
 * 12–13: The first two initials of the first name and middle name, padded with
 * a 9 if no middle name
 * 
 * 14: Arbitrary digit – usually 9, but decremented to differentiate drivers
 * with the first 13 characters in common. We will always use 9
 * 
 * 15–16: Two computer check digits. We will always use "AA"
 * 
 * Your task is to code a UK driving license number using an Array of data. The
 * Array will look like
 * 
 * data = {"John","James","Smith","01-Jan-2000","M"};
 * 
 * Where the elements are as follows
 * 
 * 0 = Forename 
 * 1 = Middle Name (if any) 
 * 2 = Surname 
 * 3 = Date of Birth (In the format Day Month Year, this could include the full Month name or just
 * shorthand ie September or Sep) 
 * 4 = M-Male or F-Female
 * 
 * You will need to output the full 16 digit driving license number.
 * 
 * Good luck and enjoy! Kata Series
 * 
 * If you enjoyed this, then please try one of my other Katas. Any feedback,
 * translations and grading of beta Katas are greatly appreciated. Thank you.
 * 
 * @author ASY
 *
 */

public class DrivingLicence {

	public static StringBuilder sb = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(driver(new String[] { "John", "James", "Smith", "01-Jan-2000", "M" }));
		System.out.println(driver(new String[] { "Johanna", "", "Gibbs", "13-Dec-1981", "F" }));
		System.out.println(driver(new String[] { "Andrew", "Robert", "Lee", "02-September-1981", "M" }));
	}

	public static String driver(String[] data) {
		sb = new StringBuilder();
		String firstName = data[0];
		String middleName = null;
		String surname = null;
		String birthDate = null;
		String sex = null;
		if (data.length == 5) {
			middleName = data[1];
			surname = data[2];
			birthDate = data[3];
			sex = data[4];
		} else {
			middleName = "";
			surname = data[1];
			birthDate = data[2];
			sex = data[3];
		}

		// make first 5 characters
		makeDriverSurname(surname);
		// make the decade digit from the year of birth
		// "01-Jan-2000"
		makeDriverBirthYear(birthDate, sex);
		// make driver initials letter
		makeDriverInitial(firstName, middleName);
		// append "9"
		makeArbitraryDigit();
		// append "AA"
		makeCheckDigits();
		return sb.toString();
	}

	private static void makeArbitraryDigit() {
		sb.append("9");
	}

	private static void makeCheckDigits() {
		sb.append("AA");
	}

	private static void makeDriverInitial(String firstName, String middleName) {
		sb.append(firstName.substring(0, 1));
		if (middleName == null || middleName.length() == 0) {
			sb.append("9");
		} else {
			sb.append(middleName.substring(0, 1));
		}
	}

	private static void makeDriverBirthYear(String birthDate, String sex) {
		// System.out.println(Locale.getDefault().getDisplayLanguage() + " " +
		// Locale.getDefault().getLanguage());
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy", Locale.US);
		Calendar c = sdf.getCalendar();
		try {
			c.setTime(sdf.parse(birthDate));
		} catch (Exception e) {
			e.printStackTrace();
		}
		int decade = (c.get(Calendar.YEAR) / 10) % 10;
		sb.append(decade);
		NumberFormat nfe = NumberFormat.getInstance();
		nfe.setMinimumIntegerDigits(2);
		if (sex.equals("M")) {
			String s = nfe.format(c.get(Calendar.MONTH) + 1);
			// ("%2d", c.get(Calendar.MONTH) + 1);
			sb.append(s);
		} else {
			sb.append(c.get(Calendar.MONTH) + 51);
		}
		sb.append(nfe.format(c.get(Calendar.DAY_OF_MONTH)));
		int year = c.get(Calendar.YEAR) % 10;
		sb.append(year);
	}

	private static void makeDriverSurname(String surname) {
		if (surname.length() < 5) {
			String s = "";
			int n = 5 - surname.length();
			for (int i = 0; i < n; i++) {
				s += "9";
			}
			sb.append(surname.toUpperCase()).append(s);
		} else {
			sb.append(surname.substring(0, 5).toUpperCase());
		}
	}

}
