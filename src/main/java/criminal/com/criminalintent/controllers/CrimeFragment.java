package criminal.com.criminalintent.controllers;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import criminal.com.criminalintent.R;
import criminal.com.criminalintent.model.Crime;

public class CrimeFragment extends Fragment {

    private Crime mCrime;
    private EditText mTitleField;
    private TextView mTitleView;
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
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_crime, container, false);

        mDateButton = ((Button) v.findViewById(R.id.crime_date));
        mDateButton.setEnabled(false);
        mDateButton.setText(mCrime.getTitle());

        mResolved = ((CheckBox) v.findViewById(R.id.crime_resolved));
        mResolved.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //setting crime if resolved or not.
                mResolved.setChecked(isChecked);
            }
        });

        mTitleView = ((TextView) v.findViewById(R.id.title_view));
        mTitleField = ((EditText) v.findViewById(R.id.crime_title));
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
                mTitleView.setText(s.toString());
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
