//ADT CARPARK
//USING INTERFACE TO CREATE THE TEMPLETE

package Practical2.CarPark;

/**
 *
 * @author taruc
 */
public interface CarPark {
    //MUTATOR METHOD
    public void setCapacity(int C);
    public int getCapacity();
    
    //ADT METHOD
    //method: carEnter
    //Objective: capacity - 1
    public void carEnter();
    public void carExit();
}
