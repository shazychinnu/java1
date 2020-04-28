/**
*Employee wage computation class
*@author Aravind
*/

public class Empusercase{
	/**
	*main method
	*@param args args
	*/

	public static void main(String[] args){
		System.out.println("Welcome to the employee usecase problem");

		//Declare an empUtils object
		empUtils utils=new empUtils();
		int presence=utils.isPresent();
                int  fullTime=utils.isFullTime();
                 int days=1;
		//Check if the employee is present 
		switch(presence){
		case 1:
			//Check if the employee works fulltime or not
			switch(fullTime){
			case 1:
				//Display the wage calculated
				while(days<21){
					double totalWage=days*utils.FtWageCalculation();
					System.out.println("Employee wage for full time for day "+ days +" is "+ totalWage);
					days++;
				}
			break;
			case 0:
				//Display the wage calculated
                                while(days<21){
                                        double totalWage=days*utils.PtWageCalculation();
                                        System.out.println("Employee wage for part time for day "+ days +" is "+ totalWage);
                                        days++;
                                }
			break;
			}
		break;

		case 0:
			System.out.println("Employee is absent");
		break;
		}
	}
}

		
/** 
* Emp utils class
* @ author Aravind
*/
 class empUtils{
	
	/** 
	*check if the employee is present or not
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
        *calculate the employee wage
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
        */	
	public double PtWageCalculation(){	
		double wagePerHour=20;
                double fullDay=4;
                double empWage;

                empWage=wagePerHour*fullDay;
                return(empWage);
        }

}
