package oleg.hubal.com.tm_homework15.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import oleg.hubal.com.tm_homework15.R;

/**
 * Created by User on 27.03.2016.
 */
public class AboutFragment extends Fragment {

    private View view;
    private TextView aboutText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle sabedInstanceState) {
        view = inflater.inflate(R.layout.fragment_about, container, false);

        initViews();
        setText();

        return view;
    }

    private void setText() {
        StringBuilder sb = new StringBuilder();
        InputStream inputStream = getResources().openRawResource(R.raw.about_info);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;

        try {
            try {
                line = reader.readLine();
                while (line != null) {
                    sb.append(line);
                    line = reader.readLine();
                }
            } finally {
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        aboutText.setText(sb.toString());
    }

    private void initViews() {
        aboutText = (TextView) view.findViewById(R.id.tv_about);
    }


}
