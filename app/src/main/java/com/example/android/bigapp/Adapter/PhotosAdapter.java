package com.example.android.bigapp.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.bigapp.EachPhotosFragment;

import java.util.ArrayList;


public class PhotosAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragmentArrayList;
    Fragment fragment;
    int fragCount;


    public PhotosAdapter
            (FragmentManager fm, ArrayList<Fragment> fragmentArrayList, int fragCount) {
        super(fm);
        this.fragmentArrayList = fragmentArrayList;
        this.fragCount = fragCount;
    }
    public void updateFragmentsList(ArrayList<Fragment> fragments){
        this.fragmentArrayList=fragments;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        try {
            fragment = fragmentArrayList.get(position);
        }catch (IndexOutOfBoundsException ioe){
           /* fragment= EachPhotosFragment.newInstance("iamgeUrl","title");
            fragmentArrayList.add(fragment);*/
        }
        return fragment;
        }

    @Override
    public int getCount() {
        return fragCount;
    }
}
