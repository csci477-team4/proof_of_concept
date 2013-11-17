package com.example.PEAR_POC.Fragments;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.PEAR_POC.Activities.NewsFeedActivity;
import com.example.PEAR_POC.TraineeCard;
import com.example.PEAR_POC.R;
import com.example.PEAR_POC.WeeklyWorkoutData;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: pajed002
 * Date: 11/16/13
 * Time: 3:16 PM
 * To change this template use File | Settings | File Templates.
 */

public class TraineeCardsFragment extends ListFragment {

    ArrayList<TraineeCard> trainees;
    boolean mDualPane;
    int mCurCheckPosition = 0;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // silly example. Normally we'd pull from the remote db here and these 'cards' would have more than just names
        trainees = new ArrayList<TraineeCard>();
        trainees.add(new TraineeCard("Daniel", "Architect"));
        trainees.add(new TraineeCard("John", "Requirements Engineer"));
        trainees.add(new TraineeCard("Marc", "Operational Concepts Engineer"));
        trainees.add(new TraineeCard("Shay", "Feasibility Analyst"));
        trainees.add(new TraineeCard("Tanya", "Project Manager"));
        trainees.add(new TraineeCard("Vahe", "Lice Cycle Planner"));

        // populate the list
        setListAdapter(new ArrayAdapter<TraineeCard>(getActivity(),
                android.R.layout.simple_list_item_activated_1, trainees));

        // check to see if we have a frame in which to embed the trainee_details
        // fragment directly in the containing UI.
        View detailsFrame = getActivity().findViewById(R.id.trainee_details);
        mDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

        if (savedInstanceState != null) {
            // Restore last state for checked position.
            mCurCheckPosition = savedInstanceState.getInt("curChoice", 0);
        }

        if (mDualPane) {
            // In dual-pane mode, the list view highlights the selected item.
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            // Make sure our UI is in the correct state.
            showNewsFeed(mCurCheckPosition);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice", mCurCheckPosition);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        showNewsFeed(position);
    }

    void showNewsFeed(int index){
        mCurCheckPosition = index;

        if (mDualPane) {
            // landscape mode, so we can display everything in-place with fragments
            // update the list to highlight the selected trainee and show the trainee's newsfeed.
            getListView().setItemChecked(index, true);

            // Check what fragment is currently shown, replace if needed.
            NewsFeedFragment newsFeed = (NewsFeedFragment)
                    getFragmentManager().findFragmentById(R.id.trainee_details);
            if (newsFeed == null || newsFeed.getShownIndex() != index) {
                // make new fragment to show this selection.
                newsFeed = NewsFeedFragment.newInstance(index, trainees.get(index));

                // Execute a transaction, replacing any existing fragment
                // with this one inside the frame.
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                if (index == 0) {
                    ft.replace(R.id.trainee_details, newsFeed);
                } else {
//                    ft.replace(R.id.a_item, newsFeed);
                }
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }

        } else {
            // Otherwise we need to launch a new activity to display
            // the news feed and workout fragments. here we fake the workout data.
            Intent intent = new Intent();
            intent.setClass(getActivity(), NewsFeedActivity.class);
            intent.putExtra("index", index);
            String[] arr = {trainees.get(index).getName(), trainees.get(index).getInfo()};
            intent.putExtra("information", arr);
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("Running", "SOME RUNNING DATA");
            map.put("Swimming", "SOME SWIMMING DATA");
            map.put("Hiking", "SOME HIKING DATA");
            WeeklyWorkoutData wwd = new WeeklyWorkoutData("Jan 1", "Jan 8", map);
            intent.putExtra("start", wwd.getStartTime());
            intent.putExtra("end", wwd.getEndTime());
            intent.putExtra("data", wwd.getWorkouts());
            startActivity(intent);
        }
    }
}

