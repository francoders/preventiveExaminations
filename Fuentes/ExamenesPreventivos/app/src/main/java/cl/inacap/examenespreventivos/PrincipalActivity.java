package cl.inacap.examenespreventivos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        pacientes = pacientesDAO.getAll();
        adaptador = new PacientesArrayAdapter(this, R.layout.pacientes_list, pacientes);
        pacientesLv = findViewById(R.id.pacientes_lv);
        pacientesLv.setAdapter(adaptador);
        this.setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
    }
}