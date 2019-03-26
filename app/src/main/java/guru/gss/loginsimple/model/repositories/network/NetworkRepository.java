package guru.gss.loginsimple.model.repositories.network;

import guru.gss.loginsimple.model.interactors.user.UserAuthorizationListener;

public interface NetworkRepository {

    void authorization(String email, String passwd, final UserAuthorizationListener listener);

}
