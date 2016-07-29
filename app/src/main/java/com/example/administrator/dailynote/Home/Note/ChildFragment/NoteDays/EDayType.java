package com.example.administrator.dailynote.Home.Note.ChildFragment.NoteDays;

/**
 * Created by LiuXiaocong on 7/29/2016.
 */
public enum EDayType {
    EYesterday(0), EToday(1), ETomorrow(2);
    private int value;

    EDayType(int value) {
        this.value = value;
    }

    public static EDayType valueOf(int value) {
        switch (value) {
            case 0:
                return EYesterday;
            case 1:
                return EToday;
            case 2:
                return ETomorrow;
            default:
                return EToday;
        }
    }

    public int getValue() {
        return value;
    }
}
