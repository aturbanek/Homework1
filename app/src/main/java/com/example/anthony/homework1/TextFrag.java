package com.example.anthony.homework1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TextFrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TextFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TextFrag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private static final String ARG_PARAM4 = "param4";

    private int score = 0;

    private Button b1;
    private Button b2;
    private Button b3;

    private String[] q1 = {"What is the class number for this course?", "302", "407", "536"};
    private String[] q2 = {"What days do we have class?","M T W", "W TH F", "M W F"};
    private String[] q3 = {"What building is by the computer science building?", "Union south",
    "Memorial Union", "none of the above"};

    private String option1;
    private String option2;
    private String option3;
    private String option4;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TextFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TextFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static TextFrag newInstance(String param1, String param2, String param3, String param4) {
        TextFrag fragment = new TextFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        args.putString(ARG_PARAM4, param4);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            option1 = getArguments().getString(ARG_PARAM1);
            option2 = getArguments().getString(ARG_PARAM2);
            option3 = getArguments().getString(ARG_PARAM3);
            option4 = getArguments().getString(ARG_PARAM4);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_text, container, false);
        TextView q = (TextView) view.findViewById(R.id.textView3);
        b1 = (Button)view.findViewById(R.id.b1);
        b2 = (Button)view.findViewById(R.id.b2);
        b3 = (Button)view.findViewById(R.id.b3);

        if(option1==null)
        {
            q.setText(q1[0]);
            b1.setText(q1[1]);
            b2.setText(q1[2]);
            b3.setText(q1[3]);

        }
        else if (option2==null)
        {
            q.setText(q2[0]);
            b1.setText(q2[1]);
            b2.setText(q2[2]);
            b3.setText(q2[2]);

        }
        else
        {
            q.setText(q3[0]);
            b1.setText(q2[1]);
            b2.setText(q2[2]);
            b3.setText(q2[3]);
        }

        return view;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (option1 == null) {
                    getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.main_fragment_container, TextFrag.newInstance(q1[1], null, null, option4))
                            .commit();
                } else if (option2 == null) {
                    getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.main_fragment_container, TextFrag.newInstance(q2[1], null, null, option4))
                            .commit();

                } else {
                    option3 = q3[1];
                    score();
                }

            }

        });

        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (option1 == null) {
                    getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.main_fragment_container, TextFrag.newInstance(q1[2], null, null, option4))
                            .commit();
                } else if (option2 == null) {
                    getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.main_fragment_container, TextFrag.newInstance(q2[2], null, null, option4))
                            .commit();

                } else
                {
                    option3 = q3[2];
                    score();
                }

            }

        });
        b3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (option1 == null) {
                    getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.main_fragment_container, TextFrag.newInstance(q1[3], null, null, option4))
                            .commit();
                } else if (option2 == null) {
                    getFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.main_fragment_container, TextFrag.newInstance(q2[3], null, null, option4))
                            .commit();

                } else
                {
                    option3 = q3[3];
                    score();
                }

            }

        });
    }

    public void score()
    {
        if(option1.equals("407"))
        {
            score++;
        }
        if(option2.equals("M W F"))
        {
            score++;
        }
        if(option3.equals("Union South"))
        {
            score++;
        }
        if(option4.equals("correct"))
        {
            score++;
        }

        String output = "You answerd "+ " questions correct";
        displayScore(output);
    }

    private void displayScore(String output) {
        new AlertDialog.Builder(getActivity())
                .setCancelable(true)
                .setTitle("")
                .setMessage(output)
                .setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getFragmentManager().popBackStack();
                        getFragmentManager().popBackStack();
                        getFragmentManager().popBackStack();
                    }
                })
                .setNegativeButton("Quit", new DialogInterface.OnClickListener(){

                        @Override
                        public void onClick(DialogInterface dialog, int which){
                            getActivity().finish();
                        }

                })
                .show();




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
