package guru.gss.loginactivitynotbad.model.repositories.network;

import guru.gss.loginactivitynotbad.model.interactors.user.UserAuthorizationListener;
import guru.gss.loginactivitynotbad.utils.network.RetrofitClient;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;

public class NetworkRepositoryImpl implements NetworkRepository {

    @Override
    public void authorization(String email, String passwd, final UserAuthorizationListener listener) {
        String content = email + passwd;
        Call<Response> call = RetrofitClient.getInstance().getApiClient().authorization("some headers", content);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<okhttp3.Response> call, retrofit2.Response<Response> response) {
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
            public void onFailure(Call<okhttp3.Response> call, Throwable t) {
                if (listener != null){
                    listener.isAuthorizationSuccess(false);
                }
            }
        });
    }
}
