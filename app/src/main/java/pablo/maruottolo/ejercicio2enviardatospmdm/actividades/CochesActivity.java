package pablo.maruottolo.ejercicio2enviardatospmdm.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pablo.maruottolo.ejercicio2enviardatospmdm.R;
import pablo.maruottolo.ejercicio2enviardatospmdm.modelos.Coche;

public class CochesActivity extends AppCompatActivity {

    private EditText txtMarca;
    private EditText txtModelo;
    private EditText txtColor;
    private Button btnCancelar;
    private Button btnCrear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coches);

        inicializarVariables();


        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Recoger la info de los editText
                String marca = txtMarca.getText().toString();
                String modelo = txtModelo.getText().toString();
                String color = txtColor.getText().toString();

                //Comprobar si esta toda la informacion
                if(marca.isEmpty() || modelo.isEmpty() || color.isEmpty()){
                    Toast.makeText(CochesActivity.this, "FALTAN DATOS",Toast.LENGTH_LONG).show();
                }else {
                    //Crear un objeto coche con esta info
                    Coche coche = new Coche(marca,modelo,color);
                    //Lo meto en la maleta(bundle) y la maleta en el maletero del coche(Intent)
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("COCHE",coche);

                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    //Informar resultado exitoso
                    setResult(RESULT_OK, intent);
                    //Fin
                    finish();
                    //Si no esta aviso y espero a que la rellene
                }
            }
        });
    }

    private void inicializarVariables() {
        txtMarca = findViewById(R.id.txtMarcaCoche);
        txtModelo = findViewById(R.id.txtModeloCoche);
        txtColor = findViewById(R.id.txtColorCoche);

        btnCrear = findViewById(R.id.btnCrearCoches);
        btnCancelar = findViewById(R.id.btnCancelarCoche);
    }
}