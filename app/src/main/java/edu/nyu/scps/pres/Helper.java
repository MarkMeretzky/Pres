package edu.nyu.scps.pres;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by computerlab on 8/9/15.
 */
public class Helper extends SQLiteAssetHelper {

    public Helper(Context context) {
        super(context, "cities.db", null, 1);
    }

    public Cursor getCursor() {
        SQLiteDatabase db = getReadableDatabase();
        //can say "_id, name" instead of "*", but _id must be included.
        Cursor cursor = db.rawQuery("SELECT * FROM presidents ORDER BY lastname, firstname;", null);
        cursor.moveToFirst();
        return cursor;
    }
}
