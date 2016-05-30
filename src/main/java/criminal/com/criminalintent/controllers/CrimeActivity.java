package criminal.com.criminalintent.controllers;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * This is a fragment activity
 */
public class CrimeActivity extends SingleFragmentActivity {

    public static final String EXTRA_CRIM_ID = "criminal.com.criminalintent.controllers.crime_id";


    public static Intent newIntent(Context packageContext, UUID crimeId){
        final Intent crimeIntent = new Intent(packageContext, CrimeActivity.class);
        crimeIntent.putExtra(EXTRA_CRIM_ID, crimeId);
        return crimeIntent;
    }

    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }

}
