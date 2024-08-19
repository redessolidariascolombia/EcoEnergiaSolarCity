package unal.todosalau.ahorravoltios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import unal.todosalau.ahorravoltios.modelos.Canchas;
import unal.todosalau.ahorravoltios.modelos.Centros;
import unal.todosalau.ahorravoltios.modelos.Parques;
public class Statistics extends AppCompatActivity {
    private TableLayout tableLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        //Elementos de la interfaz
        Button botonRegresar = findViewById(R.id.botonRetroceso);
        tableLayout = findViewById(R.id.myTableLayout);
        Intent intent = new Intent(this, Principal.class);

        //Carga de los archivos de agua y electricidad
        File centrosFile = new File(getFilesDir(), "centros.txt");
        File canchasFile = new File(getFilesDir(), "canchas.txt");
        File parquesFile = new File(getFilesDir(), "canchas.txt");

        //Listas de Centros Deportivos, Canchas y Parques
        List<Centros> listaCentros = leerArchivoCentros(centrosFile);
        List<Canchas> listaCanchas = leerArchivoCanchas(canchasFile);
        List<Parques> listaParques = leerArchivoParques(parquesFile);

        //Crear la Tabla
        addElementCentros(listaCentros);
        addElementCanchas(listaCanchas);
        addElementParques(listaParques);
        addPromedioCentros(listaCentros);
        addPromedioCanchas(listaCanchas);
        addPromedioParques(listaParques);

        //Boton Regresar
        botonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
    private void addPromedioCentros(List<Centros> centrosList){
        // Obtén una referencia al TableLayout en tu actividad o fragmento

        float promedioKilovatiosCentros = calcularPromedioKilovatiosCentros(centrosList);
        float promedioPrecioCentros = calcularPromedioPrecioCentros(centrosList);

        TableRow row = new TableRow(this);
        //AÑADE LA INFORMACIÓN A LA CELDA 1
        TextView cell1 = new TextView(this);
        cell1.setText("Promedio");
        cell1.setPadding(10, 10, 10, 10);
        cell1.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el
        // color deseado

        //AÑADE LA INFORMACIÓN A LA CELDA 2
        TextView cell2 = new TextView(this);
        cell2.setText("Campos deportivos");
        cell2.setPadding(10, 10, 10, 10);
        cell2.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el color


        //AÑADE LA INFORMACIÓN A LA CELDA 3
        TextView cell3 = new TextView(this);
        cell3.setText(String.valueOf(promedioKilovatiosCentros));
        cell3.setPadding(10, 10, 10, 10);
        cell3.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
        // el color

        //AÑADE LA INFORMACIÓN A LA CELDA 4
        TextView cell4 = new TextView(this);
        cell4.setText(String.valueOf(promedioPrecioCentros));
        cell4.setPadding(10, 10, 10, 10);
        cell4.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
        // el color

        // Agrega las celdas a la fila
        row.addView(cell1);
        row.addView(cell2);
        row.addView(cell3);
        row.addView(cell4);
        // Agrega la fila al TableLayout
        tableLayout.addView(row);
    }

    private void addPromedioCanchas(List<Canchas> canchasList){
        // Obtén una referencia al TableLayout en tu actividad o fragmento

        float promedioKilovatiosCanchas = calcularPromedioKilovatiosCanchas(canchasList);
        float promedioPrecioCanchas = calcularPromedioPrecioCanchas(canchasList);

        TableRow row = new TableRow(this);
        //AÑADE LA INFORMACIÓN A LA CELDA 1
        TextView cell1 = new TextView(this);
        cell1.setText("Promedio");
        cell1.setPadding(10, 10, 10, 10);
        cell1.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el
        // color deseado

        //AÑADE LA INFORMACIÓN A LA CELDA 2
        TextView cell2 = new TextView(this);
        cell2.setText("canchas");
        cell2.setPadding(10, 10, 10, 10);
        cell2.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el color


        //AÑADE LA INFORMACIÓN A LA CELDA 3
        TextView cell3 = new TextView(this);
        cell3.setText(String.valueOf(promedioKilovatiosCanchas));
        cell3.setPadding(10, 10, 10, 10);
        cell3.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
        // el color

        //AÑADE LA INFORMACIÓN A LA CELDA 4
        TextView cell4 = new TextView(this);
        cell4.setText(String.valueOf(promedioPrecioCanchas));
        cell4.setPadding(10, 10, 10, 10);
        cell4.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
        // el color

        // Agrega las celdas a la fila
        row.addView(cell1);
        row.addView(cell2);
        row.addView(cell3);
        row.addView(cell4);
        // Agrega la fila al TableLayout
        tableLayout.addView(row);
    }

