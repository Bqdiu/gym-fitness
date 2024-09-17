package com.example.gymfitness.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gymfitness.data.entities.Exercise;
import com.example.gymfitness.data.entities.Workout;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<Workout> selected = new MutableLiveData<Workout>();

    public void select(Workout item) {
        selected.setValue(item);
    }

    public LiveData<Workout> getSelected() {
        return selected;
    }

    public final MutableLiveData<Exercise> exerciseSelected = new MutableLiveData<Exercise>();

    public void selectExercise(Exercise exercise)
    {
        exerciseSelected.setValue(exercise);
    }

    public LiveData<Exercise> getExerciseSelected()
    {
        return this.exerciseSelected;
    }

    private final MutableLiveData<String> selectedArticleTitle = new MutableLiveData<>();

    public void setSelectedArticle(String articleTitle) {
        selectedArticleTitle.setValue(articleTitle);
    }

    public LiveData<String> getSelectedArticle() {
        return selectedArticleTitle;
    }
}