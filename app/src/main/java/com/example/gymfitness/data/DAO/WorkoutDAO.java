package com.example.gymfitness.data.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.gymfitness.data.Entities.Workout;

import java.util.List;

@Dao
public interface WorkoutDAO {
    @Query("SELECT * FROM Workout")
    List<Workout> getAllWorkouts();

    @Insert
    void insertWorkout(Workout workout);

}