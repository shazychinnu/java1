//import the required libraries.
import java.util.ArrayList;
/**
*Employee wage computation class
*@author Aravind
*/
public class EmployeeWage {
        /**
	*main method
	*@param args args
	*/
    //Constants
    public static final int IS_FULL_TIME=1;
    public static final int IS_PART_TIME=2;
    String company;
    int empRatePerHour;
    int numOfWorkingDays;
    int maxHoursPerMonth;

    //Constructor
    public EmployeeWage(String company,int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth)
    {
        this.company=company;
        this.empRatePerHour=empRatePerHour;
        this.numOfWorkingDays=numOfWorkingDays;
        this.maxHoursPerMonth=maxHoursPerMonth;
    }

    //Method to get the Working Hours Of Employee
    public int getWorkingHours(int empCheck)
    {
        int empHrs;
        switch (empCheck) {
            case IS_FULL_TIME:
                empHrs = 8;
                break;
            case IS_PART_TIME:
                empHrs = 4;
                break;
                 default:
                empHrs = 0;
                 
        }
        return empHrs;
         
    }
    //Calculating daily wage of employee
    public int calculateDailyWage(int empHours)
    {
        double wage=empHours*empRatePerHour;
        return (int) wage;
    }

    //Calculating employee wages for different company
    public int calculateEmployeeWageForCompany() {
        //Initializing variables
        int dayCount=0,totalEmpHrs=0;
        int empHours;
        int[] empDailyWage=new int[40];

        //Calculating Wages till a condition of total working hours or days is reached for a month
        while( totalEmpHrs <= maxHoursPerMonth && dayCount < numOfWorkingDays)
        {
            dayCount++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            empHours=getWorkingHours(empCheck);
            totalEmpHrs=totalEmpHrs+empHours;
            int wage=calculateDailyWage(empHours);

            //Storing daily wages
            empDailyWage[dayCount]=wage;
        }

        //returns employee wages for month
        return totalEmpHrs*empRatePerHour;
    }

    public static void main(String[] args) {
        //Displaying Welcome Message
        System.out.println("Welcome To Employee Wage Computation");

        //Declare ArrayList for different companies
        ArrayList<EmployeeWage> list=new ArrayList<EmployeeWage>();

        EmployeeWage dMart=new EmployeeWage("DMart",30,20,100);
        EmployeeWage reliance=new EmployeeWage("Reliance",40,30,150);

        list.add(dMart);
        list.add(reliance);

       System.out.println("Total Employee Wage For Company : " + dMart.company + " is : " + dMart.calculateEmployeeWageForCompany());
       System.out.println("Total Employee Wage For Company : " + reliance.company + " is : " + reliance.calculateEmployeeWageForCompany());
    }
}
