package com.example.gymfitness.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gymfitness.R;
import com.example.gymfitness.databinding.FragmentNotificationsWorkoutBinding;
import com.example.gymfitness.databinding.FragmentNotificationsWorkoutRemindersBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NotificationsWorkoutRemindersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NotificationsWorkoutRemindersFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NotificationsWorkoutRemindersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NotificationsWorkoutRemindersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NotificationsWorkoutRemindersFragment newInstance(String param1, String param2) {
        NotificationsWorkoutRemindersFragment fragment = new NotificationsWorkoutRemindersFragment();
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

    private FragmentNotificationsWorkoutRemindersBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotificationsWorkoutRemindersBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}