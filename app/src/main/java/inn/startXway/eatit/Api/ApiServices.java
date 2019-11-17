package inn.startXway.eatit.Api;

import java.util.List;

import inn.startXway.eatit.models.ResponseModel;
import inn.startXway.eatit.models.UserResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServices {

    @FormUrlEncoded
    @POST("registerInda")
    Call<ResponseModel> register(@Field("name") String name, @Field("pass") String pass, @Field("phone") String phone);

    @FormUrlEncoded
    @POST("loginAndro")
    Call<List<UserResponse>>login(@Field("pass") String pass, @Field("phone") String phone);


    @GET("userData")
    Call<List<UserResponse>> userData();

    @GET("basicPackGet")
    Call<List<UserResponse>> basicPackGet();

    @FormUrlEncoded
    @POST("placeOrder")
    Call<List<UserResponse>> placeOrder(@Field("mealId") String mealId,@Field("userId") String userId);



}
