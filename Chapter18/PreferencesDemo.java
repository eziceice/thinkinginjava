package Chapter18;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * Created by Ryan on 2017/3/22.
 */
public class PreferencesDemo {
    public static void main(String[] args) throws BackingStoreException {
        Preferences preferences = Preferences.userNodeForPackage(PreferencesDemo.class);
        preferences.put("HI", "50");
        preferences.put("Good", "100");
        preferences.putInt("NI", 100);
        int count = preferences.getInt("Bad", 0);
        count++;
        preferences.putInt("Bad", count);

        for (String s : preferences.keys()) {
            System.out.println(s + ": " + preferences.get(s, null));
        }
    }
}
