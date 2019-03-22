package guru.gss.loginactivitysimple.model.repositories.network;

import guru.gss.loginactivitysimple.model.interactors.user.UserAuthorizationListener;

public interface NetworkRepository {

    void authorization(String email, String passwd, final UserAuthorizationListener listener);

}
