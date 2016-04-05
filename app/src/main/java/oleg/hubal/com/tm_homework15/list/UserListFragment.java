package oleg.hubal.com.tm_homework15.list;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import oleg.hubal.com.tm_homework15.Constants;
import oleg.hubal.com.tm_homework15.database.DatabaseHeadlessFragment;
import oleg.hubal.com.tm_homework15.database.DatabaseHelper;
import oleg.hubal.com.tm_homework15.R;
import oleg.hubal.com.tm_homework15.User;
import oleg.hubal.com.tm_homework15.loader.DatabaseLoader;

/**
 * Created by User on 27.03.2016.
 */
public class UserListFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private View view;
    private ArrayList<User> users;
    private SQLiteDatabase database;
    private RecyclerView userList;
    private UserAdapter userAdapter;
    private DatabaseHeadlessFragment dbHeadless;
    private DatabaseHelper dbHelper;
    private SharedPreferences sPref;
    private String orderBy = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle sabedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, container, false);

        users = new ArrayList<>();
        openDatabase();
        readSettings();
        getActivity().getSupportLoaderManager().initLoader(0, null, this);

        createList();
        return view;

    }

    private void readSettings() {
        sPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        orderBy = sPref.getString(Constants.PREFERENCES_ORDER_KEY, null);
    }


    private void openDatabase() {
        dbHeadless = (DatabaseHeadlessFragment) getFragmentManager().findFragmentByTag(Constants.DB_HEADLESS_TAG);
        dbHelper = dbHeadless.getDatabase();
        database = dbHelper.getWritableDatabase();
    }

    private void createList() {

        userList = (RecyclerView) view.findViewById(R.id.list_container);
        userList.setHasFixedSize(true);

        LinearLayoutManager layoutMangager = new LinearLayoutManager(getContext());
        userList.setLayoutManager(layoutMangager);

        userAdapter = new UserAdapter(users);
        userList.setAdapter(userAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new DatabaseLoader(getContext(), database, orderBy);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        users = getList(data);
    }


    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
    }

    private ArrayList<User> getList(Cursor c) {

        ArrayList<User> arrayList = new ArrayList<>();

        if(c != null) {
            if (c.moveToFirst()) {
                int loginColIndex = c.getColumnIndex(Constants.DB_LOGIN);
                int passwordColIndex = c.getColumnIndex(Constants.DB_PASSWORD);
                int nameColIndex = c.getColumnIndex(Constants.DB_USERNAME);
                int surnameColIndex = c.getColumnIndex(Constants.DB_USERSURNAME);

                do {
                    String login = c.getString(loginColIndex);
                    String password = c.getString(passwordColIndex);
                    String name = c.getString(nameColIndex);
                    String surname = c.getString(surnameColIndex);
                    arrayList.add(new User(login, password, name, surname));
                } while (c.moveToNext());
            }
        }

        return arrayList;
    }
}
