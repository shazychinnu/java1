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

		//Print if employee is present or absent
		if(presence==1){
			System.out.println("Employee is present");
		}
		else{
			System.out.println("Employee is absent");
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
}
