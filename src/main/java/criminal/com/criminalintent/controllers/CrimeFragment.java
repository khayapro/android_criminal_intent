package criminal.com.criminalintent.controllers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;

import criminal.com.criminalintent.R;
import criminal.com.criminalintent.model.Crime;
import criminal.com.criminalintent.model.CrimeLab;

public class CrimeFragment extends Fragment {

    private static final String ARG_CRIME_ID = "crime_id";

    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mResolved;

    /**
     * Default constructor
     */
    public CrimeFragment(){
        super();
    }

    /**
     * Encapsulating the creation of the CrimeFragment to itself, the CrimeFragment
     * knows nothing about the its host - which is good.
     * @param crimeId
     * @return
     */
    public static CrimeFragment newInstance(UUID crimeId){
        final Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID, crimeId);

        final CrimeFragment crimeFragment = new CrimeFragment();
        crimeFragment.setArguments(args);
        return crimeFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Getting crimeId from fragment argument - central place for store extras for fragments.
        final UUID crimeId = (UUID) getArguments().get(ARG_CRIME_ID);
        mCrime = CrimeLab.getInstance(getActivity()).getCrime(crimeId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_crime, container, false);

        mDateButton = ((Button) v.findViewById(R.id.crime_date));
        mDateButton.setEnabled(false);
        mDateButton.setText(mCrime.getDate().toString());

        mResolved = ((CheckBox) v.findViewById(R.id.crime_resolved));
        mResolved.setChecked(mCrime.isResolved());
        mResolved.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //setting crime if resolved or not.
                mResolved.setChecked(isChecked);
            }
        });

        mTitleField = ((EditText) v.findViewById(R.id.crime_title));
        mTitleField.setText(mCrime.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                CrimeFragment.this.mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return v;
    }

    /**
     * Only the HOST i.e Activity can set the result, a fragment cannot.
     */
    private void returnResults(){
        final Intent result = new Intent();
        result.putExtra("crime_id", mCrime.getId());
        getActivity().setResult(Activity.RESULT_OK, result);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onStop() {
        super.onStop();

    }
}
