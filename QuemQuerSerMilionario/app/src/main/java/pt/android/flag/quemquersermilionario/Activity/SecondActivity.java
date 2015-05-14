package pt.android.flag.quemquersermilionario.Activity;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pt.android.flag.quemquersermilionario.Model.Question;
import pt.android.flag.quemquersermilionario.Provider.OperationsManager;
import pt.android.flag.quemquersermilionario.R;


public class SecondActivity extends ActionBarActivity implements View.OnClickListener {

    private Question[] questions;
    private int currentQuestionIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        new GetQuestionTask().execute();
        Button btnPhone = (Button) findViewById(R.id.btnPhone);
        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.toast_phone_help) + xpto(), Toast.LENGTH_SHORT).show();

            }
        });

  /*      Button btnFiftyFifty = (Button) findViewById(R.id.btnFiftyFifty);
        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.toast_fifty_help) + xpto(), Toast.LENGTH_SHORT).show();

            }
        });

        Button btnHelp = (Button) findViewById(R.id.btnHelp);
        btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setVisibility(View.GONE);

            }
        });*/


    }
    @Override
    public void onClick (View view) {
        //If TRUE, the answer is correct
        if((boolean)view.getTag()) {
            this.currentQuestionIndex++;
<<<<<<< HEAD

=======
            
>>>>>>> origin/master
            if(currentQuestionIndex < 15) {
                changeToNextQuestion();
            }
            else {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.toast_you_win), Toast.LENGTH_SHORT).show();
            }

        }
<<<<<<< HEAD
        else {

=======
         // If False, Show a Toast With Game Over
        else {
            /*
            * If statement 
            * to verify in
            * what current
            * question you are
            * and if you already
            * earn some money
            * */
>>>>>>> origin/master
            if (currentQuestionIndex > 3 && currentQuestionIndex < 10) {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.toast_first_checkpoint), Toast.LENGTH_SHORT).show();
            }
            if (currentQuestionIndex > 9 && currentQuestionIndex < 14) {
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.toast_second_checkpoint), Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.toast_game_over), Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void changeToNextQuestion() {
        Question question = this.questions[this.currentQuestionIndex];

        TextView txtQuestion = (TextView)findViewById(R.id.txt_Question);
        txtQuestion.setText(question.getIdentifier() + " - " + question.getText());

        for (Question.Answer answer : question.getAnswers()) {
            switch (answer.getIdentifier()) {
                case 'A':
                    Button btnA = (Button)findViewById(R.id.btn_Answer_A);
                    btnA.setText(answer.getIdentifier() + " - " + answer.getText());
                    btnA.setTag(answer.isCorrect());
                    btnA.setOnClickListener(this);
                    break;

                case 'B' :
                    Button btnB = (Button)findViewById(R.id.btn_Answer_B);
                    btnB.setText(answer.getIdentifier() + " - " + answer.getText());
                    btnB.setTag(answer.isCorrect());
                    btnB.setOnClickListener(this);
                    break;

                case 'C':
                    Button btnC = (Button)findViewById(R.id.btn_Answer_C);
                    btnC.setText(answer.getIdentifier() + " - " + answer.getText());
                    btnC.setTag(answer.isCorrect());
                    btnC.setOnClickListener(this);
                    break;

                case 'D':
                    Button btnD = (Button)findViewById(R.id.btn_Answer_D);
                    btnD.setText(answer.getIdentifier() + " - " + answer.getText());
                    btnD.setTag(answer.isCorrect());
                    btnD.setOnClickListener(this);
                    break;

                default:
                    break;
            }
        }


    }

<<<<<<< HEAD


    public class GetQuestionTask extends AsyncTask<Void, Void, Question[]>
    {
=======
    public class GetQuestionTask extends AsyncTask<Void, Void, Question[]> {
>>>>>>> origin/master

        @Override
        protected Question[] doInBackground(Void... voids) {
            return OperationsManager.getAllTemp();

            /*
            * Tentar buscar da "BD"
            * Se tiver:
            *   -usa
            * Se não tiver:
            *    -ir buscar via http ao servidor a 1a vez
            *    -guardar na "BD"
            * */
        }

        @Override
        protected void onPostExecute(Question[] questions) {
            SecondActivity.this.questions = questions;
            SecondActivity.this.currentQuestionIndex = 0;
            changeToNextQuestion();
        }
    }
<<<<<<< HEAD

    public String xpto() {
        Question question = this.questions[this.currentQuestionIndex];
        for (Question.Answer answer : question.getAnswers()) {
            answer.getIdentifier();
        }
        return "";
    }
}
=======
}
>>>>>>> origin/master
