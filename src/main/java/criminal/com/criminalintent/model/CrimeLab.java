package criminal.com.criminalintent.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

/**
 * Created by khayapro on 2016/05/19.
 *
 */
public class CrimeLab {

    private static CrimeLab sCrimeLab;
    private List<Crime> mCrimes;

    private CrimeLab(Context context){
        mCrimes = new ArrayList<>();
        /**
         * Initializing some crime objects and add to list.
         * for demonstration.
         */
        for (int i = 0; i < 100; i++) {
            final Crime crime = new Crime();
            crime.setTitle("#..." + i);
            crime.setDate(Calendar.getInstance().getTime());
            crime.setResolved(i % 2 == 0);
            mCrimes.add(crime);
        }

    }

    public static CrimeLab getInstance(Context context){
        if(sCrimeLab == null)
            sCrimeLab = new CrimeLab(context);

        return sCrimeLab;
    }

    /**
     * Getting a list of crimes captured.
     * @return List
     */
    public List<Crime> getCrimes() {
        return mCrimes;
    }

    /**
     * Getting a single crime based on parsed in argument.
     * @param id - unique crime id.
     * @return Crime
     */
    public Crime getCrime(UUID id){
        for (Crime crime : mCrimes) {
            if (crime.getId().equals(id)) {
                return crime;
            }
        }
        return null;
    }
}
