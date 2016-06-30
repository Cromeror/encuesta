package com.crom.encuesta.view_controller.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.crom.encuesta.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookmarkFragmento extends Fragment {


    public BookmarkFragmento() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bookmark_fragmento, container, false);
        TextView t1 = (TextView) view.findViewById(R.id.t1);
        TextView t2 = (TextView) view.findViewById(R.id.t2);
        TextView t3 = (TextView) view.findViewById(R.id.t3);
        TextView t4 = (TextView) view.findViewById(R.id.t4);
        TextView t5 = (TextView) view.findViewById(R.id.t5);
        TextView t6 = (TextView) view.findViewById(R.id.t6);
        TextView t7 = (TextView) view.findViewById(R.id.t7);
        TextView t8 = (TextView) view.findViewById(R.id.t8);
        TextView t9 = (TextView) view.findViewById(R.id.t9);
        TextView t10 = (TextView) view.findViewById(R.id.t10);
        TextView t11 = (TextView) view.findViewById(R.id.t11);
        TextView t12 = (TextView) view.findViewById(R.id.t12);
        TextView t13 = (TextView) view.findViewById(R.id.t13);
        TextView t14 = (TextView) view.findViewById(R.id.t14);
        TextView t15 = (TextView) view.findViewById(R.id.t15);
        TextView t16 = (TextView) view.findViewById(R.id.t16);
        TextView t17 = (TextView) view.findViewById(R.id.t17);
        TextView t18 = (TextView) view.findViewById(R.id.t18);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.contenedor, new IdentificacionFragment()).commit();
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.contenedor, new ViviendaHogarFragment()).commit();
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.contenedor, new CaracteristicaHogarFragment()).commit();
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.contenedor, new MiembroHogarFragment()).commit();
            }
        });
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaludFragment salud = new SaludFragment();
                Bundle bundle = new Bundle();
                bundle.putString(SaludFragment.PARAM_CONTENT, "true");
                salud.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.contenedor, salud).commit();
            }
        });
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.contenedor, new EducacionFragment()).commit();
            }
        });
        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.contenedor, new FuerzaFragment()).commit();
            }
        });
        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.contenedor, new OcupadoFragment()).commit();
            }
        });
        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.contenedor, new OcupadosAsalariadosFragment()).commit();
            }
        });
        t10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.contenedor, new OcupadoIndependienteFragment()).commit();
            }
        });
        t11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.contenedor, new OcupadosAsalariadosIndependientesFragment()).commit();
            }
        });
        t12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.contenedor, new OcupadoTrabajoSecundarioFragment()).commit();
            }
        });
        t13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.contenedor, new CalidadEmpleoFragment()).commit();
            }
        });
        t14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.contenedor, new CalidadEmpleoFragment()).commit();
            }
        });
        t15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.contenedor, new DesocupadosFragment()).commit();
            }
        });
        t16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.contenedor, new InactivosFragment()).commit();
            }
        });
        t17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.contenedor, new OtrosIngresosFragment()).commit();
            }
        });
        t18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().replace(R.id.contenedor, new TicsFragment()).commit();
            }
        });
        return view;
    }

}
