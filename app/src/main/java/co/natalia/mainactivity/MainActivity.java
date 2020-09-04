package co.natalia.mainactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
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
    private ConstraintLayout layoutMain;
    private String colores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referenciar
        textNombre = findViewById(R.id.textNombre);
        nombreEst = findViewById(R.id.nombreEst);
        continuarBtn = findViewById(R.id.continuarBtn);
        configuracionBtn = findViewById(R.id.configuracionBtn);
        layoutMain = findViewById(R.id.layoutMain);

        continuarBtn.setOnClickListener(this);
        configuracionBtn.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.continuarBtn:
                String nombre = nombreEst.getText().toString();
                //locker del nombre
                SharedPreferences preferences = getSharedPreferences("nombreEstudiante", MODE_PRIVATE);
                preferences.edit().putString("nombreEst", nombre).apply();

                //locker del color cuando le doy continuar a otras pantallas
                SharedPreferences preferences2 = getSharedPreferences("fondos", MODE_PRIVATE);
                preferences2.edit().putString("colores", colores).apply();

                Intent i = new Intent(this, calcularNota.class);
                startActivity(i);
                break;
            case R.id.configuracionBtn:
                //locker del color cuando hace click en conf
                SharedPreferences preferences1 = getSharedPreferences("fondos", MODE_PRIVATE);
                preferences1.edit().putString("colores", colores).apply();



                Intent c = new Intent(this, cambioColor.class);
                startActivityForResult(c, 12);
                break;
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 11 && resultCode == RESULT_OK){
            colores = data.getExtras().getString("colores");
            if (colores.equals("Naranja")){
                layoutMain.setBackgroundColor(Color.rgb(249, 142, 6 ));
            }
            if (colores.equals("Azul")){
                layoutMain.setBackgroundColor(Color.rgb(78, 214, 255 ));
            }
            if (colores.equals("Verde")){
                layoutMain.setBackgroundColor(Color.rgb(126, 231, 61  ));
            }
        }
    }
}