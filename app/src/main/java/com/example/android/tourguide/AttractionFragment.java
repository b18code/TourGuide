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
public class AttractionFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.category_list, container, false);

        // Create a list of restaurants with its info
        final ArrayList<Info> information = new ArrayList<Info>();

        information.add(new Info(getString(R.string.apartheid_name), getString(R.string.apartheid_address), getString(R.string.common_attraction_time), R.drawable.apartheid_museum));
        information.add(new Info(getString(R.string.gold_reef_name), getString(R.string.gold_reef_address), getString(R.string.gold_reef_time), R.drawable.gold_reef));
        information.add(new Info(getString(R.string.cradle_name), getString(R.string.cradle_address), getString(R.string.common_attraction_time), R.drawable.cradle_humankind));
        information.add(new Info(getString(R.string.constitution_name), getString(R.string.constitution_address), getString(R.string.common_attraction_time), R.drawable.constitution_hill));
        information.add(new Info(getString(R.string.monte_name), getString(R.string.monte_address), getString(R.string.monte_time), R.drawable.monte_casino));
        information.add(new Info(getString(R.string.carlton_name), getString(R.string.carlton_address), getString(R.string.carlton_time), R.drawable.carlton_centre));
        information.add(new Info(getString(R.string.zoo_name), getString(R.string.zoo_address), getString(R.string.zoo_time), R.drawable.jhb_zoo));

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
