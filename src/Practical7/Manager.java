package Practical7;

public class Manager extends Employee{
    private double allowance;
    
    public Manager(int id, String name, double basic, double allowance){
        super(id,name,basic);
        this.allowance = allowance;      
    }
   
    public double computeMonthlyPay(){
        return allowance + super.getBasicSalary();
    }
    
    public String toString(){
        return super.toString()+"\nAllowance : "+allowance+", Monthly Salary : "+computeMonthlyPay();
    }
       
}


