package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import FragmentActivity.PBreakfastFragment;
import FragmentActivity.PDinnerFragment;
import FragmentActivity.PLunchFragment;



public class PViewPagerAdapter extends FragmentPagerAdapter {
    int numTabs;
    public PViewPagerAdapter(FragmentManager fm, int numTabs) {
        super(fm);
        this.numTabs= numTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                PBreakfastFragment PbreakfastFragment = new PBreakfastFragment();
                return PbreakfastFragment;
            case 1:
                PLunchFragment PlunchFragment = new PLunchFragment();
                return PlunchFragment;
            case 2:
                PDinnerFragment PdinnerFragment = new PDinnerFragment();
                return PdinnerFragment;


            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
