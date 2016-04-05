package oleg.hubal.com.tm_homework15.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import oleg.hubal.com.tm_homework15.R;

/**
 * Created by User on 29.03.2016.
 */
public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView cardLogin, cardPassword, cardName, cardSurname;

    UserViewHolder(View itemView) {
        super(itemView);

        cardLogin = (TextView) itemView.findViewById(R.id.card_login);
        cardPassword = (TextView) itemView.findViewById(R.id.card_password);
        cardName = (TextView) itemView.findViewById(R.id.card_name);
        cardSurname = (TextView) itemView.findViewById(R.id.card_surname);

        itemView.setOnClickListener(this);
    }

    public void setLoginText(String s) {
        cardLogin.setText("Login: " + s + " ");
    }

    public void setPasswordText(String s) {
        cardPassword.setText("Password: " + s + " ");
    }

    public void setNameText(String s) {
        cardName.setText("Name: " + s + " ");
    }

    public void setSurnameText(String s) {
        cardSurname.setText("Surname: " + s + " ");
    }

    @Override
    public void onClick(View v) {

    }
}
