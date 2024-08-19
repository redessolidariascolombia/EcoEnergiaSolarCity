package unal.todosalau.ahorravoltios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServiceRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_register);
        Button botonRegresar = findViewById(R.id.botonRetroceso);
        Button botonConsejo = findViewById(R.id.botonAdvices);
        Button btnCentros = findViewById(R.id.buttonCentros);
        Button btnCanchas = findViewById(R.id.buttonCanchas);
        Button btnParques = findViewById(R.id.buttonParques);

        Intent intent1 = new Intent(this, Principal.class);
        Intent intent2 = new Intent(this, ServiceRegisterItem1.class);
        Intent intent3 = new Intent(this, ServiceRegisterItem2.class);
        Intent intent4 = new Intent(this, ServiceRegisterItem3.class);
        Intent intent5 = new Intent(this, Advice.class);

        //Boton Regresar
        botonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent1);
            }
        });


        //Boton Registro de Centros Deportivos
        btnCentros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent2);
            }
        });

        //Boton Registro de Canchas
        btnCanchas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent3);
            }
        });

        //Boton Registro de Parques
        btnParques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent4);
            }
        });
        /**
         * Botón para Consejos
         */
        botonConsejo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent5);
            }
        });
    }
}