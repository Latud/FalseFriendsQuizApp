package com.example.android.falsefriendsquizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String Q5_ANSWER = "do";
    final String Q6_ANSWER = "aguacate";
    int pointsQuantity;

    TextView questionOneAnswer;
    TextView questionTwoAnswer;
    TextView questionThreeAnswer;
    TextView questionFourAnswer;
    TextView questionFiveAnswer;
    TextView questionSixAnswer;
    TextView pointsQuantityTextView;
    RadioButton rb_firefighter;
    RadioButton rb_deMining_expert;
    RadioButton rb_bomber;
    RadioButton rb_carpet;
    RadioButton rb_folder;
    RadioButton rb_female_carp;
    RadioButton rb_long_answer;
    RadioButton rb_large;
    RadioButton rb_lake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionOneAnswer = (TextView) findViewById(R.id.view_correct_answer1);
        questionTwoAnswer = (TextView) findViewById(R.id.view_correct_answer2);
        questionThreeAnswer = (TextView) findViewById(R.id.view_correct_answer3);
        questionFourAnswer = (TextView) findViewById(R.id.view_correct_answer4);
        questionFiveAnswer = (TextView) findViewById(R.id.view_correct_answer5);
        questionSixAnswer = (TextView) findViewById(R.id.view_correct_answer6);
        pointsQuantityTextView = (TextView) findViewById(R.id.quantity_of_correct_answers);
        rb_firefighter = findViewById(R.id.rb_firefighter);
        rb_deMining_expert = findViewById(R.id.rb_deMining_expert);
        rb_bomber = findViewById(R.id.rb_bomber);
        rb_carpet = findViewById(R.id.rb_carpet);
        rb_folder = findViewById(R.id.rb_folder);
        rb_female_carp = findViewById(R.id.rb_female_carp);
        rb_long_answer = findViewById(R.id.rb_long_answer);
        rb_lake = findViewById(R.id.rb_lake);
        rb_large = findViewById(R.id.rb_large);
    }

    private void checkQuestionOneAnswers() {

        CheckBox coincidenceCheckBox = (CheckBox) findViewById(R.id.coincidence_checkbox);

        CheckBox casualtyCheckBox = (CheckBox) findViewById(R.id.casualty_checkbox);

        CheckBox chanceCheckBox = (CheckBox) findViewById(R.id.chance_checkbox);

        if (casualtyCheckBox.isChecked() && coincidenceCheckBox.isChecked() && chanceCheckBox.isChecked()) {
            Toast.makeText(this, getString(R.string.casualty_incorrect_answer), Toast.LENGTH_LONG).show();
            pointsQuantity += 2;
            return;

        } else if (casualtyCheckBox.isChecked() && coincidenceCheckBox.isChecked()) {
            Toast.makeText(this, getString(R.string.casualty_incorrect_answer), Toast.LENGTH_LONG).show();
            pointsQuantity += 1;
            return;

        } else if (casualtyCheckBox.isChecked() && chanceCheckBox.isChecked()) {
            Toast.makeText(this, getString(R.string.casualty_incorrect_answer), Toast.LENGTH_LONG).show();
            pointsQuantity += 1;
            return;

        } else if (coincidenceCheckBox.isChecked() && chanceCheckBox.isChecked()) {

            pointsQuantity += 2;

            return;

        } else if (coincidenceCheckBox.isChecked() || chanceCheckBox.isChecked()) {

            pointsQuantity += 1;

            return;

        }
    }

    public void submitAnswers(View view) {

        checkQuestionOneAnswers();
        checkQuestionFiveAnswer();
        checkQuestionSixAnswer();

        if (rb_firefighter.isChecked()) {
            pointsQuantity += 1;
        }

        if (rb_folder.isChecked()) {
            pointsQuantity += 1;
        }

        if (rb_long_answer.isChecked()) {
            pointsQuantity += 1;
        }

        String pointsMessage = createPointsSummary(pointsQuantity);
        displayMessage(pointsMessage);

        questionOneAnswer.setVisibility(View.VISIBLE);

        questionTwoAnswer.setVisibility(View.VISIBLE);

        questionThreeAnswer.setVisibility(View.VISIBLE);

        questionFourAnswer.setVisibility(View.VISIBLE);

        questionFiveAnswer.setVisibility(View.VISIBLE);

        questionSixAnswer.setVisibility(View.VISIBLE);

        Toast.makeText(this, getString(R.string.you_have_quantity_correct_answers, pointsQuantity), Toast.LENGTH_LONG).show();

        pointsQuantity = 0;

    }

    private String createPointsSummary(int pointsQuantity) {
        String pointsMessage = getString(R.string.you_have_quantity_correct_answers, pointsQuantity);
        return pointsMessage;
    }

    private void displayMessage(String message) {
        pointsQuantityTextView.setText(message);
    }

    public void onRadioButtonClicked1(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.rb_firefighter:
                if (checked)
                    return;
            case R.id.rb_deMining_expert:
                if (checked)
                    return;
            case R.id.rb_bomber:
                if (checked)
                    return;
        }

    }

    public void onRadioButtonClicked2(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.rb_folder:
                if (checked)
                    return;
            case R.id.rb_carpet:
                if (checked)
                    return;
            case R.id.rb_female_carp:
                if (checked)
                    return;
        }
    }

    public void onRadioButtonClicked3(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.rb_long_answer:
                if (checked)
                    return;
            case R.id.rb_large:
                if (checked)
                    return;
            case R.id.rb_lake:
                if (checked)
                    return;
        }
    }

    private boolean questionFiveAnswer() {

        EditText et1 = (EditText) findViewById(R.id.correct_answer);

        return et1.getText().toString().trim().equalsIgnoreCase(Q5_ANSWER);

    }

    public int checkQuestionFiveAnswer() {
        if (questionFiveAnswer()) {

            pointsQuantity += 1;

        }

        return pointsQuantity;

    }

    private boolean questionSixAnswer() {

        EditText et2 = (EditText) findViewById(R.id.correct_answer2);


        return et2.getText().toString().trim().equalsIgnoreCase(Q6_ANSWER);

    }

    public int checkQuestionSixAnswer() {
        if (questionSixAnswer()) {

            pointsQuantity += 1;

        }

        return pointsQuantity;

    }

    public void Reset(View view) {

        pointsQuantity = 0;

        displayNull(pointsQuantity);

        clearEditTexts();

        clearRadioButtons();

        clearCheckedBoxes();

        hideAnswers();
    }

    public void clearCheckedBoxes() {

        CheckBox coincidenceCheckBox = (CheckBox) findViewById(R.id.coincidence_checkbox);
        coincidenceCheckBox.setChecked(false);

        CheckBox casualtyCheckBox = (CheckBox) findViewById(R.id.casualty_checkbox);
        casualtyCheckBox.setChecked(false);

        CheckBox chanceCheckBox = (CheckBox) findViewById(R.id.chance_checkbox);
        chanceCheckBox.setChecked(false);
    }

    public void clearRadioButtons() {

        RadioGroup radioGroupOne = (RadioGroup) findViewById(R.id.radioGroup1);

        radioGroupOne.clearCheck();

        RadioGroup radioGroupTwo = (RadioGroup) findViewById(R.id.radioGroup2);

        radioGroupTwo.clearCheck();

        RadioGroup radioGroupThree = (RadioGroup) findViewById(R.id.radioGroup3);

        radioGroupThree.clearCheck();

    }

    public void clearEditTexts() {

        EditText et1 = (EditText) findViewById(R.id.correct_answer);

        et1.setText(null);

        EditText et2 = (EditText) findViewById(R.id.correct_answer2);

        et2.setText(null);

    }

    public void hideAnswers() {

        questionOneAnswer.setVisibility(View.INVISIBLE);

        questionTwoAnswer.setVisibility(View.INVISIBLE);

        questionThreeAnswer.setVisibility(View.INVISIBLE);

        questionFourAnswer.setVisibility(View.INVISIBLE);

        questionFiveAnswer.setVisibility(View.INVISIBLE);

        questionSixAnswer.setVisibility(View.INVISIBLE);

    }

    public void displayNull(int number) {

        pointsQuantityTextView.setText(String.valueOf(number));

    }

}