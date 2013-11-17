package com.example.PEAR_POC.Activities;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.view.WindowManager;
import com.example.PEAR_POC.R;

/**
 * Created with IntelliJ IDEA.
 * User: pajed002
 * Date: 11/16/13
 */
public class MainDashboardActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
    }
}
