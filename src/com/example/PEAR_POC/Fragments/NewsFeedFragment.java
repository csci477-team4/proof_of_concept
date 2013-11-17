package com.example.PEAR_POC.Fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import com.example.PEAR_POC.TraineeCard;

/**
 * Created with IntelliJ IDEA.
 * User: pajed002
 * Date: 11/16/13
 */
public class NewsFeedFragment extends Fragment {
    /**
     * Create a new instance of NewsFeedFragment, initialized to
     * show some dummy text using trainee card info
     */
    public static NewsFeedFragment newInstance(int index, TraineeCard tc) {
        NewsFeedFragment f = new NewsFeedFragment();

        // Supply index input and trainee info as arguments.
        Bundle args = new Bundle();
        args.putInt("index", index);
        String[] arr = {tc.getName(), tc.getInfo()};
        args.putStringArray("information", arr);
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
        String[] info = getArguments().getStringArray("information");
        text.setText("<More_Imagination \nWOW IT'S A NEWS FEED FOR "
                + info[0].toUpperCase() + ", OUR "
                + info[1].toUpperCase() + "! \n\n" +
                info[0].toUpperCase() + " worked out\n\n" +
                info[0].toUpperCase() + " sent you a text message\n\n" +
                "You sent a workout suggestion\n\n" +
                info[0].toUpperCase() + " didn't listen to you\n" +
                "/>");
        return scroller;
    }
}