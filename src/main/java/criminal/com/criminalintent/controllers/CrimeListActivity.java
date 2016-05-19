package criminal.com.criminalintent.controllers;

import android.support.v4.app.Fragment;

/**
 * Created by khayapro on 2016/05/19.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
