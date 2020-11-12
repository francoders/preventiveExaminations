package cl.inacap.examenespreventivos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

import cl.inacap.examenespreventivos.adapters.PacientesArrayAdapter;
import cl.inacap.examenespreventivos.dao.PacientesDAO;
import cl.inacap.examenespreventivos.dao.PacientesDAOLista;
import cl.inacap.examenespreventivos.dto.Paciente;


public class PrincipalActivity extends AppCompatActivity {

    private ListView pacientesLv; //LV
    private List<Paciente> pacientes;
    private PacientesArrayAdapter adaptador;
    private PacientesDAO pacientesDAO = PacientesDAOLista.getInstance();
    private ImageView agregarPaciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        pacientes = pacientesDAO.getAll();
        adaptador = new PacientesArrayAdapter(this, R.layout.pacientes_list, pacientes);
        pacientesLv = findViewById(R.id.pacientes_lv);
        pacientesLv.setAdapter(adaptador);
        pacientesLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentPaciente = new Intent(PrincipalActivity.this, VerPacientesActivity.class);
                startActivity(intentPaciente);
            }
        });
        agregarPaciente = findViewById(R.id.agregar_paciente);

        this.setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
    }
}