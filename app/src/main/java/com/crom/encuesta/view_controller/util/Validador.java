package com.crom.encuesta.view_controller.util;

import android.app.Activity;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by cristobal on 24/06/16.
 */
public class Validador {
    public static String SELECCIONE = "Seleccione una opción";

    public static boolean isEmptySpinners(Spinner... spinners){
        for(Spinner spinner : spinners){
            if(spinner.getSelectedItem().toString().equals(SELECCIONE)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEmptyMultiCheckBoxes(CheckBox... checkBoxes){
        for(CheckBox checkBox: checkBoxes){
            if(checkBox.isChecked()) {
                return false;
            }
        }
        return true;
    }
    public static boolean isEmptyEditText(EditText ... editTexts){
        for(EditText editText : editTexts){
            if(editText.getText().toString().equals("")) {
                return true;
            }
        }
        return false;
    }
    public static boolean isEmptyTextView(TextView ... textViews){
        for(TextView textView : textViews){
            if(textView.getText().toString().equals("")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEmptyMultiChoice(TextView ... textViews){
        for (TextView textView : textViews){
            Log.i("####",textView.getText().toString());
            if(textView.getText().equals("Toque para seleccionar la respuesta")){
                return true;
            }
        }
        return false;
    }
}
