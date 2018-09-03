package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import FragmentActivity.DCGBreakfastFragment;
import FragmentActivity.DCGDinnerFragment;
import FragmentActivity.DCGLunchFragment;





public class DCGViewPagerAdapter extends FragmentPagerAdapter {
    int numTabs;
    public DCGViewPagerAdapter(FragmentManager fm,int numTabs) {
        super(fm);
        this.numTabs= numTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new DCGBreakfastFragment();
            case 1:
                return new DCGLunchFragment();
            case 2:
                return new DCGDinnerFragment();


            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
