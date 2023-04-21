package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int mNumber;
    private int mAttepmts = 0;
    private TextView mGuessResultTextView;
    private TextView mAttemptsView;
    private EditText mGuessEditText;
    private Button mSubmitButton;

    public void restart() {
        mAttepmts = 0;
        mGuessResultTextView.setText("");
        mGuessEditText.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random random = new Random();
        mNumber = random.nextInt(100) + 1;

        mGuessResultTextView = findViewById(R.id.guess_result_text_view);
        mGuessEditText = findViewById(R.id.guess_edit_text);
        mSubmitButton = findViewById(R.id.button);
        mAttemptsView = findViewById(R.id.guess_result_text_view2);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = mGuessEditText.getText().toString();

                if (!inputText.isEmpty()) {
                    int inputNumber = Integer.parseInt(inputText);

                    mAttepmts++;
                    String toViewAttempts = Integer.toString(mAttepmts);
                    mAttemptsView.setText(toViewAttempts);

                    if (mAttepmts == 10) {
                        restart();
                        return;
                    }

                    if (inputNumber == mNumber) {
                        mGuessResultTextView.setText("Вы угадали число!");
                    } else if (inputNumber > mNumber) {
                        mGuessResultTextView.setText("Загаданное число больше ведённого");
                    } else if (inputNumber < mNumber) {
                        mGuessResultTextView.setText("Загаданное число меньше ведённого");
                    }
                }
            }
        });

    }
}