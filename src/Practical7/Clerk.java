package Practical7;

public class Clerk extends Employee{
    private double overTimeRate;
    private int overTimeHours;
    
    public Clerk(int id, String name, double basic, double overTimeRate, int overTimeHours){
        super(id,name,basic);
        this.overTimeRate = overTimeRate;
        this.overTimeHours = overTimeHours;
    }
    
    public double getOverTimeRate(){
        return overTimeRate;
    }
    public double getOverTimeHours(){
        return overTimeRate;
    }
    public double computeOverTimePay(){
        return overTimeRate*overTimeHours;
    }
    public double computeMonthlyPay(){
        return computeOverTimePay() + super.getBasicSalary();
    }
    
    public String toString(){
        return super.toString()+"\nOvertime Pay : "+computeOverTimePay()+", Monthly Salary : "+computeMonthlyPay();
    }
}
