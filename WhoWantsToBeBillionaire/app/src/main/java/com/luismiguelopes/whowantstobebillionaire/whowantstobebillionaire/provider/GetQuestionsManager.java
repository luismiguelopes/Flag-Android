package com.luismiguelopes.whowantstobebillionaire.whowantstobebillionaire.provider;

import com.luismiguelopes.whowantstobebillionaire.whowantstobebillionaire.model.Question;

/**
 * Created by luismiguelopes on 12/05/15.
 */
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
