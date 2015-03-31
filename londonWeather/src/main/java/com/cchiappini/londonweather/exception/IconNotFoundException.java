package com.cchiappini.londonweather.exception;

/**
 * Created by cchiappini on 30/03/2015.
 */
public class IconNotFoundException extends Exception {
    public IconNotFoundException(){
        super("Icon for weather not found");
    }

}
