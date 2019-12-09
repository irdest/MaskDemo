package com.example.lipengfei.maskdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lipengfei.maskdemo.R;
import com.example.lipengfei.maskdemo.model.Contants;
import com.example.lipengfei.maskdemo.model.bean.WriteData;
import com.example.lipengfei.maskdemo.util.TextUtils;
import com.example.lipengfei.maskdemo.widget.TimeView;

import java.util.List;



/**
 * Author: qzns木雨
 * Date:2018/12/4
 * Description: 主界面RecyclerView的adapter
 */
public class MainDatasAdapter extends RecyclerView.Adapter<MainDatasAdapter.ViewHodler> {

    private List<WriteData> datas;

    private final String TAG = "MainDatasAdapter";

    //构建，赋予person界面静态数据
    public MainDatasAdapter(List<WriteData> datas) {
        this.datas = datas;
    }

    static class ViewHodler extends RecyclerView.ViewHolder {
        View mView;
        TextView titleTV;
        TextView contentTV;
        TimeView mTimeView;

        public ViewHodler(View view) {
            super(view);
            mView = view;
            mTimeView = (TimeView) view.findViewById(R.id.time_v);
            titleTV = (TextView) view.findViewById(R.id.item_title_tv);
            contentTV = (TextView) view.findViewById(R.id.item_content_tv);
        }
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main_list, viewGroup, false);
        return new ViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler hodler, int position) {

        final String content = datas.get(position).getContent();
        String[] contentArray = content.split("\n");
        String mTitle = "";
        String mContent = "";

        //通过换行符来粗略划分标题和内容
        if (contentArray.length == 1) {
            //不存在换行符
            mTitle = content;
        } else {
            mTitle = contentArray[0];
            mContent = contentArray[1];
        }

        //通过一行的字数限制粗略划分标题和内容
        if (mTitle.length() > Contants.NUM_ITEM_TITLE_LENGTH) {
            mTitle = content.substring(0, Contants.NUM_ITEM_TITLE_LENGTH);
            mContent = content.substring(Contants.NUM_ITEM_TITLE_LENGTH);
        }

        if (TextUtils.isEmpty(mContent)) {
            hodler.contentTV.setVisibility(View.GONE);
        } else {
            hodler.contentTV.setVisibility(View.VISIBLE);
            hodler.contentTV.setText(mContent);
        }
        hodler.titleTV.setText(mTitle);

        hodler.mTimeView.setTime(datas.get(position).getSaveTime());

        hodler.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: " + content);

            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}
