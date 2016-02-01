package com.example.administrator.cs371.carstereo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;



public class Lab2 extends Activity implements ToggleButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener,
        OnClickListener{

    protected ToggleButton PowerButton;
    protected ToggleButton AMFM_Button;
    protected TextView radio_station;
    protected TextView volumeDisplayView;
    protected SeekBar tuningBar;
    protected SeekBar volumeBar;
    protected int seekBarProgress = 530;
    protected int seekBarProgress1;

    protected Button preset1;
    protected Button preset2;
    protected Button preset3;
    protected Button preset4;
    protected Button preset5;
    protected Button preset6;
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

        preset1 = (Button)findViewById(R.id.preset1);
        preset1.setOnClickListener(this);

        preset2 = (Button)findViewById(R.id.preset2);
        preset2.setOnClickListener(this);

        preset3 = (Button)findViewById(R.id.preset3);
        preset3.setOnClickListener(this);

        preset4 = (Button)findViewById(R.id.preset4);
        preset4.setOnClickListener(this);

        preset5 = (Button)findViewById(R.id.preset5);
        preset5.setOnClickListener(this);

        preset6 = (Button)findViewById(R.id.preset6);
        preset6.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lab2, menu);
        return true;
    }

        @Override
        public void onClick(View view) {
            if (AMFM_Button.isChecked())
            {
                if(view.getId() == R.id.preset1)
                    radio_station .setText(AM[0]);
                else if(view.getId() == R.id.preset2)
                    radio_station .setText(AM[1]);
                else if(view.getId() == R.id.preset3)
                    radio_station .setText(AM[2]);
                else if(view.getId() == R.id.preset4)
                    radio_station .setText(AM[3]);
                else if(view.getId() == R.id.preset5)
                    radio_station .setText(AM[4]);
                else if(view.getId() == R.id.preset6)
                    radio_station .setText(AM[5]);
            }
            else if(!AMFM_Button.isChecked())
            {
                if(view.getId() == R.id.preset1)
                    radio_station .setText(FM[0]);
                else if(view.getId() == R.id.preset2)
                    radio_station .setText(FM[1]);
                else if(view.getId() == R.id.preset3)
                    radio_station .setText(FM[2]);
                else if(view.getId() == R.id.preset4)
                    radio_station .setText(FM[3]);
                else if(view.getId() == R.id.preset5)
                    radio_station .setText(FM[4]);
                else if(view.getId() == R.id.preset6)
                    radio_station .setText(FM[5]);
            }
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

