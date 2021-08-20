package cl.inacap.examenespreventivos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

import cl.inacap.examenespreventivos.dto.Paciente;

public class VerPacientesActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView rut_paciente;
    private TextView nombre_paciente;
    private TextView apellido_paciente;
    private TextView calendario_registro;
    private TextView areaTrabajo_paciente;
    private TextView sintoma_paciente;
    private TextView temperatura_paciente;
    private TextView presentaTos_paciente;
    private TextView presionArterial_paciente;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_pacientes);

        this.toolbar = findViewById(R.id.toolbar);
        this.nombre_paciente = findViewById(R.id.nombrePaciente);
        this.apellido_paciente = findViewById(R.id.apellidoPaciente);
        this.rut_paciente = findViewById(R.id.rutPaciente);
        this.calendario_registro = findViewById(R.id.calendarioPaciente);
        this.presionArterial_paciente = findViewById(R.id.presionArterialPaciente);
        this.presentaTos_paciente = findViewById(R.id.presentaTosPaciente);
        this.sintoma_paciente = findViewById(R.id.sintomaPaciente);
        this.areaTrabajo_paciente = findViewById(R.id.areaTrabajoPaciente);
        this.temperatura_paciente = findViewById(R.id.temperaturaPaciente);

        this.setSupportActionBar(this.toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);

        if (getIntent() != null){
            Paciente paciente = (Paciente)getIntent().getSerializableExtra("paciente");
            this.rut_paciente.setText(paciente.getRut());
            this.nombre_paciente.setText(paciente.getNombre());
            this.apellido_paciente.setText(paciente.getApellido());
            this.calendario_registro.setText(paciente.getFechaExamen());
            this.sintoma_paciente.setText(paciente.getSintama());
            this.presentaTos_paciente.setText(paciente.getPresentaTos());
            this.presionArterial_paciente.setText(""+paciente.getPresionArterial());
            this.temperatura_paciente.setText(""+paciente.getTemperatura());
            this.areaTrabajo_paciente.setText(paciente.getAreaTrabajo());
        }
    }
}