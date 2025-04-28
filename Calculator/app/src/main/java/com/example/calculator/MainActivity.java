package com.example.calculator;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView solution, result;
    MaterialButton t1, t2, t3, t4, t5, t6, t7, t8, t9, t0, t00;

    MaterialButton plus, into, divide, minus, per, ac, bc, equal;

    boolean lastNumeric = false; //Track if the last input was a number

    boolean lastOperator = false; //Track if the last input was a operator


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        solution=findViewById(R.id.solutionTv);
        result=findViewById(R.id.resultTv);

        assignId(plus, R.id.plusBtn);
        assignId(minus, R.id.subBtn);
        assignId(into, R.id.multiBtn);
        assignId(divide, R.id.divideBtn);
        assignId(per, R.id.perBtn);
        assignId(ac, R.id.acBtn);
        assignId(bc, R.id.bsBtn);
        assignId(equal, R.id.qualBtn);
        assignId(t1, R.id.oneBtn);
        assignId(t2, R.id.twoBtn);
        assignId(t3, R.id.thrBtn);
        assignId(t4, R.id.forBtn);
        assignId(t5, R.id.fivBtn);
        assignId(t6, R.id.sixBtn);
        assignId(t7, R.id.sevBtn);
        assignId(t8, R.id.EigBtn);
        assignId(t9, R.id.nineBtn);
        assignId(t00, R.id.dobzroBtn);
        assignId(t0, R.id.zroBtn);




    }
    void assignId(MaterialButton btn, int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String currentExpression = solution.getText().toString();

        if (buttonText.equals("AC")) {
            solution.setText("");
            result.setText("0");
            lastNumeric = false;
            lastOperator = false;
            return;
        }
        if (buttonText.equals("=")) {
            if (lastNumeric) {
                solution.setText(result.getText());
            }
            return;
        }
        if (buttonText.equals("BS")) {
            if (!currentExpression.isEmpty()) {
                currentExpression = currentExpression.substring(0, currentExpression.length() - 1);
                solution.setText(currentExpression);

                if (!currentExpression.isEmpty()) {
                    result.setText(getResult(currentExpression));
                } else {
                    result.setText("0");
                }
            }
            return;
        }

        if (isOperator(buttonText)){
            if (lastOperator){
                currentExpression = currentExpression.substring(0, currentExpression.length() - 1);
            }
            lastOperator = true;
            lastNumeric= true;
        }else if (buttonText.equals("(") || buttonText.equals(")")){
            lastOperator= false;
            lastNumeric= false;
        }else {
            lastOperator=false;
            lastNumeric=true;
        }
        currentExpression+= buttonText;
        solution.setText(currentExpression);

        if (!currentExpression.isEmpty()){
            String finalResult = getResult(currentExpression);
            if (!finalResult.equals("")){
                result.setText(finalResult);
            }
        }
    }

    
    String getResult(String data){
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable= context.initStandardObjects();
            String finalResult = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
            if (finalResult.endsWith(".0")){
                finalResult= finalResult.replace(".0", "");
            }
            return finalResult;
        }catch (Exception e)
        {
            return "Err";
        }
    }

    private boolean isOperator(String str){
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }
}