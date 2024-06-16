import java.awt.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.border.EmptyBorder;
import java.time.LocalDate;
class Controller {
	public static int yrs=1;
	public static int mon=1;
	public static int dys=1;
	
	public static boolean validBirthday(int yr, int mo, int dt){
		int currentYear=LocalDate.now().getYear();
		int currentMonth=LocalDate.now().getMonthValue();
		int currentDay=LocalDate.now().getDayOfMonth();
			
			if(yr > currentYear || ((mo > 12) || (mo <= 0)) || ((dt > 30) || (dt <= 0))){
				return false;
			}else if(yr==currentYear){
				 if(mo>currentMonth){
					 return false;
				 }else if(mo==currentMonth){
					 if(dt>=currentDay){
						 return false;
					 }
				 }
			}
			 return true;
	}
	
	public static void ageCalculator(int yr, int mo, int dt){
		int days=0;
		int months=0;
		int years=0;
		int currentYear=LocalDate.now().getYear();
		int currentMonth=LocalDate.now().getMonthValue();
		int currentDay=LocalDate.now().getDayOfMonth();
		
		if(dt>currentDay){
			days=(currentDay+30)-dt;
			currentMonth-=1;
		}else{
			days=(LocalDate.now().getDayOfMonth())-dt;
		}
		if(mo>currentMonth){
			months=(currentMonth+12)-mo;
			currentYear-=1;
		}else{
			months=currentMonth-mo;
		}
		years=currentYear-yr;
		yrs=years;
		mon=months;
		dys=days;
		//return years+""+months+""+days;
	}
	
	public static void inform(){
		JOptionPane.showMessageDialog(null, 
			"Invalid BirthDay !",
			"Error",
			JOptionPane.ERROR_MESSAGE);
	}
}
