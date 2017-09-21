package br.senai.sp.informatica.sidvet.util;

import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;

import br.senai.sp.informatica.sidvet.R;

/**
 * Created by Tecnico_Tarde on 06/06/2017.
 */

public class TextWatcherUtil implements TextWatcher {

    //atributos
    TextInputEditText editText;
    TextInputLayout layout;
    Context context;


    //construtor
    public TextWatcherUtil(Context context, TextInputLayout layout, TextInputEditText editText) {
        this.context = context;
        this.layout = layout;
        this.editText = editText;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        //verifica o id do EditText
        switch (this.editText.getId()){
            case R.id.input_email:
                //valida o email
                //se NÃO é uma senha
                if (!FormValidatorUtil.isValidEmail(editText.getEditableText().toString())){
                    layout.setError(context.getString(R.string.email_error_msg));
                    editText.requestFocus();
                }else{
                    //se é um email
                    layout.setErrorEnabled(false);
                }
                break;
        }
    }
}
