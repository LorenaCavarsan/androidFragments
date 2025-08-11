package com.example.projetofragmentolorena.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

import com.example.projetofragmentolorena.R;
import com.example.projetofragmentolorena.fragments.FragmentContatos;
import com.example.projetofragmentolorena.fragments.FragmentConversas;

public class MainActivity extends AppCompatActivity {
    private Button buttonConversas;
    private Button buttonContatos;
    private FragmentConversas fragmentConversas;
    private FragmentContatos fragmentContatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //REFERÊNCIAS
        buttonConversas = findViewById(R.id.buttonConversas);
        buttonContatos = findViewById(R.id.buttonContatos);


        //Criar um objeto do Fragments CONVERSAS
        fragmentConversas = new FragmentConversas();  //new serve para criar um novo objeto


        //Configurar o objeto para o fragmento
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


        //Transação entre frameLayout e fragment
        transaction.add(R.id.frameLayoutConteudo,fragmentConversas);
        transaction.commit();  //finalizando a transação (transaction)


        //evento do botão CONTATOS
        buttonContatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Criar um objeto para Fragments CONTATOS
                fragmentContatos = new FragmentContatos();


                //Configurar o objeto para o fragmento
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


                //Transação entre frameLayout e fragment
                transaction.replace(R.id.frameLayoutConteudo,fragmentContatos);
                transaction.commit();
            }
        });

        //evento do botão CONVERSAS
        buttonConversas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Criar um objeto para Fragments CONTATOS
                fragmentConversas = new FragmentConversas();

                //criar um objeto para o fragmento
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                //Transação entre frameLayout e fragment
                transaction.replace(R.id.frameLayoutConteudo,fragmentConversas);
                transaction.commit();  //finalizando a transação (transiction)
            }
        });
    }
}