package guru.gss.loginsimple.ui.utils;

import android.content.Context;
import android.view.View;
import android.widget.EditText;

/*
ENG: Interactor for work with Utils
RU: Interactor для работи с Utils
*/
public interface UiUtilsInteractor {

    interface ContentAnimator{
        void changeContent(boolean show, View mFormView, View mProgressView);
    }

    interface EmailPasswdValidation{
        boolean logIn(Context context, EditText mEmailView, EditText mPasswordView);
    }

    interface ToastUtils{
        void showToast(Context context, String message);
    }
}
