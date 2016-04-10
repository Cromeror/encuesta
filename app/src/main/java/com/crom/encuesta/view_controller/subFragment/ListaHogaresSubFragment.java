package com.crom.encuesta.view_controller.subFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crom.encuesta.R;

public class ListaHogaresSubFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String SIZE = "size";

    // TODO: Rename and change types of parameters
    private int size;

    public ListaHogaresSubFragment() {
        // Required empty public constructor
    }

    public static ListaHogaresSubFragment newInstance(int size) {
        ListaHogaresSubFragment fragment = new ListaHogaresSubFragment();
        Bundle args = new Bundle();
        args.putInt(SIZE, size);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            size = getArguments().getInt(SIZE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_hogares_sub, container, false);
        Log.i("INFOOOOO",size+"");
        return view;
    }

}
