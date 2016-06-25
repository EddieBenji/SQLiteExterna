package ecanche.apps.sqliteexterna;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lalo
 * Date: 25/06/16
 * Project: SQLiteExterna
 */
public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;

    private static DatabaseAccess instance;

    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    public void close() {
        if (database != null) {
            database.close();
        }
    }

    public List<String> getCodesFromDB() {
        this.open();
        List<String> codes = this.getCodes();
        this.close();
        return codes;
    }

    private List<String> getCodes() {
        List<String> list = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT d_asenta || '-' || d_codigo FROM yucatan", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        return list;
    }

    public List<PostalCode> getPostalCodesObject() {
        this.open();
        List<PostalCode> helper = this.getPostalsObject();
        this.close();
        return helper;

    }

    private List<PostalCode> getPostalsObject() {
        List<PostalCode> list = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT d_asenta, d_tipo_asenta, d_codigo FROM yucatan", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            int imageID = R.drawable.thanos;
            if (cursor.getString(1).equalsIgnoreCase("colonia")) {
                imageID = R.drawable.apple;
            } else if (cursor.getString(1).equalsIgnoreCase("ampliación")) {
                imageID = R.drawable.ipad;
            } else if (cursor.getString(1).equalsIgnoreCase("fraccionamiento")) {
                imageID = R.drawable.rmadrid;
            }
            list.add(new PostalCode(cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    imageID)
            );
            cursor.moveToNext();
        }
        return list;
    }

    public List<String> getCodesByCodeFromDB(String code) {
        this.open();
        List<String> codes = this.getCodesByCode(code);
        this.close();
        return codes;
    }

    private List<String> getCodesByCode(String filter) {

        List<String> list = new ArrayList<>();

        String[] columns = {"d_codigo", "d_asenta"};
        String[] filters = {"%" + filter + "%"};

        Cursor cursor = database.query("yucatan", columns, "d_codigo LIKE ? OR d_asenta LIKE ?", filters,
                null, null, null);

//        Cursor cursor = database.rawQuery("SELECT d_codigo || '-' || d_asenta FROM yucatan WHERE d_codigo LIKE '%" + code +"%'",
//                null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0) + "-" + cursor.getString(1));
            cursor.moveToNext();
        }
        return list;
    }


}
