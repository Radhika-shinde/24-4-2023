package exception;


class TaxCalculator{
	public static double calculateTax(String empName,boolean isIndian,double empSal)
	      throws CountryNotValidException,EmployeeNameInvalidException,TaxNotEligibleException{
		if(!isIndian) {
			throw new CountryNotValidException("the employe should be an indian citizen");
		}
		
		if(empName==null || empName.isEmpty()) {
			throw new EmployeeNameInvalidException("the employee should be indian citizen for calculating");
		}
		
		double taxAmount=0.0;
		if(empSal>100000 && isIndian) {
			taxAmount = empSal * 8/100;
			
		}else if(empSal>50000 && empSal<=100000 && isIndian) {
			taxAmount=empSal * 6/100;
			
		}else if (empSal>30000 && empSal<50000 && isIndian) {
			taxAmount=empSal * 5/100;
		}else if(empSal>10000 && empSal<30000 && isIndian) {
			taxAmount=empSal * 4/100;
		}else {
			throw new TaxNotEligibleException("the employee does not need to pay tax");
		}
		
		return taxAmount;
		
	}
	

}




public class CalculatorSimulator {

	public static void main(String[] args) {
		//test case 1:
		try {
			double taxAmount=TaxCalculator.calculateTax("Ron",false,34000);
			System.out.println("Tax amount is:"+taxAmount);
			
		}catch(CountryNotValidException e) {
			System.out.println("Country not valid:"+e.getMessage());
		}catch(EmployeeNameInvalidException e) {
			System.out.println("Employee name not vaid:"+e.getMessage());
			
		}catch(TaxNotEligibleException e) {
			System.out.println("Not eligible for tax Calculation:"+e.getMessage());
		}
		
		
		//test case 2:
		try {
			double taxAmount=TaxCalculator.calculateTax("Tim",true,1000);
			System.out.println("Tax amount is:"+taxAmount);
			
		}catch(CountryNotValidException e) {
			System.out.println("Country not valid:"+e.getMessage());
		}catch(EmployeeNameInvalidException e) {
			System.out.println("Employee name not vaid:"+e.getMessage());
			
		}catch(TaxNotEligibleException e) {
			System.out.println("Not eligible for tax Calculation:"+e.getMessage());
		}
		
		//test case 3:
		try {
			double taxAmount=TaxCalculator.calculateTax("Jack",true,55000);
			System.out.println("Tax amount is:"+taxAmount);
			
		}catch(CountryNotValidException e) {
			System.out.println("Country not valid:"+e.getMessage());
		}catch(EmployeeNameInvalidException e) {
			System.out.println("Employee name not vaid:"+e.getMessage());
			
		}catch(TaxNotEligibleException e) {
			System.out.println("Not eligible for tax Calculation:"+e.getMessage());
		}

	}

}
