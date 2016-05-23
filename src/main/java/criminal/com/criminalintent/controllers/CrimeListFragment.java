package criminal.com.criminalintent.controllers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import criminal.com.criminalintent.R;
import criminal.com.criminalintent.model.Crime;
import criminal.com.criminalintent.model.CrimeLab;


/**
 * Created by khayapro on 2016/05/19.
 *
 */
public class CrimeListFragment extends Fragment {

    /**
     * This will communicate with CrimeAdapter when CrimeHolder needs to be created,
     * or connected to the Crime object. NB
     */
    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        final View v = inflater.inflate(R.layout.fragment_crime_list, container, false);
        mCrimeRecyclerView = (RecyclerView) v.findViewById(R.id.crime_recycler_view);
        //setting my layout manager
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return mCrimeRecyclerView;
    }

    /** No. 1
     * The view holder maintains reference to a single view object, it cannot
     * handle more responsibility otherwise it will crash. NB.
     */
    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mTitleTextView;
        private TextView mDateTextView;
        private CheckBox mSolved;
        private Crime mCrime;

        public CrimeHolder(View itemView) {
            super(itemView);
            mTitleTextView = ((TextView) itemView.findViewById(R.id.list_item_crime_title_text));
            mDateTextView = ((TextView) itemView.findViewById(R.id.list_item_crime_date_txt_view));
            mSolved = ((CheckBox) itemView.findViewById(R.id.list_item_crime_solved_chk));
        }

        /**
         * Binding / mapping the values of crime to their respective views.
         * @param crime
         */
        public void bindCrime(Crime crime) {
            mCrime = crime;
            mTitleTextView.setText(crime.getTitle());
            mDateTextView.setText(crime.getDate().toString());
            mSolved.setChecked(crime.isResolved());
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(), mCrime.getTitle() + " Clicked!", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    /**No. 2
     * This adapter knows everything about the Crime object and details.
     */
    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {

        private List<Crime> mCrimes;

        public CrimeAdapter(List<Crime> crimes){
            mCrimes = crimes;
        }

        /**
         * Called by the RecyclerView when it needs a new view to display and item.
         * @param parent
         * @param viewType
         * @return
         */
        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            final LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            //using my own layout view.
            final View view = layoutInflater.inflate(R.layout.list_item_crime, parent, false);
            return new CrimeHolder(view);
        }

        /**
         * Binds the ViewHolder's view to the model object, use the position to get the object
         * and map the value to the holders view.
         * @param holder
         * @param position
         */
        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {
            final Crime crime = mCrimes.get(position);
            holder.bindCrime(crime);
        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }

    public void updateUI(){
        CrimeLab crimeLab = CrimeLab.getInstance(getActivity());
        mAdapter = new CrimeAdapter(crimeLab.getCrimes());
        //Setting my adapter
        mCrimeRecyclerView.setAdapter(mAdapter);
    }
}
