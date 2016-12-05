package rnb.pcbuilder;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.NumberFormat;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CostFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CostFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CostFragment extends Fragment {
    private int totalAmount = 0;
    private TextView totalTextView;
    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;
    private RadioGroup radioGroup3;
    private RadioGroup radioGroup4;
    private RadioGroup radioGroup5;
    private RadioGroup radioGroup6;

    private int radioGroup1Value = 0;
    private int radioGroup2Value = 0;
    private int radioGroup3Value = 0;
    private int radioGroup4Value = 0;
    private int radioGroup5Value = 0;
    private int radioGroup6Value = 0;
    private static final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CostFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CostFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CostFragment newInstance(String param1, String param2) {
        CostFragment fragment = new CostFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cost, container, false);
        TextView totalTextView = (TextView)view.findViewById(R.id.totalTextView);
         radioGroup6 = (RadioGroup)view.findViewById(R.id.radioGroup6);
         radioGroup5 = (RadioGroup)view.findViewById(R.id.radioGroup5);
         radioGroup4 = (RadioGroup)view.findViewById(R.id.radioGroup4);
         radioGroup3 = (RadioGroup)view.findViewById(R.id.radioGroup3);
         radioGroup2 = (RadioGroup)view.findViewById(R.id.radioGroup2);
         radioGroup1 = (RadioGroup)view.findViewById(R.id.radioGroup1);

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                        switch (checkedId) {
                            case R.id.cpu1:
                                radioGroup1Value = 100;
                                break;
                            case R.id.cpu2:
                                radioGroup1Value = 200;
                                break;
                            case R.id.cpu3:
                                radioGroup1Value = 300;
                                break;
                        }
                        calculate();

            }
        });
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.mb1:
                        radioGroup2Value = 60;
                        break;
                    case R.id.mb2:
                        radioGroup2Value = 150;
                        break;
                    case R.id.mb3:
                        radioGroup2Value = 250;
                        break;
                }
                calculate();
            }
        });
        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.ram1:
                        radioGroup3Value = 30;
                        break;
                    case R.id.ram2:
                        radioGroup3Value = 60;
                        break;
                    case R.id.ram3:
                        radioGroup3Value = 120;
                        break;
                }
                calculate();
            }
        });
        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.gpu1:
                        radioGroup4Value = 180;
                        break;
                    case R.id.gpu2:
                        radioGroup4Value = 350;
                        break;
                    case R.id.gpu3:
                        radioGroup4Value = 800;
                        break;
                }
                calculate();
            }
        });
        radioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.storage1:
                        radioGroup5Value = 60;
                        break;
                    case R.id.storage2:
                        radioGroup5Value = 120;
                        break;
                    case R.id.storage3:
                        radioGroup5Value = 250;
                        break;
                }
                calculate();
            }
        });
        radioGroup6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.ps1:
                        radioGroup6Value = 60;
                        break;
                    case R.id.ps2:
                        radioGroup6Value = 120;
                        break;
                    case R.id.ps3:
                        radioGroup6Value = 220;
                        break;
                }
                calculate();
            }
        });

        totalTextView.setText(currencyFormat.format(0));



        return view;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public void calculate(){
        totalAmount = radioGroup1Value + radioGroup2Value + radioGroup3Value + radioGroup4Value + radioGroup5Value + radioGroup6Value;
        totalTextView.setText(currencyFormat.format(totalAmount));
    }
}
