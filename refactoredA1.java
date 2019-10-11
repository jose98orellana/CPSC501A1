/*
Name: Jose Orellana
UCID: 30022585
Course: CPSC 501
Tut: T01

REFACTORED
This is a hospital management program
*/

class Doctor {

	private String firstName;
	private String lastName;

	public void func1(String value) {
		firstName = value;
	}
	public void func2(String value) {
		lastName = value;
	}
}

class Specialist extends Doctor {

	private String type;
	private double erHours;
	private double surgeryHours;

	public String getLastName() {
		return lastName;
	}

	public double calculateWage(int daysWorked) {
		double erWage = erHours * 40
		double surgeryWage = surgeryHours * 50
		return erWage + surgeryWage;
	}

}

class Resident extends Doctor {

	private double erHours;
	private double surgeryHours;

	public String getLastName() {
		return lastName;
	}

	public double calculateWage(int daysWorked) {
		double erWage = erHours * 25
		double surgeryWage = surgeryHours * 30
		return erWage + surgeryWage;
	}
}

class Surgeon extends Specialist {

	public double getSurgeryCost() {
 		return calculateWage();
 	}
}

class Surgery {

	private String type;
	private int roomNumber;

 	public double getSurgeryCost() {
 		if (type.equalsTo("complicated")) {
 			return 2000;
 		} else if (type.equalsTo("simple")) {
 			return 500;
 		} else {
 			return 1000;
 		}
 	}
}

class Patient {

	private String firstName;
	private String lastName;

	public void func1(String value) {
		firstName = value;
	}
	public void func2(String value) {
		lastName = value;
	}
}

class Bill {

	public double calculateBill(Patient patient) {
		double surgeryFee = getSurgeryCost();
		double surgeonFee = getSurgeonCost();
		double roomFee = 500;
		double hospitalFee = 300;
		return surgeryFee + surgeonFee + roomFee + hospitalFee;
	}
}

public class Hospital {
	public static void main(String args[]) {
  		Surgeon s = new Surgeon();
  		Patient p = new Patient();
 	}
}
