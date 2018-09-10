package com.example.android.tourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoAdapter extends ArrayAdapter<Info> {

    /**
     * Create a new {@link InfoAdapter} object.
     *
     * @param context     is the current context (i.e. Activity) that the adapter is being created in.
     * @param information is the list of {@link Info}s to be displayed.
     */
    public InfoAdapter(Context context, ArrayList<Info> information) {

        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for four TextViews and/or an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, information);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.category_list_item, parent, false);
        }

        // Get the {@link Info} object located at this position in the list
        Info currentInfo = getItem(position);

        // Find the TextView in the category_list_item.xml layout with the ID name_text_view
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);

        // Get the name from the current Info object and set this text on the name TextView
        nameTextView.setText(currentInfo.getName());

        // Find the TextView in the category_list_item.xml layout with the ID address_text_view
        TextView addressTextView = (TextView) listItemView.findViewById(R.id.address_text_view);

        // Get the address from the current Info object and set this text on the address TextView
        addressTextView.setText(currentInfo.getAddress());

        // Find the TextView in the category_list_item.xml layout with the time_text_view
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time_text_view);

        // Check if there is a time provided for this category
        if (currentInfo.hasTime()) {

            // If there is a time provided.
            // Get the time from the current Info object and set this text on the time TextView
            timeTextView.setText(currentInfo.getTime());

            // Make sure the view is visible
            timeTextView.setVisibility(View.VISIBLE);

        } else {
            // Otherwise hide the time TextView (set visibility to GONE)
            timeTextView.setVisibility(View.GONE);
        }

        // Find the TextView in the category_list_item.xml layout with the ID date_phone_text_view
        TextView datePhoneTextView = (TextView) listItemView.findViewById(R.id.date_phone_text_view);

        // Check if there is a date or phone provided for this category
        if (currentInfo.hasDateOrPhone()) {

            // Get the date or phone number from the current Info object and
            // set this text on the date_phone TextView
            datePhoneTextView.setText(currentInfo.getDatePhone());

            // Make sure the view is visible
            datePhoneTextView.setVisibility(View.VISIBLE);

        } else {

            //Set the timeTextView text to the left next to the Attraction image/icon
            timeTextView.setGravity(3);

            // Otherwise hide the date or phone TextView (set visibility to INVISIBLE)
            //being INVISIBLE helps keep the Parks category info remain inline with the
            //imageView
            datePhoneTextView.setVisibility(View.INVISIBLE);
        }

        // Find the ImageView in the  category_list_item.xml layout with the ID category_image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.category_image);

        // Check if an image is provided for this category or not
        if (currentInfo.hasImage()) {

            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentInfo.getImageResourceId());

            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);

        } else {

            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Return the whole list item layout so that it can be shown in the ListView
        return listItemView;
    }
}
