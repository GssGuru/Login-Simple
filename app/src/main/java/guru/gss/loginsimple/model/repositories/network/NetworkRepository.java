package guru.gss.loginsimple.model.repositories.network;

import guru.gss.loginsimple.model.interactors.user.UserAuthorizationListener;

/*
ENG: Repository for work with internet request
RU: Repository для работи с Интернет запросами
*/
public interface NetworkRepository {

    void authorization(String email, String passwd, final UserAuthorizationListener listener);

}
