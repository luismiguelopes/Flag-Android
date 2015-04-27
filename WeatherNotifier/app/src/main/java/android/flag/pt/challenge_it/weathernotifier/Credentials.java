package android.flag.pt.challenge_it.weathernotifier;

/**
 * Created by luismiguelopes on 27/04/15.
 */
public class Credentials {

    private String _username;
    private String _password;

    public Credentials(String username, String password) {

        _username = username;
        _password = password;
    }

    public String getUsername() {
        return _username;
    }

    public String getPassword() {
        return _password;
    }
}
