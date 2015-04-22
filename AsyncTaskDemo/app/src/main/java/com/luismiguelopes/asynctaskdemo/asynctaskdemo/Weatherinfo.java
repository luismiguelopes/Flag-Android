package com.luismiguelopes.asynctaskdemo.asynctaskdemo;

/**
 * Created by luismiguelopes on 22/04/15.
 */
public class Weatherinfo {

    private double _temp;
    private final String _city;

    Weatherinfo(String city) {
        _city = city;
    }

    public double getTemp() {
        return _temp;
    }

    public void setTemp(double temp) {
        this._temp = temp;
    }

    public String getCity() {
        return _city;
    }
}
