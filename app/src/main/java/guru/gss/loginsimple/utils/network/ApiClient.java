package guru.gss.loginsimple.utils.network;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/*
ENG: Interface Api with methods for internet request
RU: Interface Api с методами для интернет запроса
*/
public interface ApiClient {

    @Headers({"Content-Type: application/json"})
    @POST("authorization")
    Call<String> authorization(@Header("Authorization") String contentRange, @Body String data);
}
