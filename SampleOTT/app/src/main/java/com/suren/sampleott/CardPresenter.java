package com.suren.sampleott;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.PresenterSelector;
import androidx.leanback.widget.RowPresenter;

import org.w3c.dom.Text;

public class CardPresenter extends Presenter {
    private final FragmentActivity activity;

    public CardPresenter(FragmentActivity activity) {
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(activity).inflate(R.layout.card, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        CardViewHolder cardViewHolder = (CardViewHolder) viewHolder;
        cardViewHolder.title.setText(((Asset) item).getName());
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }

    private class CardViewHolder extends ViewHolder {

        TextView title;

        public CardViewHolder(final View view) {
            super(view);
            title = view.findViewById(R.id.title);
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.setBackgroundColor(Color.RED);
            view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                      view.setBackgroundColor(Color.GREEN);
                    } else {

                        view.setBackgroundColor(Color.RED);
                    }
                }
            });
        }
    }
}
