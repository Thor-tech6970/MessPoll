package com.example.messpoll.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.messpoll.breakfast.Breakfast;
import com.example.messpoll.Dinner;
import com.example.messpoll.lunch.Lunch;
import com.example.messpoll.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {



    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;


    }

    @Override
    public Fragment getItem(int position) {




        switch (position){

            case 0:

                Breakfast breakfast = new Breakfast();

                return breakfast;


            case 1:

                Lunch lunch = new Lunch();

                return lunch;

            case 2:

                Dinner dinner = new Dinner();

                return dinner;


        }

        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){

            case 0:

                return "BREAKFAST";

            case 1:

                return "LUNCH";

            case 2:

                return "DINNER";


        }

        return null;

    }



    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }


}