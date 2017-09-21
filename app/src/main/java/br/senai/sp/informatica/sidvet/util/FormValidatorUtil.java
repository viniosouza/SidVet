package br.senai.sp.informatica.sidvet.util;

import android.text.TextUtils;
import android.util.Patterns;

/**
 * Created by Tecnico_Tarde on 05/06/2017.
 */

public class FormValidatorUtil {

    public static boolean isValidEmail(String email){
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

}
