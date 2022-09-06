package com.example.padraomvp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.padraomvp.R;

public class MainActivity extends AppCompatActivity implements AppView{

    TextView textView;
    Button button;

    //Conectando a Activity com a Presenter
    Presenter presenter;


    //   Padrão MVP

    // View: Activity com o TextView e o Button
    //Model: É a classe MyModel
    //Presenter: É a classe Presenter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startComponents();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Chama o presenter para ter acesso aos dados do DB ou da API
                //Sem conexão da Activity com a Model
                //A MainActivity está lidando apenas com dados da UI
                //Toda a lógica ocorre dentro da Presenter

               presenter.getAppDetails();
            }
        });

        //Instanciando o Presenter
        //O Presenter é a ponte entre a View e a Model, ele que irá solicitar as informações
        presenter = new Presenter(this);

    }

//    public void DisplayAppText(){
//        textView.setText(GetAppFromModel().getAppName() + "Downloads" + GetAppFromModel().getAppDownloads());
//    }

    public void startComponents(){

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

    }

    //Método para setar o texto no TextView
    @Override
    public void onGetAppName(String name) {
        textView.setText(name);
    }
}