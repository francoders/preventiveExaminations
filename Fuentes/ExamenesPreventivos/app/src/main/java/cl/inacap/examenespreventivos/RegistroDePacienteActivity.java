package cl.inacap.examenespreventivos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cl.inacap.examenespreventivos.dao.PacientesDAO;
import cl.inacap.examenespreventivos.dao.PacientesDAOSQLite;
import cl.inacap.examenespreventivos.dto.Paciente;

public class RegistroDePacienteActivity extends AppCompatActivity {

    private PacientesDAO pacientesDAO = new PacientesDAOSQLite(this);
    private List<Paciente> pacientes = new ArrayList<>();

    private Toolbar toolbar;
    private EditText rut_paciente;
    private EditText nombre_paciente;
    private EditText apellido_paciente;
    private Button calendario_paciente;
    private int dia,mes,ano;
    private Spinner areaTrabajo_paciente;
    private Switch sintoma_paciente;
    private EditText temperatura_paciente;
    private Switch presentaTos_paciente;
    private EditText presionArterial_paciente;
    private Button agregarBtn;
    private ArrayAdapter<Paciente> adapter;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();//
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_de_paciente);
        this.toolbar = findViewById(R.id.toolbar);
        this.rut_paciente = findViewById(R.id.reg_rutTxt);
        this.nombre_paciente = findViewById(R.id.reg_nombreTxt);
        this.apellido_paciente = findViewById(R.id.reg_apellidoTxt);
        this.calendario_paciente = findViewById(R.id.reg_calendarioBtn);
        this.areaTrabajo_paciente = findViewById(R.id.reg_areaTrabajoSp);
        this.sintoma_paciente = findViewById(R.id.reg_sintomaSw);
        this.temperatura_paciente = findViewById(R.id.reg_temperaturaTxt);
        this.presentaTos_paciente = findViewById(R.id.reg_presentaTosSw);
        this.presionArterial_paciente = findViewById(R.id.reg_presionArterialTxt);
        this.agregarBtn = findViewById(R.id.crear_btn);
        this.adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, pacientes);
        this.setSupportActionBar(this.toolbar);
        //I___________________________
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);

        String [] areaTrabajo= {"Atencion a publico", "Otros"};
        ArrayAdapter <String> adapterTipo = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, areaTrabajo);
        areaTrabajo_paciente.setAdapter(adapterTipo);
        this.agregarBtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                List<String> errores = new ArrayList<>();
                String nombre = nombre_paciente.getText().toString().trim();
                String apellido = apellido_paciente.getText().toString().trim();
                String rut = rut_paciente.getText().toString().trim();
                String fecha = calendario_paciente.getText().toString();
                String temperaturaStr = temperatura_paciente.getText().toString().trim();
                String areaTrabajo = areaTrabajo_paciente.getSelectedItem().toString();


                int temperatura = 0;
                if (nombre.isEmpty()){
                    errores.add("Ingrese el nombre");
                }
                if (apellido.isEmpty()){
                    errores.add("Ingrese el apellido");
                }
                if (validaRut(rut)==false){
                    errores.add("ingrese el rut");
                }
                if (fecha.isEmpty()){
                    errores.add("fecha valida");
                }

                try {
                    temperatura = Integer.parseInt(temperaturaStr);
                    if (temperatura<20){
                        throw new NumberFormatException();
                    }
                }catch (NumberFormatException ex){
                    errores.add("Falta temperatura");
                }
                if (areaTrabajo.equals("Seleccione uno")){
                    errores.add(" Debe seleccionar: ");
                }


                try {
                    if (errores.isEmpty()){
                        Paciente p = new Paciente();
                        p.setNombre(nombre_paciente.getText().toString());
                        p.setApellido(apellido_paciente.getText().toString());
                        p.setRut(rut_paciente.getText().toString());
                        p.setFechaExamen(calendario_paciente.getText().toString());
                        p.setAreaTrabajo(areaTrabajo_paciente.getSelectedItem().toString());
                        p.setTemperatura(Float.parseFloat(temperatura_paciente.getText().toString()));
                        p.setPresionArterial(Integer.parseInt(presionArterial_paciente.getText().toString()));
                        p.setSintama(sintoma_paciente.getText().toString());
                        p.setPresentaTos(presentaTos_paciente.getText().toString());


                        if(sintoma_paciente.isChecked()){
                            p.setSintama("Si");
                        }else{
                            p.setSintama("No");
                        }
                        if(presentaTos_paciente.isChecked()){
                            p.setPresentaTos("Si");
                        }else{
                            p.setPresentaTos("No");
                        }
                        pacientesDAO.save(p);
                        startActivity(new Intent(RegistroDePacienteActivity.this, PrincipalActivity.class));
                    }else{
                        mostrarErrores(errores);
                    }
                }catch(Exception ex){
                }
            }


            private boolean validaRut(String rut) {
                Pattern pattern = Pattern.compile("^[0-9]+-[0-9kK]{1}$");
                Matcher matcher = pattern.matcher(rut);
                if ( matcher.matches() == false ) return false;
                String[] stringRut = rut.split("-");
                return stringRut[1].toLowerCase().equals(RegistroDePacienteActivity.digitoVerificador(stringRut[0]));
            }
        });
    }


    public static String digitoVerificador ( String rut ) {
        Integer M=0,S=1,T=Integer.parseInt(rut);
        for (;T!=0;T=(int) Math.floor(T/=10))
            S=(S+T%10*(9-M++%6))%11;
        return ( S > 0 ) ? String.valueOf(S-1) : "k";
    }

    public void mostrarErrores(List<String> errores){
        String mensaje = "";
        for (String e: errores) {
            mensaje += "-" + e + "\n";
        }
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(RegistroDePacienteActivity.this);
        alertBuilder.setTitle("Error de validación")
                .setMessage(mensaje)
                .setPositiveButton("Aceptar", null)
                .show();
    }

    public void onClick(View v) {
        if (v == calendario_paciente){
            final Calendar cal = Calendar.getInstance();
            dia = cal.get(Calendar.DAY_OF_MONTH);
            mes = cal.get(Calendar.MONTH);
            ano = cal.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    calendario_paciente.setText(dayOfMonth + "/" + (month+1) + "/" + year);
                }
            }
                    ,dia,mes,ano);
            datePickerDialog.show();
        }
    }
}
