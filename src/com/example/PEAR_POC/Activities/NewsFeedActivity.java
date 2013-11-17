package com.example.PEAR_POC.Activities;

import android.app.Fragment;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.example.PEAR_POC.Fragments.NewsFeedFragment;
import com.example.PEAR_POC.Fragments.WeeklyProgressFragment;
import com.example.PEAR_POC.R;

/**
 * Created with IntelliJ IDEA.
 * User: pajed002
 * Date: 11/16/13
 * Time: 2:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class NewsFeedActivity extends Activity {
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
            // During initial setup, plug in the newsfeed fragment and weekly workout fragment.

            //Create a frame layout, so we can add fragments to it.
            LinearLayout layout = new LinearLayout(this);
            layout.setOrientation(LinearLayout.VERTICAL);
            layout.setId(477);

            //Load the frame layout for this activity.
            setContentView(layout);

            //Create and add two fragments to linear layout created above.
            FragmentTransaction t = getFragmentManager().beginTransaction();
            //Add first fragment
            WeeklyProgressFragment wp = new WeeklyProgressFragment();
            wp.setArguments(getIntent().getExtras());
            t.add(layout.getId(), wp, "weekly_progress");

            //Add second fragment
            NewsFeedFragment newsFeed = new NewsFeedFragment();
            newsFeed.setArguments(getIntent().getExtras());
            t.add(layout.getId(), newsFeed, "news_feed");
            t.commit();
        }
    }
}