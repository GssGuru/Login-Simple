package guru.gss.loginactivitysimple.model.interactors.user;


import guru.gss.loginactivitysimple.model.interactors.Interactor;
import guru.gss.loginactivitysimple.model.repositories.network.NetworkRepository;
import guru.gss.loginactivitysimple.model.repositories.preference.PreferenceRepository;
import guru.gss.loginactivitysimple.model.repositories.preference.PreferenceRepositoryImpl;
import guru.gss.loginactivitysimple.utils.network.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserInteractor implements Interactor.InteractorUser {

    private NetworkRepository networkRepository;
    private PreferenceRepository preferenceRepository;

    public UserInteractor(NetworkRepository networkRepository, PreferenceRepository preferenceRepository) {
        this.networkRepository = networkRepository;
        this.preferenceRepository = preferenceRepository;
    }

    @Override
    public void authorization(String email, String passwd, final UserAuthorizationListener listener) {
        networkRepository.authorization(email, passwd, new UserAuthorizationListener() {
            @Override
            public void isAuthorizationSuccess(boolean isSuccess) {
                if(isSuccess){
                    preferenceRepository.setValue(PreferenceRepositoryImpl.IS_USER_EXIST, true);
                }
                listener.isAuthorizationSuccess(isSuccess);
            }
        });
    }

    @Override
    public boolean isUserExist() {
        if(preferenceRepository.isValueExist(PreferenceRepositoryImpl.IS_USER_EXIST)){
            return preferenceRepository.getValue().getBoolean(PreferenceRepositoryImpl.IS_USER_EXIST, false);
        } else {
            return false;
        }
    }
}