/** 
* Emp utils class
* @ author Aravind
*/

public class empUtils{

	//print the name of the company

	public void printName(){
		Employee tcs=new Employee("tcs",20.0,8.0,4.0); 
		System.out.println("Name of the company is "+ tcs.companyName);
	}

	 /**
        *check if the employee is present
        * @ return isPresent or not
        */
	
	public int isPresent(){
                int IS_PRESENT=1;
                double isPresentEmp=Math.floor(Math.random()*10)%2;
                if(isPresentEmp==IS_PRESENT){
                        return(1);
                }
                else{
                        return(0);
            	}
	}

	/**
	*Check if the employee works parttime or fulltime
	*@ return empWorks
	*/

	public int isFullTime(){

		int IS_FULLTIME=1;
		double isFulltime=Math.floor(Math.random()*10)%2;
		if(isFulltime==IS_FULLTIME){
			return(1);
		}
		else{
			return(0);
		}
	}


	/**
        *calculate the fulltime employee wage
        * @ return employee wage
        */

	public double FtWageCalculation(){

		Employee tcs=new Employee("tcs",20.0,8.0,4.0);
		double empWage;
		empWage=tcs.wagePerHour*tcs.fullTime;
		return(empWage);
	}
	
	/**
        *calculate the parttime employee wage
        * @ return employee wage
        */	
	public double PtWageCalculation(){
		Employee tcs=new Employee("tcs",20.0,8.0,4.0);	
		double empWage;
                empWage=tcs.wagePerHour*tcs.partTime;
                return(empWage);
        }

}

