package guru.gss.loginsimple.ui;

import android.content.Context;
import android.view.View;
import android.widget.EditText;

import com.arellomobile.mvp.MvpAppCompatActivity;

import guru.gss.loginsimple.ui.utils.UiUtilsInteractor;
import guru.gss.loginsimple.ui.utils.utils.ContentAnimator;
import guru.gss.loginsimple.ui.utils.utils.EmailPasswdValidation;

/*
ENG: Basic activity where we write all the functions that can be common to all activate
RU: Базовые activity куда пишем все функции, которые могут быть общими для всех активируют
*/
public class BaseActivity extends MvpAppCompatActivity {

    public boolean logIn(UiUtilsInteractor.EmailPasswdValidation interactor, Context context, EditText mEmailView, EditText mPasswordView) {
        return interactor.logIn(context, mEmailView, mPasswordView);
    }

    public void changeContent(UiUtilsInteractor.ContentAnimator interactor, boolean show, View mLoginFormView, View mProgressView) {
        interactor.changeContent(show, mLoginFormView, mProgressView);
    }

    public void showToast(UiUtilsInteractor.ToastUtils interactor, Context context, String message){
        interactor.showToast(context, message);
    }
}
