package unal.todosalau.ahorravoltios;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

import unal.todosalau.ahorravoltios.modelos.Parques;

public class ServiceRegisterItem3 extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_service_register_item3);
    // Obtener referencias a los elementos de la interfaz de usuario
    Button botonRegresar = findViewById(R.id.botonRetroceso);
    Button botonRegistrar = findViewById(R.id.btnRegistrarParques);
    Button botonConsejo = findViewById(R.id.botonAdvices);
    EditText kilovatios = findViewById(R.id.editTextKilovatiosE);
    EditText precio = findViewById(R.id.editTextPrecioE);
    EditText mes = findViewById(R.id.editTextMesE);

    // Intent utilizado para regresar a la actividad ServiceRegister
    Intent intent1 = new Intent(this, ServiceRegister.class);

    // Intent utilizado para navegar a la actividad Principal
    Intent intent2 = new Intent(this, Principal.class);


    // Configuración del botón "Regresar"
    botonRegresar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(intent1);
        }
    });

    // Configuración del botón "Consejo"
    Intent intent5 = new Intent(this, Advice.class);

    /*
     * Botón para Consejos
     */
    botonConsejo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(intent5);
        }
    });

    // Configuración del botón "Registrar"
    botonRegistrar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Verificar que los campos no estén vacíos
            if (!kilovatios.getText().toString().isEmpty() && !precio.getText().toString().isEmpty() && !mes.getText().toString().isEmpty()) {
                String mesBuscado = mes.getText().toString();
                boolean mesExiste = verificarMes(mesBuscado);
                if (mesExiste) {
                    // El mes ya existe en el archivo
                    Toast.makeText(ServiceRegisterItem3.this, "El mes ya existe", Toast.LENGTH_SHORT).show();
                } else {
                    boolean datosGuardados = guardarDatos(kilovatios.getText().toString(), precio.getText().toString(), mes.getText().toString());
                    if (datosGuardados) {
                        // Se cambia de actividad
                        startActivity(intent2);
                    } else {
                        Toast.makeText(ServiceRegisterItem3.this, "Error al guardar el archivo",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            } else {
                // Algunos campos están vacíos
                Toast.makeText(ServiceRegisterItem3.this, "Los campos no pueden estar vacíos", Toast.LENGTH_SHORT).show();
            }
        }
    });
}

    /**
     * Verifica si un mes existe en el archivo "parques.txt".
     *
     * @param mesBuscado El mes a buscar.
     * @return true si el mes existe, false en caso contrario.
     */
    public boolean verificarMes(String mesBuscado) {
        File file = new File(getFilesDir(), "canchas.txt");
        mesBuscado = mesBuscado.toLowerCase();
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                String mes = linea.split(",")[2]; // Suponiendo que el mes está en la tercera columna separada por coma (,)
                if (mes.equalsIgnoreCase(mesBuscado)) {
                    bufferedReader.close();
                    return true; // El mes existe
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false; // El mes no existe
    }

    /*
     * Guarda los datos en el archivo "parques.txt" si el mes no existe.
     * @param Kilovatios La carga proveída en el dispositivo.
     * @param precio  El precio comercial del Kw en la instalación.
     * @param mes     El mes a guardar.
     * @return true si se guarda correctamente, false en caso contrario.
     */
    public boolean guardarDatos(String kilovatios, String precio, String mes) {
        File file = new File(getFilesDir(), "canchas.txt");
        mes = mes.toLowerCase();
        try {
            // Verificar si el archivo existe
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            // Crear una instancia de Centros y escribir los datos en el archivo
            Parques parques = new Parques(Float.parseFloat(kilovatios), Float.parseFloat(precio), mes);
            String linea = String.format(Locale.getDefault(), "%.2f,%.2f,%s", parques.getKilovatios(), parques.getPrecio(), parques.getMes());
            bufferedWriter.write(linea);
            bufferedWriter.newLine();
            bufferedWriter.close();
            return true; // Los datos se guardaron correctamente
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false; // Error al guardar los datos
    }
}
