package eu.syrou.nobsrecyclerview;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Syrou on 2015-09-20.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();
    private final List<NOBSTabSelected> mTabSelectedListenerArray = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFrag(Fragment fragment, String title, NOBSTabSelected tabSelected) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
        mTabSelectedListenerArray.add(tabSelected);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

    public List<NOBSTabSelected> getTabSelectedArray() {
        return mTabSelectedListenerArray;
    }


}
