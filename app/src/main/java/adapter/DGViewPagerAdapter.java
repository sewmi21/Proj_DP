package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import FragmentActivity.DGBreakfastFragment;
import FragmentActivity.DGDinnerFragment;
import FragmentActivity.DGLunchFragment;




public class DGViewPagerAdapter extends FragmentPagerAdapter {
    int numTabs;
    public DGViewPagerAdapter(FragmentManager fm, int numTabs) {
        super(fm);
        this.numTabs= numTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                DGBreakfastFragment dgbreakfastFragment = new DGBreakfastFragment();
                return dgbreakfastFragment;
            case 1:
                DGLunchFragment dglunchFragment = new DGLunchFragment();
                return dglunchFragment;
            case 2:
                DGDinnerFragment dgdinnerFragment = new DGDinnerFragment();
                return dgdinnerFragment;


            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
