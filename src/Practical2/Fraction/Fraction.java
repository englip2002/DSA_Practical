/*
ADT Specification
Title: Fraction
Description: To represent Fraction Value
Objective: To build fraction and manipulate using 
customize operation (add, minus, multiply, division)
*/
package Practical2.Fraction;

public interface Fraction {
    //mutator method
    public void setNumerator(String N);
    public void setDenominator(String D);
    
    public String getNumerator();
    public String getDenominator();
    
    //arithmetric operation
    public Fraction add(Fraction B);
    public Fraction minus(Fraction B);
    public Fraction multiply(Fraction B);
    public Fraction division(Fraction B);
}
