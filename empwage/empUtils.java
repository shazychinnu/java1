
/** 
* Emp utils class
* @ author Aravind
*/

public class empUtils{
	
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
		double wagePerHour=20;
		double fullDay=8;
		double empWage;

		empWage=wagePerHour*fullDay;
		return(empWage);
	}
	
	/**
        *calculate the parttime employee wage
        * @ return employee wage
        */	
	public double PtWageCalculation(){	
		double wagePerHour=20;
                double fullDay=4;
                double empWage;

                empWage=wagePerHour*fullDay;
                return(empWage);
        }

}
