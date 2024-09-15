package com.example.gymfitness.adapters.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gymfitness.R;
import com.example.gymfitness.data.entities.Exercise;
import com.example.gymfitness.data.entities.Round;
import com.example.gymfitness.data.entities.Workout;
import com.example.gymfitness.databinding.RoundItemBinding;
import com.example.gymfitness.viewmodels.SharedViewModel;

import java.util.ArrayList;

public class RoundRCVAdapter extends RecyclerView.Adapter<RoundRCVAdapter.RoundHolder> {

    private ArrayList<Round> listRound;

    public RoundRCVAdapter(ArrayList<Round> list)
    {
        this.listRound = list;
    }



    @NonNull
    @Override
    public RoundRCVAdapter.RoundHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RoundItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.round_item, parent, false);
        NavController navController = Navigation.findNavController(parent);
        SharedViewModel sharedViewModel = new ViewModelProvider((ViewModelStoreOwner) parent.getContext()).get(SharedViewModel.class);
        return new RoundRCVAdapter.RoundHolder(binding, navController,sharedViewModel);
    }

    static class RoundHolder extends RecyclerView.ViewHolder {
        private RoundItemBinding binding;
        private NavController navController;
        private SharedViewModel sharedViewModel;

        public RoundHolder(@NonNull RoundItemBinding binding, NavController navController, SharedViewModel sharedViewModel) {
            super(binding.getRoot());
            this.binding = binding;
            this.navController = navController;
            this.sharedViewModel = sharedViewModel;
        }
        public void bind(Round round) {
            binding.setRound(round);
            binding.executePendingBindings();
            ExerciseRCVAdapter exerciseAdapter = new ExerciseRCVAdapter(round.getExercises());
            binding.rcvExecercise.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));
            binding.rcvExecercise.setAdapter(exerciseAdapter);
            exerciseAdapter.setOnItemClickListener(new ExerciseRCVAdapter.OnExerciseListener() {
                @Override
                public void onItemClick(Exercise exercise) {
                    sharedViewModel.selectExercise(exercise);
                    navController.navigate(R.id.action_exerciseRoutineFragment_to_exerciseDetail);
                }
            });
        }
    }

    @NonNull
    @Override
    public void onBindViewHolder(@NonNull RoundRCVAdapter.RoundHolder holder, int position) {
        Round round = listRound.get(position);
        holder.bind(round);
    }

    @Override
    public int getItemCount() {
        return listRound == null ? 0 : listRound.size();
    }

}
