package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView, text_result, text_gratitude, text_gameName, text_description, text_count;
    private Button btn_Correct, btn_Incorrect, btn_Next, btn_play;
    private int question_index = 0, answer_Correct = 0, count = 1;

    private Questions[] questions = new Questions[] {
            new Questions(false, R.string.question_1),
            new Questions(false, R.string.question_2),
            new Questions(true, R.string.question_3),
            new Questions(true, R.string.question_4),
            new Questions(false, R.string.question_5),
            new Questions(true, R.string.question_6),
            new Questions(true, R.string.question_7)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.TextView);
        btn_Correct = findViewById(R.id.btn_Correct);
        btn_Incorrect = findViewById(R.id.btn_Incorrect);
        btn_Next = findViewById(R.id.btn_Next);
        text_result = findViewById(R.id.text_result);
        text_gratitude = findViewById(R.id.text_gratitude);
        btn_play = findViewById(R.id.btn_play);
        text_gameName = findViewById(R.id.text_gameName);
        text_description = findViewById(R.id.text_description);
        text_count = findViewById(R.id.text_count);

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setVisibility(View.VISIBLE);
                btn_Incorrect.setVisibility(View.VISIBLE);
                btn_Correct.setVisibility(View.VISIBLE);
                text_gameName.setVisibility(View.INVISIBLE);
                text_description.setVisibility(View.INVISIBLE);
                btn_play.setVisibility(View.INVISIBLE);
                text_count.setVisibility(View.VISIBLE);
            }
        });



        textView.setText(questions[question_index].getQuestion());
        text_count.setText("Вопрос - " + count + "/" + questions.length);

        btn_Correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer(true);
                btn_Incorrect.setVisibility(View.INVISIBLE);
                btn_Correct.setVisibility(View.INVISIBLE);
                btn_Next.setVisibility(View.VISIBLE);
            }
        });

        btn_Incorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer(false);
                btn_Incorrect.setVisibility(View.INVISIBLE);
                btn_Correct.setVisibility(View.INVISIBLE);
                btn_Next.setVisibility(View.VISIBLE);
            }
        });

        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question_index++;
                count++;
                if (question_index < questions.length){
                    btn_Incorrect.setVisibility(View.VISIBLE);
                    btn_Correct.setVisibility(View.VISIBLE);
                    btn_Next.setVisibility(View.INVISIBLE);
                    textView.setText(questions[question_index].getQuestion());
                    text_count.setText("Вопрос - " + count + "/" + questions.length);
                } else {
                    btn_Incorrect.setVisibility(View.INVISIBLE);
                    btn_Correct.setVisibility(View.INVISIBLE);
                    btn_Next.setVisibility(View.INVISIBLE);
                    text_count.setVisibility(View.INVISIBLE);
                    text_result.setVisibility(View.VISIBLE);
                    text_gratitude.setVisibility(View.VISIBLE);
                    textView.setTextColor(Color.WHITE);
                    textView.setTextSize(37);
                    textView.setText("Конец игры!");
                    text_result.setText("Количество правильных ответов: " + answer_Correct + "/" + questions.length);
                }

            }
        });
    }

    private void answer(boolean answer) {
        if (answer == questions[question_index].isCorrect()) {
            Toast.makeText(this, "Вы ответили верно", Toast.LENGTH_SHORT).show();
            answer_Correct++;
        } else {
            Toast.makeText(this, "Вы ответили не верно", Toast.LENGTH_SHORT).show();
        }
    }
}