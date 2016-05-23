package criminal.com.criminalintent.controllers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import criminal.com.criminalintent.R;

/**
 * Created by khayapro on 2016/05/19.
 *
 */
public abstract class SingleFragmentActivity extends AppCompatActivity {

    /**
     * To be implement by the concrete class and will return the
     * Fragment in context.
     * @return Fragment
     */
    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        final FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);

        if(fragment == null){
            fragment = createFragment();
            fragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, fragment)
                .commit();
        }
    }
}