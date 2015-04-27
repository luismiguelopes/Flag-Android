package android.flag.pt.challenge_it.weathernotifier;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class WeatherApplication extends Application {

    private int xpto = 0;

    @Override
    public void onCreate() {


        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String username = prefs.getString(PreferencesActivity.USERNAME_KEY, null);
        String password = prefs.getString(PreferencesActivity.PASSWORD_KEY, null);
        
        _credentials = new Credentials(username, password);
        
        super.onCreate();
    }

}
