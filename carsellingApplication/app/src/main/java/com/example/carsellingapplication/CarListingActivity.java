package com.example.carsellingapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class CarListingActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CarAdapter carAdapter;
    private List<Car> carList;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_listing);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        carList = new ArrayList<>();
        carAdapter = new CarAdapter(carList);
        recyclerView.setAdapter(carAdapter);
        db = FirebaseFirestore.getInstance();

        loadCars();
    }

    private void loadCars() {
        db.collection("cars").addSnapshotListener((value, error) -> {
            if (error != null) {
                Toast.makeText(CarListingActivity.this, "Error loading cars.", Toast.LENGTH_SHORT).show();
                return;
            }

            if (value != null) {
                carList.clear();
                for (QueryDocumentSnapshot doc : value) {
                    Car car = doc.toObject(Car.class);
                    carList.add(car);
                }
                carAdapter.notifyDataSetChanged();
            }
        });
    }
}