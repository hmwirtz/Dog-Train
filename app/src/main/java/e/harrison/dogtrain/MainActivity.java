package e.harrison.dogtrain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button goodDog, whistle;
    TextView sitCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goodDog = findViewById(R.id.goodDog_button);
        whistle = findViewById(R.id.whistle_button);
        sitCounter = findViewById(R.id.sitTracker_counter);
        goodDog.setOnClickListener(goodDogOnClickListener);
        whistle.setOnClickListener(whistleOnClickListener);
    }

    public void sitTrackerUpdate() {
        int counter = Integer.parseInt(sitCounter.getText().toString());
        int counterUpdated = ++counter;

        String counterUpdate = String.valueOf(counterUpdated);

        sitCounter.setText(counterUpdate);

        Intent sendClickCount = new Intent();
        sendClickCount.putExtra(counterUpdate,counterUpdated);
    }

    View.OnClickListener goodDogOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            sitTrackerUpdate();

        }

    };

    View.OnClickListener whistleOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };


    }










