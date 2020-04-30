/**
* Employee class to create and pass objects
* @ author Aravind
*/

public class Employee{

	//declare the default variables.
	String companyName;
	double wagePerHour;
	double fullTime;
	double partTime;

	public Employee(){
	//default constructor
	}

	public Employee(String companyName){
		this.companyName=companyName;
	}

	public Employee(String companyName,double wagePerHour){
		this.companyName=companyName;
		this.wagePerHour=wagePerHour;
	}
	
	public Employee(String companyName,double wagePerHour,double fullTime){
		this.companyName=companyName;
		this.wagePerHour=wagePerHour;
		this.fullTime=fullTime;
	}

	public Employee(String companyName,double wagePerHour,double fullTime,double partTime){                                                       
		this.companyName=companyName;
                this.wagePerHour=wagePerHour;
                this.fullTime=fullTime;
		this.partTime=partTime;
        }
}
