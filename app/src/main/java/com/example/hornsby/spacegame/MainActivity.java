package com.example.hornsby.spacegame;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    public ImageView spot;
    public Ship ship;

    private Button mRightButton;
    private Button mLeftButton;
    private LinearLayout mSpotBar;

    private ImageView mSpot1;
    private ImageView mSpot2;
    private ImageView mSpot3;
    private ImageView mSpot4;
    private ImageView mSpot5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ship = new Ship();

        mSpot1 = (ImageView) findViewById(R.id.spot_1);
        mSpot2 = (ImageView) findViewById(R.id.spot_2);
        mSpot3 = (ImageView) findViewById(R.id.spot_3);
        mSpot4 = (ImageView) findViewById(R.id.spot_4);
        mSpot5 = (ImageView) findViewById(R.id.spot_5);

        findSpot(ship.getHori()).setImageResource(R.drawable.ic_ship);

        mSpotBar = (LinearLayout) findViewById(R.id.spot_bar);
        mSpotBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = SettingsActivity.newIntent(MainActivity.this);
                startActivity(intent);
            }
        });

        mRightButton = (Button) findViewById(R.id.right_button);
        mRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ship.getHori() != 5) {
                    spot = findSpot(ship.getHori());
                    spot.setImageDrawable(null);
                    ship.setHori(ship.getHori() + 1);
                    spot = findSpot(ship.getHori());
                    spot.setImageResource(R.drawable.ic_ship);
                }
            }
        });

        mLeftButton = (Button) findViewById(R.id.left_button);
        mLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ship.getHori() != 1) {
                    spot = findSpot(ship.getHori());
                    spot.setImageDrawable(null);
                    ship.setHori(ship.getHori() - 1);
                    spot = findSpot(ship.getHori());
                    spot.setImageResource(R.drawable.ic_ship);
                }
            }
        });
    }

    private ImageView findSpot (int spot) {
        ImageView shipLocation = null;
        if (spot == 1) { shipLocation = mSpot1; }
        else if (spot == 2) { shipLocation = mSpot2; }
        else if (spot == 3) { shipLocation = mSpot3; }
        else if (spot == 4) { shipLocation = mSpot4; }
        else if (spot == 5) { shipLocation = mSpot5; }
        return shipLocation;
    }
}
