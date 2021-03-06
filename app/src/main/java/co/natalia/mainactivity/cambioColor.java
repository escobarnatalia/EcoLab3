package co.natalia.mainactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class cambioColor extends AppCompatActivity {

    private TextView textColor;
    private TextView textSel;
    private Button naranjaBtn;
    private Button azulBtn;
    private Button verdeBtn;
    private ConstraintLayout colorLay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambio_color);

        textColor = findViewById(R.id.textCalcular);
        textSel = findViewById(R.id.textSel);
        naranjaBtn = findViewById(R.id.naranjaBtn);
        azulBtn = findViewById(R.id.azulBtn);
        verdeBtn = findViewById(R.id.verdeBtn);
        colorLay = findViewById(R.id.colorLay);


        naranjaBtn.setOnClickListener(
                (v)->{
                    Intent n = new Intent();
                    n.putExtra("color", "Naranja");
                    setResult(RESULT_OK, n);
                    finish();
                }
        );

        azulBtn.setOnClickListener(
                (v)->{
                    Intent a = new Intent();
                    a.putExtra("color", "Azul");
                    setResult(RESULT_OK, a);
                    finish();
                }
        );

        verdeBtn.setOnClickListener(
                (v)->{
                    Intent r = new Intent();
                    r.putExtra("color", "Verde");
                    setResult(RESULT_OK, r);
                    finish();
                }
        );



    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences fondo = getSharedPreferences("fondos", MODE_PRIVATE);
        String fondoConf = fondo.getString("colores", "NO_COLORES");

        if (fondoConf.equals("Naranja")){
            colorLay.setBackgroundColor(Color.rgb(249, 142, 6 ));
        }
        if (fondoConf.equals("Azul")){
            colorLay.setBackgroundColor(Color.rgb(78, 214, 255 ));
        }
        if (fondoConf.equals("Verde")){
            colorLay.setBackgroundColor(Color.rgb(126, 231, 61  ));
        }
    }
}