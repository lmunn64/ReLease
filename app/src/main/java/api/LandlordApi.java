package api;
/**
 * @author Luke Munn
 */

import java.util.ArrayList;
import java.util.List;

import model.Building;
import model.Landlord;
import model.Unit;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
/**
 * Main API interface for Landlord with RetroFit2
 * Allows for the posting of a single Landlord by path or body
 * and allows for the retrieval of all landlord or a single one
 * by its email and password
 */
public interface LandlordApi {
    @GET("landlord/all")
    Call<List<Landlord>> GetAllLandlords();

    @POST("landlord/post/{nameF}/{nameL}/{email}/{password}")
    Call<Landlord> PostLandlordByPath(@Path("nameF") String nameF,
                                      @Path("nameL") String nameL,
                                      @Path("email") String email,
                                      @Path("password") String pass);
//                                      @Path("buildings") ArrayList<Building> buildings);
    @POST("landlord")
    Call<Landlord> PostLandlordByBody(@Body Landlord newLandlord);

    @GET("landlord/login/{email}/{password}")
    Call<Landlord> Login(@Path("email") String email,
                        @Path("password") String password);
}
