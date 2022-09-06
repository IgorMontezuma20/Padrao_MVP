package com.example.padraomvp.ui;

import com.example.padraomvp.util.MyModel;

//This will act as a Presenter [The waiter]
public class Presenter {

    // 1 - A conexão entre o Presenter e a view(MainActivity) é feita por meio de uma Interface


    //Link instance
    AppView appView;

    public Presenter(AppView appView) {
        this.appView = appView;
    }


    // 2 - Link entre o Presenter e o Model

    public MyModel GetAppFromModel(){
        return new MyModel("Padrão MVP", 90000, 4);
    }


    //3 - Link entre Presenter e MainActivity (Chamando a Interface)

    public void getAppDetails(){
        /*   Aqui são passados os results da Model  */
        appView.onGetAppName(GetAppFromModel().getAppName());
    }

}
