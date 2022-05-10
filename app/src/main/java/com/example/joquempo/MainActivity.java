package com.example.joquempo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);}

        //Escolha do Usuario
        String opcao_usuario;
        public void escolha_pedra(View view){
        opcao_usuario = "pedra";
        escolha_adversario();
    }
        public void escolha_papel(View view){
        opcao_usuario = "papel";
        escolha_adversario();
    }
        public void escolha_tesoura(View view){
        opcao_usuario = "tesoura";
        escolha_adversario();
    }


    public void escolha_adversario( ){
            //Criando numeros randomicos para escolha do adversário
            int numero = new Random().nextInt(3);
            String[] opcoes = {"pedra","papel","tesoura"};
            String opcao_adversario = opcoes[numero];
            //

            //Settando imagem conforme escolha randomica
            ImageView imag_adversario = findViewById(R.id.imageView_adv_escolh);

            switch (opcao_adversario) {
                case "pedra" : imag_adversario.setImageResource(R.drawable.pedra);
                    break;
                case "papel" : imag_adversario.setImageResource(R.drawable.papel);
                    break;
                case "tesoura": imag_adversario.setImageResource(R.drawable.tesoura);
                    break;
            }
            System.out.println("Escolha do adversário: " + opcao_adversario);
            result(opcao_adversario, opcao_usuario);
            //
        }

        //Calculando resultado
        public void result(String escolha_adversario, String escolha_usuario){
            TextView resultado = findViewById(R.id.textView_result);

        //Usuario vencedor
        if (    escolha_usuario == "pedra" && escolha_adversario == "tesoura" ||
                escolha_usuario == "papel" && escolha_adversario == "pedra" ||
                escolha_usuario == "tesoura" && escolha_adversario == "papel"
        ){
                resultado.setText(R.string.result_win);
        }
        //Adversario vencedor
        else if (
                escolha_adversario == "pedra" && escolha_usuario == "tesoura" ||
                escolha_adversario == "papel" && escolha_usuario == "pedra" ||
                escolha_adversario == "tesoura" && escolha_usuario == "papel"
        ){
                resultado.setText(R.string.result_lose);
        }
        //Empate
        else {
                resultado.setText(R.string.result_draw);
        }}}