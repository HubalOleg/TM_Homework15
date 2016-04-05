package oleg.hubal.com.tm_homework15.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import oleg.hubal.com.tm_homework15.Constants;

/**
 * Created by User on 27.03.2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +
                Constants.DB_TABLE + " (" +
                Constants.DB_LOGIN + " TEXT, " +
                Constants.DB_PASSWORD + " TEXT, " +
                Constants.DB_USERNAME + " TEXT, " +
                Constants.DB_USERSURNAME + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
