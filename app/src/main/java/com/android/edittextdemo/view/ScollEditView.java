package com.android.edittextdemo.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

public class ScollEditView extends EditText {

	public ScollEditView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public ScollEditView(Context context) {
		super(context);
	}

	public ScollEditView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@SuppressLint("ClickableViewAccessibility")
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_MOVE:
		case MotionEvent.ACTION_UP:
			if (getLineCount() * getLineHeight() > getHeight()) {
				getParent().requestDisallowInterceptTouchEvent(true);
			}

			break;
		}
		return super.onTouchEvent(event);
	}

}
