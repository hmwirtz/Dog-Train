package e.harrison.dogtrain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class TrainingLog extends AppCompatActivity {

    private ProgressBar progressBar;
    private String trackerUpdate;
    private TextView test;
    private Intent intent;
    private Button backButton, shakeButton, layButton, sitButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_log);

        progressBar = findViewById(R.id.progressBar);
        test = findViewById(R.id.test);
        intent = getIntent();
        backButton = findViewById(R.id.BACK_BUTTON);
        backButton.setOnClickListener(backToMainListener);
        shakeButton = findViewById(R.id.SHAKE_BUTTON);
        layButton = findViewById(R.id.LAY_BUTTON);
        sitButton = findViewById(R.id.SIT_BUTTON);

        shakeButton.setOnClickListener(shakeListener);
        layButton.setOnClickListener(layListener);
        sitButton.setOnClickListener(sitListener);




        setProgressBar();



    }

    View.OnClickListener backToMainListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent mainIntent = new Intent(TrainingLog.this,MainActivity.class);
            TrainingLog.this.startActivity(mainIntent);
        }
    };

    void setProgressBar() {


        Bundle bundle = intent.getExtras();
        trackerUpdate = bundle.getString("counted");
        int counter = Integer.parseInt(trackerUpdate);
        progressBar.setProgress(counter);
        progressBar.setMax(50);
        test.setText(trackerUpdate);




    }








    View.OnClickListener sitListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            intent = new Intent(TrainingLog.this, MainActivity.class);
            Bundle bundle = intent.getExtras();
            String sitCounter = bundle.getString("Trick");
            String sitCount = bundle.getString("counted");

            if (sitCounter.equals("Sit Tracker")) {

                int counter = Integer.parseInt(sitCount);

                test.setText(sitCount);

            }


        }

    };


        View.OnClickListener shakeListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = intent.getExtras();
                bundle.getString("currentTrick");


            }
        };

        View.OnClickListener layListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = intent.getExtras();
                bundle.getString("currentTrick");


            }
        };
    }





