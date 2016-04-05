package oleg.hubal.com.tm_homework15.fragments;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import oleg.hubal.com.tm_homework15.Constants;

/**
 * Created by User on 15.03.2016.
 */
public class GreetingDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        String user = bundle.getString(Constants.GREETING_BUNDLE_TAG);

        return new AlertDialog
                .Builder(getActivity())
                .setIcon(android.R.drawable.ic_btn_speak_now)
                .setMessage("user" + "\n" + user + "\n" + "added")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
    }
}
