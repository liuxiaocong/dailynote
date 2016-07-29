package com.example.administrator.dailynote.Base;

import java.util.Locale;

/**
 * Created by LiuXiaocong on 7/29/2016.
 */
public class Util {
    static String language = null;

    public static boolean isZhSetting() {
        if (language == null) {
            Locale l = Locale.getDefault();
            language = l.getLanguage();
            String country = l.getCountry().toLowerCase();
            if ("zh".equals(language)) {
                if ("cn".equals(country)) {
                    language = "zh-CN";
                } else if ("tw".equals(country)) {
                    language = "zh-TW";
                }
            }
        }
        if (language != null
                && (language.toLowerCase().trim().equals("zh-cn")))
            return true;
        else
            return false;
    }
}
