package criminal.com.criminalintent.model;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Created by khayapro on 2016/05/09.
 */
public class Crime {

    private UUID mId;
    private String mTitle;
    private boolean mResolved;
    private Date mDate;

    public Crime(){
        super();
        mId = UUID.randomUUID();
        mDate = Calendar.getInstance().getTime();
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public boolean isResolved() {
        return mResolved;
    }

    public void setResolved(boolean resolved) {
        mResolved = resolved;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }
}
