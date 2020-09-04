package co.natalia.mainactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
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
    private Button aceptarBtn;
    private ConstraintLayout ColorLay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambio_color);

        textColor = findViewById(R.id.textCalcular);
        textSel = findViewById(R.id.textSel);
        naranjaBtn = findViewById(R.id.naranjaBtn);
        azulBtn = findViewById(R.id.azulBtn);
        verdeBtn = findViewById(R.id.verdeBtn);
        aceptarBtn = findViewById(R.id.aceptarBtn);

        aceptarBtn.setOnClickListener(
                (v)->{
                    aceptarColor();
                }
        );

    }

    public void onBackPressed(){
        aceptarColor();
    }

    public void aceptarColor(){
        Intent i = new Intent();
        setResult(RESULT_OK, i);

    }

}