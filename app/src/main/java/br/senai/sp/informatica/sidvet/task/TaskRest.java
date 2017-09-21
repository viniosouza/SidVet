package br.senai.sp.informatica.sidvet.task;

import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import br.senai.sp.informatica.sidvet.util.ReadStremUtil;

import static br.senai.sp.informatica.sidvet.task.TaskRest.RequestMethod.PUT;

public class TaskRest extends AsyncTask<String, SwipeRefreshLayout, String> {

    public enum RequestMethod {
        GET, POST, PUT, DELETE
    }

    private Exception exception;

    private RequestMethod requestMethod;

    private HandlerTask handlerTask;

    private boolean refresh;

    private SwipeRefreshLayout swipeRefreshLayout;

    public TaskRest(RequestMethod requestMethod, HandlerTask handlerTask) {
        this.requestMethod = requestMethod;
        this.handlerTask = handlerTask;
    }

    public TaskRest(RequestMethod requestMethod, HandlerTask handlerTask, boolean refresh,SwipeRefreshLayout swipeRefreshLayout){
        this.requestMethod = requestMethod;
        this.handlerTask = handlerTask;
        this.refresh = refresh;
        this.swipeRefreshLayout = swipeRefreshLayout;
    }



    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        handlerTask.onPreHandler();
    }

    @Override
    protected String doInBackground(String... params) {
        String retorno = null;
        try {
            String endereco = params[0];
            URL url = new URL(endereco);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(259200);
            connection.setReadTimeout(259200);

            connection.setRequestMethod(requestMethod.toString());
            if (requestMethod == RequestMethod.POST || requestMethod == PUT) {
                String json = params[1];
                connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                connection.setDoOutput(true);
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(json.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();
            }
            int responseCode = connection.getResponseCode();
            switch (requestMethod){
                case GET:
                case POST:
                case PUT:
                    if(responseCode == HttpURLConnection.HTTP_CREATED || responseCode  == HttpURLConnection.HTTP_OK){
                        InputStream inputStream = connection.getInputStream();
                        retorno = ReadStremUtil.readStream(inputStream);
                        inputStream.close();
                    } else if(responseCode == 401){
                        retorno = "Usuário ou senha INVÁLIDOS";
                    } else {
                        throw new RuntimeException("Erro no " + requestMethod.toString() + " código de resposta: " + responseCode);
                    }
                    break;
                case DELETE:
                    if(responseCode == HttpURLConnection.HTTP_NO_CONTENT){
                        retorno = "";

                    } else {
                        throw new RuntimeException("Erro no " + requestMethod.toString() + " código de resposta: " + responseCode);
                    }
            }
            connection.disconnect();
        } catch (MalformedURLException e) {
            exception = new RuntimeException("Erro na url: " + e.getMessage());
        } catch (ProtocolException e) {
            exception = new RuntimeException("Erro no protocolo: " + e.getMessage());
        } catch (IOException e) {
            exception = new RuntimeException("Erro ao acessar os dados: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            exception = new RuntimeException("Erro: falta um parâmetro para a execução do método.");
        }
        return retorno;
    }

    @Override
    protected void onPostExecute(String s) {
        if (s != null) {
            // redireciona a resposta do
            // servidor para o onSuccess
            handlerTask.onSucess(s);
            // retira da tela o swiperefresh
            if (swipeRefreshLayout != null) {
                swipeRefreshLayout.setRefreshing(false);
            }
        } else {
            // se deu ruim
            handlerTask.onError(exception);
        }
    }
}

