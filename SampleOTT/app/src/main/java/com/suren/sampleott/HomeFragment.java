package com.suren.sampleott;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.BaseOnItemViewSelectedListener;
import androidx.leanback.widget.FocusHighlight;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeFragment extends RowsSupportFragment implements BaseOnItemViewSelectedListener {

    HashMap<String, List<Asset>> data = new HashMap<>();
    String[] titles = {"Movies", "Shows", "Sports", "Kids"};
    ArrayObjectAdapter dataAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataAdapter = new ArrayObjectAdapter(new CustomRowPresenter(FocusHighlight.ZOOM_FACTOR_NONE, false, getActivity()));
        loadAssets();
        setAdapter(dataAdapter);
        setOnItemViewSelectedListener(this);
    }

    private HashMap<String, List<Asset>> loadAssets() {
        for (String title : titles) {
            List<Asset> assets = new ArrayList<>();
            assets.add(new Asset(title + " 1", ""));
            assets.add(new Asset(title + " 2", ""));
            assets.add(new Asset(title + " 3", ""));
            assets.add(new Asset(title + " 4", ""));
            assets.add(new Asset(title + " 5", ""));
            assets.add(new Asset(title + " 6", ""));
            assets.add(new Asset(title + " 7", ""));
            assets.add(new Asset(title + " 8", ""));
            assets.add(new Asset(title + " 9", ""));
            assets.add(new Asset(title + " 10", ""));
            data.put(title, assets);
        }
        for (String key : data.keySet()) {
            HeaderItem header = new HeaderItem( key);
            ArrayObjectAdapter rowAdapter = new ArrayObjectAdapter(new CardPresenter(getActivity()));
            for (Asset asset : data.get(key)) {
                rowAdapter.add(asset);
            }
            dataAdapter.add(new ListRow(header, rowAdapter));
        }
        return data;
    }

    @Override
    public void onItemSelected(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Object row) {

    }
}
