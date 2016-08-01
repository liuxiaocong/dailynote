package com.example.administrator.dailynote.Base;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by LiuXiaocong on 7/29/2016.
 */
public class DNTextView extends TextView {
    public DNTextView(Context context) {
        super(context);
        setDefault();
    }

    public DNTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setDefault();
    }

    public DNTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setDefault();
    }

    @Override
    public void setTypeface(Typeface tf, int style) {
        super.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/digigraphics.ttf"));
    }
    private  void setDefault(){
        //setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/appfont.ttf"));
    }
}
