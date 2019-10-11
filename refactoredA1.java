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

	public double calculateWage(int daysWorked) {
		double subWage = calcSubWage(daysWorked);
		return subWage - calcTaxCalc(subWage);
	}

	public abstract double calcSubWage(int daysWorked);

	public abstract double calcTaxCalc(double subWage);
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

	public double calcSubWage(int daysWorked) {
		return daysWorked * ((erHours * 40) + (surgeryHours * 50));
	}

	public double calcTaxCalc(double subWage) {
		return subWage * 0.06;
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

	public double calcSubWage(int daysWorked) {
		return daysWorked * ((erHours * 25) + (surgeryHours * 30));
	}

	public double calcTaxCalc(double subWage) {
		return subWage * 0.06;
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
	public Surgeon surgeon;
	public Room room;

	public Surgery(Surgeon newSurgeon, String newType, int roomNumber) {
		this.surgeon = newSurgeon;
		this.type = newType;
		this.room = new Room(roomNumber); 
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

class Room {

	private int type;
	private int roomNumber;
	private boolean status;

	public Room(int newRoomNumber) {
		if (roomNumber < 301) {
			type = 1;
		} else if (roomNumber > 300 && roomNumber < 601) {
			type = 2;
		} else {
			type = 3;
		}
		this.roomNumber = newRoomNumber;
		this.status = TRUE;
	}

	public double getRoomCost() {
 		if (type == 1) {
 			return 500;
 		} else if (type == 2) {
 			return 750;
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
		double surgeonFee = patient.surgery.surgeon.getSurgeonCost();
		double roomFee = patient.surgery.room.getRoomCost();
		double hospitalFee = 300;
		return surgeryFee + surgeonFee + roomFee + hospitalFee;
	}
}

public class A1 {
	public static void main(String args[]) {
  		Surgeon s = new Surgeon("Jane", "Doe", "senior");
  		Surgery c = new Surgery(s, "complicated", 467);
  		Patient p = new Patient("John", "Smith", c);

  		System.out.println(p.getFirstName() + " " + p.getLastName() + " bill is $" + Bill.calculateBill(p));
 	}
}
