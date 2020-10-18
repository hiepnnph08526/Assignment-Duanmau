package com.example.assignment_duanmau.activity;

import android.app.Dialog;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DataPickerFragment extends DialogFragment {
    private int year, month, day;

    public DataPickerFragment() {
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
    }
}
