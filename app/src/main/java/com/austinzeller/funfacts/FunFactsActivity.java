package com.austinzeller.funfacts;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class FunFactsActivity extends Activity {

    public static final String TAG = FunFactsActivity.class.getSimpleName();

    private FactBook mFactbook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // Declare our View variables and assign Views from layout
        final TextView factLabel = (TextView) findViewById(R.id.factTextView);
        final Button factButton = (Button) findViewById(R.id.factButton);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fact = mFactbook.getFact();

                factLabel.setText(fact);

                int color = mColorWheel.getColor();
                relativeLayout.setBackgroundColor(color);
                factButton.setTextColor(color);

            }
        };

        factButton.setOnClickListener(listener);

        //Toast.makeText(this, "Activity was created!", Toast.LENGTH_LONG).show();

        Log.d(TAG, "We're logging from onCreate() method");


    }
}
