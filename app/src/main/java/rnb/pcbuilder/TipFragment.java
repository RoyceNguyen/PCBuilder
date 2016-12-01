package rnb.pcbuilder;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TipFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TipFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TipFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView TipTextView;
    ListView list;

    private OnFragmentInteractionListener mListener;

    public TipFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TipFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TipFragment newInstance(String param1, String param2) {
        TipFragment fragment = new TipFragment();
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
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        TipTextView = (TextView) view.findViewById(R.id.tipListDescription);
        list = (ListView) view.findViewById(R.id.TipList);
        ArrayList<TipItem> tiplist = new ArrayList<TipItem>();
        tiplist.add(new TipItem("String", "Stores text"));
        tiplist.add(new TipItem("char", "Stores a character"));
        tiplist.add(new TipItem("Boolean", "Stores true or false"));
        tiplist.add(new TipItem("Int", "Stores a whole number"));
        tiplist.add(new TipItem("double", "Stores a decimal number"));
        tiplist.add(new TipItem("object", "Stores an object of an objects datatype"));
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, tiplist);
        CustomAdapter adapter1 = new CustomAdapter(getContext(), tiplist);
        list.setAdapter(adapter1);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TipItem item = (TipItem) list.getItemAtPosition(position);
                TipTextView.setText(item.getTip());
            }
        });

        return view;
    }

    public class CustomAdapter extends ArrayAdapter<TipItem>{
        public CustomAdapter(Context context, ArrayList<TipItem> items){
            super(context, 0, items);

        }
        public View getView(int position, View convertView, ViewGroup parent){
            TipItem item = getItem(position);

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_view, parent, false);
            }
            TextView name = (TextView) convertView.findViewById(R.id.name);
            name.setText(item.getName());
            return convertView;
        }
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
}
