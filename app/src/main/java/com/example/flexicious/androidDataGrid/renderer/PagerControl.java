package com.example.flexicious.androidDataGrid.renderer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.flexicious.androidDataGrid.R;
import com.flexicious.controls.ComboBox;
import com.flexicious.controls.core.Event;
import com.flexicious.controls.core.ExtendedView;
import com.flexicious.nestedtreedatagrid.FlexDataGrid;
import com.flexicious.nestedtreedatagrid.FlexDataGridColumnLevel;
import com.flexicious.nestedtreedatagrid.events.ExtendedFilterPageSortChangeEvent;
import com.flexicious.nestedtreedatagrid.pager.IExtendedPager;
import com.flexicious.nestedtreedatagrid.valueobjects.RowInfo;
import com.flexicious.utils.Constants;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PagerControl extends ExtendedView implements IExtendedPager, View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    private int _totalRecords = 0;
    private int _pageSize = 50;
    private int _pageIndex = 0;
    private FlexDataGridColumnLevel _level;
    private FlexDataGrid _grid;
    private RowInfo _rowInfo;
    private Boolean _pageDropdownDirty = false;
    private Boolean _dispatchEvents = false;
    private Boolean built = false;
    private static final int SELECT_PAGE_GROUP = 1;

    View view;
    PopupMenu popupMenu;
    public TextView lblPaging;
    public TextView lblGotoPage;
    public ComboBox cbxPage;

    public PagerControl(Context context) {
        super(context);
    }

    public PagerControl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PagerControl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override
    public FlexDataGridColumnLevel getLevel() {
        return _level;
    }

    @Override
    public void setLevel(FlexDataGridColumnLevel flexDataGridColumnLevel) {
        _level = flexDataGridColumnLevel;
    }

    @Override
    public RowInfo getRowInfo() {
        return _rowInfo;
    }

    @Override
    public void setRowInfo(RowInfo rowInfo) {
        _rowInfo = rowInfo;
    }

    @Override
    public Boolean getDispatchEvents() {
        return _dispatchEvents;
    }

    @Override
    public void setDispatchEvents(Boolean aBoolean) {
        _dispatchEvents = aBoolean;
    }

    @Override
    public void initializePager() {

    }

    @Override
    public void setSizes() {

    }

    @Override
    public int getTotalRecords() {
        return _totalRecords;
    }

    @Override
    public void setTotalRecords(int i) {
        _totalRecords = i;
    }

    @Override
    public int getPageIndex() {
        return _pageIndex;
    }

    @Override
    public void setPageIndex(int val) {
        if (_pageIndex != val) {
            _pageIndex = val;
            onPageChanged();
            dispatchEvent(new Event("pageIndexChanged"));
        }
    }

    @Override
    public FlexDataGrid getGrid() {
        return _grid;
    }

    @Override
    public void setGrid(FlexDataGrid flexDataGrid) {
        _grid = flexDataGrid;
    }

    @Override
    public int getPageSize() {
        return _pageSize;
    }

    @Override
    public void setPageSize(int i) {
        _pageSize = i;
    }

    /**
     * Sets the page index to 1(0), dispatches the reset event.
     */
    public void reset() {
        _pageIndex = 0;
        //cbxPage.setSelectedIndex(0);
        dispatchEvent(new Event("reset", true, false));
    }

    /**
     * Returns the first record on the page
     */
    public int getPageStart() {
        return _totalRecords == 0 ? 0 : ((_pageIndex) * _pageSize) + 1;
    }

    /**
     * Returns the last record on the page
     */
    public int getPageEnd() {
        int val = (_pageIndex + 1) * _pageSize;
        return (val > _totalRecords) ? _totalRecords : val;
    }

    /**
     * Returns the first total number of pages
     */
    public int getPageCount() {
        return (int) (getPageSize() > 0 ? Math.ceil(getTotalRecords() / getPageSize()) : 0);
    }

    /**
     * Default handler for the Page Change Event
     */
    public void onPageChanged() {
        if (cbxPage != null && (cbxPage.getSelectedIndex() != (_pageIndex))) {
            cbxPage.setSelectedIndex(_pageIndex);
        }
        if (_dispatchEvents)
            dispatchEvent(new ExtendedFilterPageSortChangeEvent(ExtendedFilterPageSortChangeEvent.PAGE_CHANGE, null, false, false));
    }

    public void updateDisplayList(float unscaledWidth, float unscaledHeight) {
        super.updateDisplayList(unscaledWidth, unscaledHeight);

        if (view != null && view.getLayoutParams() != null) {
            Log.d("lwidth", "" + this.getGrid().getPagerContainer().getLayoutParams().width);
            view.getLayoutParams().width = this.getGrid().getPagerContainer().getLayoutParams().width;
            view.getLayoutParams().height = this.getGrid().getPagerContainer().getLayoutParams().height;
        }

        FlexDataGrid grid = this.getGrid();
        if (!built && grid != null) {
            grid.traceEvent("building pager");
            reBuild();
            grid.traceEvent("done building pager");
        }

        /*if(_pageDropdownDirty && cbxPage!=null){
            _pageDropdownDirty=false;
            setPageDropdown();
            if(_grid.pagerStyleName!=null){
                _grid.pagerStyleName.initializeTextView(lblPaging);
                _grid.pagerStyleName.initializeTextView(lblGotoPage);
            }

        }*/
    }

    public void reBuild() {
        this.removeAllViews();
        built = true;
        FlexDataGrid grid = this.getGrid();
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.flxs_pager_view, null, false);
        Button mBtnGridMenu = (Button) view.findViewById(R.id.btn_pager_menu);
        mBtnGridMenu.setOnClickListener(this);
        lblPaging = (TextView) view.findViewById(R.id.tv_grid_pager_label);

        addChild(view);

        ViewGroup.LayoutParams layoutParams = (ViewGroup.LayoutParams) view.getLayoutParams();
        layoutParams.width = this.getGrid().getPagerContainer().getLayoutParams().width;
        layoutParams.height = this.getGrid().getPagerContainer().getLayoutParams().height;

        if (grid != null) {
            if (grid.getEnablePaging()) {
                setPagingLabel();
            }
        }
    }

    private void setPagingLabel() {
        if (lblPaging != null)
            lblPaging.setText(Constants.PGR_ITEMS + " " + getPageStart() + " " + Constants.PGR_TO + " " + getPageEnd() + " " + Constants.PGR_OF + " " + getTotalRecords()
                    + ". " + Constants.PGR_PAGE + " " + Integer.toString((getTotalRecords() == 0 ? 0 : (getPageIndex() + 1))) + " " + Constants.PGR_OF + " " + getPageCount());
    }

    public /*override*/  boolean dispatchEvent(Event event) {

        if (event.type.equals("pageIndexChanged") || event.type.equals("pageChange") || event.type.equals("reset")) {
            setPagingLabel();
        }
        return super.dispatchEvent(event);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_pager_menu:
                popupMenu = new PopupMenu(this.getContext(), view);
                try {
                    Field[] fields = popupMenu.getClass().getDeclaredFields();
                    for (Field field : fields) {
                        if ("mPopup".equals(field.getName())) {
                            field.setAccessible(true);
                            Object menuPopupHelper = field.get(popupMenu);
                            Class<?> classPopupHelper = Class.forName(menuPopupHelper.getClass().getName());
                            Method setForceIcons = classPopupHelper.getMethod("setForceShowIcon", boolean.class);
                            setForceIcons.invoke(menuPopupHelper, true);
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                popupMenu.getMenuInflater().inflate(R.menu.grid_option_menu, popupMenu.getMenu());

                popupMenu.getMenu().setGroupVisible(R.id.grid_menu_group_paging, getGrid().getEnablePaging());
                popupMenu.getMenu().setGroupVisible(R.id.grid_menu_group_footer, getGrid().getEnableFooters());
                popupMenu.getMenu().setGroupVisible(R.id.grid_menu_group_filer, getGrid().getEnableFilters());

                popupMenu.getMenu().findItem(R.id.grid_action_export).setVisible(getGrid().getEnableExport());
                popupMenu.getMenu().findItem(R.id.grid_action_print).setVisible(getGrid().getEnablePrint());
                popupMenu.getMenu().findItem(R.id.grid_action_save_settings).setVisible(getGrid().getEnablePreferencePersistence());

                if (getGrid().getEnablePaging()) {
                    SubMenu selectMenu = (SubMenu) popupMenu.getMenu().findItem(R.id.grid_action_select_page).getSubMenu();
                    for (int i = 1; i <= getPageCount(); i++) {
                        selectMenu.add(SELECT_PAGE_GROUP, i, i, "Page " + i);
                    }
                }

                if (getGrid().getEnableFooters()) {
                    popupMenu.getMenu().findItem(R.id.grid_action_show_footer).setVisible(!getGrid().getFooterVisible());
                    popupMenu.getMenu().findItem(R.id.grid_action_hide_footer).setVisible(getGrid().getFooterVisible());
                }

                if (getGrid().getEnableFilters()) {
                    popupMenu.getMenu().findItem(R.id.grid_action_show_filter).setVisible(!getGrid().getFilterVisible());
                    popupMenu.getMenu().findItem(R.id.grid_action_hide_filter).setVisible(getGrid().getFilterVisible());
                    popupMenu.getMenu().findItem(R.id.grid_action_run_filter).setVisible(getGrid().getFilterVisible());
                    popupMenu.getMenu().findItem(R.id.grid_action_clear_filter).setVisible(getGrid().getFilterVisible());
                }

                popupMenu.setOnMenuItemClickListener(this);
                popupMenu.show();
                break;
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.grid_action_export:
                getGrid().defaultExcelHandlerFunction();
                break;
            case R.id.grid_action_print:
                getGrid().defaultPdfHandlerFunction();
                break;
            case R.id.grid_action_settings:
                Intent intent = new Intent(this.getContext(), Constants.SETTINGS_POPUP_ACTIVITY);
                FlexDataGrid.currentGrid = this.getGrid();
                this.getContext().startActivity(intent);
                break;
            case R.id.grid_action_save_settings:
                FlexDataGrid.currentGrid = this.getGrid();
                this.getContext().startActivity(new Intent(this.getContext(), Constants.SAVE_SETTINGS_POPUP_ACTIVITY));
                break;
            case R.id.grid_action_first_page:
                if (_pageIndex != 0) {
                    _pageIndex = 0;
                    onPageChanged();
                }
                break;
            case R.id.grid_action_next_page:
                if (_pageIndex < getPageCount() - 1) {
                    _pageIndex++;
                    onPageChanged();
                }
                break;
            case R.id.grid_action_previous_page:
                if (_pageIndex > 0) {
                    _pageIndex--;
                    onPageChanged();
                }
                break;
            case R.id.grid_action_last_page:
                if (_pageIndex < getPageCount() - 1) {
                    _pageIndex = getPageCount() - 1;
                    onPageChanged();
                }
                break;
            case R.id.grid_action_hide_footer:
                getGrid().setFooterVisible(false);
                getGrid().placeSections();
                break;
            case R.id.grid_action_show_footer:
                getGrid().setFooterVisible(true);
                getGrid().placeSections();
                break;
            case R.id.grid_action_hide_filter:
                getGrid().setFilterVisible(false);
                getGrid().placeSections();
                break;
            case R.id.grid_action_show_filter:
                getGrid().setFilterVisible(true);
                getGrid().placeSections();
                break;
            case R.id.grid_action_run_filter:
                getGrid().processFilter();
                break;
            case R.id.grid_action_clear_filter:
                getGrid().clearFilter();
                break;
            case R.id.grid_action_select_page:
                break;
            default:

                if (menuItem.getGroupId() == SELECT_PAGE_GROUP) {
                    _pageIndex = menuItem.getItemId()-1;
                    onPageChanged();
                }
                break;
        }
        return true;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (getGrid() != null) {
            getGrid().rebuild();
            //remove popup menu while orientation change
            if (popupMenu != null) {
                popupMenu.dismiss();
            }
        }
    }
}
