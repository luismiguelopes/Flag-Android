package com.luismiguelopes.whowantstobebillionaire.whowantstobebillionaire;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.luismiguelopes.whowantstobebillionaire.whowantstobebillionaire.model.Question;
import com.luismiguelopes.whowantstobebillionaire.whowantstobebillionaire.provider.GetQuestionsManager;


public class GameActivity extends Activity implements View.OnClickListener{

    private Question[] questions;
    private int currentQuestionIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }


    @Override
    public void onClick(View view) {

        //If true, the answer is correct
        if ((boolean) view.getTag()) {
            this.currentQuestionIndex++;
            changeToNextQuestion();

            /*
            * TODO:
            *  - Testar se já chegou ao final
            * */
        }
        else {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.toastGameOver), Toast.LENGTH_SHORT).show();
            finish();

            /*
            * TODO:
            *  - Ver os patamares de segurança para ver se ganhou alguma coisa
            * */
        }
    }

    private void changeToNextQuestion() {
        Question question = this.questions[this.currentQuestionIndex];
        TextView txtQuestion = (TextView)findViewById(R.id.txtQuestion);
        txtQuestion.setText(question.getIdentifier() + " - " +question.getText());


        for (Question.Answer answer : question.getAnswers()){

            switch (answer.getIdentifier()) {

                case 'A':
                    //Add button to GameActivity Answer A
                    Button btnAnswerA = (Button)findViewById(R.id.btnAnswerA);
                    btnAnswerA.setText(answer.getIdentifier() + " - " +answer.getText());
                    btnAnswerA.setTag(answer.isCorrect());
                    btnAnswerA.setOnClickListener(this);

                    break;
                case 'B':
                    //Add button to GameActivity Answer1
                    Button btnAnswerB = (Button)findViewById(R.id.btnAnswerB);
                    btnAnswerB.setText(answer.getIdentifier() + " - " +answer.getText());
                    btnAnswerB.setTag(answer.isCorrect());
                    btnAnswerB.setOnClickListener(this);

                    break;
                case 'C':
                    //Add button to GameActivity Answer1
                    Button btnAnswerC = (Button)findViewById(R.id.btnAnswerC);
                    btnAnswerC.setText(answer.getIdentifier() + " - " +answer.getText());
                    btnAnswerC.setTag(answer.isCorrect());
                    btnAnswerC.setOnClickListener(this);
                    break;
                case 'D':
                    //Add button to GameActivity Answer1
                    Button btnAnswerD = (Button)findViewById(R.id.btnAnswerD);
                    btnAnswerD.setText(answer.getIdentifier() + " - " +answer.getText());
                    btnAnswerD.setTag(answer.isCorrect());
                    btnAnswerD.setOnClickListener(this);
                    break;
                default:
                    break;
            }

            new GetQuestionsTask().execute();
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class GetQuestionsTask extends AsyncTask<Void, Void, Question[]> {

        @Override
        protected Question[] doInBackground(Void... voids) {
            return GetQuestionsManager.getAllTemp();

            /*
            *
            *
            *
            *
            * */
        }

        @Override
        protected void onPostExecute(Question[] questions) {
            super.onPostExecute(questions);

            GameActivity.this.questions = questions;
            GameActivity.this.currentQuestionIndex = 0;
            changeToNextQuestion();

        }
    }
}
