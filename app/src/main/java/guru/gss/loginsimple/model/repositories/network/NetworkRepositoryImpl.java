package guru.gss.loginsimple.model.repositories.network;

import guru.gss.loginsimple.model.interactors.user.UserAuthorizationListener;
import guru.gss.loginsimple.utils.network.RetrofitClient;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;

/*
ENG: Repository for work with internet request
RU: Repository для работи с Интернет запросами
*/
public class NetworkRepositoryImpl implements NetworkRepository {

    @Override
    public void authorization(String email, String passwd, final UserAuthorizationListener listener) {
        String content = email + passwd;
        Call<String> call = RetrofitClient.getInstance().getApiClient().authorization("some headers", content);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                if (response.isSuccessful()) {
                    if (listener != null) {
                        listener.isAuthorizationSuccess(true);
                    }
                } else {
                    if (listener != null) {
                        listener.isAuthorizationSuccess(false);
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                if (listener != null){
                    listener.isAuthorizationSuccess(false);
                }
            }
        });
    }
}
