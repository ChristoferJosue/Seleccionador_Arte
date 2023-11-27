package com.example.parcial3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //declaracion de controles
    Button datePicker1,BtnGuardar;
    ImageButton BtnSalir,BtnImagenes;
    RadioButton Rb1,Rb2,Rb3,Rb4,Rb5;
    EditText EtNombre,EtApellido;
    //variables globales
    int anioPersona ,mesPersona ,diaPersona,position;
    int[] imagen={R.drawable.moderno,R.drawable.abstracto,R.drawable.gotico,R.drawable.griego,R.drawable.renacentista};//para las imagenes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //obtencion de valores de los controles
        EtApellido=(EditText) findViewById(R.id.Etapellido);
        BtnImagenes=(ImageButton) findViewById(R.id.BtnImgs);
        EtNombre=(EditText)findViewById(R.id.Etnombre);
        BtnGuardar=(Button) findViewById(R.id.Guardar);
        Rb1=(RadioButton) findViewById(R.id.RbTema1);
        Rb2=(RadioButton) findViewById(R.id.RbTema2);
        Rb3=(RadioButton) findViewById(R.id.RbTema3);
        Rb4=(RadioButton) findViewById(R.id.RbTema4);
        Rb5=(RadioButton) findViewById(R.id.RbTema5);
        datePicker1=findViewById(R.id.BtnDatePicker);
        BtnSalir=(ImageButton) findViewById(R.id.btnSalir);
        BtnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finaliza todo
                finishAffinity();
            }
        });
        datePicker1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FechaInicial();
            }
        });
        BtnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int centinela=0;
                String nombreStr=EtNombre.getText().toString();
                String apellidoStr=EtApellido.getText().toString();
                String FechaStr=datePicker1.getText().toString();
                if(nombreStr.isEmpty() || apellidoStr.isEmpty()){//si el nombre o el apellido estan vacios tira este mensaje
                    Toast.makeText(MainActivity.this,"El nombre o el apellido estan vacios", Toast.LENGTH_SHORT).show();
                    centinela=1;
                }

                if (FechaStr.isEmpty()){//si no ha seleccionado la fecha tira este mensaje
                    Toast.makeText(MainActivity.this,"Elige la fecha",Toast.LENGTH_SHORT).show();
                    centinela=1;

                }
                else{
                    centinela=0;
                }



            }
        });
        Rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Rb1.isChecked())//si este se activa o hace click desactivar los otros
                {
                    position=0;
                   actualizarImagen(position);




                    Rb5.setChecked(false);
                    Rb2.setChecked(false);
                    Rb3.setChecked(false);
                    Rb4.setChecked(false);
                }


            }
        });
        Rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Rb2.isChecked())//si este se activa o hace click desactivar los otros
                {
                    position=1;
                    actualizarImagen(position);
                    Rb5.setChecked(false);
                    Rb1.setChecked(false);
                    Rb3.setChecked(false);
                    Rb4.setChecked(false);
                }

            }
        });
        Rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Rb3.isChecked())//si este se activa o hace click desactivar los otros
                {
                    position=2;
                    actualizarImagen(position);
                    Rb5.setChecked(false);
                    Rb2.setChecked(false);
                    Rb1.setChecked(false);
                    Rb4.setChecked(false);
                }

            }
        });
        Rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Rb4.isChecked())//si este se activa o hace click desactivar los otros
                {
                    position=3;
                    actualizarImagen(position);
                    Rb5.setChecked(false);
                    Rb2.setChecked(false);
                    Rb3.setChecked(false);
                    Rb1.setChecked(false);
                }

            }
        });
        Rb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Rb5.isChecked())//si este se activa o hace click desactivar los otros
                {

                    position=4;
                    actualizarImagen(position);
                    Rb1.setChecked(false);
                    Rb2.setChecked(false);
                    Rb3.setChecked(false);
                    Rb4.setChecked(false);
                }

            }
        });



    }
    private void actualizarImagen(int position) {
        // Establece la imagen del ImageButton según la posición que se da en parametro
        BtnImagenes.setVisibility(View.VISIBLE);
        BtnImagenes.setImageDrawable(getResources().getDrawable(imagen[position]));

    }
    private void FechaInicial(){
        //
        DatePickerDialog dialog= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                //guardar los datos que la persona puso en variables para su posterior uso
                anioPersona=year;
                mesPersona=month+1;
                diaPersona=day;
                datePicker1.setText(String.valueOf(day)+"/"+String.valueOf(month+1)+"/"+String.valueOf(year));//texto que se va mostrar ;
            }
        }, 2023, 11, 26);
        dialog.show();
    }
}