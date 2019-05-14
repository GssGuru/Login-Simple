package guru.gss.loginsimple.model.repositories.preference;

import android.content.SharedPreferences;

/*
ENG: Repository for work with Preference
RU: Repository для работи с Preference
*/
public interface PreferenceRepository {

    /**
     * Установить значение в SharedPreferences
     */
    void setValue(String key, Object value);

    /**
     * Взять значение с SharedPreferences
     */
    SharedPreferences getValue();

    /**
     * Удалить значение в SharedPreferences
     */
    void remove(String key);

    /**
     * Проверить сужествует ли значение в SharedPreferences
     */
    boolean isValueExist(String key);

}
