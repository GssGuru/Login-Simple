package guru.gss.loginactivitysimple.ui.login;

import com.arellomobile.mvp.MvpView;

public interface LoginActivityView extends MvpView {

    void successAuthorization();
    void failedAuthorization();
    void showProgressDialog();
    void hideProgressDialog();
}
