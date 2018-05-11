package e.harrison.dogtrain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button goodDog, whistle, switchButton;
    TextView sitCounter, trickSwitch;
    String counterUpdate, counterInit;
    int counterUpdated, counter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchButton = findViewById(R.id.trick_Change);
        goodDog = findViewById(R.id.goodDog_button);
        whistle = findViewById(R.id.whistle_button);
        sitCounter = findViewById(R.id.sitTracker_counter);
        goodDog.setOnClickListener(goodDogOnClickListener);
        whistle.setOnClickListener(whistleOnClickListener);
        trickSwitch = findViewById(R.id.sitTracker);
        switchButton.setOnClickListener(trickButton);



        sitCounter.setText("0");
    }

    public void switchTrick(){

        String currentTrick = trickSwitch.getText().toString();
        Intent intent = new Intent(MainActivity.this, TrainingLog.class);
        intent.putExtra("Trick", currentTrick);

        if (currentTrick.equals("Sit Tracker")){

            trickSwitch.setText("Lay Tracker");
            counter = 0;
            sitCounter.setText("0");

        }
        else if (currentTrick.equals("Lay Tracker")){

            trickSwitch.setText("Shake Tracker");
            counter = 0;
            sitCounter.setText("0");
        }

        else if (currentTrick.equals("Shake Tracker")){

            trickSwitch.setText("Sit Tracker");
            counter = 0;
            sitCounter.setText("0");
        }





    }

    View.OnClickListener trickButton = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switchTrick();
        }
    };




    public void TrackerUpdate() {


        counterUpdated = ++counter;
        counterUpdate = String.valueOf(counterUpdated);
        sitCounter.setText(counterUpdate);




    }


    View.OnClickListener goodDogOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TrackerUpdate();

        }

    };

    View.OnClickListener whistleOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            counterInit = String.valueOf(counter);


            Intent intent = new Intent(MainActivity.this, TrainingLog.class);

            if (counter == 0) {
                intent.putExtra("counted", counterInit);
            } else {
                intent.putExtra("counted", counterUpdate);
            }
            MainActivity.this.startActivity(intent);


        }


    };
}













