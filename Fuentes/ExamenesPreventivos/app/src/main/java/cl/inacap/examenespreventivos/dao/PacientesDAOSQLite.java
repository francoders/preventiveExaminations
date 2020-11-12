package cl.inacap.examenespreventivos.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.examenespreventivos.dto.Paciente;
import cl.inacap.examenespreventivos.helpers.PacientesSQLiteHelper;

public class PacientesDAOSQLite implements PacientesDAO {

    private PacientesSQLiteHelper paHelper;

    public PacientesDAOSQLite(Context context){
        this.paHelper = new PacientesSQLiteHelper(context, "PacientesDB", null, 1);
    }

    @Override
    public List<Paciente> getAll() {
        SQLiteDatabase reader = this.paHelper.getReadableDatabase();
        List<Paciente> pacientes = new ArrayList<>();
        try {
            if (reader != null){
                Cursor c = reader.rawQuery("SELECT id, rut, nombre, apellido, fechaExamen, areaTrabajo, sintoma, temperatura, presentaTos" +
                        ",presionArterial FROM pacientes",null);
                if (c.moveToFirst()){
                    do {
                        Paciente p = new Paciente();
                        p.setId(c.getInt(0));
                        p.setRut(c.getString(1));
                        p.setNombre(c.getString(2));
                        p.setApellido(c.getString(3));
                        p.setFechaExamen(c.getString(4));
                        p.setAreaTrabajo(c.getString(5));
                        p.setSintama(c.getString(6));
                        p.setTemperatura(c.getInt(7));
                        p.setPresentaTos(c.getString(8));
                        p.setPresionArterial(c.getInt(9));
                        pacientes.add(p);
                    }while (c.moveToNext());
                }
                reader.close();
            }
        }catch (Exception ex){
            pacientes = null;
        }
        return pacientes;
    }

    @Override
    public Paciente save(Paciente p) {
        SQLiteDatabase writer = this.paHelper.getWritableDatabase();
        String sql = String.format("INSERT INTO pacientes(rut, nombre, apellido, fechaExamen, areaTrabajo, sintoma, temperatura, presentaTos, presionArterial )"+
                "VALUES('%s','%s','%s','%s','%s','%s','%.2f','%s','%d')", p.getRut(), p.getNombre(), p.getApellido(), p.getFechaExamen(), p.getAreaTrabajo()
                , p.getSintama(), p.getTemperatura(), p.getPresentaTos(), p.getPresionArterial());
        writer.execSQL(sql);
        writer.close();
        return p;
    }
}