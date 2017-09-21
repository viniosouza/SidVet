package br.senai.sp.informatica.sidvet.rest;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Tecnico_Tarde on 14/06/2017.
 */

public class JsonParser<T> {

    final Class<T> tipoObjeto;

    Gson gson = new Gson();

    public JsonParser(Class<T> tipoObjeto) {
        this.tipoObjeto = tipoObjeto;
    }

    public List<T> toList(String json, Class<T[]> objeto){
        return Arrays.asList(gson.fromJson(json, objeto));
    }

    public T toObject(String json){
        return gson.fromJson(json, tipoObjeto);
    }
    public String fromObject(T objeto){
        return gson.toJson(objeto);
    }
}
