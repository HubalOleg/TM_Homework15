package oleg.hubal.com.tm_homework15.loader;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.content.CursorLoader;

import oleg.hubal.com.tm_homework15.Constants;

/**
 * Created by User on 05.04.2016.
 */
public class DatabaseLoader extends CursorLoader {

    private SQLiteDatabase db;
    private String orderBy;

    public DatabaseLoader(Context context, SQLiteDatabase db, String orderBy) {
        super(context);

        this.db = db;
        this.orderBy = orderBy;
    }

    @Override
    public Cursor loadInBackground() {
        return db.query(Constants.DB_TABLE, null, null, null, null, null, orderBy);
    }
}
