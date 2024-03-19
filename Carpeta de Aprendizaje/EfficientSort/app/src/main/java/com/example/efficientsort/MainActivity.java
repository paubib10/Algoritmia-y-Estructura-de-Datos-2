package com.example.efficientsort;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumero;
    private TextView textViewNumerosDesordenados;
    private TextView textViewNumerosOrdenados;
    private TextView textViewTiempo;
    private Button btnSelectSort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asignar referencias a los elementos de la interfaz
        editTextNumero = findViewById(R.id.editText1);
        textViewNumerosDesordenados = findViewById(R.id.textView2);
        textViewNumerosOrdenados = findViewById(R.id.textView3);
        textViewTiempo = findViewById(R.id.textView4);
        btnSelectSort = findViewById(R.id.button);

        // Añadir el desplazamiento a los TextView
        textViewNumerosDesordenados.setMovementMethod(new ScrollingMovementMethod());
        textViewNumerosOrdenados.setMovementMethod(new ScrollingMovementMethod());

        btnSelectSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ejecutarAlgoritmoSelectionSort();
            }
        });
    }

    private void ejecutarAlgoritmoSelectionSort() {
        // Obtener el número introducido
        String numeroStr = editTextNumero.getText().toString();

        if (!numeroStr.isEmpty()) {
            int numero = Integer.parseInt(numeroStr);

            // Generar un array de números desordenados
            int[] numerosDesordenados = generarNumerosDesordenados(numero);

            // Mostrar el array desordenado
            textViewNumerosDesordenados.setText(Arrays.toString(numerosDesordenados));

            // Medir el tiempo antes de iniciar el algoritmo de selección
            long startTime = SystemClock.elapsedRealtime();

            // Ordenar el array utilizando el algoritmo de selección
            selectionSort(numerosDesordenados);

            // Medir el tiempo después de completar el algoritmo de selección
            long endTime = SystemClock.elapsedRealtime();

            // Mostrar el array ordenado
            textViewNumerosOrdenados.setText(Arrays.toString(numerosDesordenados));

            // Mostrar el tiempo transcurrido en milisegundos
            long tiempoTranscurrido = endTime - startTime;
            textViewTiempo.setText(tiempoTranscurrido + " ms");
        }
    }

    private int[] generarNumerosDesordenados(int numero) {
        int[] numerosDesordenados = new int[numero];
        Random random = new Random();

        for (int i = 0; i < numero; i++) {
            numerosDesordenados[i] = random.nextInt(numero + 1);
        }

        return numerosDesordenados;
    }

    private void selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Intercambiar los elementos
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
