package criminal.com.criminalintent.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import criminal.com.criminalintent.BuildConfig;

import static org.junit.Assert.*;

/**
 * Created by khayapro on 2016/05/12.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class CrimeActivityTest {

    @Test
    public void isTitleCorrect(){
        final CrimeActivity activity = Robolectric.setupActivity(CrimeActivity.class);
        assertTrue(activity.getTitle().toString().equals("title"));
    }

}