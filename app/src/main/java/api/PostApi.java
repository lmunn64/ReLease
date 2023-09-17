package api;

import model.Post;
import retrofit2.Call;

import retrofit2.http.GET;

public interface PostApi {

    @GET("post/1")
    Call<Post>getFirstPost();

}
