package api;
/**
 * @author Luke Munn
 */

import java.util.ArrayList;
import java.util.List;

import model.Building;

import model.Tenant;
import model.Unit;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
/**
 * Main API interface for Tenants with RetroFit2
 * Allows for the posting of a single tenant by body
 * or path, and allows the app to get all tenants
 * or a tenant by its email and password
 */
public interface TenantApi {
    @GET("tenant/all")
    Call<List<Tenant>> GetAllTenants();

    @POST("tenant/post/{nameF}/{nameL}/{email}/{password}/{unit}")
    Call<Tenant> PostTenantByPath(@Path("nameF") String nameF,
                                      @Path("nameL") String nameL,
                                      @Path("email") String email,
                                      @Path("password") String password,
                                      @Path("unit") long unit);
    @POST("tenant")
    Call<Tenant> PostTenantByBody(@Body Tenant newTenant);

    @GET("tenant/login/{email}/{password}")
    Call<Tenant> Login(@Path("email") String email,
                        @Path("password") String password);
}
