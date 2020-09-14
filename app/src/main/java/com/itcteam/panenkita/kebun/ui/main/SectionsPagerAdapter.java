package com.itcteam.panenkita.kebun.ui.main;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.itcteam.panenkita.R;
import com.itcteam.panenkita.kebun.Kebun;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[] {R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
    private final Context mContext;
    private final String id_panen;

    public SectionsPagerAdapter(Context context, FragmentManager fm, String id_panen) {
        super(fm);
        this.id_panen = id_panen;
        mContext = context;

    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = DaftarKebunFragment.newInstance(id_panen);
                break;
            case 1:
                fragment = BiayaPokokFragment.newInstance(id_panen);
                break;
            case 2:
                fragment = RingkasanFragment.newInstance(id_panen);
                break;
            }
        return fragment;
//        return PlaceholderFragment.newInstance(position + 1);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }

}