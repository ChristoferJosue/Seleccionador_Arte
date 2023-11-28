package com.example.parcial3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    //declaracion de controles
    Button datePicker1;
    ImageButton BtnSalir,BtnImagenes,BtnSiguiente;
    RadioButton Rb1,Rb2,Rb3,Rb4,Rb5;
    EditText EtNombre,EtApellido;
    //variables globales

    String nombre,apellido,fecha;
    int anioPersona ,mesPersona ,diaPersona,position,centinela;
    int[] imagen={R.drawable.moderno,R.drawable.abstracto,R.drawable.gotico,R.drawable.griego,R.drawable.renacentista};//para las imagenes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //obtencion de valores de los controles no necesito castearlos por lo que no pongo su tipo de dato ejemp(Button)
        EtApellido= findViewById(R.id.Etapellido);
        BtnImagenes= findViewById(R.id.BtnImgs);
        EtNombre=findViewById(R.id.Etnombre);
        Rb1= findViewById(R.id.RbTema1);
        Rb2=findViewById(R.id.RbTema2);
        Rb3= findViewById(R.id.RbTema3);
        Rb4= findViewById(R.id.RbTema4);
        Rb5= findViewById(R.id.RbTema5);
        datePicker1=findViewById(R.id.BtnDatePicker);
        BtnSalir= findViewById(R.id.btnSalir);
        BtnSiguiente=findViewById(R.id.btnSiguiente);
        BtnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GuardarDatos();
                if(centinela==0)
                {
                    Intent packageContext;
                    Intent siguiente=new Intent(MainActivity.this, MainActivity2.class);
                    siguiente.putExtra("nombre",nombre);
                    siguiente.putExtra("apellido",apellido);
                    siguiente.putExtra("fecha",fecha);
                    startActivity(siguiente);

                }
                else {
                    Toast.makeText(MainActivity.this,"rellena todos los campos para poder usar esto", Toast.LENGTH_SHORT).show();

                }

            }
        });



        BtnSalir.setOnClickListener(View -> {//probando un nuevo metodo para evitar algunas advertencias de android studio

            finishAffinity();
        });
        BtnImagenes.setOnClickListener(v -> {
            GuardarDatos();//guarda los datos

            if(centinela==0){//si esta vacio arriba no puede entrar a la webview
                Intent packageContext;
                Intent web1=new Intent(MainActivity.this, webview.class);
                String enlace;
                enlace=EnlacePaginaWeb(position);
                web1.putExtra("enlace",enlace);//pasandole el valor de el radio button seleccionado
                startActivity(web1);

            }
            else
            {
                Toast.makeText(MainActivity.this,"rellena todos los campos para poder usar esto", Toast.LENGTH_SHORT).show();

            }


        });


        datePicker1.setOnClickListener(view -> FechaInicial());//pone la fecha inicial en el date picker


        Rb1.setOnClickListener(v -> {
            if(Rb1.isChecked())//si este se activa o hace click desactivar los otros
            {
                position=0;//posicion de la imagen
               actualizarImagen(position);




                Rb5.setChecked(false);
                Rb2.setChecked(false);
                Rb3.setChecked(false);
                Rb4.setChecked(false);
            }


        });
        Rb2.setOnClickListener(v -> {
            if(Rb2.isChecked())//si este se activa o hace click desactivar los otros
            {
                position=1;
                actualizarImagen(position);
                Rb5.setChecked(false);
                Rb1.setChecked(false);
                Rb3.setChecked(false);
                Rb4.setChecked(false);
            }

        });
        Rb3.setOnClickListener(v -> {
            if(Rb3.isChecked())//si este se activa o hace click desactivar los otros
            {
                position=2;
                actualizarImagen(position);
                Rb5.setChecked(false);
                Rb2.setChecked(false);
                Rb1.setChecked(false);
                Rb4.setChecked(false);
            }

        });
        Rb4.setOnClickListener(v -> {
            if(Rb4.isChecked())//si este se activa o hace click desactivar los otros
            {
                position=3;
                actualizarImagen(position);
                Rb5.setChecked(false);
                Rb2.setChecked(false);
                Rb3.setChecked(false);
                Rb1.setChecked(false);
            }

        });
        Rb5.setOnClickListener(v -> {
            if(Rb5.isChecked())//si este se activa o hace click desactivar los otros
            {

                position=4;
                actualizarImagen(position);
                Rb1.setChecked(false);
                Rb2.setChecked(false);
                Rb3.setChecked(false);
                Rb4.setChecked(false);
            }

        });



    }
    private void actualizarImagen(int position) {
        // Establece la imagen del ImageButton según la posición que se da en parametro
        BtnImagenes.setVisibility(View.VISIBLE);
        BtnImagenes.setImageDrawable(getResources().getDrawable(imagen[position], getTheme()));



    }
    private void FechaInicial(){
        //
        @SuppressLint("SetTextI18n")//sirve para que ignore la advertencia para el metodo settextindicando
        // que estás consciente de la situación y has decidido no aplicar internacionalización en ese caso particular.
        DatePickerDialog dialog= new DatePickerDialog(this, (datePicker, year, month, day) -> {
            //guardar los datos que la persona puso en variables para su posterior uso
            anioPersona=year;
            mesPersona=month+1;
            diaPersona=day;
            datePicker1.setText(day +"/"+ (month + 1) +"/"+ year);//texto que se va mostrar ;
        }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));//para que enseñe la fecha actual al abrir el datepicker
        dialog.show();
    }
    public  String   EnlacePaginaWeb(int valorImagen){
        //dependiendo del valor de la imagen o del radio button seleccionado  retorna un enlace diferente;
        String enlace="";
        switch (valorImagen){
            case 0:
                enlace="https://enciclopediadehistoria.com/arte-moderno/";
                break;
            case 1:
                enlace="https://concepto.de/arte-abstracto/";
                break;

            case 2:
                enlace="https://humanidades.com/arte-gotico/";

                break;
            case 3:
                enlace="https://enciclopediadehistoria.com/arte-griego/";

                break;
            case 4:
                enlace="https://humanidades.com/arte-renacentista/";
                break;
            default:
                enlace="https://www.google.com";

        }

        return enlace;
    }
    public void GuardarDatos(){
        String nombreStr=EtNombre.getText().toString();
        String apellidoStr=EtApellido.getText().toString();
        String fechaStr=datePicker1.getText().toString();
        if(nombreStr.isEmpty() || apellidoStr.isEmpty()){//si el nombre o el apellido estan vacios tira este mensaje
            Toast.makeText(MainActivity.this,"El nombre o el apellido estan vacios", Toast.LENGTH_SHORT).show();
            centinela=1;
        }

        if (fechaStr.isEmpty()){//si no ha seleccionado la fecha tira este mensaje
            Toast.makeText(MainActivity.this,"Elige la fecha",Toast.LENGTH_SHORT).show();
            centinela=1;

        }
        else{
            centinela=0;
            nombre=nombreStr;
            apellido=apellidoStr;
            fecha=fechaStr;

        }

    }
}


