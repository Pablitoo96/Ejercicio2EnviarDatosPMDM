package pablo.maruottolo.ejercicio2enviardatospmdm.actividades;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import pablo.maruottolo.ejercicio2enviardatospmdm.R;
import pablo.maruottolo.ejercicio2enviardatospmdm.modelos.Bici;
import pablo.maruottolo.ejercicio2enviardatospmdm.modelos.Coche;
import pablo.maruottolo.ejercicio2enviardatospmdm.modelos.Moto;

public class MainActivity extends AppCompatActivity {

    //ATRIBUTOS DE LA VISTA
    private TextView txtCantidadCoches;
    private TextView txtCantidadMotos;
    private TextView txtCantidadBicis;
    private Button btnCrearCoche;
    private Button btnCrearMoto;
    private Button btnCrearBici;


    //ATRIBUTOS DE LA LOGICA
    private ArrayList<Coche>listaCoche;
    private ArrayList<Moto>listaMoto;
    private ArrayList<Bici>listaBici;

    //ATRIBUTO PARA LOS LAUCHERS

    private ActivityResultLauncher<Intent> laucherCoches;
    private ActivityResultLauncher<Intent> laucherMotos;
    private ActivityResultLauncher<Intent> laucherBicis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVariables();

        btnCrearCoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                laucherCoches.launch(new Intent(MainActivity.this,CochesActivity.class));
            }
        });

        laucherCoches = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == RESULT_OK){
                            if(result.getData() != null && result.getData().getExtras() != null){
                                Coche coche = (Coche) result.getData().getExtras().getSerializable("COCHE");
                                listaCoche.add(coche);
                                txtCantidadCoches.setText("COCHES: " + listaCoche.size());
                            }else{
                                Toast.makeText(MainActivity.this,"No se han pasado los datos",Toast.LENGTH_LONG).show();
                            }
                        }else{
                            Toast.makeText(MainActivity.this,"VENTANA CENCELADA",Toast.LENGTH_LONG).show();
                        }

                    }
                }
        );
    }



    private void inicializarVariables() {
        txtCantidadCoches = findViewById(R.id.txtContarCoches);
        txtCantidadMotos = findViewById(R.id.txtContarMotos);
        txtCantidadBicis = findViewById(R.id.txtContarBicis);

        btnCrearCoche = findViewById(R.id.btnCrearCoche);
        btnCrearMoto = findViewById(R.id.btnCrearMoto);
        btnCrearBici = findViewById(R.id.btnCrearBici);

    }
}