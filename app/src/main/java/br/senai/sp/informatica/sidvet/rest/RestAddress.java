package br.senai.sp.informatica.sidvet.rest;

public class RestAddress {
    public  static  String  protocolo = "http://";
    public  static String  servidor = "10.84.144.8";
    public  static String  porta = ":80";
    public  static String site = "/Sidvet";
    public  static String urlService = protocolo + servidor + site;

    //Recurso da API
    public static String login = urlService + "/login";

    public static String listaPet = urlService + "/pet/%d";



}
