package com.suren.sampleott;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;

import androidx.leanback.widget.BaseGridView;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.PresenterSelector;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowHeaderPresenter;
import androidx.leanback.widget.RowPresenter;

import java.util.List;

public class CustomRowPresenter extends ListRowPresenter {

    private Context context;
    private int focusZoomFactor;


    public CustomRowPresenter(int zoomFactorLarge, boolean b, Context context) {
        super(zoomFactorLarge, b);
        setHeaderPresenter(new CustomRowHeaderPresenter());

        this.context = context;
        this.focusZoomFactor = zoomFactorLarge;
    }
    @Override
    protected void initializeRowViewHolder(RowPresenter.ViewHolder holder) {
        super.initializeRowViewHolder(holder);
        setHeaderPresenter(new CustomRowHeaderPresenter());
        int windowAlignment = BaseGridView.WINDOW_ALIGN_HIGH_EDGE;
        ((ListRowPresenter.ViewHolder) holder).getGridView().setWindowAlignment(windowAlignment);

        float windowAlignmentOffSetPercent = 0f;
        ((ListRowPresenter.ViewHolder) holder).getGridView().setWindowAlignmentOffsetPercent(windowAlignmentOffSetPercent);

        int windowAlignmentOffset = context.getResources().getDimensionPixelSize(R.dimen.lb_browse_padding_start);
        ((ListRowPresenter.ViewHolder) holder).getGridView().setWindowAlignmentOffset(windowAlignmentOffset);

        float itemAlignmentoffsetPercent = 0f;
        ((ListRowPresenter.ViewHolder) holder).getGridView().setItemAlignmentOffsetPercent(itemAlignmentoffsetPercent);

        ((ListRowPresenter.ViewHolder) holder).getGridView().setItemSpacing(10);

        /* Disable Shadow */
        setShadowEnabled(false);
        setSelectEffectEnabled(false);
        setKeepChildForeground(false);
    }

    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item, List<Object> payloads) {
        super.onBindViewHolder(viewHolder, item, payloads);
    }

    private class CustomRowHeaderPresenter extends RowHeaderPresenter {
        @Override
        public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item, List<Object> payloads) {
            super.onBindViewHolder(viewHolder, item, payloads);
            RowHeaderPresenter.ViewHolder vh = (RowHeaderPresenter.ViewHolder) viewHolder;
            TextView title = vh.view.findViewById(R.id.row_header);
            title.setAlpha(0.1f);
        }

        @Override
        public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {
            super.onBindViewHolder(viewHolder, item);
            RowHeaderPresenter.ViewHolder vh = (RowHeaderPresenter.ViewHolder) viewHolder;
            TextView title = vh.view.findViewById(R.id.row_header);
            title.setTextColor(Color.YELLOW);
        }
    }
}
