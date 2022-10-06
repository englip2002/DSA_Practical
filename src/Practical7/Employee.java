package Practical7;

//allow us to redefine .compareTo()
 
public abstract class Employee {
    ///CLASS ATTRIBUTES / CLASS FIELDS
    private int id;
    private String name;
    private double basicSalary;
    
    public int compareTo(Employee obj){
        return this.id - obj.id;//==0, >0, <0;
    }
    
    public Employee(int id, String name, double basic){
        this.id = id;
        this.name = name;
        this.basicSalary = basic;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setBasicSalary(double basic){
        this.basicSalary = basic;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getBasicSalary(){
        return basicSalary;
    }
    
    public String toString(){
        return "Name : "+name+", Staff ID : "+id+", Basic Salary : "+basicSalary;
    }
    
    abstract double computeMonthlyPay(); 
}