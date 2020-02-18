package com.pdrzz.lcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editGasolina,editAlcool;
    private Button calcular;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editGasolina=findViewById(R.id.txtGasolina);
        editAlcool=findViewById(R.id.txtAlcool);
        calcular=findViewById(R.id.btnCalcular);
        resultado=findViewById(R.id.txtResultado);


    }

    public void calcularPreco(View view){
        boolean camposValidados = validarCampos(editGasolina.getText().toString(),editAlcool.getText().toString());

        if (camposValidados){
            String alcool,gasolina,tratamento;
            tratamento=tratar(editAlcool.getText().toString(),editGasolina.getText().toString());
            alcool=tratamento.split("/")[0];
            gasolina=tratamento.split("/")[1];

            Double valorAlcool,valorGasolina;
            valorAlcool=Double.parseDouble(alcool);
            valorGasolina=Double.parseDouble(gasolina);

            Double result = valorAlcool/valorGasolina;
            if (result>=0.7){
                resultado.setText("Melhor Utilizar a GASOLINA!");
            }else{resultado.setText("Melhor Utilizar o ÁLCOOL!");}

        }else{
            Toast.makeText(this,"Preencha todos os campos",Toast.LENGTH_LONG);
        }

    }

    public String tratar(String alcool,String gasolina){
        if (alcool.contains(",") | gasolina.contains(",")) {
            alcool = alcool.replace(",", ".");
            gasolina=gasolina.replace(",",".");
        }
        return alcool+"/"+gasolina;
    }

    public boolean validarCampos(String pGasolina,String pAlcool){
        Boolean camposValidos=true;
        if(pGasolina==null || pGasolina.equals("") || pAlcool==null || pAlcool.equals("")){
            camposValidos=false;

        }
        return camposValidos;
    }



}
