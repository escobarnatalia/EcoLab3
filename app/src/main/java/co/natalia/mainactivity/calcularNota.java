package co.natalia.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calcularNota extends AppCompatActivity implements View.OnClickListener{

    private TextView textCalcular;
    private EditText notaProyecto1;
    private EditText notaProyecto2;
    private EditText notaQuices;
    private EditText notaSemanal;
    private EditText notaParcial1;
    private EditText notaParcial2;
    private Button calcularBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_nota);

        textCalcular = findViewById(R.id.textCalcular);
        notaProyecto1 = findViewById(R.id.notaProyecto1);
        notaProyecto2 = findViewById(R.id.notaProyecto2);
        notaQuices = findViewById(R.id.notaQuices);
        notaSemanal = findViewById(R.id.notaSemanal);
        notaParcial1 = findViewById(R.id.notaParcial1);
        notaParcial2 = findViewById(R.id.notaParcial2);
        calcularBtn = findViewById(R.id.calcularBtn);

        calcularBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


        String nProyecto1Str = notaProyecto1.getText().toString();
        double nProyecto1 = Double.parseDouble(nProyecto1Str);

        String nProyecto2Str = notaProyecto2.getText().toString();
        double nProyecto2 = Double.parseDouble(nProyecto2Str);

        String nQuicesStr = notaQuices.getText().toString();
        double nQuices = Double.parseDouble(nQuicesStr);

        String nSemanalStr = notaQuices.getText().toString();
        double nSemanal = Double.parseDouble(nSemanalStr);

        String nParcial1Str = notaParcial1.getText().toString();
        double nParcial1 = Double.parseDouble(nParcial1Str);

        String nParcial2Str = notaProyecto2.getText().toString();
        double nParcial2 = Double.parseDouble(nParcial2Str);

        double resultado = (nProyecto1*0.15) + (nProyecto2*0.15) + (nQuices*0.15) + (nSemanal*0.5) + (nParcial1*0.25) + (nParcial2*0.25);

        Intent i = new Intent(this, resultadoFinal.class);
        i.putExtra("resultado", resultado);
        startActivity(i);
        finish();

    }
}