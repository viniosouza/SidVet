package br.senai.sp.informatica.sidvet.activity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.parceler.Parcels;

import br.senai.sp.informatica.sidvet.R;
import br.senai.sp.informatica.sidvet.model.Cliente;
import br.senai.sp.informatica.sidvet.model.Login;
import br.senai.sp.informatica.sidvet.rest.JsonParser;
import br.senai.sp.informatica.sidvet.rest.RestAddress;
import br.senai.sp.informatica.sidvet.task.HandlerTask;
import br.senai.sp.informatica.sidvet.task.HandlerTaskAdapter;
import br.senai.sp.informatica.sidvet.task.TaskRest;
import br.senai.sp.informatica.sidvet.util.FormValidatorUtil;
import br.senai.sp.informatica.sidvet.util.TextWatcherUtil;

public class MainActivity extends BaseActivity {

    String userEmail = "teste@teste.com";
    String userPassword = "teste";

    //componentes da tela
    TextInputLayout emailLayout;
    TextInputLayout senhaLayout;

    TextInputEditText editEmail;
    TextInputEditText editSenha;

    Login l;
    public static Cliente cliente;

    @Override
    protected void inicializarComponnetes() {
        setupToolbar();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponnetes();

        senhaLayout = (TextInputLayout) findViewById(R.id.input_senha_layout);
        editSenha = (TextInputEditText) findViewById(R.id.input_senha);

        emailLayout = (TextInputLayout) findViewById(R.id.input_email_layout);
        editEmail = (TextInputEditText) findViewById(R.id.input_email);

        editEmail.addTextChangedListener( new TextWatcherUtil(this, emailLayout, editEmail));

        editSenha.addTextChangedListener( new TextWatcherUtil(this, senhaLayout, editSenha));

    }

    public void loginOnClick(View view) {
        if(isFormValid()){
            login();
        }
    }

    private void login(String email, String senha) {
        if (email.equals(userEmail) && senha.equals(userPassword)) {
            startActivity(new Intent(this, HomeActivity.class));
        }
    }

    private void login() {
        JsonParser<Login> jsonParser;
        String json;

        if(l== null){
            l = new Login();
        }
        l.setEmail(editEmail.getEditableText().toString());
        l.setSenha(editSenha.getEditableText().toString());

        jsonParser = new JsonParser<>(Login.class);
        json = jsonParser.fromObject(l);
        new TaskRest(TaskRest.RequestMethod.POST, handler).execute(RestAddress.login, json);

    }



    private boolean isFormValid() {
        //valida o email
        if (!FormValidatorUtil.isValidEmail(editEmail.getEditableText().toString())) {
            emailLayout.setError(getString(R.string.email_error_msg));
            editEmail.requestFocus();
            return false;
        } else {
            return true;
        }


    }

    private HandlerTask handler = new HandlerTaskAdapter(){
        @Override
        public void onSucess(String s) {
            super.onSucess(s);
            if(s.equals("Usuário ou senha INVÁLIDOS")){
                Toast.makeText(MainActivity.this, getString(R.string.erro_Login), Toast.LENGTH_SHORT).show();
            } else {
                fazLogin(cliente);
            }
        }

        @Override
        public void onError(Exception erro) {
            super.onError(erro);
            Toast.makeText(MainActivity.this, getString(R.string.erro_Login), Toast.LENGTH_SHORT).show();
            Log.e(erro.getMessage(), "TAG");
        }
    };

    private void fazLogin(Cliente c) {
        Intent intent = new Intent(this, HomeActivity.class);
        Bundle b = new Bundle();
        b.putParcelable("cliente", Parcels.wrap(c));
        startActivity(intent);
    }


}