    private void addPromedioParques(List<Parques> parquesList){
        // Obtén una referencia al TableLayout en tu actividad o fragmento

        float promedioKilovatiosParques = calcularPromedioKilovatiosParques(parquesList);
        float promedioPrecioParques = calcularPromedioPrecioParques(parquesList);

        TableRow row = new TableRow(this);
        //AÑADE LA INFORMACIÓN A LA CELDA 1
        TextView cell1 = new TextView(this);
        cell1.setText("Promedio");
        cell1.setPadding(10, 10, 10, 10);
        cell1.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el
        // color deseado

        //AÑADE LA INFORMACIÓN A LA CELDA 2
        TextView cell2 = new TextView(this);
        cell2.setText("parques");
        cell2.setPadding(10, 10, 10, 10);
        cell2.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el color


        //AÑADE LA INFORMACIÓN A LA CELDA 3
        TextView cell3 = new TextView(this);
        cell3.setText(String.valueOf(promedioKilovatiosParques));
        cell3.setPadding(10, 10, 10, 10);
        cell3.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
        // el color

        //AÑADE LA INFORMACIÓN A LA CELDA 4
        TextView cell4 = new TextView(this);
        cell4.setText(String.valueOf(promedioPrecioParques));
        cell4.setPadding(10, 10, 10, 10);
        cell4.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
        // el color

        // Agrega las celdas a la fila
        row.addView(cell1);
        row.addView(cell2);
        row.addView(cell3);
        row.addView(cell4);
        // Agrega la fila al TableLayout
        tableLayout.addView(row);
    }
    private void addElementCentros(List<Centros> centrosList){
        // Obtén una referencia al TableLayout en tu actividad o fragmento

        for (Centros item: centrosList) {
            // Crea una nueva fila y agrega las celdas
            TableRow row = new TableRow(this);
            //AÑADE LA INFORMACIÓN A LA CELDA 1
            TextView cell1 = new TextView(this);
            cell1.setText(item.getMes());

            cell1.setPadding(10, 10, 10, 10);
            cell1.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el
            // color deseado

            //AÑADE LA INFORMACIÓN A LA CELDA 2
            TextView cell2 = new TextView(this);
            cell2.setText("Centros deportivos");
            cell2.setPadding(10, 10, 10, 10);
            cell2.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el color


            //AÑADE LA INFORMACIÓN A LA CELDA 3
            TextView cell3 = new TextView(this);
            cell3.setText(String.valueOf((item.getKilovatios())));
            cell3.setPadding(10, 10, 10, 10);
            cell3.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
            // el color

            //AÑADE LA INFORMACIÓN A LA CELDA 4
            TextView cell4 = new TextView(this);
            cell4.setText(String.valueOf((item.getPrecio())));
            cell4.setPadding(10, 10, 10, 10);
            cell4.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
            // el color

            // Agrega las celdas a la fila
            row.addView(cell1);
            row.addView(cell2);
            row.addView(cell3);
            row.addView(cell4);
            // Agrega la fila al TableLayout
            tableLayout.addView(row);
        }
    }

    private void addElementCanchas(List<Canchas> canchasList){
        // Obtén una referencia al TableLayout en tu actividad o fragmento

        for (Canchas item: canchasList) {
            // Crea una nueva fila y agrega las celdas
            TableRow row = new TableRow(this);
            //AÑADE LA INFORMACIÓN A LA CELDA 1
            TextView cell1 = new TextView(this);
            cell1.setText(item.getMes());

            cell1.setPadding(10, 10, 10, 10);
            cell1.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el
            // color deseado

            //AÑADE LA INFORMACIÓN A LA CELDA 2
            TextView cell2 = new TextView(this);
            cell2.setText("Canchas");
            cell2.setPadding(10, 10, 10, 10);
            cell2.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el color


            //AÑADE LA INFORMACIÓN A LA CELDA 3
            TextView cell3 = new TextView(this);
            cell3.setText(String.valueOf((item.getKilovatios())));
            cell3.setPadding(10, 10, 10, 10);
            cell3.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
            // el color

            //AÑADE LA INFORMACIÓN A LA CELDA 4
            TextView cell4 = new TextView(this);
            cell4.setText(String.valueOf((item.getPrecio())));
            cell4.setPadding(10, 10, 10, 10);
            cell4.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
            // el color

            // Agrega las celdas a la fila
            row.addView(cell1);
            row.addView(cell2);
            row.addView(cell3);
            row.addView(cell4);
            // Agrega la fila al TableLayout
            tableLayout.addView(row);
        }
    }

