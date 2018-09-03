package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import FragmentActivity.DBreakfastFragment;
import FragmentActivity.DDinnerFragment;
import FragmentActivity.DLunchFragment;





public class DViewPagerAdapter extends FragmentPagerAdapter {
    int numTabs;
    public DViewPagerAdapter(FragmentManager fm, int numTabs) {

        super(fm);
        this.numTabs= numTabs;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                DBreakfastFragment dbreakfastFragment = new DBreakfastFragment();
                return dbreakfastFragment;
            case 1:
                DLunchFragment dlunchFragment = new DLunchFragment();
                return dlunchFragment;
            case 2:
                DDinnerFragment ddinnerFragment = new DDinnerFragment();
                return ddinnerFragment;


            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
