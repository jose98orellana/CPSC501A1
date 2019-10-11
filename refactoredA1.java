/*
Name: Jose Orellana
UCID: 30022585
Course: CPSC 501
Tut: T01

REFACTORED
This is a hospital management program
*/

class Doctor {

	public String firstName;
	public String lastName;

	public Doctor(String first, String last) {
		this.firstName = first;
		this.lastName = last;
	}

	public void setFirstName(String value) {
		firstName = value;
	}
	public void setLastName(String value) {
		lastName = value;
	}

	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
}

class Specialist extends Doctor {

	public String type;
	public double erHours;
	public double surgeryHours;

	public Specialist(String first, String last, String newType){
		super(first, last);
		this.type = newType;
	}

	public void setType(String newType) {
		type = newType;
	}

	public String getType() {
		return type;
	}

	public void setERHours(double addHours) {
		erHours = erHours + addHours;
	}

	public void setSurgeryHours(double addHours) {
		surgeryHours = surgeryHours + addHours;
	}

	public double calculateWage(int daysWorked) {
		double erWage = erHours * 40;
		double surgeryWage = surgeryHours * 50;
		return erWage + surgeryWage;
	}

}

class Resident extends Doctor {

	public double erHours;
	public double surgeryHours;

	public Resident(String first, String last){
		super(first, last);
	}

	public void setERHours(double addHours) {
		erHours = erHours + addHours;
	}

	public void setSurgeryHours(double addHours) {
		surgeryHours = surgeryHours + addHours;
	}

	public double calculateWage(int daysWorked) {
		double erWage = erHours * 25;
		double surgeryWage = surgeryHours * 30;
		return erWage + surgeryWage;
	}
}

class Surgeon extends Specialist {

	public Surgeon(String first, String last, String type){
		super(first, last, type);
	}

	public double getSurgeonCost() {
 		if (type.equals("senior")) {
 			return 2000;
 		} else if (type.equals("rookie")) {
 			return 500;
 		} else {
 			return 1000;
 		}
 	}
}

class Surgery {

	public String type;
	public Surgeon s;
	public int roomNumber;

	public Surgery(Surgeon surgeon, String newType) {
		this.s = surgeon;
		this.type = newType;
	}

 	public double getSurgeryCost() {
 		if (type.equals("complicated")) {
 			return 2000;
 		} else if (type.equals("simple")) {
 			return 500;
 		} else {
 			return 1000;
 		}
 	}
}

class Patient {

	public String firstName;
	public String lastName;
	public Surgery surgery;

	public Patient(String first, String last, Surgery c) {
		this.firstName = first;
		this.lastName = last;
		this.surgery = c;
	}

	public void setFirstName(String value) {
		firstName = value;
	}
	public void setLastName(String value) {
		lastName = value;
	}

	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
}

class Bill {

	public static double calculateBill(Patient patient) {
		double surgeryFee = patient.surgery.getSurgeryCost();
		double surgeonFee = patient.surgery.s.getSurgeonCost();
		double roomFee = 500;
		double hospitalFee = 300;
		return surgeryFee + surgeonFee + roomFee + hospitalFee;
	}
}

public class A1 {
	public static void main(String args[]) {
  		Surgeon s = new Surgeon("Jane", "Doe", "senior");
  		Surgery c = new Surgery(s, "complicated");
  		Patient p = new Patient("John", "Smith", c);

  		System.out.println(p.getFirstName() + " " + p.getLastName() + " bill is $" + Bill.calculateBill(p));
 	}
}
