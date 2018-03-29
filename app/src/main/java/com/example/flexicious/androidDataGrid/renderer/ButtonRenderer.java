package com.example.flexicious.androidDataGrid.renderer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import com.example.flexicious.androidDataGrid.R;

public class ButtonRenderer extends android.support.v7.widget.AppCompatButton implements View.OnClickListener {

	public ButtonRenderer(Context context) {
		super(context);
	}

	public ButtonRenderer(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ButtonRenderer(Context context,
                          AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	
	public Object getData() {
		return data;
	}
	/*public void setLines(int lines) {
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
    	
    }*/

	@SuppressLint("WrongConstant")
	public void setData(Object data) {
		this.data = data;

		ShapeDrawable shapedrawable = new ShapeDrawable();
		shapedrawable.setShape(new RectShape());
		shapedrawable.getPaint().setStrokeWidth(20f);
		shapedrawable.getPaint().setStyle(Paint.Style.STROKE);
		shapedrawable.getPaint().setColor(Color.parseColor("#E8EAF6"));
		shapedrawable.getPaint().setStyle(Paint.Style.FILL);


		this.setText(getResources().getString(R.string.view));
		this.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD_ITALIC));
		this.setTextColor(Color.parseColor("#FAFAFA"));
		this.setBackgroundResource(R.drawable.bg_button);
		this.setOnClickListener(this);
	}

	private Object data;

	@Override
	public void onClick(View view) {
		Toast.makeText(this.getContext(),"Button Clicked "+getData().toString(),Toast.LENGTH_LONG).show();
	}
}
