package com.crom.encuesta.view_controller.custom;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.widget.TextView;

import com.crom.encuesta.R;
import com.crom.encuesta.view_controller.MainActivity;
import com.crom.encuesta.view_controller.fragment.CaracteristicaHogarFragment;
import com.crom.encuesta.view_controller.fragment.ViviendaFragment;

import java.util.ArrayList;

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
                        if(saveMultipleChoice(((MainActivity) activity), c)){
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

    private boolean saveMultipleChoice(MainActivity mainActivity, Class c) {
        if (ViviendaFragment.class.equals(c)) {
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

    public void dialogIncompleteField(Activity activity, String message){
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
