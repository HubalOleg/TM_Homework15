package oleg.hubal.com.tm_homework15.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import oleg.hubal.com.tm_homework15.R;
import oleg.hubal.com.tm_homework15.list.UserListFragment;

/**
 * Created by User on 13.03.2016.
 */
public class SignInFragment extends Fragment implements View.OnClickListener {

    private View view;
    private Button btnReg, btnList, btnSettings, btnAbout;


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        initView();

        return view;
    }

    private void initView() {
        btnReg      = (Button) view.findViewById(R.id.btn_register);
        btnList     = (Button) view.findViewById(R.id.btn_show);
        btnSettings = (Button) view.findViewById(R.id.btn_preference);
        btnAbout    = (Button) view.findViewById(R.id.btn_about);

        btnReg.setOnClickListener(this);
        btnSettings.setOnClickListener(this);
        btnList.setOnClickListener(this);
        btnAbout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_register:
                openFragment(new RegFragment());
                break;
            case R.id.btn_show:
                openFragment(new UserListFragment());
                break;
            case R.id.btn_preference:
                openFragment(new SettingsFragment());
                break;
            case R.id.btn_about:
                openFragment(new AboutFragment());
                break;
        }
    }

    private void openFragment(Fragment fragment) {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frgm_container_AM, fragment)
                .addToBackStack(null)
                .commit();
    }

}
