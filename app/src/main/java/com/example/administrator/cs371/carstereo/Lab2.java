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
    protected SeekBar minAM = null;
    protected TextView minAM_Val = null;
    protected SeekBar maxAM = null;
    protected TextView maxAM_Val = null;
    protected SeekBar minFM = null;
    protected TextView minFM_Val = null;
    protected SeekBar maxFM = null;
    protected TextView maxFM_Val = null;

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

        minAM = (SeekBar)findViewById(R.id.tuningBar);
        minAM. setOnSeekBarChangeListener(this);

        maxAM = (SeekBar)findViewById(R.id.tuningBar);
        maxAM. setOnSeekBarChangeListener(this);

        minFM = (SeekBar)findViewById(R.id.tuningBar);
        minFM. setOnSeekBarChangeListener(this);

        maxFM = (SeekBar)findViewById(R.id.tuningBar);
        maxFM. setOnSeekBarChangeListener(this);

        minAM_Val = (TextView)findViewById(R.id.radio_station);
        maxAM_Val =(TextView)findViewById(R.id.radio_station);

        //minFM_Val = (TextView)findViewById(R.id.);
        //maxFM_Val = (TextView)findViewById(R.id);


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
            radio_station.setText("600 AM");
        }
        else if(!(AMFM_Button.isChecked())) {
            radio_station.setText("100.1 FM");
        }

        }
    public final synchronized void incrementProgressBy (int increment){
        increment = 10;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


        if (AMFM_Button.isChecked()) {
            int step = 10;
            progress = ((int) Math.round(progress / step)) * step;
            seekBar.setMax(1170);
            int seekBarProgress = (progress + 530);//530
            seekBar.setProgress(progress);
            radio_station.setText(seekBarProgress + " AM");
        }
        else if (!(AMFM_Button.isChecked())) {
            int step = 2;
            progress = ((int) Math.round(progress / step)) * step;
            seekBar.setMax(198);
            int seekBarProgress = (progress + 881);//530
            seekBar.setProgress(progress);
            radio_station.setText((((double) seekBarProgress)/10) + " FM");
        }
    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
