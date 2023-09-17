package api;
/**
 * @author Luke Munn
 */

import model.Rent;
import model.Unit;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
/**
 * Main API interface for Rent with RetroFit2.
 * Allows app to get the specified rent for a unit by id
 * and due date
 */
public interface RentApi {
    @GET("/rent/unit/{id}/getRentByMonth/{dateDue}")
    Call<Rent> GetRentByUnitAndTerm(@Path("id") int id,
                                    @Path("dateDue") int dueDate
    );
    @GET("/rent/unit/{id}/getRent")
    Call<Rent> GetRentByUnit(@Path("id") int id
    );

}
