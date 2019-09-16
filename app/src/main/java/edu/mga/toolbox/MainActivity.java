package edu.mga.toolbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int carCount = 0;
    int carType = 0;

    public void sendInfo(View v){
        Intent intent = new Intent(this, InfoActivity.class);
        int car = carType;

        intent.putExtra("car_type", carType);
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

}
