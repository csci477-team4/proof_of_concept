package com.example.PEAR_POC.Fragments;

import android.R;
import android.app.Fragment;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import com.example.PEAR_POC.WeeklyWorkoutData;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: pajed002
 * Date: 11/16/13
 */
public class WeeklyProgressFragment extends Fragment {
    /**
     * Create a new instance of WeeklyProgressFragment, initialized to
     * show the details of a workout.
     */
    public static WeeklyProgressFragment newInstance(WeeklyWorkoutData wwd) {
        WeeklyProgressFragment f = new WeeklyProgressFragment();

        Bundle args = new Bundle();
        ArrayList<String> arr = wwd.getWorkouts();
        args.putSerializable("start", wwd.getStartTime());
        args.putSerializable("end", wwd.getEndTime());
        args.putStringArrayList("data", arr);
        f.setArguments(args);

        return f;
    }

    public int getShownIndex() {
        return getArguments().getInt("index", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        ScrollView scroller = new ScrollView(getActivity());
        TextView text = new TextView(getActivity());
        int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                4, getActivity().getResources().getDisplayMetrics());
        text.setPadding(padding, padding, padding, padding);
        scroller.addView(text);
        ArrayList<String> data = getArguments().getStringArrayList("data");
        text.setText("<Imagination \nWEEKLY PROGRESS REPORT FOR "
                + getArguments().getSerializable("start").toString()
                + " THROUGH " + getArguments().getSerializable("end").toString() + "\n\n");
        for (String s : data) {
            text.append(s + "\n");
        }
        text.append("/>");
        return scroller;
    }
}