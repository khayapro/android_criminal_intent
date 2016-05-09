package criminal.com.criminalintent.model;

import java.util.UUID;

/**
 * Created by khayapro on 2016/05/09.
 */
public class Crime {

    private UUID mId;
    private String mTitle;

    public Crime(){
        super();
        //generating a random unique id number.
        mId = UUID.randomUUID();
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
}
