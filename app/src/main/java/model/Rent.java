package model;
/**
 * @author Luke Munn
 */
import java.time.LocalDate;
/**
 * Rent model class
 */
public class Rent {
    //unique rent id
    private int id;
    //boolean value to see if its paid
    private boolean paid;
    //total rent bill value
    private double bill;

    private LocalDate dueDate;

    /**
     * Rent constructor for given double cost/bill
     * @param bill
     */
    public Rent(double bill){
        this.bill = bill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }
}
