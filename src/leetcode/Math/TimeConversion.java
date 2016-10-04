package leetcode.Math;

public class TimeConversion {
	public static void main(String[] args){
		System.out.println(addTime("10:00 PM", 120));
	}
	static String addTime(String time, int min){
		//"10:23 AM", 13  ==> "10:36 AM"
		String suffix = time.substring(6);
		int hh = Integer.parseInt(time.substring(0,2));
		int mm = Integer.parseInt(time.substring(3,5));

		mm = (mm + min) % 60;
		if (suffix.equals("PM"))
			hh = hh + 12;
		hh = ((mm + min)/60 + hh)%24;
		if (hh > 12) { 
			hh %= 12; 
			suffix = "PM";
		}
		else {
			suffix = "AM";
		}
		return String.format("%02d:%02d %s",hh,mm,suffix);
	}

	/*
	 * A single string containing a time in 12-hour clock format (i.e. hh:mm:ssAM or hh:mm:ssPM)
	 * Convert and print the given time in -hour format, where .
	 */
	static String convertTimeFormat(String time){
		String suffix = time.substring(8);
		int hh = Integer.parseInt(time.substring(0,2));
		int mm = Integer.parseInt(time.substring(3,5));
		int ss = Integer.parseInt(time.substring(6,8));

		if(suffix.equals("PM") && hh != 12){
			hh = hh + 12;                
		}
		else if(suffix.equals("AM") && hh == 12) {
			hh = 0;
		}

		return String.format("%02d:%02d:%02d",hh,mm,ss);
	}
}
