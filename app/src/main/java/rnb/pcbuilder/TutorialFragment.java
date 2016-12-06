package rnb.pcbuilder;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TutorialFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TutorialFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TutorialFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private SectionPagerAdapter mSectionsPagerAdapter;
    private OnFragmentInteractionListener mListener;
    private ViewPager mViewPager;

    public TutorialFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TutorialFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TutorialFragment newInstance(String param1, String param2) {
        TutorialFragment fragment = new TutorialFragment();
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
        View view = inflater.inflate(R.layout.fragment_tutorial, container, false);
        mSectionsPagerAdapter = new SectionPagerAdapter(getChildFragmentManager());
        mViewPager = (ViewPager)  view.findViewById(R.id.tutorialContent);
        mViewPager.setAdapter(mSectionsPagerAdapter);
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

    public class SectionPagerAdapter extends FragmentPagerAdapter {
        public SectionPagerAdapter(FragmentManager fm){
            super(fm);
        }
        public Fragment getItem(int position)
        {
            switch(position){
                case 0: return FactFragment.newInstance("Step 1:\n Get the proper screwdriver - Usually a Phillips head screwdriver");
                case 1: return FactFragment.newInstance("Step 2:\n Open the case - Unscrew the thumbscrews on either side to open the case up");
                case 2: return FactFragment.newInstance("Step 3:\n Install the CPU - Remove the CPU from the plastic and DO NOT touch the gold pins on the bottom. On the motherboard, push the CPU cover up then the lever on the side. Place the CPU in gently using the arrows to line it up");
                case 3: return FactFragment.newInstance("Step 4:\n Add the heatsink - The heastsink will fit right over the processor. It has 4 screws");
                case 4: return FactFragment.newInstance("Step 5:\n Install the RAM - Unlock the clips on the RAM slots, install the RAM in the correct slot then push down on both sides of the module");
                case 5: return FactFragment.newInstance("Step 6:\n Install the motherboard - Place the motherboard in the case and place it in matching up with the ports. Secure the motherboard to the case once it is placed in position with the screws it came with");
                case 6: return FactFragment.newInstance("Step 7:\n Install the graphics card - Remove the expansion slot covers on the back of the case, slide the GPU into place then push it down into the slot on the motherboard.");
                case 7: return FactFragment.newInstance("Step 8:\n Install the hard drive - Secure your hard drive to the back of your hard drive bracket and slide it back into the bay");
                case 8: return FactFragment.newInstance("Step 9:\n Install the power supply - Remove the thumbscrews securing your power supply bracket. Attach it to the bracket with supplied screws then thread the cables through the case");
                case 9: return FactFragment.newInstance("Step 10:\n Attach all the cables - Attach all the cables to the designated spots, the GPU power pins and the PSU cable to the motherboard and the hard drive sata cable, CPU power pins, heatsink cables and finally the fans from the case");
                default: return FactFragment.newInstance("Step 10:\n Attach all the cables - Attach all the cables to the designated spots, the GPU power pins and the PSU cable to the motherboard and the hard drive sata cable, CPU power pins, heatsink cables and finally the fans from the case");
            }
        }
        public int getCount(){
            return 10;
        }
    }
}
