package guru.gss.loginactivitynotbad.ui.login;

import com.arellomobile.mvp.MvpView;

public interface LoginActivityView extends MvpView {

    void successAuthorization();
    void failedAuthorization();
    void showProgressDialog();
    void hideProgressDialog();
}
