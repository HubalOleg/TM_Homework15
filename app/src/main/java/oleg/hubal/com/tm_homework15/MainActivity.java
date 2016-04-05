package oleg.hubal.com.tm_homework15;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import oleg.hubal.com.tm_homework15.database.DatabaseHeadlessFragment;
import oleg.hubal.com.tm_homework15.fragments.AboutFragment;
import oleg.hubal.com.tm_homework15.fragments.SignInFragment;
import oleg.hubal.com.tm_homework15.list.UserListFragment;

public class MainActivity extends AppCompatActivity {

    private SignInFragment signInFragment;
    private DatabaseHeadlessFragment dbFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragment();

        if (savedInstanceState == null) {
            commitSignInFragment();
            commitDBHeadlessFragment();
        }
    }

    private void commitDBHeadlessFragment() {
        dbFragment = new DatabaseHeadlessFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(dbFragment, Constants.DB_HEADLESS_TAG)
                .commit();
    }

    private void initFragment() {
        signInFragment = new SignInFragment();
    }

    private void commitSignInFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frgm_container_AM, signInFragment)
                .addToBackStack(null)
                .commit();
    }
}
