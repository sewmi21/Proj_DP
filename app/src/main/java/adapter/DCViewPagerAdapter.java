package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import FragmentActivity.DCBreakfastFragment;
import FragmentActivity.DCDinnerFragment;
import FragmentActivity.DCLunchFragment;





public class DCViewPagerAdapter extends FragmentPagerAdapter {
    int numTabs;
    public DCViewPagerAdapter(FragmentManager fm, int numTabs) {
        super(fm);
        this.numTabs= numTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                DCBreakfastFragment dcbreakfastFragment = new DCBreakfastFragment();
                return dcbreakfastFragment;
            case 1:
                DCLunchFragment dclunchFragment = new DCLunchFragment();
                return dclunchFragment;
            case 2:
                DCDinnerFragment dcdinnerFragment = new DCDinnerFragment();
                return dcdinnerFragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
