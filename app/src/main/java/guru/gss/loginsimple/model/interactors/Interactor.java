package guru.gss.loginsimple.model.interactors;

import guru.gss.loginsimple.model.interactors.user.UserAuthorizationListener;

/*
ENG: Interactor for all entities  in the application
RU: Интерактор для всех сущностей в приложении
*/
public interface Interactor {

    interface InteractorUser {

        void authorization(String email, String password, UserAuthorizationListener listener);

        boolean isUserExist();
    }
}
