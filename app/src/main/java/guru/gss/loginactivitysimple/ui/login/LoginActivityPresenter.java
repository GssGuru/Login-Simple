package guru.gss.loginactivitysimple.ui.login;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import guru.gss.loginactivitysimple.model.interactors.Interactor;
import guru.gss.loginactivitysimple.model.interactors.user.UserAuthorizationListener;

@InjectViewState
public class LoginActivityPresenter extends MvpPresenter<LoginActivityView> {

    private Interactor.InteractorUser interactorUser;

    public LoginActivityPresenter(Interactor.InteractorUser interactorUser) {
        this.interactorUser = interactorUser;
    }

    public void autorization(String email, String password){
       interactorUser.authorization(email, password, new UserAuthorizationListener() {

           @Override
           public void isAuthorizationSuccess(boolean isSuccess) {
               if (isSuccess){
                   getViewState().successAuthorization();
               } else {
                   getViewState().failedAuthorization();
               }
           }
       });

    }

}
