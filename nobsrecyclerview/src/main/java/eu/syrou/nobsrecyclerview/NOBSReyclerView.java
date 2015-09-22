package eu.syrou.nobsrecyclerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.graphics.Palette;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by Syrou on 2015-09-20.
 */
public class NOBSReyclerView extends RelativeLayout {
    CoordinatorLayout contentView;
    CollapsingToolbarLayout collapsingToolbarLayout;
    TabLayout tabLayout;
    ViewPager viewPager;
    FrameLayout headerFrameLayout;
    FrameLayout contentFrameLayout;

    SparseArray<Fragment> recyclerViewArray = new SparseArray<>();
    private ViewPagerAdapter fragmentAdapter;


    public NOBSReyclerView(Context context) {
        super(context);
        inflateView();
    }

    public NOBSReyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflateView();
    }

    public NOBSReyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflateView();
    }

    public NOBSReyclerView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflateView();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for(int i = 0 ; i < getChildCount() ; i++){
            getChildAt(i).layout(l, t, r, b);
        }
    }

    public void inflateView()
    {
        inflate(getContext(), R.layout.nobs_reycler_view_layout, this);
        contentView = (CoordinatorLayout) findViewById(R.id.nobs_maincontent);
        tabLayout = (TabLayout) findViewById(R.id.nobs_tabs);
        contentFrameLayout = (FrameLayout) findViewById(R.id.nobs_content);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.nobs_collapse_toolbar);
        headerFrameLayout = (FrameLayout) findViewById(R.id.nobs_header);
    }



    private void showToast(String value) {
        Toast.makeText(getContext(), value, Toast.LENGTH_SHORT).show();
    }

    public void addHeader(ViewGroup viewGroup)
    {
        headerFrameLayout.addView(viewGroup);
    }

    public void setupViewPager(FragmentManager fragmentManager, ViewPager viewPager) {
        this.viewPager = viewPager;
        contentFrameLayout.addView(this.viewPager);
        fragmentAdapter = new ViewPagerAdapter(fragmentManager);
        viewPager.setAdapter(fragmentAdapter);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(tabChangeListener);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.header);

        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @SuppressWarnings("ResourceType")
            @Override
            public void onGenerated(Palette palette) {

                int vibrantColor = palette.getVibrantColor(R.color.primary_500);
                int vibrantDarkColor = palette.getDarkVibrantColor(R.color.primary_700);
                collapsingToolbarLayout.setContentScrimColor(vibrantColor);
                collapsingToolbarLayout.setStatusBarScrimColor(vibrantDarkColor);
            }
        });
    }

    private TabLayout.OnTabSelectedListener tabChangeListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            viewPager.setCurrentItem(tab.getPosition());
            fragmentAdapter.getTabSelectedArray().get(tab.getPosition()).OnTabSelected(tab);
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };

    public void addFragmentToReyclerView(Fragment fragment, String tabName, NOBSTabSelected nobsTabSelected)
    {
        fragmentAdapter.addFrag(fragment, tabName, nobsTabSelected);
        fragmentAdapter.notifyDataSetChanged();
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(tabChangeListener);
    }
}
