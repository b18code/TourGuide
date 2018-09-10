package com.example.android.tourguide;


/**
 * {@link Info} represents information about a category the user wants to know about.
 * The categories are Attractions, Events, Parks and Restaurants.
 * All categories contains a name and address. Then depending on the specific category,
 * a date, time, phone number or icon is included
 */
public class Info {

    /**
     * This checks if there isn't a time
     */
    private static final String noTime = "";
    /**
     * This checks if there isn't a date or phone number
     */
    private static final String noDatePhone = "";
    /**
     * Constant value that represents no image was provided for this category
     */
    private static final int NO_IMAGE_PROVIDED = -1;
    /**
     * Name of the attraction, event, park or restaurant
     */
    private String mName;
    /**
     * Address of the attraction, event, park or restaurant
     */
    private String mAddress;
    /**
     * Time for the attraction, event or restaurant
     */
    private String mTime = noTime;
    /**
     * Date for the event or phone number for restaurant
     */
    private String mDateOrPhone = noDatePhone;
    /**
     * Image/icon for the attraction or park
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * Create a new Info object. Used for Events and Restaurants
     *
     * @param name        is the name of the event or restaurant
     * @param address     is the address of the event or restaurant
     * @param time        is the opening and closing time of the restaurant or
     *                    time is only a start time for the event
     * @param dateOrPhone is either the date of the event or phone number of the restaurant
     */
    public Info(String name, String address, String time, String dateOrPhone) {

        mName = name;
        mAddress = address;
        mTime = time;
        mDateOrPhone = dateOrPhone;
    }

    /**
     * Create a new Info object. Used for Attractions
     *
     * @param name            is the name of the attraction
     * @param address         is the address of the attraction
     * @param time            is the opening and closing time of the attraction for today
     * @param imageResourceId is the drawable resource ID for the image associated with the attraction
     */
    public Info(String name, String address, String time, int imageResourceId) {

        mName = name;
        mAddress = address;
        mTime = time;
        mImageResourceId = imageResourceId;
    }

    /**
     * Create a new Info object. Used for Parks
     *
     * @param name            is the name of the park
     * @param address         is the address of the park
     * @param imageResourceId is the drawable resource ID for the image associated with the park
     */
    public Info(String name, String address, int imageResourceId) {

        mName = name;
        mAddress = address;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the name of the attraction, event, park or restaurant
     */
    public String getName() {
        return mName;
    }

    /**
     * Get the address of the attraction, event, park or restaurant
     */
    public String getAddress() {
        return mAddress;
    }

    /**
     * Get the date or phone number for the event or restaurant
     */
    public String getDatePhone() {
        return mDateOrPhone;
    }

    /**
     * Returns whether or not there is a date or phone number
     */
    public boolean hasDateOrPhone() {
        return (!mDateOrPhone.equals(noDatePhone));
    }

    /**
     * Get the time for attraction, event or restaurant
     */
    public String getTime() {
        return mTime;
    }

    /**
     * Returns whether or not there is a time
     */
    public boolean hasTime() {
        return (!mTime.equals(noTime));
    }

    /**
     * Return the image resource ID of the information depending on the category (i.e Attraction or Park)
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this category.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}
