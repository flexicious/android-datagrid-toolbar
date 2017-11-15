package com.example.fexicious.androidDataGrid.renderer;

import android.content.Context;
import android.util.AttributeSet;

import com.flexicious.grids.filters.FilterExpression;
import com.flexicious.nestedtreedatagrid.cells.FlexDataGridFooterCell;
import com.flexicious.utils.UIUtils;

public class CustomFooterRenderer_CustomFooter extends android.support.v7.widget.AppCompatTextView {

	public CustomFooterRenderer_CustomFooter(Context context) {
		super(context);
	}

	public CustomFooterRenderer_CustomFooter(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public CustomFooterRenderer_CustomFooter(Context context,
                                             AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	
	public Object getData() {
		return data;
	}
	public void setLines(int lines) {
		super.setLines(lines);
	}
    public void setText(CharSequence text, BufferType type) {
    	FlexDataGridFooterCell cell = (FlexDataGridFooterCell) this.getParent();
    	if(cell==null || cell.getLevel()==null){
    		
    	}else{
    		
    		String newline = System.getProperty("line.separator");
			 text = "Average: ";
    	    text = text  + UIUtils.formatCurrency(UIUtils.average(
    	    		cell.getLevel().getGrid().getDataProvider(),cell.getColumn().getDataField()),"");
    	    text = text  + newline;
    	    text = text  + "Min:";
    	    text = text  + UIUtils.formatCurrency((Float) UIUtils.min(
    	    		cell.getLevel().getGrid().getDataProvider(),cell.getColumn().getDataField(), FilterExpression.FILTER_COMPARISION_TYPE_AUTO),"");
    	    text = text  + newline;
    	    text = text  + "Sum:";
    	    text = text  + UIUtils.formatCurrency(UIUtils.max(
    	    		cell.getLevel().getGrid().getDataProvider(),cell.getColumn().getDataField(), FilterExpression.FILTER_COMPARISION_TYPE_AUTO),"");
    	}
    	super.setText(text, type);
    	
    }

	public void setData(Object data) {
		this.data = data;

	}

	private Object data;

}
