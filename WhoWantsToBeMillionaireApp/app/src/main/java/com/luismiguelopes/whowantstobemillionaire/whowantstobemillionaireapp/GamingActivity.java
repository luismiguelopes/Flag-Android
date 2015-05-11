package com.luismiguelopes.whowantstobemillionaire.whowantstobemillionaireapp;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.luismiguelopes.whowantstobemillionaire.whowantstobemillionaireapp.model.Question;
import com.luismiguelopes.whowantstobemillionaire.whowantstobemillionaireapp.provider.GetQuestionsManager;


public class GamingActivity extends Activity implements View.OnClickListener {

    private Question[] questions;
    private int currentQuestionIndex;



    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
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
                    //Add button to GameActivity Answer1
                    Button btnOne = (Button)findViewById(R.id.btnOne);
                    btnOne.setText(answer.getIdentifier() + " - " +answer.getText());
                    btnOne.setTag(answer.isCorrect());
                    btnOne.setOnClickListener(this);

                    break;
                case 'B':
                    //Add button to GameActivity Answer1
                    Button btnTwo = (Button)findViewById(R.id.btnTwo);
                    btnTwo.setText(answer.getIdentifier() + " - " +answer.getText());
                    btnTwo.setTag(answer.isCorrect());
                    btnTwo.setOnClickListener(this);

                    break;
                case 'C':
                    //Add button to GameActivity Answer1
                    Button btnThree = (Button)findViewById(R.id.btnThree);
                    btnThree.setText(answer.getIdentifier() + " - " +answer.getText());
                    btnThree.setTag(answer.isCorrect());
                    btnThree.setOnClickListener(this);
                    break;
                case 'D':
                    //Add button to GameActivity Answer1
                    Button btnFour = (Button)findViewById(R.id.btnFour);
                    btnFour.setText(answer.getIdentifier() + " - " +answer.getText());
                    btnFour.setTag(answer.isCorrect());
                    btnFour.setOnClickListener(this);
                    break;
                default:
                    break;
            }

            new GetQuestionsTask().execute();
        }



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

            GamingActivity.this.questions = questions;
            GamingActivity.this.currentQuestionIndex = 0;
            changeToNextQuestion();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gaming, menu);
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
}
