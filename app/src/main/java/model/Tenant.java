package model;
/**
 * @author Luke Munn
 */

/**
 * Tenant user model class
 */
public class Tenant {

    private int id;
    private String nameF;
    private String nameL;
    private String email;
    private String password;
    private Building building;
    private int unit;
    private String address;

    /**
     * Tenant constructor
     * @param nameF
     * @param nameL
     * @param email
     * @param pass
     */
    public Tenant(String nameF, String nameL, String email, String pass){
        this.nameF = nameF;
        this.nameL = nameL;
        this.email = email;
        this.password = pass;
    }

    /**
     * Tenant constructor with id for unit as last param
     * @param nameF
     * @param nameL
     * @param email
     * @param pass
     * @param id
     */
    public Tenant(String nameF, String nameL, String email, String pass, int id){
        this.nameF = nameF;
        this.nameL = nameL;
        this.email = email;
        this.password = pass;
        this.id = id;
    }
    /**
     * Blank Tenant Constructor
     */
    public Tenant(){}

    /**
     * First name and Last name Tenant constructor
     * @param nameF
     * @param nameL
     */
    public Tenant(String nameF, String nameL){
        this.nameF = nameF;
        this.nameL = nameL;
    }
    public String getNameF() {
        return nameF;
    }

    public void setNameF(String nameF) {
        this.nameF = nameF;
    }

    public String getNameL() {
        return nameL;
    }

    public void setNameL(String nameL) {
        this.nameL = nameL;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public int getUnit() {
        return unit;
    }

    /**
     * set unit by it's id
     * @param unit
     */
    public void setUnit(int unit) {
        this.unit = unit;
    }

    /**
     * get id of tenant as given by database
     * @return id of tenant
     */
    public int getId() {
        return id;
    }
}
