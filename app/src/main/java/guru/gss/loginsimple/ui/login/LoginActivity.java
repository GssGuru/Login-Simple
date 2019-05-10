package guru.gss.loginsimple.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import guru.gss.loginsimple.R;
import guru.gss.loginsimple.model.interactors.user.UserInteractor;
import guru.gss.loginsimple.model.repositories.network.NetworkRepositoryImpl;
import guru.gss.loginsimple.model.repositories.preference.PreferenceRepositoryImpl;
import guru.gss.loginsimple.ui.BaseActivity;
import guru.gss.loginsimple.ui.utils.utils.ContentAnimator;
import guru.gss.loginsimple.ui.utils.utils.EmailPasswdValidation;
import guru.gss.loginsimple.ui.utils.utils.ToastUtils;

public class LoginActivity extends BaseActivity implements LoginActivityView {

    @InjectPresenter
    LoginActivityPresenter presenter;

    @ProvidePresenter
    LoginActivityPresenter providePresenter() {
        return new LoginActivityPresenter(new UserInteractor(new NetworkRepositoryImpl(), new PreferenceRepositoryImpl(this)));
    }

    @BindView(R.id.email)
    EditText mEmailView;
    @BindView(R.id.password)
    EditText mPasswordView;
    @BindView(R.id.login_form)
    View mLoginFormView;
    @BindView(R.id.login_progress)
    View mProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.email_sign_in_button)
    void email_sign_in_button() {
        if (logIn(new EmailPasswdValidation(), this, mEmailView, mPasswordView)) {
            presenter.autorization(mEmailView.getText().toString(), mPasswordView.getText().toString());
        }
    }

    @Override
    public void successAuthorization() {
        showToast(new ToastUtils(), this,  getResources().getString(R.string.login_success));
        changeContent(new ContentAnimator(), false, mLoginFormView, mProgressView);
    }

    @Override
    public void failedAuthorization() {
        showToast(new ToastUtils(), this,  getResources().getString(R.string.login_error));
        changeContent(new ContentAnimator(), false, mLoginFormView, mProgressView);
    }

    @Override
    public void showProgressDialog() {
        changeContent(new ContentAnimator(), true, mLoginFormView, mProgressView);
    }

    @Override
    public void hideProgressDialog() {
        changeContent(new ContentAnimator(), false, mLoginFormView, mProgressView);
    }
}
