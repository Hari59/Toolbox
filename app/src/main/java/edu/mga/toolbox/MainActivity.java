package edu.mga.toolbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar c=Calendar.getInstance();
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        Spinner spinM1 = (Spinner) findViewById(R.id.startdateMM);
        Spinner spinD1 = (Spinner) findViewById(R.id.startdateDD);
        spinM1.setSelection(month);
        spinD1.setSelection(day-1);

        Spinner spinM2 = (Spinner) findViewById(R.id.returndateMM);
        Spinner spinD2 = (Spinner) findViewById(R.id.returndateDD);

        spinM2.setSelection(month);
        spinD2.setSelection(day);
    }

    int carCount = 0;
    int carType = 0;

    public void sendInfo(View v){
        Intent intent = new Intent(this, InfoActivity.class);
        int car = carType;

        intent.putExtra("car_type", carType);

        Spinner spinM2 = (Spinner) findViewById(R.id.returndateMM);
        Spinner spinD2 = (Spinner) findViewById(R.id.returndateDD);
        Spinner spinM1 = (Spinner) findViewById(R.id.startdateMM);
        Spinner spinD1 = (Spinner) findViewById(R.id.startdateDD);

       int days = (spinM2.getSelectedItemPosition() - spinM1.getSelectedItemPosition())*30 + (spinD2.getSelectedItemPosition() - spinD1.getSelectedItemPosition());
        intent.putExtra("days", days);

        startActivity(intent);

    }


    public void next(View v){
        ImageView imageView= (ImageView) findViewById(R.id.imageView2);

        if(carType == 1){
            imageView.setImageResource(R.drawable.suv2);
        }

        if(carType == 2){
            imageView.setImageResource(R.drawable.van2);
        }

        if(carType == 3){
            imageView.setImageResource(R.drawable.conv2);
        }

        if(carType == 4){
            imageView.setImageResource(R.drawable.truck2);
        }
    }

    public void previous(View v){
        ImageView imageView= (ImageView) findViewById(R.id.imageView2);

        if(carType == 1){
            imageView.setImageResource(R.drawable.suv1);
        }

        if(carType == 2){
            imageView.setImageResource(R.drawable.van1);
        }

        if(carType == 3){
            imageView.setImageResource(R.drawable.conv1);
        }

        if(carType == 4){
            imageView.setImageResource(R.drawable.truck1);
        }
    }



    public void suvChecked(View v){
        RadioButton suvbutton = (RadioButton) findViewById(R.id.suvRB);

        TextView costTV= (TextView) findViewById(R.id.cost);
        if(suvbutton.isChecked()){
            carType = 1;

            ImageView imageView= (ImageView) findViewById(R.id.imageView2);
            imageView.setImageResource(R.drawable.suv1);
            costTV.setText("$10 per Day");
        }
    }

    public void vanChecked(View v){
        RadioButton vanbutton = (RadioButton) findViewById(R.id.vanRB);
        TextView costTV = (TextView) findViewById(R.id.cost);
        if(vanbutton.isChecked()){
            carType = 2;

            ImageView imageView= (ImageView) findViewById(R.id.imageView2);
            imageView.setImageResource(R.drawable.van1);
            costTV.setText("$15 per Day");
        }
    }

    public void convChecked(View v){
        RadioButton convbutton = (RadioButton) findViewById(R.id.convertibleRB);
        TextView costTV = (TextView) findViewById(R.id.cost);
        if(convbutton.isChecked()){
            carType = 3;

            ImageView imageView= (ImageView) findViewById(R.id.imageView2);
            imageView.setImageResource(R.drawable.conv1);
            costTV.setText("$20 per Day");
        }
    }

    public void truckChecked(View v){
        RadioButton truckbutton = (RadioButton) findViewById(R.id.truckRB);
        TextView costTV = (TextView) findViewById(R.id.cost);
        if(truckbutton.isChecked()){
            carType = 4;

            ImageView imageView= (ImageView) findViewById(R.id.imageView2);
            imageView.setImageResource(R.drawable.truck1);
            costTV.setText("$25 per Day");
        }
    }

    public void switchClicked(View v){
        Switch simpleSwitch = (Switch) findViewById(R.id.switch1);
        Boolean switchState = simpleSwitch.isChecked();
        TextView taxTV = (TextView) findViewById(R.id.Tax);

        if(switchState){
            int amt = 0;
            if(carType == 1)
                amt = 10;
            if(carType == 2)
                amt = 15;
            if(carType == 3)
                amt = 20;
            if(carType == 4)
                amt = 15;
            taxTV.setText("Tax: $" + amt*.1);
        }
        if(!switchState){
            taxTV.setText(" ");
        }
    }

    public void setDate (View v){
        Calendar c=Calendar.getInstance();
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        Spinner spinM1 = (Spinner) findViewById(R.id.startdateMM);
        Spinner spinD1 = (Spinner) findViewById(R.id.startdateDD);
        spinM1.setSelection(month);
        spinD1.setSelection(day-1);

        Spinner spinM2 = (Spinner) findViewById(R.id.returndateMM);
        Spinner spinD2 = (Spinner) findViewById(R.id.returndateDD);

        spinM2.setSelection(month);
        spinD2.setSelection(day);
    }

}
