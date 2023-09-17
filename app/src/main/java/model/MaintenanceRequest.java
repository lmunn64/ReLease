package model;
/**
 * @author Luke Munn
 */
/**
 * Maintenance Request model class
 */
public class MaintenanceRequest {

    protected int id;
    public String message;
    public String status;
    public Tenant tenant;

    /**
     * Constructor for Maintenance request that takes a message, the status and
     * which tenant requested it
     * @param message
     * @param status
     * @param tenant
     */
    public MaintenanceRequest(String message, String status, Tenant tenant){
        this.message = message;
        this.status = status;
        this.tenant = tenant;
    }
    /**
     * Empty MaintenanceRequest constructor
     */
    public MaintenanceRequest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

}
