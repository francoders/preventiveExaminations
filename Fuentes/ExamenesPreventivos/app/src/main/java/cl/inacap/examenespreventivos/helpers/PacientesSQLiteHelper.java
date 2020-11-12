package cl.inacap.examenespreventivos.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PacientesSQLiteHelper extends SQLiteOpenHelper {

    private final String sqlCreate = "CREATE TABLE pacientes(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL " +
            ",rut TEXT" +
            ",nombre TEXT" +
            ",apellido TEXT" +
            ",fechaExamen TEXT" +
            ",areaTrabajo TEXT" +
            ",sintoma TEXT" +
            "temperatura REAL" +
            ",presentaTos TEXT" +
            ",presionArterial INTEGER)";


    public PacientesSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //1
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
