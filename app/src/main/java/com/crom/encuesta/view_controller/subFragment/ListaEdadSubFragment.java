package com.crom.encuesta.view_controller.subFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.crom.encuesta.R;
import com.crom.encuesta.view_controller.custom.IntegranteHogar;
import com.crom.encuesta.view_controller.custom.IntegranteHogarAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaEdadSubFragment extends Fragment {

    private static final String SIZE = "size";

    private ArrayList<IntegranteHogar> animales;
    private ListView lvAnimales;
    private IntegranteHogarAdapter adapter;
    private TextView tvNombre, tvNumCelda;

    public ListaEdadSubFragment() {
        // Required empty public constructor
    }
    public  static ListaEdadSubFragment newInstance(int size){
        ListaEdadSubFragment instance = new ListaEdadSubFragment();
        Bundle args = new Bundle();
        args.putInt(SIZE, size);
        instance.setArguments(args);
        return instance;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.subfragment_edades, container, false);
// Inicializamos las variables.
        animales = new ArrayList<IntegranteHogar>();

        rellenarArrayList();

        //tvNombre = (TextView) view.findViewById(R.id.tvItemContent);
        //tvNumCelda = (TextView) view.findViewById(R.id.tvItemField);

        adapter = new IntegranteHogarAdapter(view.getContext(), animales);

        lvAnimales = (ListView) view.findViewById(R.id.lvItems);
        // Asignamos el Adapter al ListView, en este punto hacemos que el
        // ListView muestre los datos que queremos.
        lvAnimales.setAdapter(adapter);
        // Asignamos el Listener al ListView para cuando pulsamos sobre uno de
        // sus items.
        //lvAnimales.setOnItemClickListener(this);

        return view;
    }
    private void rellenarArrayList() {
        int size = getArguments().getInt(SIZE);
        for (int i =0;i<size;i++)
            animales.add(new IntegranteHogar("aguila", R.drawable.ic_menu_camera));
    }
}
