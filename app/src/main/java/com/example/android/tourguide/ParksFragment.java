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
public class ParksFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.category_list, container, false);

        // Create a list of restaurants with its info
        final ArrayList<Info> information = new ArrayList<Info>();

        information.add(new Info(getString(R.string.james_name), getString(R.string.james_address), R.drawable.botanic_gardens));
        information.add(new Info(getString(R.string.rhodes_name), getString(R.string.rhodes_address), R.drawable.melville_koppies));
        information.add(new Info(getString(R.string.lake_name), getString(R.string.lake_address), R.drawable.jhb_zoo));
        information.add(new Info(getString(R.string.bez_name), getString(R.string.bez_address), R.drawable.botanic_gardens));
        information.add(new Info(getString(R.string.wild_name), getString(R.string.wild_address), R.drawable.melville_koppies));
        information.add(new Info(getString(R.string.botanical_name), getString(R.string.botanical_address), R.drawable.botanic_gardens));
        information.add(new Info(getString(R.string.koppies_name), getString(R.string.koppies_address), R.drawable.melville_koppies));

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
