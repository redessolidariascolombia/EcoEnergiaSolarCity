package unal.todosalau.ahorravoltios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Crear archivo para usuarios y escribir los datos
    File file1 = new File(getFilesDir(), "datos.txt");
    try {
        FileWriter writer = new FileWriter(file1);
        writer.append("root,root@root.com,toor,TOOR\n");
        writer.flush();
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Crear archivo para registro de agua
    File file2 = new File(getFilesDir(), "centros.txt");
    try {
        FileWriter writer = new FileWriter(file2);
        writer.append("50,150000,enero\n");
        writer.flush();
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    // Crear archivo para registro de electricidad
    File file3 = new File(getFilesDir(), "canchas.txt");
    try {
        FileWriter writer = new FileWriter(file3);
        writer.append("60,200000,enero\n");
        writer.flush();
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

        // Crear archivo para registro de consejos
    File file4 = new File(getFilesDir(), "consejos.txt");
    try {
        FileWriter writer = new FileWriter(file4);

    // Lista de consejos para instalacion de paneles dentro de array
        String[] consejos = {
                "La instalación de los paneles corresponde a profesionales.",
                "Existe riesgo de electrocución por manipulación inexperta.",
                "Debe mantener separadas las acometidas eléctricas.",
                "Contrate mantenimientos corresctivos y preventivos a sus paneles.",
                "Instale protectores a sus acometidas eléctricas.",
                "Proteja los acumuladores de energía eléctrica.",
                "Revise las baterías, acumuladores en el período ordenado por el fabricante.",
                "Proteja la instalación con los breakes indicados.",
                "Revise la carga eléctrica de los aparatos conectados a sus paneles.",
                "Invierta en luminarias de alta eficiencia energética."};

       // Recorrer el array y agregar los consejos al archivo
        writer.append("Lista de consejos para instalación de paneles solares:\n");
        for (String consejo : consejos) {
            writer.append(consejo).append("\n");
        }
        writer.flush();
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }


    Intent intent = new Intent(this, Login.class);
    startActivity(intent);
    }
}