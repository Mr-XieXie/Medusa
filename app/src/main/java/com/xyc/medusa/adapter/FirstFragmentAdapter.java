package com.xyc.medusa.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xyc.medusa.R;

import java.util.List;

public class FirstFragmentAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public FirstFragmentAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String data) {
        helper.setText(R.id.text_message,data);
    }
}
