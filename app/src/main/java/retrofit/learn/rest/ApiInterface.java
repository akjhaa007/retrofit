package retrofit.learn.rest;

import com.google.gson.JsonArray;

import java.util.List;

import retrofit.learn.model.Box;
import retrofit.learn.model.Login;
import retrofit.learn.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {



    //@GET("/api/getfacelist")
   // Call<ResponseBody>secret(@Header("Authorization") String authToken);


    @GET("/api/getfacelist") //?gallery_name=TestCollection&limit=500")
    Call<List<Box>>secret(
            @Header("Authorization") String authToken,
            @Query("gallery_name") String gallery_name,
            @Query("limit") String limit);

    @POST("/api/auth/signin")
    Call<User>login(@Header("Authorization") String authHeader,
                    @Body Login login);


}