package com.example.fexicious.androidDataGrid;

import android.graphics.Color;

import com.example.fexicious.androidDataGrid.utills.StyleManager;
import com.flexicious.nestedtreedatagrid.interfaces.IFlexDataGridCell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Utill {

    public static String getStringFromResource(int resouceId) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(App.getAppContext().getResources().openRawResource(resouceId)));
        StringBuilder builder = new StringBuilder();
        String aux = "";
        try {
            while ((aux = reader.readLine()) != null) {
                builder.append(aux);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return builder.toString();
    }

    public static Object getGridBackgroundColor(IFlexDataGridCell cell) {

        if (cell.getRowInfo().getIsHeaderRow() || cell.getRowInfo().getIsFooterRow()) {
            if (cell.getColumn() != null && cell.getColumn().getColIndex() % 2 == 0) {
                return Color.parseColor("#3E2723");
            }
            return Color.parseColor("#5D4037");
        } else if (cell.getColumn() != null) {
            if (cell.getRowInfo().rowPositionInfo.rowIndex % 2 == 0) {
                return Color.parseColor("#ede8e8");
            } else {
                return Color.parseColor("#fdfdfd");
            }
        } else {
            return Color.parseColor("#90A4AE");
        }

    }

    public static int getGridTextColor(IFlexDataGridCell cell) {
        if (cell.getRowInfo().getIsHeaderRow() || cell.getRowInfo().getIsColumnGroupRow() || cell.getRowInfo().getIsFooterRow()) {
            return StyleManager.instance().getUIColorObjectFromHexString(
                    "0xfcfcfc");
        } else if (cell.getColumn() != null && cell.getColumn().getDataField() != null && cell.getRowInfo().getIsDataRow()) {
            if (cell.getColumn().getDataField().toLowerCase().startsWith("email")) {
                return StyleManager.instance().getUIColorObjectFromHexString("0x0091EA");
            } else if (cell.getColumn().getDataField().toLowerCase().startsWith("gender")) {
                if (((HashMap) cell.getRowInfo().getData()).get("gender").toString().toLowerCase().contains("female")) {
                    return StyleManager.instance().getUIColorObjectFromHexString("0xE040FB");
                } else {
                    return StyleManager.instance().getUIColorObjectFromHexString("0x4DB6AC");
                }
            }
        }
        return StyleManager.instance().getUIColorObjectFromHexString(
                "0x0a0c0c");
    }
}
