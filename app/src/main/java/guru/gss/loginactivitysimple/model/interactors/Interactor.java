package guru.gss.loginactivitysimple.model.interactors;

import guru.gss.loginactivitysimple.model.interactors.user.UserAuthorizationListener;

public interface Interactor {

    interface InteractorUser {

        void authorization(String email, String password, UserAuthorizationListener listener);

        boolean isUserExist();
    }
}
