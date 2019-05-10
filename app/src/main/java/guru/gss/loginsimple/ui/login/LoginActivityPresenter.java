package guru.gss.loginsimple.ui.login;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import guru.gss.loginsimple.model.interactors.Interactor;
import guru.gss.loginsimple.model.interactors.user.UserAuthorizationListener;

@InjectViewState
public class LoginActivityPresenter extends MvpPresenter<LoginActivityView> {

    private Interactor.InteractorUser interactorUser;

    public LoginActivityPresenter(Interactor.InteractorUser interactorUser) {
        this.interactorUser = interactorUser;
    }

    public void autorization(String email, String password) {
        getViewState().showProgressDialog();
        interactorUser.authorization(email, password, new UserAuthorizationListener() {
            @Override
            public void isAuthorizationSuccess(boolean isSuccess) {
                if (isSuccess) {
                    getViewState().successAuthorization();
                } else {
                    getViewState().failedAuthorization();
                }
                getViewState().hideProgressDialog();
            }
        });

    }

}
