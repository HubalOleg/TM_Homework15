package oleg.hubal.com.tm_homework15.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import oleg.hubal.com.tm_homework15.Constants;
import oleg.hubal.com.tm_homework15.R;

/**
 * Created by User on 05.04.2016.
 */
public class SettingsFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button btnSave;
    private RadioGroup rgOrderGroup;
    private RadioButton rbLogin, rbPassword, rbName, rbSurname;
    private String orderBy;
    private SharedPreferences sPref;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle sabedInstanceState) {
        view = inflater.inflate(R.layout.fragment_settings, container, false);

        sPref = getActivity().getPreferences(Context.MODE_PRIVATE);

        initViews();
        loadSettings();

        return view;
    }

    private void initViews() {
        btnSave = (Button) view.findViewById(R.id.btn_save_settings);
        rgOrderGroup = (RadioGroup) view.findViewById(R.id.rg_order_group);

        rbLogin = (RadioButton) view.findViewById(R.id.rb_by_login);
        rbPassword = (RadioButton) view.findViewById(R.id.rb_by_password);
        rbName = (RadioButton) view.findViewById(R.id.rb_by_name);
        rbSurname = (RadioButton) view.findViewById(R.id.rb_by_surname);

        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (rgOrderGroup.getCheckedRadioButtonId()) {
            case R.id.rb_by_login:
                orderBy = Constants.DB_LOGIN;
                break;
            case R.id.rb_by_password:
                orderBy = Constants.DB_PASSWORD;
                break;
            case R.id.rb_by_name:
                orderBy = Constants.DB_USERNAME;
                break;
            case R.id.rb_by_surname:
                orderBy = Constants.DB_USERSURNAME;
                break;
        }

        saveSettings();
    }

    private void saveSettings() {
        SavePrefTask savePrefTask = new SavePrefTask();
        savePrefTask.execute(orderBy);
    }

    private void loadSettings() {
        LoadPrefTask loadPrefTask = new LoadPrefTask();
        loadPrefTask.execute();
    }

    private void setCheck() {
        switch (orderBy) {
            case Constants.DB_LOGIN:
                rbLogin.setChecked(true);
                break;
            case Constants.DB_PASSWORD:
                rbPassword.setChecked(true);
                break;
            case Constants.DB_USERNAME:
                rbName.setChecked(true);
                break;
            case Constants.DB_USERSURNAME:
                rbSurname.setChecked(true);
                break;
        }
    }

    class SavePrefTask extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... params) {
            SharedPreferences.Editor ed = sPref.edit();
            ed.putString(Constants.PREFERENCES_ORDER_KEY, params[0]);
            ed.apply();
            return null;
        }
    }

    class LoadPrefTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            return sPref.getString(Constants.PREFERENCES_ORDER_KEY, Constants.DB_USERNAME);
        }

        @Override
        protected void onPostExecute(String result) {
            orderBy = result;
            setCheck();
        }
    }
}
