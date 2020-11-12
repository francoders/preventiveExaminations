package cl.inacap.examenespreventivos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import cl.inacap.examenespreventivos.adapters.PacientesArrayAdapter;

import cl.inacap.examenespreventivos.dao.PacientesDAO;
import cl.inacap.examenespreventivos.dao.PacientesDAOSQLite;
import cl.inacap.examenespreventivos.dto.Paciente;


public class PrincipalActivity extends AppCompatActivity {

    private FloatingActionButton agregarPacienteBtn;
    private Toolbar toolbar;
    private ListView pacientesLv; //LV
    private List<Paciente> pacientes;
    private PacientesArrayAdapter adaptador;
    private PacientesDAO pacientesDAO = new PacientesDAOSQLite(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        this.setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        this.toolbar = findViewById(R.id.toolbar);
        this.agregarPacienteBtn = findViewById(R.id.agregarBtnFloat);
        this.agregarPacienteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrincipalActivity.this, RegistroDePacienteActivity.class));
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        pacientes = pacientesDAO.getAll();
        adaptador = new PacientesArrayAdapter(this, R.layout.pacientes_list, pacientes);
        pacientesLv = findViewById(R.id.pacientes_lv);
        pacientesLv.setAdapter(adaptador);
        pacientesLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(PrincipalActivity.this, VerPacientesActivity.class);
                Paciente actual = pacientes.get(i);
                intent.putExtra("paciente",actual);
                startActivity(intent);
            }
        });

    }
}