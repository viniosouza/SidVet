package br.senai.sp.informatica.sidvet.task;

/**
 * Created by Tecnico_Tarde on 14/06/2017.
 */

public interface HandlerTask {

    void onPreHandler();

    void onHandler();

    void onSucess(String readValue);

    void onError(Exception erro);
}
