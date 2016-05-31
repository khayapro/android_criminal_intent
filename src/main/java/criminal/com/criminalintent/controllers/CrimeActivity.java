package criminal.com.criminalintent.controllers;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * This is a fragment activity
 */
public class CrimeActivity extends SingleFragmentActivity {

    private static final String EXTRA_CRIME_ID = "criminal.com.criminalintent.controllers.crime_id";



    public static Intent newIntent(Context packageContext, UUID crimeId){
        final Intent crimeIntent = new Intent(packageContext, CrimeActivity.class);
        crimeIntent.putExtra(EXTRA_CRIME_ID, crimeId);
        return crimeIntent;
    }

    /**
     * The host, CrimeActivity knows about the creation of
     * CrimeFragment because it hosts it.
     * @return Fragment
     */
    @Override
    protected Fragment createFragment() {
        final UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(crimeId);
    }

}
