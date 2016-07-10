package com.crom.encuesta.view_controller.custom;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.crom.encuesta.R;
import com.crom.encuesta.view_controller.MainActivity;
import com.crom.encuesta.view_controller.fragment.CaracteristicaHogarFragment;
import com.crom.encuesta.view_controller.fragment.CaracteristicasViviendaFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Cristobal Romero on 18/06/2016.
 */

public class DialogBuilder {

    private ArrayList mSelectedItems;

    public DialogBuilder() {
        mSelectedItems = new ArrayList();
    }

    public ArrayList<String> MultipleChoiceList(final Class c, final TextView component, final Activity activity, final String title, final int array) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        final String arrayResource[] = activity.getResources().getStringArray(array);
        builder.setTitle(title)
                .setMultiChoiceItems(array, null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int position, boolean isChecked) {
                                //String item = arrayAdapter.getItem(0);
                                if (isChecked) {
                                    mSelectedItems.add(arrayResource[position]);
                                } else if (mSelectedItems.contains(arrayResource[position])) {
                                    mSelectedItems.remove(arrayResource[position]);
                                }
                            }
                        })
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        if (saveMultipleChoice(((MainActivity) activity), c)) {
                            component.setBackgroundColor(Color.WHITE);
                            component.setText("Completo");
                        }
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        mSelectedItems.clear();
                        component.setBackgroundColor(Color.RED);
                        component.setText(activity.getString(R.string.touch_me));
                    }
                });
        builder.create();
        builder.show();
        return mSelectedItems;
    }


    public ArrayList<String> MultipleChoiceList(final ArrayList<String> selectList, final TextView component, final Activity activity, final String title, final int array) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        final String arrayResource[] = activity.getResources().getStringArray(array);
        boolean checks[] = new boolean[activity.getResources().getStringArray(array).length];
        int index = 0;
        for (String elemento : arrayResource) {
            for (String itemCheck : selectList) {
                if (elemento.contains(itemCheck))
                    checks[index] = true;
            }
            if (checks[index] != true) {
                checks[index] = false;
            }
            index++;
        }
        //Toast.makeText(activity,"Cjhecks: "+Arrays.toString(checks), Toast.LENGTH_LONG).show();
        builder.setTitle(title)
                .setMultiChoiceItems(array, checks,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int position, boolean isChecked) {
                                //String item = arrayAdapter.getItem(0);
                                if (isChecked) {
                                    if (!selectList.contains(arrayResource[position]))
                                        selectList.add(arrayResource[position]);
                                } else if (selectList.contains(arrayResource[position])) {
                                    selectList.remove(arrayResource[position]);
                                }
                            }
                        })
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogI, int id) {
                        /*String element = "";//
                        for (int i = 0; i < selectList.size(); i++) {
                            if (stringStart("Otro, ¿Cual?",selectList.get(i))) {
                                selectList.remove(i);
                                final Dialog dialog = new Dialog(activity);
                                dialog.setContentView(R.layout.b5_dialog);
                                dialog.setTitle(activity.getString(R.string.personas_cuarto_vivienda));
                                Button aceptar = (Button) dialog.findViewById(R.id.dialog_btn);
                                final EditText editText = (EditText) dialog.findViewById(R.id.personas_dialog);
                                aceptar.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        selectList.add("Otro, ¿Cual?: " + editText.getText().toString());
                                        Toast.makeText(activity, "" + editText.getText().toString(), Toast.LENGTH_LONG).show();
                                        dialog.dismiss();
                                    }
                                });
                                dialog.show();
                            }
                        }*/
                        if(selectList.isEmpty()) {
                            component.setBackgroundColor(Color.RED);
                            component.setText(activity.getString(R.string.touch_me));
                        }else {
                            component.setBackgroundColor(Color.WHITE);
                            component.setText("Completo");
                        }
                    }
                });
        builder.create();
        builder.show();
        return selectList;
    }

    private boolean stringStart(String param, String text) {
        Pattern pat = Pattern.compile("^" + param + ".*");
        Matcher mat = pat.matcher(text);
        if (mat.matches()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean saveMultipleChoice(MainActivity mainActivity, Class c) {
        if (CaracteristicasViviendaFragment.class.equals(c)) {
            mainActivity.getVivienda().setServicios(mSelectedItems);
        } else if (CaracteristicaHogarFragment.class.equals(c)) {
            //Log.i("DIALOG",""+mainActivity.getVivienda().getHogares().size());
            if (mainActivity.getVivienda().getHogares().size() > 0) {
                mainActivity.getVivienda().getHogares().get(mainActivity.getVivienda().getHogares().size() - 1).setServiciosBienes(mSelectedItems);
            }
        }
        if (mSelectedItems.isEmpty()) {
            return false;
        }
        return true;
    }

    public void dialogIncompleteField(Activity activity, String message) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(message).setTitle("Formulario incompleto")
                .setCancelable(true)
                .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
