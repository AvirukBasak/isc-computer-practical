/*
 * QUESTION:
 * 
 * If the 1st day of the year is given Find out the months which are having
 * Sunday as the Ist day of the month
 * 
 * Input : Year 2019
 * Ist January:- Tuesday
 * 
 * Output:
 * Months having Ist day as Sunday : September,December
 * 
 * 
 * Input: Year 2016
 * Ist January:- Friday
 * 
 * Output:
 * Months having Ist day as Sunday : May
 * 
 * Input:2017
 * Ist January :Sunday:
 * Months having Ist day as Sunday : October
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class FirstSunday {
	static int	year;
	static String nextDay( String today ) {
		// returns the next day of the week
		String[] days = { "Sunday", "Monaday", "Tuesday", "Wednessday", "Thursday", "Friday", "Saturday" };
		int index = 0;
		// searches for the day in the list
		for ( int i = 0; i < days.length; i++ ) {
			if ( days[ i ].equalsIgnoreCase( today ) ) {
				index = i;
				break;
			}
		}
		// Also returns Sunday if today is Saturday
		return days[ index + 1 == days.length ? 0 : index + 1 ];
	}
	static boolean isLeapYear( int year ) {
		return ( year % 4 == 0 & year % 100 != 0 | year % 400 == 0 );
	}
	static int getLastDate( int month ) {
		int[] lastDates = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		// if leap-year then 1 is added to last day value of month 2
		return lastDates[ month ] + ( ( month == 2 & isLeapYear( year ) ) ? 1 : 0 );
	}
	public static void main( String[] args ) throws IOException {
		int date = 1, month = 1, year;
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		// Taking inputs
		System.out.print( "Year: " );
		year = Integer.parseInt( br.readLine() );
		FirstSunday.year = year;
		System.out.print( "Gregorian New Year's Day: " );
		String day = br.readLine();
		// array to contain month names
		String[] months = { "", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
		System.out.print( "\nMonth(s) starting with Sunday: " );
		while ( month <= 12 ) {
			while ( date <= getLastDate( month ) ) {
				// If 1st day is a Sunday, it is printed
				if ( day.equalsIgnoreCase( "Sunday" ) & date == 1 ) {
					System.out.print( months[ month ] + " " );
				}
				/*
				 * Jumps by 28 days since the 28th day is same as
				 * 1st day of a month.
				 */
				else if ( date == 1 ) {
					date += 28;
					for ( int i = 1; i <= 28; i++ ) {
						day = nextDay( day );
					}
					continue;
				}
				day = nextDay( day );
				date++;
			}
			date = 1;
			month++;
		}
	}
}

/* OUTPUTS:
 * 
 * Year: 2019
 * English New Year's Day: Tuesday
 * 
 * Month(s) starting with Sunday: September December
 * 
 * Year: 2020
 * English New Year's Day: wednessday
 * 
 * Month(s) starting with Sunday: March November
 */
