package utils.iamdilipkumar.com.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import utils.iamdilipkumar.com.scorekeeper.data.TeamPreferences;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_winning_team)
    TextView mWinningTeam;

    @BindView(R.id.tv_team_a)
    TextView mTeamA;

    @BindView(R.id.tv_team_b)
    TextView mTeamB;

    @OnClick(R.id.btn_a_one)
    void addAOnePoint() {
        mTeamAPoints++;
        updateTeamPoints(mTeamAPoints, TeamPreferences.PREF_TEAM_A);
    }

    @OnClick(R.id.btn_a_two)
    void addATwoPoints() {
        mTeamAPoints += 2;
        updateTeamPoints(mTeamAPoints, TeamPreferences.PREF_TEAM_A);
    }

    @OnClick(R.id.btn_a_three)
    void addAThreePoints() {
        mTeamAPoints += 3;
        updateTeamPoints(mTeamAPoints, TeamPreferences.PREF_TEAM_A);
    }

    @OnClick(R.id.btn_a_four)
    void addAFourPoints() {
        mTeamAPoints += 4;
        updateTeamPoints(mTeamAPoints, TeamPreferences.PREF_TEAM_A);
    }

    @OnClick(R.id.btn_b_one)
    void addBOnePoint() {
        mTeamBPoints++;
        updateTeamPoints(mTeamBPoints, TeamPreferences.PREF_TEAM_B);
    }

    @OnClick(R.id.btn_b_two)
    void addBTwoPoints() {
        mTeamBPoints += 2;
        updateTeamPoints(mTeamBPoints, TeamPreferences.PREF_TEAM_B);
    }

    @OnClick(R.id.btn_b_three)
    void addBThreePoints() {
        mTeamBPoints += 3;
        updateTeamPoints(mTeamBPoints, TeamPreferences.PREF_TEAM_B);
    }

    @OnClick(R.id.btn_b_four)
    void addBFourPoints() {
        mTeamBPoints += 4;
        updateTeamPoints(mTeamBPoints, TeamPreferences.PREF_TEAM_B);
    }

    private int mTeamAPoints, mTeamBPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mTeamAPoints = TeamPreferences.getTeamScorePreference(this, TeamPreferences.PREF_TEAM_A);
        if (mTeamAPoints != 0) {
            updateTeamPoints(mTeamAPoints, TeamPreferences.PREF_TEAM_A);
        }

        mTeamBPoints = TeamPreferences.getTeamScorePreference(this, TeamPreferences.PREF_TEAM_B);
        if (mTeamBPoints != 0) {
            updateTeamPoints(mTeamBPoints, TeamPreferences.PREF_TEAM_B);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_reset) {
            mTeamAPoints = 0;
            mTeamBPoints = 0;
            mWinningTeam.setText(getString(R.string.lets_get));
            TeamPreferences.resetPreferences(this);
            mTeamA.setText(getString(R.string.team_a));
            mTeamB.setText(getString(R.string.team_b));
        }

        return true;
    }

    /**
     * Method to update the points of the team
     *
     * @param points - Concatenation of previous points
     * @param team - The team for which the update has to be made
     */
    private void updateTeamPoints(int points, String team) {

        TeamPreferences.addChangePreferences(this, points, team);
        if (team.equals(TeamPreferences.PREF_TEAM_A)) {
            String displayPoints = getString(R.string.team_a) + " - " + points;
            mTeamA.setText(displayPoints);
        } else {
            String displayPoints = getString(R.string.team_b) + " - " + points;
            mTeamB.setText(displayPoints);
        }

        if(mTeamAPoints>mTeamBPoints){
            mWinningTeam.setText(getString(R.string.team_a_winning));
        }else if(mTeamBPoints>mTeamAPoints){
            mWinningTeam.setText(getString(R.string.team_b_winning));
        }else{
            mWinningTeam.setText(getString(R.string.team_tie));
        }
    }
}
