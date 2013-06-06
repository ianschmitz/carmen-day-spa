package com.pixelcrunch.resources;

import com.pixelcrunch.carmendayspa.R;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class TextViewChantelli extends TextView {

	public TextViewChantelli(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public TextViewChantelli(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public TextViewChantelli(Context context) {
		super(context);
		init();
	}

	private void init() {
		if (!isInEditMode()) {
			Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
					"fonts/Chantelli_Antiqua.ttf");
			setTypeface(tf);
			setTextColor(getResources().getColor(R.color.Text_Font));
		}
	}
}