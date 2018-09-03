package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;



import FragmentActivity.GBreakfastFragment;
import FragmentActivity.GDinnerFragment;
import FragmentActivity.GLunchFragment;




public class GViewPagerAdapter extends FragmentPagerAdapter {
    int numTabs;
    public GViewPagerAdapter(FragmentManager fm, int numTabs) {
        super(fm);
        this.numTabs= numTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                GBreakfastFragment GbreakfastFragment = new GBreakfastFragment();
                return GbreakfastFragment;
            case 1:
                GLunchFragment GlunchFragment = new GLunchFragment();
                return GlunchFragment;
            case 2:
                GDinnerFragment GdinnerFragment = new GDinnerFragment();
                return GdinnerFragment;


            default:
                return null;

        }
    }

    @Override
    public int getCount()
    {
        return numTabs;
    }
}
