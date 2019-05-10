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
        if (logIn(mEmailView, mPasswordView)) {
            presenter.autorization(mEmailView.getText().toString(), mPasswordView.getText().toString());
        }
    }

    @Override
    public void successAuthorization() {
        Toast.makeText(this, getResources().getString(R.string.login_success), Toast.LENGTH_LONG).show();
        showLoadingDialog(false, mLoginFormView, mProgressView);
    }

    @Override
    public void failedAuthorization() {
        Toast.makeText(this, getResources().getString(R.string.login_error), Toast.LENGTH_LONG).show();
        showLoadingDialog(false, mLoginFormView, mProgressView);
    }

    @Override
    public void showProgressDialog() {
        showLoadingDialog(true, mLoginFormView, mProgressView);
    }

    @Override
    public void hideProgressDialog() {
        showLoadingDialog(false, mLoginFormView, mProgressView);
    }
}
