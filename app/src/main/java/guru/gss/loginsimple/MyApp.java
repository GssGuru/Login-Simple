package guru.gss.loginsimple;

import android.app.Application;
import android.content.Context;

/*
ENG: Basic Application class
RU: Базовый Application class
*/
public class MyApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
