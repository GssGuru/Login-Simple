package guru.gss.loginsimple.model.interactors;

import guru.gss.loginsimple.model.interactors.user.UserAuthorizationListener;

public interface Interactor {

    interface InteractorUser {

        void authorization(String email, String password, UserAuthorizationListener listener);

        boolean isUserExist();
    }
}
