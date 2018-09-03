package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import FragmentActivity.CGBreakfastFragment;
import FragmentActivity.CGDinnerFragment;
import FragmentActivity.CGLunchFragment;



public class CGViewPagerAdapter extends FragmentPagerAdapter {
    int numTabs;
    public CGViewPagerAdapter(FragmentManager fm,int numTabs) {
        super(fm);
        this.numTabs= numTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new CGBreakfastFragment();
            case 1:
                return new CGLunchFragment();
            case 2:
                return new CGDinnerFragment();


            default:
                return null;
        }
    }
    

    @Override
    public int getCount() {
        return  numTabs;
    }
}
