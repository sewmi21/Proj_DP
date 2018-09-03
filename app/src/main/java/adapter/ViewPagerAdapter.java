package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import FragmentActivity.BreakfastFragment;
import FragmentActivity.DinnerFragment;
import FragmentActivity.LunchFragment;


public class ViewPagerAdapter extends FragmentPagerAdapter{
    int numTabs;
    public ViewPagerAdapter(FragmentManager fm, int numTabs) {
        super(fm);
        this.numTabs= numTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                BreakfastFragment breakfastFragment = new BreakfastFragment();
                return breakfastFragment;
            case 1:
                LunchFragment lunchFragment = new LunchFragment();
                return lunchFragment;
            case 2:
                DinnerFragment dinnerFragment = new DinnerFragment();
                return dinnerFragment;


            default:
                return null;

        }

    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
