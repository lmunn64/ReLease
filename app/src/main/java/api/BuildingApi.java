package api;

/**
 * @author Luke Munn
 */
import java.util.List;

import model.Building;
import model.Unit;
import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
/**
 * Main API interface for Buildings with RetroFit2
 * Allows for the posting of a single building and allows
 * for the retrieval of a building by its landlord
 */
public interface BuildingApi {

    @GET("building/all/{buildingId}")
    Call<List<Building>>findByLandlord(@Path("buildingId") int id);

    @GET("building/all")
    Call<List<Building>>getAllBuildings();

    @POST("building/post/{landlordId}/{address}/{NumOfUnits}")
    Call<Building> PostBuildingByPath(@Path("landlordId") int id,
                                     @Path("address") String address,
                                     @Path("NumOfUnits") int NumOfUnits
                                     );


    @POST("building/post")
    Call<Building> PostBuildingByBody(@Body Building newBuilding);

}
