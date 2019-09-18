package edu.mga.toolbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;
import android.view.View;

public class InfoActivity extends AppCompatActivity {

    public static final int CARTYPE = 0;
    int costperday = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();
        int carType = intent.getIntExtra("car_type", 0);
        int daysRented = intent.getIntExtra("days",0);
        TextView str = (TextView) findViewById(R.id.cost);
        TextView rented = (TextView) findViewById(R.id.days);

        if (carType == 1)
            costperday = 10;
        if (carType == 2)
            costperday = 15;
        if (carType == 3)
            costperday = 20;
        if (carType == 4)
            costperday = 25;

        str.setText("Cost Per Day:   $" + costperday);
        rented.setText("Days Rented: " + daysRented);
    }

    public void checkDiscount(View v){
        CheckBox checkbox = (CheckBox) findViewById(R.id.checkBox);
        TextView discount = (TextView) findViewById(R.id.discountTV);
        if(checkbox.isChecked()){
           discount.setText("Discount   :-$5");
        }

        if(!checkbox.isChecked()){
            discount.setText("Discount:   :None" );
        }
    }

    public void calculateCost(View v){
        TextView finalCost = (TextView) findViewById(R.id.finalCost);
        Intent intent = getIntent();
        CheckBox checkbox = (CheckBox) findViewById(R.id.checkBox);


        int daysRented = intent.getIntExtra("days",0);

        double cost = ((costperday*daysRented)+(costperday*daysRented)*.1);
        cost = cost-5;
        if(checkbox.isChecked()){
            finalCost.setText("Final Coat: $"+cost);
        }

        if(!checkbox.isChecked()){
            finalCost.setText("Final Coat: $"+((costperday*daysRented)+(costperday*daysRented)*.1));
        }

    }
}
