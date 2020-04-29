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
 
