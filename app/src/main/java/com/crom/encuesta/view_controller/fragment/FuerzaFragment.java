package com.crom.encuesta.view_controller.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.crom.encuesta.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FuerzaFragment extends Fragment {
    private static final String PARAM_EDAD = "Edad";
    private Button next;
    private View view;
    private FragmentTransaction transaction;

    public FuerzaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fuerza, container, false);
        getActivity().setTitle(getActivity().getString(R.string.capMHogarD));
        transaction = getActivity().getSupportFragmentManager().beginTransaction();
        next = (Button) view.findViewById(R.id.next_salud_btn);
        init();

        Spinner fuerza_1 = (Spinner) view.findViewById(R.id.fuerza_1);
        ArrayAdapter spinner_adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.actividad_ocupo_mayor_tiempo_mayo, android.R.layout.simple_spinner_item);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fuerza_1.setAdapter(spinner_adapter);
        fuerza_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                String scountry = adapter.getItemAtPosition(position).toString();
                // Showing selected spinner item
                if (scountry.equalsIgnoreCase("trabajando")) {
                    transaction.replace(R.id.contenedor, new OcupadoFragment()).commit();
                }
                if (scountry.equalsIgnoreCase("incapacitado permanentemente para trabajar")) {
                    transaction.replace(R.id.contenedor, new InactivosFragment()).commit();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        Spinner fuerza_2 = (Spinner) view.findViewById(R.id.fuerza_2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.sino_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fuerza_2.setAdapter(adapter2);
        fuerza_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v, int position, long id) {
                if (position == 1) {
                    Log.i("###PERGUNTA###", "2");
                    transaction.replace(R.id.contenedor, new OcupadoFragment()).commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        Spinner fuerza_3 = (Spinner) view.findViewById(R.id.fuerza_3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(getActivity(),
                R.array.sino_array, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fuerza_3.setAdapter(adapter3);
        fuerza_3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 1) {
                    Log.i("###PERGUNTA###", "3");
                    transaction.replace(R.id.contenedor, new OcupadoFragment()).commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Spinner fuerza_4 = (Spinner) view.findViewById(R.id.fuerza_4);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(getActivity(),
                R.array.sino_array, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fuerza_4.setAdapter(adapter4);
        fuerza_4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 1) {
                    Log.i("###PERGUNTA###", "4");
                    transaction.replace(R.id.contenedor, new OcupadoFragment()).commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Spinner fuerza_5 = (Spinner) view.findViewById(R.id.fuerza_5);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(getActivity(),
                R.array.sino_array, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fuerza_5.setAdapter(adapter5);
        fuerza_5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 2) {
                    ((LinearLayout) view.findViewById(R.id.l6)).setVisibility(View.GONE);
                } else if (i == 1) {
                    ((LinearLayout) view.findViewById(R.id.l6)).setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        Spinner fuerza_6 = (Spinner) view.findViewById(R.id.fuerza_6);
        ArrayAdapter spinner_adapter_6 = ArrayAdapter.createFromResource(getActivity(),
                R.array.fuerza_6, android.R.layout.simple_spinner_item);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fuerza_6.setAdapter(spinner_adapter_6);
        fuerza_6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // On selecting a spinner item
                String scountry = adapter.getItemAtPosition(position).toString();
                // Showing selected spinner item
                if (scountry.equalsIgnoreCase("Pidió ayuda a familia, amigos, colegas\n")) {

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        Spinner fuerza_7 = (Spinner) view.findViewById(R.id.fuerza_7);
        ArrayAdapter<CharSequence> adapter7 = ArrayAdapter.createFromResource(getActivity(),
                R.array.sino_array, android.R.layout.simple_spinner_item);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fuerza_7.setAdapter(adapter7);
        fuerza_7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 2) {
                    transaction.replace(R.id.contenedor, new InactivosFragment()).commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        final EditText t8 = (EditText) view.findViewById(R.id.t8);
        t8.setVisibility(View.GONE);
        Spinner fuerza_8 = (Spinner) view.findViewById(R.id.fuerza_8);
        ArrayAdapter spinner_adapter_8 = ArrayAdapter.createFromResource(getActivity(),
                R.array.fuerza_8, android.R.layout.simple_spinner_item);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fuerza_8.setAdapter(spinner_adapter_8);
        fuerza_8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                if (position == 1) {
                    ((LinearLayout) view.findViewById(R.id.l8)).setVisibility(View.GONE);
                    t8.setVisibility(View.GONE);
                } else if (position == 9) {
                    transaction.replace(R.id.contenedor, new InactivosFragment()).commit();
                } else if (position == 13) {
                   /* if (((LinearLayout) view.findViewById(R.id.l8)).getVisibility() == View.GONE) {
                        ((LinearLayout) view.findViewById(R.id.l8)).setVisibility(View.VISIBLE);
                    }*/
                    ((LinearLayout) view.findViewById(R.id.l8)).setVisibility(View.VISIBLE);
                    t8.setVisibility(View.VISIBLE);
                } else {
                    ((LinearLayout) view.findViewById(R.id.l8)).setVisibility(View.VISIBLE);
                    t8.setVisibility(View.GONE);
                }
                //((TextView) view.findViewById(R.id.tv8)).requestFocus();

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        final Spinner fuerza_10 = (Spinner) view.findViewById(R.id.fuerza_10);
        ((LinearLayout) view.findViewById(R.id.l10)).setVisibility(View.VISIBLE);
        Spinner fuerza_9 = (Spinner) view.findViewById(R.id.fuerza_9);
        ArrayAdapter<CharSequence> adapter9 = ArrayAdapter.createFromResource(getActivity(),
                R.array.sino_array, android.R.layout.simple_spinner_item);
        adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fuerza_9.setAdapter(adapter9);
        fuerza_9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View v, int i, long l) {
                 if (i == 2) {
                   ((LinearLayout) view.findViewById(R.id.l10)).setVisibility(View.GONE);
                } else {
                    ((LinearLayout) view.findViewById(R.id.l10)).setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<CharSequence> adapter10 = ArrayAdapter.createFromResource(getActivity(),
                R.array.sino_array, android.R.layout.simple_spinner_item);
        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fuerza_10.setAdapter(adapter10);
        fuerza_10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View v, int i, long l) {
                if (i == 1) {
                    ((LinearLayout) view.findViewById(R.id.l11)).setVisibility(View.GONE);
                } else if (i == 2) {
                    transaction.replace(R.id.contenedor, new InactivosFragment()).commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Spinner fuerza_11 = (Spinner) view.findViewById(R.id.fuerza_11);
        ArrayAdapter<CharSequence> adapter11 = ArrayAdapter.createFromResource(getActivity(),
                R.array.sino_array, android.R.layout.simple_spinner_item);
        adapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fuerza_11.setAdapter(adapter11);
        fuerza_11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View v, int i, long l) {
                if (i == 2) {
                    transaction.replace(R.id.contenedor, new InactivosFragment()).commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Spinner fuerza_13 = (Spinner) view.findViewById(R.id.fuerza_13);
        ArrayAdapter<CharSequence> adapter13 = ArrayAdapter.createFromResource(getActivity(),
                R.array.sino_array, android.R.layout.simple_spinner_item);
        adapter13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fuerza_13.setAdapter(adapter13);
        fuerza_13.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View v, int i, long l) {
                if (i==1){
                    transaction.replace(R.id.contenedor, new DesocupadosFragment()).commit();
                }else if (i == 2) {
                    transaction.replace(R.id.contenedor, new InactivosFragment()).commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ((TextView) view.findViewById(R.id.tv1)).requestFocus();
        return view;
    }

    private void init() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //transaction.replace(R.id.contenedor, SaludFragment.newInstance(edad)).commit();
                /*Intent i = new Intent(v.getContext(),FamilyActivity.class);
                startActivity(i);*/

                transaction.replace(R.id.contenedor, new OcupadoFragment()).commit();
            }
        });


    }

}
