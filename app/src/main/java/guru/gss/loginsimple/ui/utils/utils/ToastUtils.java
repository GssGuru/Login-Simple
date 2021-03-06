package guru.gss.loginsimple.ui.utils.utils;

import android.content.Context;
import android.widget.Toast;

import guru.gss.loginsimple.R;
import guru.gss.loginsimple.ui.utils.UiUtilsInteractor;

/*
ENG: Utils for working with pop-up messages(Toast)
RU: Utils для работы с всплывающими сообщениями
*/
public class ToastUtils implements UiUtilsInteractor.ToastUtils {

    public void showToast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
