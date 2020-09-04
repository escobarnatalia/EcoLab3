package co.natalia.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class resultadoFinal extends AppCompatActivity {

    private TextView textResultados;
    private TextView textoNombre;
    private TextView notaFinal;
    private Button otravezBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_final);

        double resultado = getIntent().getExtras().getDouble("resultado");
        String resultadoStr = String.valueOf(resultado);

        textResultados = findViewById(R.id.textResultados);
        textoNombre = findViewById(R.id.textoNombre);
        notaFinal = findViewById(R.id.notaFinal);
        otravezBtn = findViewById(R.id.otravezBtn);

        SharedPreferences preferences = getSharedPreferences("nombreEstudiante", MODE_PRIVATE);
        String nombre = preferences.getString("nombreEst", "NO_USER");

        textoNombre.setText("Hola" + " " + nombre + ", tu nota final es");

        notaFinal.setText(resultadoStr);

        otravezBtn.setOnClickListener(
                (v)->{
                    Intent i = new Intent();
                    finish();
                }
        );

    }



}