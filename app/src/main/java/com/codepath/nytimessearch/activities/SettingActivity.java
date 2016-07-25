package com.codepath.nytimessearch.activities;


import android.app.DatePickerDialog;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.codepath.nytimessearch.DatePickerFragment;
import com.codepath.nytimessearch.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public  class SettingActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        spinner();

    }

    public void onShowDatePicker(View view) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        // store the values selected into a Calendar instance
        final Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, monthOfYear);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        SimpleDateFormat formatDate = new SimpleDateFormat("yy-MM-dd");

        EditText beginDate = (EditText) findViewById(R.id.beginDate);

        beginDate.setText(formatDate.format(c.getTime()));

    }


        public Spinner spinner() {
            //fetch the spinner in the xml file
            spinner = (Spinner) findViewById(R.id.spinner);
            //Create the arrayList to put elemet in the spinner
            List exempleList = new ArrayList();
            exempleList.add("Oldest");
            exempleList.add("Newest");

            //use an adapter to bind data
            ArrayAdapter adapter = new ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_item,
                    exempleList
            );


                   // set the dropdown
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //Enfin on passe l'adapter au Spinner et c'est tout
            spinner.setAdapter(adapter);

            return spinner;
        }

}
