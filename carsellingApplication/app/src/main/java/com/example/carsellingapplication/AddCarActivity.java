package com.example.carsellingapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

public class AddCarActivity extends AppCompatActivity {
    private EditText carNameEditText, carPriceEditText;
    private Button addCarButton;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        carNameEditText = findViewById(R.id.carName);
        carPriceEditText = findViewById(R.id.carPrice);
        addCarButton = findViewById(R.id.addCarButton);
        db = FirebaseFirestore.getInstance();

        addCarButton.setOnClickListener(v -> addCar());
    }

    private void addCar() {
        String name = carNameEditText.getText().toString();
        String price = carPriceEditText.getText().toString();

        Car car = new Car(name, price);
        db.collection("cars").add(car)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(AddCarActivity.this, "Car added.", Toast.LENGTH_SHORT).show();
                    finish();
                })
                .addOnFailureListener(e -> Toast.makeText(AddCarActivity.this, "Error adding car.", Toast.LENGTH_SHORT).show());
    }
}