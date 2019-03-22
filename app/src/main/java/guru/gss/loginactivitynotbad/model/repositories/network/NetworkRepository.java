package guru.gss.loginactivitynotbad.model.repositories.network;

import guru.gss.loginactivitynotbad.model.interactors.user.UserAuthorizationListener;

public interface NetworkRepository {

    void authorization(String email, String passwd, final UserAuthorizationListener listener);

}
