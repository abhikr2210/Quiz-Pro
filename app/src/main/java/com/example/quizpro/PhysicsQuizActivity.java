package com.example.quizpro;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PhysicsQuizActivity extends AppCompatActivity {

    TextView questionTextView;
    TextView totalQuestionTextView;
    TextView quitTextView;
    Button ansA,ansB,ansC,ansD;
    Button btn_submit;


    int score=0;
    int totalQuestion = PhysicsQuestion.question.length;
    int currentQuestionIndex =0;
    String selectedAnswer="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_physics_quiz);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        totalQuestionTextView = findViewById(R.id.totalQuestionTextView);
        questionTextView = findViewById(R.id.questionTextView);
        quitTextView = findViewById(R.id.quitTextView);
        ansA = findViewById(R.id.ans_a);
        ansB = findViewById(R.id.ans_b);
        ansC= findViewById(R.id.ans_c);
        ansD = findViewById(R.id.ans_d);
        btn_submit = findViewById(R.id.btn_submit);

        quitTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = 0;
                currentQuestionIndex=0;
                startActivity(new Intent(PhysicsQuizActivity.this,DashBoardActivity.class));
                finish();
            }
        });

        ansA.setOnClickListener(this::onClick);
        ansB.setOnClickListener(this::onClick);
        ansC.setOnClickListener(this::onClick);
        ansD.setOnClickListener(this::onClick);
        btn_submit.setOnClickListener(this::onClick);

        totalQuestionTextView.setText("Total Question: "+totalQuestion);

        loadNewQuestion();
    }

    private void loadNewQuestion() {
        if(currentQuestionIndex == totalQuestion){
            finishQuiz();
            return;
        }

        questionTextView.setText(PhysicsQuestion.question[currentQuestionIndex]);
        ansA.setText(PhysicsQuestion.choices[currentQuestionIndex][0]);
        ansB.setText(PhysicsQuestion.choices[currentQuestionIndex][1]);
        ansC.setText(PhysicsQuestion.choices[currentQuestionIndex][2]);
        ansD.setText(PhysicsQuestion.choices[currentQuestionIndex][3]);

        selectedAnswer="";

    }

    private void finishQuiz() {

        String passStatus;
        if(score >= totalQuestion*0.6){
            passStatus = "Passed";
        }else{
            passStatus = "Failed";
        }
        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Your Score is "+score+" Out of "+totalQuestion)
                .setPositiveButton("Try Again",((dialog, i) -> tryAgainQuiz() ))
                .setNegativeButton("Exit",((dialog, i) -> exitQuiz()))
                .setCancelable(false)
                .show();
    }

    private void exitQuiz() {
        score = 0;
        currentQuestionIndex=0;
        startActivity(new Intent(PhysicsQuizActivity.this,DashBoardActivity.class));
        finish();
    }

    private void tryAgainQuiz() {

        score = 0;
        currentQuestionIndex=0;
        loadNewQuestion();
    }

    @SuppressLint("ResourceAsColor")
    private void onClick(View view){
        ansA.setBackgroundColor(getColor(R.color.gray));
        ansB.setBackgroundColor(getColor(R.color.gray));
        ansC.setBackgroundColor(getColor(R.color.gray));
        ansD.setBackgroundColor(getColor(R.color.gray));

        Button clickedButton = (Button) view;

        if(clickedButton.getId() == R.id.btn_submit) {
            if(!selectedAnswer.isEmpty()){
                if(selectedAnswer.equals(PhysicsQuestion.correctAnswers[currentQuestionIndex])){
                    score++;
                }else{
//                    clickedButton.setBackgroundColor(Color.GREEN);
                }
                currentQuestionIndex++;
                loadNewQuestion();
            }else{
                Toast.makeText(this, "Select answer", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            selectedAnswer=clickedButton.getText().toString();
            clickedButton.setBackgroundColor(getColor(R.color.green));
        }
    }
}