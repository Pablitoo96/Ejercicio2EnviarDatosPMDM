package pablo.maruottolo.ejercicio2enviardatospmdm.actividades;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

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