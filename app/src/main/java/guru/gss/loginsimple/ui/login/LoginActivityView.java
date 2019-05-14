package guru.gss.loginsimple.ui.login;

import com.arellomobile.mvp.MvpView;

/*
ENG: interface to work with View from Presenter
RU: interface для работы с View из Presenter
*/
public interface LoginActivityView extends MvpView {

    void successAuthorization();
    void failedAuthorization();
    void showProgressDialog();
    void hideProgressDialog();
}
