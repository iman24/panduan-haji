package com.imanancin.panduanhaji.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.imanancin.panduanhaji.fragment.GuideFragment;
import com.imanancin.panduanhaji.model.Guide;

import java.util.ArrayList;


public class GuidePagerAdapter extends FragmentStatePagerAdapter {


    static public ArrayList<Guide> guides = new ArrayList<>();

    public GuidePagerAdapter(@NonNull FragmentManager fm, ArrayList<Guide> guides) {
        super(fm);
        this.guides = guides;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return GuideFragment.newInstance(position);
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return guides.get(position).getTitle();
    }

    @Override
    public int getCount() {
        return guides.size();
    }
}
