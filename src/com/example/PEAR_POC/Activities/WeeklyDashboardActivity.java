package com.example.PEAR_POC.Activities;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import com.example.PEAR_POC.Fragments.NewsFeedFragment;
import com.example.PEAR_POC.Fragments.WeeklyProgressFragment;

/**
 * Created with IntelliJ IDEA.
 * User: pajed002
 * Date: 11/16/13
 */
public class WeeklyDashboardActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE) {
            // If the screen is now in landscape mode, we can show the
            // dialog in-line with the list so we don't need this activity.
            finish();
            return;
        }

        if (savedInstanceState == null) {
            // During initial setup, plug in the weekly progress fragment.
            WeeklyProgressFragment progress = new WeeklyProgressFragment();
            progress.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().add(android.R.id.content, progress).commit();
        }
    }
}