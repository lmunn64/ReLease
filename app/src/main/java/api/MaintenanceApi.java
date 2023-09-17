package api;
/**
 * @author Luke Munn
 */

import java.util.List;

import model.Building;
import model.MaintenanceRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
/**
 * Main API interface for Maintenance Requests with RetroFit2
 * Allows for the posting of Maintenance Requests by path,
 * and request a maintenance request object by all or by email of
 * tenant who posted it.
 */
public interface MaintenanceApi {
    @GET("maintenanceRequest/all")
    Call<List<MaintenanceRequest>> GetAllMaintenanceReqs();


    @GET("maintenanceRequest/all")
    Call<MaintenanceRequest> GetMaintenanceReqByEmail (@Body String email);


    @POST("maintenanceRequest/{id}/{message}")
    Call<MaintenanceRequest>  PostMaintenanceReq (@Path("id") int id,
                                                  @Path("message") String message);

    @DELETE("maintenanceRequest/")
    Call<MaintenanceRequest> deleteMaintenanceReq(@Body MaintenanceRequest maintenanceRequest);
}
