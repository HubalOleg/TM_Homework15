package oleg.hubal.com.tm_homework15.database;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by User on 27.03.2016.
 */
public class DatabaseHeadlessFragment extends Fragment {

    private DatabaseHelper mDbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setRetainInstance(true);

        mDbHelper = new DatabaseHelper(getContext());

        return null;
    }

    public DatabaseHelper getDatabase() {
        return mDbHelper;
    }
}
