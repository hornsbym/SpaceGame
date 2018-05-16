package com.example.hornsby.spacegame;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    public ImageView mSpot;
    public Ship mShip;

    private Button mRightButton;
    private Button mLeftButton;
    private LinearLayout mSpotBar;
    private LinearLayout mRunwayBar;
    private ImageView mAsteroid;

    private ImageView mSpot1;
    private ImageView mSpot2;
    private ImageView mSpot3;
    private ImageView mSpot4;
    private ImageView mSpot5;

    private RelativeLayout mRunway1;
    private RelativeLayout mRunway2;
    private RelativeLayout mRunway3;
    private RelativeLayout mRunway4;
    private RelativeLayout mRunway5;

    private BitmapDrawable mBitmapDrawable1;
    private Bitmap mBitmap1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShip = new Ship();

        mAsteroid = (ImageView) findViewById(R.id.asteroid);

        mSpot1 = (ImageView) findViewById(R.id.spot_1);
        mSpot2 = (ImageView) findViewById(R.id.spot_2);
        mSpot3 = (ImageView) findViewById(R.id.spot_3);
        mSpot4 = (ImageView) findViewById(R.id.spot_4);
        mSpot5 = (ImageView) findViewById(R.id.spot_5);

        mRunway1 = (RelativeLayout) findViewById(R.id.runway_1);
        mRunway2 = (RelativeLayout) findViewById(R.id.runway_2);
        mRunway3 = (RelativeLayout) findViewById(R.id.runway_3);
        mRunway4 = (RelativeLayout) findViewById(R.id.runway_4);
        mRunway5 = (RelativeLayout) findViewById(R.id.runway_5);

        findSpot(mShip.getHori()).setImageResource(R.drawable.ic_ship);

        mSpotBar = (LinearLayout) findViewById(R.id.spot_bar);
        mSpotBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = SettingsActivity.newIntent(MainActivity.this);
                startActivity(intent);
            }
        });

        mBitmap1.createBitmap(mRunway1.getHeight(),mRunway1.getWidth(), Bitmap.Config.ARGB_8888);
        mBitmapDrawable1 = new BitmapDrawable(mBitmap1);

        mRunwayBar = (LinearLayout) findViewById(R.id.runway_bar);
        mRunwayBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Asteroid clicked", Toast.LENGTH_SHORT).show();
                mRunway1.setOnClickListenerBackground(mBitmapDrawable1);
            }
        });

        mRightButton = (Button) findViewById(R.id.right_button);
        mRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mShip.getHori() != 5) {
                    mSpot = findSpot(mShip.getHori());
                    mSpot.setImageDrawable(null);
                    mShip.setHori(mShip.getHori() + 1);
                    mSpot = findSpot(mShip.getHori());
                    mSpot.setImageResource(R.drawable.ic_ship);
                }
            }
        });

        mLeftButton = (Button) findViewById(R.id.left_button);
        mLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mShip.getHori() != 1) {
                    mSpot = findSpot(mShip.getHori());
                    mSpot.setImageDrawable(null);
                    mShip.setHori(mShip.getHori() - 1);
                    mSpot = findSpot(mShip.getHori());
                    mSpot.setImageResource(R.drawable.ic_ship);
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
