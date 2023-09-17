package api;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SlimCallback<T> implements Callback<T> {

    LambdaInterface<T> lamdaInterface;

    String logTag;

    public SlimCallback(LambdaInterface<T> lamdaInterface){
        this.lamdaInterface = lamdaInterface;
    }

    public SlimCallback(LambdaInterface<T> lamdaInterface, String customTag){
        this.lamdaInterface = lamdaInterface;
        this.logTag = customTag;
    }


    @Override
    public void onResponse(Call<T> call, Response<T> response) {

       if( response.isSuccessful()){
           lamdaInterface.doSomthing(response.body());
       }else{
           Log.d(logTag, "code:  "+response.code() + "  Msg:  "+response );
       }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        Log.d(logTag, "Thrown:  "+t.getMessage());
    }
}
