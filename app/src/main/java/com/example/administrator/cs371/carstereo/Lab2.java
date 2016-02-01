package com.example.administrator.cs371.carstereo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.ProgressBar;


public class Lab2 extends Activity implements ToggleButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener {

    protected ToggleButton PowerButton;
    protected ToggleButton AMFM_Button;
    protected TextView radio_station;
    protected TextView volumeDisplayView;
    protected SeekBar tuningBar;
    protected SeekBar volumeBar;
    protected boolean amFlag = false;
    protected int seekBarProgress = 530;
    protected int seekBarProgress1;
    protected String[] AM = {"550 AM", "600 AM", "650 AM", "700 AM", "750 AM", "800 AM"};
    protected String[] FM = {"90.9 FM","92.9 FM", "94.9 FM", "96.9 FM", "98.9 FM", "100.9 FM" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);

        PowerButton = (ToggleButton)findViewById(R.id.PowerButton);
        PowerButton.setOnCheckedChangeListener(this);

        AMFM_Button = (ToggleButton)findViewById(R.id.AMFM_Button);
        AMFM_Button.setOnCheckedChangeListener(this);

        radio_station = (TextView)findViewById(R.id.radio_station);

        volumeDisplayView = (TextView)findViewById(R.id.volumeDisplayView);

        tuningBar = (SeekBar)findViewById(R.id.tuningBar);
        tuningBar.setOnSeekBarChangeListener(this);

        volumeBar = (SeekBar)findViewById(R.id.volumeBar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lab2, menu);
        return true;
    }

    public void Power(View view){

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
       int black = 0xFF000000;
        if (!PowerButton.isChecked()) {
            radio_station.setBackgroundColor(black);
            tuningBar.setBackgroundColor(black);
            volumeBar.setBackgroundColor(black);
            AMFM_Button.setBackgroundColor(black);
            tuningBar.setEnabled(false);
            AMFM_Button.setEnabled(false);
        } else {
            radio_station.setBackgroundColor(0xFFFFFFFF);
            tuningBar.setBackgroundColor(0xFF9DD8FF);
            volumeBar.setBackgroundColor(0xFFFF97C5);
            AMFM_Button.setBackgroundColor(0xFFB300FF);
            tuningBar.setEnabled(true);
            AMFM_Button.setEnabled(true);
        }

        if(AMFM_Button.isChecked()){
            radio_station.setText(seekBarProgress + " AM");
        }
        else if(!(AMFM_Button.isChecked())) {
            radio_station.setText((double)seekBarProgress1/10 + " FM");
        }


        }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


        if (AMFM_Button.isChecked()) {
            int step = 10;
            int newProgress = ((int) Math.round(progress / step)) * step;
            seekBar.setMax(1170);
            seekBarProgress = (newProgress + 530);//530
            radio_station.setText(seekBarProgress + " AM");
            amFlag = true;
        }
        else if (!(AMFM_Button.isChecked())) {
            int step = 2;
            progress = ((int) Math.round(progress / step)) * step;
            seekBar.setMax(198);
            seekBarProgress1 = (progress + 881);//530
            radio_station.setText((((double) seekBarProgress1)/10) + " FM");
        }
    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
