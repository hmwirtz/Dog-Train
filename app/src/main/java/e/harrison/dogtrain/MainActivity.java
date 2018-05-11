package e.harrison.dogtrain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.ArraySet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Enumeration;
import java.util.Hashtable;

public class MainActivity extends AppCompatActivity {

    Button goodDog, whistle, switchButton;
    TextView sitCounter, trickSwitch;
    Hashtable<String, Integer> tricks = new Hashtable<>();
    int counter;
    String currentTrick;
    String newTrick;
    Enumeration keys;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize all of the button binding and listening etc..
        initializeViewElements();

        // initalize the tricks hashTable
        //should be put in it's own function later
        tricks.put("Sit Tracker", 0);
        tricks.put("Lay Tracker", 0);
        tricks.put("Shake Tracker", 0);

        keys = this.tricks.keys();

        currentTrick = "Sit Tracker";
        counter = 0;
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

        currentTrick = trickSwitch.getText().toString();
        Intent intent = new Intent(MainActivity.this, TrainingLog.class);
        intent.putExtra("Trick", currentTrick);

        if (!keys.hasMoreElements()){
            keys = this.tricks.keys();
        }
        newTrick = String.valueOf(keys.nextElement());

        trickSwitch.setText(newTrick);
        counter = tricks.get(newTrick);
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
        tricks.put(currentTrick, counter);
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