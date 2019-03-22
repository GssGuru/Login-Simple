package guru.gss.loginactivitynotbad.model.interactors;

import guru.gss.loginactivitynotbad.model.interactors.user.UserAuthorizationListener;

public interface Interactor {

    interface InteractorUser {

        void authorization(String email, String password, UserAuthorizationListener listener);

        boolean isUserExist();
    }
}
