package utils.iamdilipkumar.com.scorekeeper.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created on 26/04/17.
 *
 * @author dilipkumar4813
 * @version 1.0
 */

public class TeamPreferences {

    public static final String PREF_TEAM_A = "team_a";
    public static final String PREF_TEAM_B = "team_b";

    public static void addChangePreferences(Context context, int count, String team) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(team, count);
        editor.apply();
    }

    public static void resetPreferences(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public static int getTeamScorePreference(Context context, String team) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getInt(team, 0);
    }
}
