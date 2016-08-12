package com.android.edittextdemo.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.android.edittextdemo.R;
import com.android.edittextdemo.domain.EditData;

public class EditView extends FrameLayout {

    private TextView mItemNameTV;
    private EditTextView mEditView;
    private TextView mCountTV;
    private EditData mEditData;
    private StringBuilder sb = new StringBuilder();

    public EditView(Context context) {
        super(context);
        initView();
        initListener();
    }

    private void initListener() {
        mEditView.setOnEditTextChangeListener(new EditTextView.OnEditTextChangeListener() {

            @Override
            public void afterTextChanged(Editable s) {
                if (mEditData.data != null && mEditData.data.equals(s.toString())) {
                    return;
                }
                sb.setLength(0);
                sb.append(500 - s.length());
                sb.append("字");
                mCountTV.setText(sb.toString());
                mEditData.data = s.toString();
            }
        });
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_editview, this);
        mItemNameTV = (TextView) findViewById(R.id.tv_item_name);
        mEditView = (EditTextView) findViewById(R.id.fl_text_edit);
        mCountTV = (TextView) findViewById(R.id.tv_edit_count);
    }

    public void setData(EditData data, int position) {
        mEditData = data;
        mItemNameTV.setText("item" + position);
        mEditView.updateEditText(data.data);
        if (TextUtils.isEmpty(data.data)) {
            mCountTV.setText("500字");
        } else {
            sb.setLength(0);
            sb.append(500 - data.data.length());
            sb.append("字");
            mCountTV.setText(sb.toString());
        }
    }

}
