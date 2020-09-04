package co.natalia.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textNombre;
    private EditText nombreEst;
    private Button continuarBtn;
    private  Button configuracionBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referenciar
        textNombre = findViewById(R.id.textNombre);
        nombreEst = findViewById(R.id.nombreEst);
        continuarBtn = findViewById(R.id.continuarBtn);
        configuracionBtn = findViewById(R.id.configuracionBtn);

        continuarBtn.setOnClickListener(this);
        configuracionBtn.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.continuarBtn:
                String nombre = nombreEst.getText().toString();

                SharedPreferences preferences = getSharedPreferences("nombreEstudiante", MODE_PRIVATE);
                preferences.edit().putString("nombreEst", nombre).apply();

                Intent i = new Intent(this, calcularNota.class);
                startActivity(i);
                break;
            case R.id.configuracionBtn:
                Intent c = new Intent(this, cambioColor.class);
                startActivity(c);
                break;
        }
    }
}