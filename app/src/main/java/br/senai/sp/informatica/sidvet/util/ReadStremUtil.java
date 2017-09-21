package br.senai.sp.informatica.sidvet.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Tecnico_Tarde on 14/06/2017.
 */

public class ReadStremUtil {
    public static String readStream(InputStream inputStream) {
        try {
            BufferedReader leitor = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();
            String linha = null;
            //Enquanto houver linhas no buffered
            while ((linha = leitor.readLine()) != null) {
                //acrescenta a linha ao StringBuilder
                builder.append(linha + "\n");
            }
            //fecha o buffered reader
            leitor.close();
            return builder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
