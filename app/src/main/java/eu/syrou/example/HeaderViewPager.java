package eu.syrou.example;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by Syrou on 2015-09-21.
 */
public class HeaderViewPager extends RelativeLayout {
    private ScreenSlidePagerAdapter mPagerAdapter;

    public HeaderViewPager(Context context) {
        super(context);
    }

    public HeaderViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    public void init(FragmentManager fragmentManager)
    {
        inflate(getContext(), R.layout.header_viewpager_frame, this);
        //ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        //this.setLayoutParams(lp);
        //invalidate();
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);;
        mPagerAdapter = new ScreenSlidePagerAdapter(fragmentManager);
        viewPager.setAdapter(mPagerAdapter);

    }
}
