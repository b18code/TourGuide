package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.category_list, container, false);

        // Create a list of events with its info
        final ArrayList<Info> information = new ArrayList<Info>();

        information.add(new Info(getString(R.string.soweto_name), getString(R.string.soweto_address), getString(R.string.soweto_time), getString(R.string.date_8_sept)));
        information.add(new Info(getString(R.string.gin_name), getString(R.string.gin_address), getString(R.string.gin_time), getString(R.string.date_8_sept)));
        information.add(new Info(getString(R.string.fnb_name), getString(R.string.fnb_address), getString(R.string.fnb_time), getString(R.string.fnb_date)));
        information.add(new Info(getString(R.string.fitch_name), getString(R.string.fitch_address), getString(R.string.fitch_time), getString(R.string.date_29_sept)));
        information.add(new Info(getString(R.string.battle_name), getString(R.string.battle_address), getString(R.string.battle_time), getString(R.string.date_29_sept)));

        // Create an {@link InfoAdapter}, whose data source is a list of {@link Info}s. The
        // adapter knows how to create list items for each item in the list.
        InfoAdapter adapter = new InfoAdapter(getActivity(), information);

        // There should be a {@link ListView} with the view ID called category_list_view, which is declared in the
        // category_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.category_list_view);

        // Make the {@link ListView} use the {@link InfoAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Info} in the list.
        listView.setAdapter(adapter);

        return rootView;
    }
}
