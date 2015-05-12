package pt.android.flag.quemquersermilionario.Service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import pt.android.flag.quemquersermilionario.http.QuestionHttpRequest;
import pt.android.flag.quemquersermilionario.Model.Question;
import pt.android.flag.quemquersermilionario.Provider.OperationsManager;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * @author Challenge.IT
 */
public class QuestionsService extends IntentService
{
    private OperationsManager operationsManager;

    public QuestionsService()
    {
        super("QuestionsService");
        operationsManager = new OperationsManager(this);
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        try
        {
            Question[] questions = QuestionHttpRequest.getAll();
            for (Question question : questions)
                operationsManager.save(question);

        } catch (Exception e)
        {
            Log.i("QuestionService", e.getMessage());
        }
    }
}
