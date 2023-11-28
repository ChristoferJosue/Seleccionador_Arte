package com.example.parcial3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {


    //declarar controles
    TextView TvResultado;
    CheckBox cb1,cb2,cb3,cb4,cb5;
    Button GenerarResultado;
    ImageButton BtnAtras;

    String  resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        String nombre,fecha,apellido;

        //recibiendo los valores de el anterior activity
        nombre=getIntent().getStringExtra("nombre");
        apellido=getIntent().getStringExtra("apellido");
        fecha=getIntent().getStringExtra("fecha");
        resultado=nombre+" "+apellido+" "+fecha;

        //recibir los valores de los controles

        TvResultado=findViewById(R.id.EtResultado);
        cb1=findViewById(R.id.Cb1);
        cb2=findViewById(R.id.Cb2);
        cb3=findViewById(R.id.Cb3);
        cb4=findViewById(R.id.Cb4);
        cb5=findViewById(R.id.Cb5);
        BtnAtras=findViewById(R.id.btnAtras);
        GenerarResultado=findViewById(R.id.BtnGenerarResultados);
        TvResultado.setText(resultado);


        BtnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        GenerarResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TvResultado.setText(resultado);
            }
        });

        cb1.setOnClickListener(v -> {
            if(cb1.isChecked()){
                resultado=resultado+"\nInteresante";

            }
        });
        cb2.setOnClickListener(v -> {
            if(cb2.isChecked()){
                resultado=resultado+"\nútil";

            }
        });
        cb3.setOnClickListener(v -> {
            if(cb3.isChecked()){
                resultado=resultado+"\nDivertida";

            }
        });
        cb4.setOnClickListener(v -> {
            if(cb4.isChecked()){
                resultado=resultado+"\nBuena calidad";

            }
        });
        cb5.setOnClickListener(v -> {
            if(cb5.isChecked()){
                resultado=resultado+"\nBuena estetica";

            }
        });



    }
}