package guru.gss.loginsimple.ui.utils;

import android.content.Context;
import android.view.View;
import android.widget.EditText;

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
