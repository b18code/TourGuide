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
public class RestaurantsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.category_list, container, false);

        // Create a list of restaurants with its info
        final ArrayList<Info> information = new ArrayList<Info>();

        information.add(new Info(getString(R.string.ristorante_name), getString(R.string.ristorante_address), getString(R.string.common_time_restaurant), getString(R.string.ristorante_phone)));
        information.add(new Info(getString(R.string.cafe_name), getString(R.string.cafe_address), getString(R.string.cafe_time), getString(R.string.cafe_phone)));
        information.add(new Info(getString(R.string.grill_name), getString(R.string.grill_address), getString(R.string.grill_time), getString(R.string.grill_phone)));
        information.add(new Info(getString(R.string.mo_name), getString(R.string.mo_address), getString(R.string.common_time_restaurant), getString(R.string.mo_phone)));
        information.add(new Info(getString(R.string.plaka_name), getString(R.string.plaka_address), getString(R.string.plaka_time), getString(R.string.plaka_phone)));

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
