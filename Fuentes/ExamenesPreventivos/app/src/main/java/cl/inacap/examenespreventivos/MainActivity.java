package cl.inacap.examenespreventivos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText ingresoRut;
    private EditText ingresoContrasena;
    private Button inicioSesionBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.ingresoRut = findViewById(R.id.rut_text);
        this.ingresoContrasena = findViewById(R.id.contrasena_text);
        this.inicioSesionBtn = findViewById(R.id.inicio_sesion_btn);
        this.inicioSesionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String rut = ingresoRut.getText().toString();
                String contrasena = ingresoContrasena.getText().toString();
                try {
                    if (rut.isEmpty()){
                        Toast.makeText(MainActivity.this, "Campo VACIO, debe Ingresar nombre de Usuario", Toast.LENGTH_SHORT).show();
                    }else if (!rutValido(rut)) {
                        Toast.makeText(MainActivity.this, "Nombre de Usuario invalido", Toast.LENGTH_SHORT).show();
                    }

                    //Cantidad
                    if (!rut.isEmpty()){
                        if (rut.length() == 9 ){
                            if (contrasena.equals(rut.substring(3,7))){
                                startActivity(new Intent(MainActivity.this, PrincipalActivity.class ));
                            }
                        }
                    }

                    if (!rut.isEmpty()){
                        if (rut.length() == 10 ){
                            if (contrasena.equals(rut.substring(4,8))){
                                startActivity(new Intent(MainActivity.this, PrincipalActivity.class ));
                            }else{
                                Toast.makeText(MainActivity.this, "Complete la contraseña", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }catch(Exception ex){
                }
            }
        });
    }


    public static Boolean rutValido(String rut) {
        Pattern pattern = Pattern.compile("^[0-9]+-[0-9kK]{1}$");
        Matcher matcher = pattern.matcher(rut);
        if ( matcher.matches() == false ) return false;
        String[] stringRut = rut.split("-");
        return stringRut[1].toLowerCase().equals(MainActivity.digitoVerificador(stringRut[0]));
    }

    public static String digitoVerificador ( String rut ) {
        Integer D=0,S=1,T=Integer.parseInt(rut);
        for (;T!=0;T=(int) Math.floor(T/=10))
            S=(S+T%10*(9-D++%6))%11;
        return ( S > 0 ) ? String.valueOf(S-1) : "k";
    }
}