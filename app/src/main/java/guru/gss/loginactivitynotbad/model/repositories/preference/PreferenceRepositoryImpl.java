package guru.gss.loginactivitynotbad.model.repositories.preference;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import guru.gss.loginactivitynotbad.MyApp;

public class PreferenceRepositoryImpl implements PreferenceRepository {

    public static final String IS_USER_EXIST = "is_user_exist";

    private final SharedPreferences mPref;

    public PreferenceRepositoryImpl() {
        mPref = PreferenceManager.getDefaultSharedPreferences(MyApp.getContext());
    }

    /**
     * Установить значение в SharedPreferences
     */
    @Override
    public void setValue(String key, Object value) {
        SharedPreferences.Editor editor = mPref.edit();
        if (value instanceof String) {
            String val = (String) value;
            editor.putString(key, val);
        }
        if (value instanceof Integer) {
            Integer val = (Integer) value;
            editor.putInt(key, val);
        }
        if (value instanceof Boolean) {
            Boolean val = (Boolean) value;
            editor.putBoolean(key, val);
        }
        editor.apply();
    }

    /**
     * Взять значение с SharedPreferences
     */
    @Override
    public SharedPreferences getValue() {
        return mPref;
    }

    /**
     * Удалить значение в SharedPreferences
     */
    @Override
    public void remove(String key){
        mPref.edit().remove(key).apply();
    }

    /**
     * Проверить сужествует ли значение в SharedPreferences
     */
    @Override
    public boolean isValueExist(String key){
        return mPref.contains(key);
    }
}
