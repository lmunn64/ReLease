package api;

/**
 * @author Luke Munn
 */
import static Utils.Const.base_url;

import model.MaintenanceRequest;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;
/**
 * Main API client factory class that sends
 * requests to http client with RetroFit2
 */
public class ApiClientFactory {

    static Retrofit apiClientSeed = null;

    static Retrofit GetApiClientSeed(){
        if(apiClientSeed == null){
            apiClientSeed = new Retrofit.Builder()

                    .baseUrl("http:coms-309-018.class.las.iastate.edu:8080/") //url here
                    //"http:coms-309-018.class.las.iastate.edu/"
                    //"https://ec6408a3-7640-4b64-ba19-7e5f98fb6c9d.mock.pstmn.io/"
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return apiClientSeed;
    }

    public static PostApi GetPostApi() {return GetApiClientSeed().create(PostApi.class);}
    public static BuildingApi GetBuildingApi(){return GetApiClientSeed().create(BuildingApi.class);}
    public static LandlordApi GetLandlordApi(){return GetApiClientSeed().create(LandlordApi.class);}
    public static TenantApi GetTenantApi(){return GetApiClientSeed().create(TenantApi.class);}
    public static RentApi GetRentApi(){return GetApiClientSeed().create(RentApi.class); }
    public static MaintenanceApi GetMaintenanceApi(){return GetApiClientSeed().create(MaintenanceApi.class); }
    public static UnitApi GetUnitApi(){return GetApiClientSeed().create(UnitApi.class);}

}
