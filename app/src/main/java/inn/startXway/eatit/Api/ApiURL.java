package inn.startXway.eatit.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiURL {

  // public static final String BASE_URL="http://159.89.167.205/EatEat/";
   // public static final String IMG_URL="http://159.89.167.205/EatEat/uploads/";
   public static final String BASE_URL="http://10.0.2.2/EatEAT_Demo/EatEat";
  public static final String IMG_URL="http://10.0.2.2/EatEAT_Demo/EatEat/uploads/";



    public Retrofit getRetrofitObject() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
