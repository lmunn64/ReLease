package model;
import java.util.ArrayList;
/**
 * @author Luke Munn
 */

/**
 * Landlord user model class
 */
public class Landlord {

    private int id;
    private String nameF;
    private String nameL;
    private String email;
    private String password;
    private ArrayList<Building> buildings;

    /**
     * Landlord constructor for a given name, last name, email and password
     * @param nameF
     * @param nameL
     * @param email
     * @param pass
     */
    public Landlord(String nameF, String nameL, String email, String pass){
        this.nameF = nameF;
        this.nameL = nameL;
        this.email = email;
        this.password = pass;
    }

    /**
     * Landlord constructor for a given name, last name, email, password and id
     * @param nameF
     * @param nameL
     * @param email
     * @param pass
     * @param id
     */
    public Landlord(String nameF, String nameL, String email, String pass, int id){
        this.nameF = nameF;
        this.nameL = nameL;
        this.email = email;
        this.password = pass;
        this.id = id;
    }

    /**
     * Empty Landlord constructor
     */
    public Landlord(){}
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

    public String getBuildings() {
        return buildings.toString();
    }

    public void setBuildings(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }

    /**
     * add building to a landlord building list
     * @param building
     */
    public void addBuildings(Building building){
        this.buildings.add(building);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
