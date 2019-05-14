package guru.gss.loginsimple.utils.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/*
ENG: Simple client Retrofit initialization
RU: Простая инициализация Retrofit клиента
*/
public class RetrofitClient {

    public static final String BASE_URL = "https://gss.guru/api/";
    private static final int RESPONSE_TIMEOUT = 120;
    private static RetrofitClient instance = null;
    private ApiClient apiClient;

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(initHttpClient())
                .build();
        apiClient = retrofit.create(ApiClient.class);
    }

    public static RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    private OkHttpClient initHttpClient() {

        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        okHttpBuilder
                .connectTimeout(RESPONSE_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(RESPONSE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(RESPONSE_TIMEOUT, TimeUnit.SECONDS);

        return okHttpBuilder.build();
    }

//    public static void recreateRetrofit() {
//        instance = null;
//    }

    public ApiClient getApiClient() {
        return apiClient;
    }
}
