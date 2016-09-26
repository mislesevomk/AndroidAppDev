/*
Jacob Muzikoski
z1756867
Assignment 1
Basketball Calculator

Background Image:
https://image.winudf.com/39/2f0d59ece99d56/screen-1.jpg

This app allows the user to input the number of shots made in the form of two pointer's and
three pointer's. It also asks the user to input the amount of rebounds for a single game.
The user then hits submit and the the App displays the average shots made and average shots rebounded.
The app also displays the amount of attempted shots, total points, and shots made during that game.
 */

package mislesevomk.basketballaverageshotcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private PlayerShots playerShots;
    private EditText twosMadeET, threesMadeET,reboundET;
    private TextView madeAVGTV, reboundAVGTV, totalTV, totalPointsTV, totalShotsMadeTV;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Matches TextViews from activity_main.xml to variables declared in MainActivity.java
        playerShots = new PlayerShots();
        madeAVGTV = (TextView)findViewById(R.id.textViewMadeZeroLBL);
        reboundAVGTV = (TextView)findViewById(R.id.textViewReboundZeroLBL);
        totalTV = (TextView)findViewById(R.id.textViewTotalZeroLBL);
        totalPointsTV = (TextView)findViewById(R.id.textViewTotalPointsZeroLBL);
        totalShotsMadeTV = (TextView)findViewById(R.id.textViewTotalShotsMadeZeroLBL);

        // Two and Three Pointers editText that listens for user input
        twosMadeET = (EditText)findViewById(R.id.editTextTwosMade);
        twosMadeET.addTextChangedListener(twosMadeTextWatcher);
        threesMadeET = (EditText)findViewById(R.id.editTextThreesMade);
        threesMadeET.addTextChangedListener(threesMadeTextWatcher);

        // Rebound editText that listens for user input
        reboundET = (EditText)findViewById(R.id.editTextRebound);
        reboundET.addTextChangedListener(reboundTextWatcher);

        // Button that submits all the user input, performs calculations with that input, and then calls the display method to show results
        buttonSubmit = (Button)findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                displayPlayerShots();
            }
        });
    }

    private TextWatcher twosMadeTextWatcher = new TextWatcher()
    {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s)
        {
            // If the user tries to enter a null value, the value gets set to 0
            try
            {
                playerShots.setTwoPointersMade(Double.parseDouble(s.toString()));
            }
            catch (NumberFormatException e)
            {
                playerShots.setTwoPointersMade(0.0);
            }
        }
    };

    private TextWatcher threesMadeTextWatcher = new TextWatcher()
    {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {

        }

        @Override
        public void afterTextChanged(Editable s)
        {
            // If the user tries to enter a null value, the value gets set to 0
            try
            {
                playerShots.setThreePointersMade(Double.parseDouble(s.toString()));
            }
            catch (NumberFormatException e)
            {
                playerShots.setThreePointersMade(0.0);
            }
        }
    };

    private TextWatcher reboundTextWatcher = new TextWatcher()
    {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {

        }

        @Override
        public void afterTextChanged(Editable s)
        {
            // If the user tries to enter a null value, the value gets set to 0
            try
            {
                playerShots.setShotsRebound(Double.parseDouble(s.toString()));
            }
            catch(NumberFormatException e)
            {
                playerShots.setShotsRebound(0.0);
            }
        }
    };

    // Displays Averages, and Totals based on the users input
    private void displayPlayerShots()
    {
        madeAVGTV.setText(String.format("%.02f", (playerShots.getShotsMadeAVG() * 100 )) + "%");
        reboundAVGTV.setText(String.format("%.02f", (playerShots.getShotsReboundAVG() * 100 )) + "%");
        totalTV.setText(playerShots.getShotsTotal().toString());
        totalPointsTV.setText(playerShots.getPointsTotal().toString());
        totalShotsMadeTV.setText(playerShots.getShotsMadeTotal().toString());
    }
}
