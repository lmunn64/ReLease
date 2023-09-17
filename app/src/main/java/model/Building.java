package model;
/**
 * @author Luke Munn
 */
/**
 * Building model class
 */
public class Building {

    private int id;
    private String address;
    private int numberOfUnits;
    private Unit[] units;
    private int unitCount; //keeps track of how many units are in unit array

    /**
     * Constructor creates building with empty unit array and
     * address
     * @param address
     * @param numberOfUnits
     */
    public Building(String address, int numberOfUnits){
        this.address = address;
        this.numberOfUnits = numberOfUnits;
        units = new Unit[numberOfUnits];
    }

    /**
     * Constructor creates building with set unit array
     * and address
     * @param address
     * @param numberOfUnits
     * @param u
     */
    public Building(String address, int numberOfUnits, Unit [] u){
        this.address = address;
        this.numberOfUnits = numberOfUnits;
        setUnitArray(u);
    }

    public int getId() {return id;}
    public void setId(int id){this.id = id;}

    public String getAddress(){return address;}
    public void setAddress(String addy){address = addy;}

    public void setUnitArray(Unit [] a){
        for(int i = 0; i <units.length; i++){
            units[i] = a[i];
        }
    }

    /**
     * print whole unit array for given building
     * @return units
     */
    public String printUnitArray(){
        String out = "";
        for(int i = 0; i < units.length; i++){
            out = out + units[i].getUnitNumber() + ", ";
        }

        return out;
    }

    public int getNumberOfUnits(){
        return numberOfUnits;
    }

    public Unit[] getUnitArray(){
        return units;

    }

    /**
     * Creates a Unit and adds it to an array
     * @param unitNumber
     * @param beds
     * @param baths
     * @param rent
     */
    public void addNewUnit(int unitNumber, int beds, int baths, int rent){
        if(unitCount < numberOfUnits) {
            units[unitCount] = new Unit(this, unitNumber, beds, baths, rent);
            unitCount++;
        }//add exception
    }

    /**
     * adds and existing unit to the unit array
     * @param unit
     */
    public void addExistingUnit(Unit unit){
        if(unitCount < numberOfUnits) {
            units[unitCount] = unit;
            unitCount++;
        }//add exception
    }
}
