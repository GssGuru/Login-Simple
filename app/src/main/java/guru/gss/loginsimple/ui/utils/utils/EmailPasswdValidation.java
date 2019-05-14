package guru.gss.loginsimple.ui.utils.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import guru.gss.loginsimple.R;
import guru.gss.loginsimple.ui.utils.UiUtilsInteractor;

/*
ENG: Utils for work with data validation
RU: Utils для работы с валидацией данных
*/
public class EmailPasswdValidation implements UiUtilsInteractor.EmailPasswdValidation {

    public boolean logIn(Context context, EditText mEmailView, EditText mPasswordView) {

        mEmailView.setError(null);
        mPasswordView.setError(null);

        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean isValid = true;
        View focusView = null;

        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(context.getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            isValid = false;
        }

        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(context.getString(R.string.error_field_required));
            focusView = mEmailView;
            isValid = false;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(context.getString(R.string.error_invalid_email));
            focusView = mEmailView;
            isValid = false;
        }

        if (focusView != null) {
            focusView.requestFocus();
        }

        return isValid;
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

}
