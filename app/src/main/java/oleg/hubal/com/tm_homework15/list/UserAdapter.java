package oleg.hubal.com.tm_homework15.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import oleg.hubal.com.tm_homework15.R;
import oleg.hubal.com.tm_homework15.User;

/**
 * Created by User on 29.03.2016.
 */
public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private ArrayList<User> users;


    public UserAdapter(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_card, parent, false);

        UserViewHolder userViewHolder = new UserViewHolder(v);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.setLoginText(users.get(position).getLogin());
        holder.setPasswordText(users.get(position).getPassword());
        holder.setNameText(users.get(position).getName());
        holder.setSurnameText(users.get(position).getSurname());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
