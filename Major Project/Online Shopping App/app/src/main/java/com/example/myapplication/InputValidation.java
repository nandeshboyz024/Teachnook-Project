package com.example.myapplication;

import android.content.Context;
import android.util.Patterns;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class InputValidation {

    private Context context;

    public InputValidation(Context context) {
        this.context = context;
    }

    public static boolean IsInputEditTextFilled(EditText edt, TextInputLayout l, String s){
        String value = edt.getText().toString().trim();
        if(value.isEmpty()){
            l.setError(s);
        //    hideKeyboardfrom(edt);
            return false;
        }
        else {
            l.setErrorEnabled(false);
        }
        return true;
    }
    public static boolean IsInputEditTextEmail(EditText edt, TextInputLayout l, String s){
        String value = edt.getText().toString().trim();
        if(value.isEmpty()|| !Patterns.EMAIL_ADDRESS.matcher(value).matches()){
            l.setError(s);
        //    hideKeyboardfrom(edt);
            return false;
        }
        else {
            l.setErrorEnabled(false);
        }
        return true;
    }

    public static boolean IsInputEditTextMatches(EditText edt1, EditText edt2, TextInputLayout l, String s){
        String value1 = edt1.getText().toString().trim();
        String value2 = edt2.getText().toString().trim();
        if(!value1.contentEquals(value2)){
            l.setError(s);
          //  hideKeyboardfrom(edt2);
            return false;
        }
        else {
            l.setErrorEnabled(false);
        }
        return true;
    }
//
//    private void hideKeyboardfrom(EditText edt) {
//
//    }
}
