package utils.iamdilipkumar.com.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_team_a)
    TextView mTeamA;

    @BindView(R.id.tv_team_b)
    TextView mTeamB;

    @BindView(R.id.btn_a_one)
    Button mAOne;

    @BindView(R.id.btn_a_two)
    Button mATwo;

    @BindView(R.id.btn_a_three)
    Button mAThree;

    @BindView(R.id.btn_a_four)
    Button mAFour;

    @BindView(R.id.btn_b_one)
    Button mBOne;

    @BindView(R.id.btn_b_two)
    Button mBTwo;

    @BindView(R.id.btn_b_three)
    Button mBThree;

    @BindView(R.id.btn_b_four)
    Button mBFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
