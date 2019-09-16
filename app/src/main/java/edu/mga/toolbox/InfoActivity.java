package edu.mga.toolbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    public static final int CARTYPE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();
        int carType = intent.getIntExtra("car_type", 0);
        int costperday = 0;
        TextView str = (TextView) findViewById(R.id.cost);

        if (carType == 1)
            costperday = 10;
        if (carType == 2)
            costperday = 15;
        if (carType == 3)
            costperday = 20;
        if (carType == 4)
            costperday = 25;

        str.setText("Cost Per Day:     $" + costperday);
    }
}
