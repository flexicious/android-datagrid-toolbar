package com.example.fexicious.androidDataGrid.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.fexicious.androidDataGrid.R;
import com.example.fexicious.androidDataGrid.Utill;
import com.example.fexicious.androidDataGrid.renderer.PagerControl;
import com.flexicious.controls.core.ClassFactory;
import com.flexicious.nestedtreedatagrid.FlexDataGrid;
import com.flexicious.nestedtreedatagrid.FlexDataGridColumn;
import com.flexicious.nestedtreedatagrid.interfaces.IFlexDataGridCell;
import com.flexicious.nestedtreedatagrid.utils.ExtendedUIUtils;
import com.flexicious.utils.UIUtils;


public class GridViewFragment extends Fragment {

    public GridViewFragment() {
        // Required empty public constructor
    }


    public static GridViewFragment newInstance() {
        GridViewFragment fragment = new GridViewFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grid_view, container, false);
        FlexDataGrid grid = (FlexDataGrid) view.findViewById(R.id.flxs_grid_view);
        grid.delegate = this;
        grid.buildFromXml(Utill.getStringFromResource(R.raw.flxs_grid));
        grid.setDataProviderJson(Utill.getStringFromResource(R.raw.flxs_data));
        grid.setPagerRenderer(new ClassFactory(PagerControl.class));
        return view;
    }

    public String dataGridFormatCurrencyLabelFunction(Object rowData, FlexDataGridColumn col) {

        String string = UIUtils.toString(ExtendedUIUtils.resolveExpression(rowData, col.getDataField(), null, false, false));
        if (string.length() == 0)
            return "";
        return UIUtils.formatCurrency(Float.parseFloat(string), "");
    }

    public Object getCellBackgroundColor(IFlexDataGridCell cell) {
        return Utill.getGridBackgroundColor(cell);
    }

    public int getCellTextColor(IFlexDataGridCell cell) {
        return Utill.getGridTextColor(cell);
    }
}
