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
 * Main API for Units with RetroFit2
 * Allows for posting a building object by a path
 * and getting a building by its unique id
 */
public interface UnitApi {

    @GET("Unit/all/{buildingId}")
    Call<List<Unit>>findByBuilding(@Path("buildingId") int id);

    @POST("Unit/post/{buildingId}/{unitNum}/{beds}/{baths}/{rentAmt}")
    Call<Unit>CreateUnit2(@Path("buildingId") int id,
                                @Path("unitNum") int unitNum,
                                @Path("beds") int beds,
                                @Path("baths") int baths,
                                @Path("rentAmt") int rent);

}
