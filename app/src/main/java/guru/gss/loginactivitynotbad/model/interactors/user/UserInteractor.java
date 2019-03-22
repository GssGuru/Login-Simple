package guru.gss.loginactivitynotbad.model.interactors.user;


import guru.gss.loginactivitynotbad.model.interactors.Interactor;
import guru.gss.loginactivitynotbad.model.repositories.network.NetworkRepository;
import guru.gss.loginactivitynotbad.model.repositories.preference.PreferenceRepository;
import guru.gss.loginactivitynotbad.model.repositories.preference.PreferenceRepositoryImpl;

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