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
import com.crom.encuesta.model.FuerzaTrabajo;
import com.crom.encuesta.persistence.EducacionDAO;
import com.crom.encuesta.persistence.FuerzaTrabajoDAO;
import com.crom.encuesta.view_controller.MainActivity;

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
        return view;
    }

    private void init() {
        Spinner fuerza_1 = (Spinner) view.findViewById(R.id.fuerza_1);
        ArrayAdapter spinner_adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.actividad_ocupo_mayor_tiempo_mayo, android.R.layout.simple_spinner_item);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fuerza_1.setAdapter(spinner_adapter);
        fuerza_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                if(position == 1){
                    save(1);
                    transaction.replace(R.id.contenedor, new OcupadoFragment()).commit();
                }else if(position == 5){
                    save(1);
                    transaction.replace(R.id.contenedor, new InactivosFragment()).commit();
                }else if(position == 6){
                    ((EditText) view.findViewById(R.id.et1)).setVisibility(View.VISIBLE);
                }else {
                    save(0);
                    ((EditText) view.findViewById(R.id.et1)).setVisibility(View.GONE);
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
            public void onItemSelected(AdapterView<?> adapterView, View v, int i, long l) {
                if (i == 2) {
                    ((LinearLayout) view.findViewById(R.id.l6)).setVisibility(View.GONE);
                    ((LinearLayout) view.findViewById(R.id.l7_12)).setVisibility(View.VISIBLE);
                } else if (i == 1) {
                    ((LinearLayout) view.findViewById(R.id.l6)).setVisibility(View.VISIBLE);
                    ((LinearLayout) view.findViewById(R.id.l7_12)).setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
final EditText fuerza_6E = (EditText) view.findViewById(R.id.fuerza6_e);
        fuerza_6E.setVisibility(View.GONE);
        Spinner fuerza_6 = (Spinner) view.findViewById(R.id.fuerza_6);
        ArrayAdapter spinner_adapter_6 = ArrayAdapter.createFromResource(getActivity(),
                R.array.fuerza_6, android.R.layout.simple_spinner_item);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fuerza_6.setAdapter(spinner_adapter_6);
        fuerza_6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                if(position>0) {
                    if (position==7)
                        fuerza_6E.setVisibility(View.VISIBLE);
                    save(6);
                    ((LinearLayout) view.findViewById(R.id.l7_12)).setVisibility(View.GONE);
                }else
                save(0);
                    ((LinearLayout) view.findViewById(R.id.l7_12)).setVisibility(View.VISIBLE);
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
                    save(8);
                    ((LinearLayout) view.findViewById(R.id.l8)).setVisibility(View.GONE);
                    t8.setVisibility(View.GONE);
                } else if (position == 9) {
                    save(8);
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
                    save(9);
                    ((LinearLayout) view.findViewById(R.id.l10)).setVisibility(View.GONE);
                } else {
                    save(0);
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
                    save(10);
                    ((LinearLayout) view.findViewById(R.id.l11)).setVisibility(View.GONE);
                } else if (i == 2) {
                    save(10);
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
                    save(11);
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
                    save(13);
                    transaction.replace(R.id.contenedor, new DesocupadosFragment()).commit();
                }else if (i == 2) {
                    save(13);
                    transaction.replace(R.id.contenedor, new InactivosFragment()).commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ((TextView) view.findViewById(R.id.tv1)).requestFocus();

        EditText d12 = (EditText) view.findViewById(R.id.fuerza_12);
        d12.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                save(12);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.replace(R.id.contenedor, new OcupadoFragment()).commit();
            }
        });
    }
    public boolean save(int op){
        FuerzaTrabajo fuerzaTrabajo = new FuerzaTrabajo();
        ((MainActivity)getActivity()).getMiembro().setFuerzaTrabajo(fuerzaTrabajo);
        Spinner d1 = (Spinner) view.findViewById(R.id.fuerza_1);

        Spinner d2 = (Spinner) view.findViewById(R.id.fuerza_2);
        Spinner d3 = (Spinner) view.findViewById(R.id.fuerza_3);
        Spinner d4 = (Spinner) view.findViewById(R.id.fuerza_4);
        Spinner d5 = (Spinner) view.findViewById(R.id.fuerza_5);
        Spinner d6 = (Spinner) view.findViewById(R.id.fuerza_6);
        Spinner d7 = (Spinner) view.findViewById(R.id.fuerza_7);
        Spinner d8 = (Spinner) view.findViewById(R.id.fuerza_8);
        Spinner d9 = (Spinner) view.findViewById(R.id.fuerza_9);
        Spinner d10 = (Spinner) view.findViewById(R.id.fuerza_10);
        Spinner d11= (Spinner) view.findViewById(R.id.fuerza_11);
        EditText d12 = (EditText) view.findViewById(R.id.fuerza_12);
        Spinner d13 = (Spinner) view.findViewById(R.id.fuerza_13);
        switch (op){
            case 0:
                fuerzaTrabajo = new FuerzaTrabajo();
                Log.i("FUERZA0", fuerzaTrabajo.toString());
                break;
            case 1:
                if(d1.getSelectedItemPosition() == 6){
                    fuerzaTrabajo.setD1(((EditText) view.findViewById(R.id.et1)).getText().toString());
                }else
                    fuerzaTrabajo.setD1(d1.getSelectedItem().toString());
                Log.i("FUERZA1", fuerzaTrabajo.toString());
                break;
            case 2:
                fuerzaTrabajo.setD1(d1.getSelectedItem().toString());
                fuerzaTrabajo.setD2(d2.getSelectedItem().toString());
                break;
            case 3:
                save(2);
                fuerzaTrabajo.setD3(d3.getSelectedItem().toString());
                break;
            case 4:
                save(3);
                fuerzaTrabajo.setD4(d4.getSelectedItem().toString());
                break;
            case 5:
                save(4);
                fuerzaTrabajo.setD5(d5.getSelectedItem().toString());
                break;
            case 6:
                save(5);
                if(d6.getSelectedItemPosition()==7){
                    fuerzaTrabajo.setD5(((EditText) view.findViewById(R.id.fuerza6_e)).getText().toString());
                }else
                    fuerzaTrabajo.setD6(d5.getSelectedItem().toString());
                break;
            case 7:
                save(5);
                fuerzaTrabajo.setD7(d7.getSelectedItem().toString());
                break;
            case 8:
                save(7);
                if(d8.getSelectedItemPosition()==13){
                    fuerzaTrabajo.setD8(((EditText) view.findViewById(R.id.t8)).getText().toString());
                }else {
                    fuerzaTrabajo.setD8(d8.getSelectedItem().toString());
                }
                break;
            case 9:
                save(8);
                fuerzaTrabajo.setD9(d9.getSelectedItem().toString());
                break;
            case 10:
                save(9);
                fuerzaTrabajo.setD10(d10.getSelectedItem().toString());
                break;
            case 11:
                save(10);
                fuerzaTrabajo.setD11(d11.getSelectedItem().toString());
                break;
            case 12:
                save(11);
                fuerzaTrabajo.setD12(d12.getText().toString());
            case 13:
                fuerzaTrabajo.setD13(d13.getSelectedItem().toString());
                break;
            default:
                return false;
        }
        fuerzaTrabajo.setMiembroId(((MainActivity) getActivity()).getMiembro().getId());
        Log.i("FUERZA Save", fuerzaTrabajo.toString());
        return true;
    }

}
