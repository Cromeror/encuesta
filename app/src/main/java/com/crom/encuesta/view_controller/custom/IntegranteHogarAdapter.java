package com.crom.encuesta.view_controller.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import com.crom.encuesta.R;

/**
 * Created by Katherine Buelvas on 01/04/2016.
 */

public class IntegranteHogarAdapter extends ArrayAdapter<IntegranteHogar> {
    private Context context;
    private ArrayList<IntegranteHogar> datos;

    /**
     * Constructor del Adapter.
     *
     * @param context
     *            context de la Activity que hace uso del Adapter.
     * @param datos
     *            Datos que se desean visualizar en el ListView.
     */
    public IntegranteHogarAdapter(Context context, ArrayList datos) {
        super(context, R.layout.listview_item, datos);
        // Guardamos los parametros en variables de clase.
        this.context = context;
        this.datos = datos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;
        IntegranteHogarHolder holder;

        if (item == null) {
            item = LayoutInflater.from(context).inflate(R.layout.listview_item,
                    null);
            // Inicializamos el holder y guardamos las referencias a los
            // controles.
            holder = new IntegranteHogarHolder();
            holder.parentesco = (Spinner) item.findViewById(R.id.spinner_parentesco);
            // Almacenamos el holder en el Tag de la vista.
            item.setTag(holder);
        }
        // Recuperamos el holder del Tag de la vista.
        holder = (IntegranteHogarHolder) item.getTag();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(item.getContext(),
                R.array.parentesco_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.parentesco.setAdapter(adapter);

        return item;
    }

}
