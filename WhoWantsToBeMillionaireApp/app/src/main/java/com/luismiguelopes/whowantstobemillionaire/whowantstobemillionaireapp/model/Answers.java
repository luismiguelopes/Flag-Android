package com.luismiguelopes.whowantstobemillionaire.whowantstobemillionaireapp.model;

import java.util.ArrayList;

/**
 * Created by luismiguelopes on 06/05/15.
 */
public class Answers {

    private String _value;
    private int _id;



     public Answers(int id, String value) {
         _value = value;
         _id = id;
     }

    public Answers(String value) {
        _value = value;
    }

    public String getValue() {
        return _value;
    }

    public int getId() {
        return _id;
    }


}
