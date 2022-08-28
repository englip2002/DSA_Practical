/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practical2.CarPark;

/**
 *
 * @author taruc
 */
//concrete class for interface CarPark
public class CarParkImplementer implements CarPark {

    private int capacity;
    private int max;

    public void setCapacity(int C) {
        max = C;
        capacity = max;
    }

    public int getCapacity() {
        return capacity;
    }

    //ADT METHOD
    //method: carEnter
    //Objective: capacity - 1
    public void carEnter() {
        if (capacity > 0 && capacity <= 10) {//precondition
            capacity -= 1; //postcondition
        }

    }

    //method: carExit
    //Objective: capacity + 1
    public void carExit() {
        if (capacity < 10) { //precondition
            capacity += 1; //postcondition
        }
    }
}
