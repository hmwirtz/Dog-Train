package e.harrison.dogtrain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button goodDog, whistle, switchButton;
    TextView sitCounter, trickSwitch;
    ArrayList<e.harrison.dogtrain.DogTrick> tricks = new ArrayList<>();
    int counter,trickIndex;
    e.harrison.dogtrain.DogTrick currentTrick;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize all of the button binding and listening etc..
        initializeViewElements();

        // initalize the tricks hashTable
        //should be put in it's own function later
        e.harrison.dogtrain.DogTrick sit = new e.harrison.dogtrain.DogTrick("Sit Tracker");
        e.harrison.dogtrain.DogTrick lay = new e.harrison.dogtrain.DogTrick("Lay Tracker");
        e.harrison.dogtrain.DogTrick shake = new e.harrison.dogtrain.DogTrick("Shake Tracker");

        tricks.add(sit);
        tricks.add(lay);
        tricks.add(shake);

        counter = 0;
        trickIndex = 0;
        currentTrick = tricks.get(trickIndex);

        sitCounter.setText(String.valueOf(counter));
    }


    private void initializeViewElements(){
        switchButton = findViewById(R.id.trick_Change);
        goodDog = findViewById(R.id.goodDog_button);
        whistle = findViewById(R.id.whistle_button);
        sitCounter = findViewById(R.id.sitTracker_counter);
        goodDog.setOnClickListener(goodDogOnClickListener);
        whistle.setOnClickListener(whistleOnClickListener);
        trickSwitch = findViewById(R.id.sitTracker);
        switchButton.setOnClickListener(trickButton);
    }
    public void switchTrick(){
        trickIndex++;
        if (tricks.size() - 1  < trickIndex ){
            trickIndex = 0;
        }
        currentTrick = tricks.get(trickIndex);
        Intent intent = new Intent(MainActivity.this, TrainingLog.class);
        intent.putExtra("Trick", currentTrick.getTrickname());



        trickSwitch.setText(currentTrick.getTrickname());
        counter = tricks.get(trickIndex).getTracker();
        sitCounter.setText( String.valueOf(counter));

    }
    View.OnClickListener trickButton = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switchTrick();
        }
    };

    public void TrackerUpdate() {

        this.counter++;
        tricks.get(trickIndex).setTracker(counter);
        sitCounter.setText(String.valueOf(counter));
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

            Intent intent = new Intent(MainActivity.this, TrainingLog.class);
            intent.putExtra("counted", Integer.toString(counter));

            MainActivity.this.startActivity(intent);
        }
    };
}