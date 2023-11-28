package com.example.parcial3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class webview extends AppCompatActivity {
    //declaracion de controles
    WebView webview1;
    Button btnCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        //recibe el valor de los controles
        webview1= findViewById(R.id.webview1);
        btnCerrar=findViewById(R.id.btnCerrar);
        webview1.setWebViewClient(new WebViewClient());
        String enlace=getIntent().getStringExtra("enlace");



        webview1.loadUrl(enlace);

        btnCerrar.setOnClickListener(view -> finish());//para cerrar la actividad al presionar el boton, es utilizando el metodo lambda para compactar las cosas

    }


    }
