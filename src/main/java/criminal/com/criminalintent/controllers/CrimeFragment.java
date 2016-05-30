package criminal.com.criminalintent.controllers;

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

    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mResolved;



    public Crime getCrime() {
        return mCrime;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime = new Crime();

        //configure instance fragment here.
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Easy way to get extra using current activity.
        final Intent intent = getActivity().getIntent();
        final UUID crimeId = (UUID) intent.getSerializableExtra(CrimeActivity.EXTRA_CRIM_ID);
        this.mCrime = CrimeLab.getInstance(getActivity()).getCrime(crimeId);


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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
