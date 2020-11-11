package cl.inacap.examenespreventivos.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import cl.inacap.examenespreventivos.R;
import cl.inacap.examenespreventivos.dto.Paciente;

public class PacientesArrayAdapter extends ArrayAdapter<Paciente> {
    private Activity activity;
    private List<Paciente> pacientes;
    public PacientesArrayAdapter(@NonNull Activity context, int resource, @NonNull List<Paciente> objects) {
        super(context, resource, objects);
        this.activity = context;
        this.pacientes = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.activity.getLayoutInflater();
        View fila = inflater.inflate(R.layout.pacientes_list, null, true);
        ImageView imagenVie = fila.findViewById(R.id.imagen_sintoma_lv);
        TextView nombreTv = fila.findViewById(R.id.nombre_lv);
        Paciente actual = pacientes.get(position);
        nombreTv.setText(actual.getNombre());
        return fila;
    }
}
