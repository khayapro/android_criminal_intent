package criminal.com.criminalintent.controllers;

import android.support.v4.app.Fragment;

/**
 * This is a fragment activity
 */
public class CrimeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }

}
