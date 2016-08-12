package com.android.edittextdemo.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.android.edittextdemo.R;

public class EditTextView extends FrameLayout {

    private OnEditTextChangeListener mListener;
    private EditText editText;


    public EditTextView(Context context) {
        super(context);
    }

    public EditTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void updateEditText(final String text) {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(R.layout.edittext_view, this);
        editText = (EditText) findViewById(R.id.et_comment_content);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (mListener != null) {
                    mListener.afterTextChanged(s);
                }
            }
        });
        if (!TextUtils.isEmpty(text)) {
            editText.setText(text);
        }
    }

    public void setOnEditTextChangeListener(OnEditTextChangeListener listener) {
        this.mListener = listener;
    }

    public interface OnEditTextChangeListener {
        //void onFocusChange();

        void afterTextChanged(Editable s);
    }

    public void clearFocus() {
        if (editText != null) {
            editText.clearFocus();
        }
    }
}
