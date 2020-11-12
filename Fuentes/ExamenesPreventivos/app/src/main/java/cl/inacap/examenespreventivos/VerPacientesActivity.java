package cl.inacap.examenespreventivos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

public class VerPacientesActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView reg_rutTxt;
    private TextView reg_nombreTxt;
    private TextView reg_apellidoTxt;
    private TextView reg_calendarioBtn;
    private TextView reg_areaTrabajoSp;
    private TextView reg_sintomaSw;
    private TextView reg_presentaTosSw;
    private TextView reg_temperaturaTxt;
    private TextView reg_presionArterialTxt;

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
        this.setSupportActionBar(this.toolbar);

    }
}