    private void addElementParques(List<Parques> parquesList){
        // Obtén una referencia al TableLayout en tu actividad o fragmento

        for (Parques item: parquesList) {
            // Crea una nueva fila y agrega las celdas
            TableRow row = new TableRow(this);
            //AÑADE LA INFORMACIÓN A LA CELDA 1
            TextView cell1 = new TextView(this);
            cell1.setText(item.getMes());

            cell1.setPadding(10, 10, 10, 10);
            cell1.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el
            // color deseado

            //AÑADE LA INFORMACIÓN A LA CELDA 2
            TextView cell2 = new TextView(this);
            cell2.setText("Parques");
            cell2.setPadding(10, 10, 10, 10);
            cell2.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el color


            //AÑADE LA INFORMACIÓN A LA CELDA 3
            TextView cell3 = new TextView(this);
            cell3.setText(String.valueOf((item.getKilovatios())));
            cell3.setPadding(10, 10, 10, 10);
            cell3.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
            // el color

            //AÑADE LA INFORMACIÓN A LA CELDA 4
            TextView cell4 = new TextView(this);
            cell4.setText(String.valueOf((item.getPrecio())));
            cell4.setPadding(10, 10, 10, 10);
            cell4.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
            // el color

            // Agrega las celdas a la fila
            row.addView(cell1);
            row.addView(cell2);
            row.addView(cell3);
            row.addView(cell4);
            // Agrega la fila al TableLayout
            tableLayout.addView(row);
        }
    }
    private static List<Centros> leerArchivoCentros(File archivo) {
        List<Centros> listaCentros = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                float kilovatios = Float.parseFloat(datos[0]);
                float precio = Float.parseFloat(datos[1]);
                String mes = datos[2];

                Centros centros = new Centros(kilovatios, precio, mes);
                listaCentros.add(centros);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaCentros;
    }

    private static List<Canchas> leerArchivoCanchas(File archivo) {
        List<Canchas> listaCanchas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                float kilovatios = Float.parseFloat(datos[0]);
                float precio = Float.parseFloat(datos[1]);
                String mes = datos[2];

                Canchas canchas = new Canchas(kilovatios, precio, mes);
                listaCanchas.add(canchas);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaCanchas;
    }

    private static List<Parques> leerArchivoParques(File archivo) {
        List<Parques> listaParques = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                float kilovatios = Float.parseFloat(datos[0]);
                float precio = Float.parseFloat(datos[1]);
                String mes = datos[2];

                Parques parques = new Parques(kilovatios, precio, mes);
                listaParques.add(parques);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaParques;
    }
    private float calcularPromedioKilovatiosCentros(List<Centros> centrosList) {
        float sum = 0;
        for (Centros item : centrosList) {
            sum += item.getKilovatios();
        }
        return sum / centrosList.size();
    }
    private float calcularPromedioPrecioCentros(List<Centros> centrosList) {
        float sum = 0;
        for (Centros item : centrosList) {
            sum += item.getPrecio();
        }
        return sum / centrosList.size();
    }

    private float calcularPromedioKilovatiosCanchas(List<Canchas> canchasList) {
        float sum = 0;
        for (Canchas item : canchasList) {
            sum += item.getKilovatios();
        }
        return sum / canchasList.size();
    }

    private float calcularPromedioPrecioCanchas(List<Canchas> canchasList) {
        float sum = 0;
        for (Canchas item : canchasList) {
            sum += item.getPrecio();
        }
        return sum / canchasList.size();
    }
    private float calcularPromedioKilovatiosParques(List<Parques> parquesList) {
        float sum = 0;
        for (Parques item : parquesList) {
            sum += item.getKilovatios();
        }
        return sum / parquesList.size();
    }
    private float calcularPromedioPrecioParques(List<Parques> parquesList) {
        float sum = 0;
        for (Parques item : parquesList) {
            sum += item.getPrecio();
        }
        return sum / parquesList.size();
    }
}
