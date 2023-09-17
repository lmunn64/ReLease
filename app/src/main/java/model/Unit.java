package model;
/**
 * @author Luke Munn
 */
import model.Building;
import model.Tenant;
/**
 * Unit model class
 */
public class Unit {

    private int id;
    private int unitNumber;
    private Building building;
    private String address;
    private int beds;
    private int baths;
    private int maxOccupancy; //how many people are permitted to live in unit, 2 for every bed.
    private double rent;

    private Tenant[] tenants;
    private int tenantNum; //keeps track of how many tenants are in tenant array

    /**
     * Unit constructor containing the following params:
     * @param building
     * @param unitNumber
     * @param beds
     * @param baths
     * @param rent
     */
    public Unit( Building building, int unitNumber, int beds, int baths, double rent) {
        this.unitNumber = unitNumber;
        this.building = building;
        this.beds = beds;
        this.baths = baths;
        this.rent = rent;
        maxOccupancy = beds * 2;
    }

    public int getId() {return id;}
    public void setId(int id){this.id = id;}

    public int getUnitNumber() {
        return unitNumber;
    }
    public void setUnitNumber(int a){
        unitNumber = a;
    }

    public double getRent(){return rent;}
    public void setRent(double rent){this.rent = rent;}

    public String getAddress(){return address;}
    public void setAddress(String addy){address = addy;}

    /**
     * Adds new tenant to a unit
     * @param nameF
     * @param nameL
     */
    public void addNewTenant(String nameF, String nameL){
        if(tenantNum < maxOccupancy){
            tenants[tenantNum] = new Tenant(nameF, nameL);
            tenantNum++;
        }
    }

}
