//import the required libraries.
import java.util.ArrayList;
import java.util.HashMap;
/**
*Employee wage computation class
*@author Aravind
*/

class EmployeeWageBuilder {
      /**
	*main method
	*@param args args
	*/
    //Constants
    public static final int IS_FULL_TIME=1;
    public static final int IS_PART_TIME=2;

    //variables
    public String company;
    public int empRatePerHour;
    public int numOfWorkingDays;
    public int maxHoursPerMonth;
    public int dayCount=0, totalEmpHrs=0,empHours;

    //For Storing tha daily wage of Employee
    HashMap<Integer,Integer> empDailyWage=new HashMap<Integer, Integer>();

    //For Storing the Total Wage Of Employee
    HashMap<String,Integer>totalWages=new HashMap<String, Integer>();

    //Constructor
    public EmployeeWageBuilder(String company,int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth)
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
        double dailyWage=empHours*empRatePerHour;
        return (int) dailyWage;
    }

    //Calculating employee wages and total wages for different company
    public void calculateEmployeeWageForCompany() {
        System.out.println("Employee Details of "+company);

        //Calculating Wages till a condition of total working hours or days is reached for a month
        while( totalEmpHrs <= maxHoursPerMonth && dayCount < numOfWorkingDays)
        {
            dayCount++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            empHours=getWorkingHours(empCheck);
            totalEmpHrs=totalEmpHrs+empHours;
            int dailyWage=calculateDailyWage(empHours);
            empDailyWage.put(dayCount,dailyWage);
        }

        //calculating employee wages for month
        int monthSalary=totalEmpHrs*empRatePerHour;
        totalWages.put(company,monthSalary);

        printDailyWage();
        companyTotalWage(company);
    }

    //Displaying daily employee wage
    public void printDailyWage() {
        System.out.println("Employee's Daily Wage Of : "+company);
        for (int i:empDailyWage.keySet()) {
            System.out.println("Day "+i+" : "+empDailyWage.get(i));
        }
    }

    //Displaying Total wage of company
    public void companyTotalWage(String company) {
        if(totalWages.get(company)!=null)
            System.out.println("Total wage of "+company+" "+totalWages.get(company));
    }
}

public class EmployeeWage {

    ArrayList<EmployeeWageBuilder> empDetails=new ArrayList<EmployeeWageBuilder>();

    public void empWageDetails(String company,int empRatePerHour,int numOfWorkingDays,int maxHoursPerMonth) {
        empDetails.add(new EmployeeWageBuilder(company,empRatePerHour,numOfWorkingDays,maxHoursPerMonth));
        EmployeeWageBuilder employeeWageBuilder=empDetails.get(empDetails.size()-1);
        employeeWageBuilder.calculateEmployeeWageForCompany();
    }

    public static void main(String[] args) {
        //Displaying Welcome Message
        System.out.println("Welcome To Employee Wage Computation");
        EmployeeWage employeeWage=new EmployeeWage();
        employeeWage.empWageDetails("DMart",30,20,100);
        employeeWage.empWageDetails("Reliance",40,30,150);
    }
}
