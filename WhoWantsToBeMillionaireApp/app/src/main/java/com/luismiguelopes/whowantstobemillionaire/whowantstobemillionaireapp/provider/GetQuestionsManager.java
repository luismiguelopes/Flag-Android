package com.luismiguelopes.whowantstobemillionaire.whowantstobemillionaireapp.provider;

import com.luismiguelopes.whowantstobemillionaire.whowantstobemillionaireapp.model.Question;


public class GetQuestionsManager {

    public static Question[] getAllTemp() {

        try {
            return QuestionsHttpRequest.getAll();
        } catch (Exception e) {
            //TODO Exception
        }
    return null;
    }
}
