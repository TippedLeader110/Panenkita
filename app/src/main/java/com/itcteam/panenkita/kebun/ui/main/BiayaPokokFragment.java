package com.itcteam.panenkita.kebun.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.itcteam.panenkita.R;
import com.itcteam.panenkita.kebun.Kebun;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BiayaPokokFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BiayaPokokFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Kebun listener;

    public BiayaPokokFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment Spot.
     */
    // TODO: Rename and change types and number of parameters
    public static BiayaPokokFragment newInstance(String param1) {
        BiayaPokokFragment fragment = new BiayaPokokFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_biayapokok, container, false);

        return root;
    }

}