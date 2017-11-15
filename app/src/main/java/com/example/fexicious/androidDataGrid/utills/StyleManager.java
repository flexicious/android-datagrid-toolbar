package com.example.fexicious.androidDataGrid.utills;

import android.graphics.Color;

import com.flexicious.nestedtreedatagrid.FlexDataGrid;
import com.flexicious.nestedtreedatagrid.valueobjects.FontInfo;

import java.util.HashMap;

public class StyleManager {
	HashMap<String, Object> defaultStyles;
	String iconFilePrefix;
	String gridTheme;

	static StyleManager _instance;

	public static String FLXS_GRID_THEME_DEFAULT() {
		return "default";
	}

	public static String FLXS_GRID_THEME_OFFICE_BLUE() {
		return "officeBlue";
	}

	public static String FLXS_GRID_THEME_OFFICE_GRAY() {
		return "officeGray";
	}

	public static String FLXS_GRID_THEME_OFFICE_BLACK() {
		return "officeBlack";
	}

	public static String FLXS_GRID_THEME_ANDROID_GRAY() {
		return "androidGray";
	}

	public static String FLXS_GRID_THEME_GRAY() {
		return "Gray";
	}

	public static String FLXS_GRID_THEME_IVORY() {
		return "Ivory";
	}

	public static String FLXS_GRID_THEME_GREEN_COLORFUL() {
		return "greenColorful";
	}

	public static String FLXS_GRID_THEME_PINK_COLORFUL() {
		return "pinkColorful";
	}

	public static String FLXS_GRID_THEME_ITUNES() {
		return "itunes";
	}

	public static String FLXS_GRID_THEME_MINIMAL() {
		return "MINIMAL";
	}

	public static StyleManager instance() {
		if (_instance == null) {
			_instance = new StyleManager();
			_instance.iconFilePrefix = "FLXS";
			_instance.gridTheme = "officeBlue";

		}
		return _instance;
	}

	public int getUIColorObjectFromHexString(String hexint) {
		hexint=hexint.replaceAll("0x", "#");
		return Color.parseColor(hexint);
//		return Color.rgb((int) ((hexint & 0xFF0000) >> 16) / 255,
//				((int) ((hexint & 0xFF00) >> 8)) / 255,
//				((int) (hexint & 0xFF)) / 255);

	}

	public void applyStylesToGrid(FlexDataGrid grid) {
		

		applyDefaultStyles(grid);

		if (gridTheme.equals(StyleManager.FLXS_GRID_THEME_OFFICE_BLUE())) {
			applyOfficeBlueStyle(grid);
		} else if (gridTheme.equals(StyleManager.FLXS_GRID_THEME_OFFICE_GRAY())) {
			applyOfficeGrayStyle(grid);
		} else if (gridTheme
				.equals(StyleManager.FLXS_GRID_THEME_OFFICE_BLACK())) {
			applyOfficeBlackStyle(grid);
		} else if (gridTheme
				.equals(StyleManager.FLXS_GRID_THEME_ANDROID_GRAY())) {
			applyAndroidGrayStyle(grid);
		} else if (gridTheme.equals(StyleManager.FLXS_GRID_THEME_GRAY())) {
			applyGrayStyle(grid);
		} else if (gridTheme.equals(StyleManager.FLXS_GRID_THEME_IVORY())) {
			applyIvoryStyle(grid);
		} else if (gridTheme.equals(StyleManager
				.FLXS_GRID_THEME_GREEN_COLORFUL())) {
			applyGreenColorfulStyle(grid);
		} else if (gridTheme.equals(StyleManager
				.FLXS_GRID_THEME_PINK_COLORFUL())) {
			applyPinkColorfulStyles(grid);
		} else if (gridTheme.equals(StyleManager.FLXS_GRID_THEME_ITUNES())) {
			applyITunesStyles(grid);
		} else if (gridTheme.equals(StyleManager.FLXS_GRID_THEME_MINIMAL())) {
			applyMINIMALStyle(grid);
		}

		/*
		 * if(! UIUtils.isIPad()){ //we are iPhone
		 * 
		 * grid.filterVisible=NO; grid.footerVisible=NO;
		 * 
		 * }
		 */

	}

	public void applyDefaultStyles(FlexDataGrid grid) {
		grid.pagerStyleName= new FontInfo(null,0,Color.DKGRAY);
		grid.footerStyleName = new FontInfo(null, 0, Color.DKGRAY);
		grid.headerStyleName = new FontInfo(null, 0, Color.DKGRAY);
		grid.columnGroupStyleName = new FontInfo(null, 0, Color.DKGRAY);

		grid.columnMoveResizeSeparatorColor = getUIColorObjectFromHexString("0x000000");
		grid.columnMoveAlpha = 0.0f;
		grid.backgroundColor = new Integer[] { getUIColorObjectFromHexString("0xEFF3FA") };
		grid.alternatingItemColors = new Integer[] {
				getUIColorObjectFromHexString("0xEFF3FA"),
				getUIColorObjectFromHexString("0xFFFFFF") };

		grid.alternatingTextColors = new Integer[] {
				getUIColorObjectFromHexString("0x000000"),
				getUIColorObjectFromHexString("0x000000") };
		grid.dragAlpha = 0.8f;
		grid.dragRowBorderStyle = "solid";
		grid.editItemColors = new Integer[] {
				getUIColorObjectFromHexString("0xF5F9FC"),
				getUIColorObjectFromHexString("0xC5CED6") };
		grid.editTextColor = getUIColorObjectFromHexString("0x000000");
		grid.errorBackgroundColor = getUIColorObjectFromHexString("0xFCDCDF");
		// grid.errorBorderColor = getUIColorObjectFromHexString( 0xF23E2C );
		grid.verticalGridLineColor = getUIColorObjectFromHexString("0x010101");
		grid.verticalGridLines = true;
		grid.verticalGridLineThickness = 1;
		grid.horizontalGridLineColor = getUIColorObjectFromHexString("0x010101");
		grid.horizontalGridLines = true;
		grid.horizontalGridLineThickness = 1;
		grid.textDisabledColor = getUIColorObjectFromHexString("0xAFAFAF");
		grid.columnGroupVerticalGridLineColor = getUIColorObjectFromHexString("0x666666");
		grid.columnGroupVerticalGridLines = true;
		grid.columnGroupVerticalGridLineThickness = 1;

		grid.columnGroupHorizontalGridLineColor = getUIColorObjectFromHexString("0x666666");
		grid.columnGroupHorizontalGridLines = true;
		grid.columnGroupHorizontalGridLineThickness = 1;
		grid.columnGroupDrawTopBorder = false;

		grid.headerVerticalGridLineColor = getUIColorObjectFromHexString("0x666666");
		grid.headerVerticalGridLines = true;
		grid.headerVerticalGridLineThickness = 1;

		grid.headerHorizontalGridLineColor = getUIColorObjectFromHexString("0x666666");
		grid.headerHorizontalGridLines = true;
		grid.headerHorizontalGridLineThickness = 1;
		grid.headerDrawTopBorder = false;
		grid.headerSortSeparatorRight = 16;

		grid.filterVerticalGridLineColor = getUIColorObjectFromHexString("0x666666");
		grid.filterVerticalGridLines = true;
		grid.filterVerticalGridLineThickness = 1;

		grid.filterHorizontalGridLineColor = getUIColorObjectFromHexString("0x666666");
		grid.filterHorizontalGridLines = true;
		grid.filterHorizontalGridLineThickness = 1;
		grid.filterDrawTopBorder = false;

		grid.footerVerticalGridLineColor = getUIColorObjectFromHexString("0x666666");
		grid.footerVerticalGridLines = true;
		grid.footerVerticalGridLineThickness = 1;

		grid.footerHorizontalGridLineColor = getUIColorObjectFromHexString("0x666666");
		grid.footerHorizontalGridLines = false;
		grid.footerHorizontalGridLineThickness = 1;
		grid.footerDrawTopBorder = false;

		grid.pagerVerticalGridLineColor = getUIColorObjectFromHexString("0x666666");
		grid.pagerVerticalGridLines = true;
		grid.pagerVerticalGridLineThickness = 1;

		grid.pagerHorizontalGridLineColor = getUIColorObjectFromHexString("0x666666");
		grid.pagerHorizontalGridLines = true;
		grid.pagerHorizontalGridLineThickness = 1;

		grid.rendererVerticalGridLineColor = getUIColorObjectFromHexString("0x666666");
		grid.rendererVerticalGridLines = true;
		grid.rendererVerticalGridLineThickness = 1;

		grid.rendererHorizontalGridLineColor = getUIColorObjectFromHexString("0x666666");
		grid.rendererHorizontalGridLines = true;
		grid.rendererHorizontalGridLineThickness = 1;
		grid.rendererDrawTopBorder = false;

		grid.rollOverColor = getUIColorObjectFromHexString("0xCEDBEF");

		grid.headerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xCEDBEF"),
				getUIColorObjectFromHexString("0xCEDBEF") };
		grid.headerColors = new Integer[] {
				getUIColorObjectFromHexString("0xE6E6E6"),
				getUIColorObjectFromHexString("0xFFFFFF") };

		grid.columnGroupRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xCEDBEF"),
				getUIColorObjectFromHexString("0xCEDBEF") };
		grid.columnGroupColors = new Integer[] {
				getUIColorObjectFromHexString("0xE6E6E6"),
				getUIColorObjectFromHexString("0xFFFFFF") };

		grid.footerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xCEDBEF"),
				getUIColorObjectFromHexString("0xCEDBEF") };
		grid.footerColors = new Integer[] {
				getUIColorObjectFromHexString("0xBFBFBF"),
				getUIColorObjectFromHexString("0xBFBFBF") };

		grid.fixedColumnFillColors = new Integer[] {
				getUIColorObjectFromHexString("0xBFBFBF"),
				getUIColorObjectFromHexString("0xBFBFBF") };

		grid.filterRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xBFBFBF"),
				getUIColorObjectFromHexString("0xBFBFBF") };
		grid.filterColors = new Integer[] {
				getUIColorObjectFromHexString("0xBFBFBF"),
				getUIColorObjectFromHexString("0xBFBFBF") };

		grid.activeCellColor = getUIColorObjectFromHexString("0xB7DBFF");

		grid.pagerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xE6E6E6"),
				getUIColorObjectFromHexString("0xFFFFFF") };
		grid.pagerColors = new Integer[] {
				getUIColorObjectFromHexString("0xE6E6E6"),
				getUIColorObjectFromHexString("0xFFFFFF") };

		grid.rendererRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xFFFFFF"),
				getUIColorObjectFromHexString("0xFFFFFF") };
		grid.rendererColors = new Integer[] {
				getUIColorObjectFromHexString("0xFFFFFF"),
				getUIColorObjectFromHexString("0xFFFFFF") };

		grid.setLockedSeparatorColor(getUIColorObjectFromHexString("0x6f6f6f"));
		grid.lockedSeparatorThickness = 2;

		// grid.dropIndicatorColor=[self getUIColorObjectFromHexString:
		// "0x000000"];
		// grid.dropIndicatorThickness= 2;

		grid.textSelectedColor = getUIColorObjectFromHexString("0x000000");
		grid.textRollOverColor = getUIColorObjectFromHexString("0x000000");
		grid.selectionDisabledColor = null;
		// grid.selectionDisabledTextColor=[self
		// getUIColorObjectFromHexString:0xDDDDDD];

//		grid.disclosureClosedIcon = "FLXS_expandOne.png";
//		grid.disclosureOpenIcon = "FLXS_collapseOne.png";

		grid.cellPaddingBottom = 2;
		grid.cellPaddingLeft = 2;
		grid.cellPaddingRight = 2;
		grid.cellPaddingTop = 2;

		grid.columnGroupPaddingBottom = 2;
		grid.columnGroupPaddingLeft = 2;
		grid.columnGroupPaddingRight = 2;
		grid.columnGroupPaddingTop = 2;

		grid.headerPaddingBottom = 2;
		grid.headerPaddingLeft = 2;
		grid.headerPaddingRight = 2;
		grid.headerPaddingTop = 2;

		grid.filterPaddingBottom = 2;
		grid.filterPaddingLeft = 2;
		grid.filterPaddingRight = 2;
		grid.filterPaddingTop = 2;

		grid.footerPaddingBottom = 2;
		grid.footerPaddingLeft = 2;
		grid.footerPaddingRight = 2;
		grid.footerPaddingTop = 2;

		grid.pagerPaddingBottom = 0;
		grid.pagerPaddingLeft = 0;
		grid.pagerPaddingRight = 0;
		grid.pagerPaddingTop = 0;
		grid.rendererPaddingBottom = 2;
		grid.rendererPaddingLeft = 2;
		grid.rendererPaddingRight = 2;
		grid.rendererPaddingTop = 2;

		grid.borderSides = "left";// [[NSArray alloc] initWithObjects:
									// "left","right","top","bottom",nil];
		grid.borderThickness = 1;
		grid.borderColor = getUIColorObjectFromHexString("0x666666");

		grid.columnGroupClosedIcon = "/expand.png";
		grid.columnGroupOpenIcon = "/collapse.png";

		grid.multiColumnSortNumberHeight = 15;
		grid.multiColumnSortNumberWidth = 10;
		// grid.selectionColor= [self getUIColorObjectFromHexString:0x7FCEFF];
		grid.headerSortSeparatorColor = getUIColorObjectFromHexString("0xCCCCCC");
	}

	public void applyOfficeBlueStyle(FlexDataGrid grid) {
		
		
		grid.pagerStyleName = new FontInfo(null, 0, Color.DKGRAY);
		grid.footerStyleName = new FontInfo(null, 0, Color.DKGRAY);
		grid.headerStyleName = new FontInfo(null, 0, Color.DKGRAY);
		grid.columnGroupStyleName = new FontInfo(null, 0, Color.DKGRAY);

		grid.rollOverColor = getUIColorObjectFromHexString("0xCEDBEF");

		grid.alternatingItemColors = new Integer[] {
				getUIColorObjectFromHexString("0xEFF3FA"),
				getUIColorObjectFromHexString("0xFFFFFF") };

		grid.headerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xCEDBEF"),
				getUIColorObjectFromHexString("0xCEDBEF") };
		grid.headerColors = new Integer[] {
				getUIColorObjectFromHexString("0xBDCFEF"),
				getUIColorObjectFromHexString("0xD6E7F7") };

		grid.columnGroupRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xBDCFEF"),
				getUIColorObjectFromHexString("0xD6E7F7") };
		grid.columnGroupColors = new Integer[] {
				getUIColorObjectFromHexString("0xBDCFEF"),
				getUIColorObjectFromHexString("0xD6E7F7") };

		grid.footerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xBDCFEF"),
				getUIColorObjectFromHexString("0xD6E7F7") };
		grid.footerColors = new Integer[] {
				getUIColorObjectFromHexString("0xBDCFEF"),
				getUIColorObjectFromHexString("0xD6E7F7") };

		grid.fixedColumnFillColors = new Integer[] {
				getUIColorObjectFromHexString("0xEFEFEF"),
				getUIColorObjectFromHexString("0xEFEFEF") };

		grid.filterRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xBDCFEF"),
				getUIColorObjectFromHexString("0xD6E7F7") };
		grid.filterColors = new Integer[] {
				getUIColorObjectFromHexString("0xBDCFEF"),
				getUIColorObjectFromHexString("0xD6E7F7") };

		grid.activeCellColor = getUIColorObjectFromHexString("0xB7DBFF");

		grid.pagerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xBDCFEF"),
				getUIColorObjectFromHexString("0xD6E7F7") };
		grid.pagerColors = new Integer[] {
				getUIColorObjectFromHexString("0xBDCFEF"),
				getUIColorObjectFromHexString("0xD6E7F7") };

		grid.rendererRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xFFFFFF"),
				getUIColorObjectFromHexString("0xFFFFFF") };
		grid.rendererColors = new Integer[] {
				getUIColorObjectFromHexString("0xFFFFFF"),
				getUIColorObjectFromHexString("0xFFFFFF") };
		grid.setLockedSeparatorColor(getUIColorObjectFromHexString("0x6f6f6f"));
		grid.lockedSeparatorThickness = 2;

		// grid.dropIndicatorColor=[self getUIColorObjectFromHexString:
		// "0x000000"];
		// grid.dropIndicatorThickness= 2;

		grid.textSelectedColor = getUIColorObjectFromHexString("0x000000");
		grid.textRollOverColor = getUIColorObjectFromHexString("0x000000");
		grid.selectionDisabledColor = null;
		// grid.selectionDisabledTextColor=[self
		// getUIColorObjectFromHexString:0xDDDDDD];

//		grid.disclosureClosedIcon = "FLXS_expandOne.png";
//		grid.disclosureOpenIcon = "FLXS_collapseOne.png";

		grid.borderSides = "left";// [[NSArray alloc] initWithObjects:
									// "left","right","top","bottom",nil];
		grid.borderThickness = 1;
		grid.borderColor = getUIColorObjectFromHexString("0x666666");

		grid.multiColumnSortNumberHeight = 15;
		grid.multiColumnSortNumberWidth = 10;
		grid.selectionColor = getUIColorObjectFromHexString("0xFFEFB5");// [[NSArray
																		// alloc]
																		// initWithObjects:[
																		// self
																		// getUIColorObjectFromHexString:"0xFFEFB5"],[self
																		// getUIColorObjectFromHexString:0xFFDF8C],nil];
		grid.headerSortSeparatorColor = getUIColorObjectFromHexString("0xCCCCCC");

	}

	// from http://www.htmltreegrid.com/demo/Themes.js - see method above for
	// example
	public void applyOfficeGrayStyle(FlexDataGrid grid) {

		
		grid.pagerStyleName = new FontInfo(null, 0, Color.DKGRAY);
		grid.footerStyleName = new FontInfo(null, 0, Color.DKGRAY);
		grid.headerStyleName = new FontInfo(null, 0, Color.DKGRAY);
		grid.columnGroupStyleName = new FontInfo(null, 0, Color.DKGRAY);

		grid.alternatingItemColors = new Integer[] {
				getUIColorObjectFromHexString("0xF7F7F7"),
				getUIColorObjectFromHexString("0xE7E7E7") };
		grid.alternatingTextColors = new Integer[] {
				getUIColorObjectFromHexString("0x636163"),
				getUIColorObjectFromHexString("0x636163") };
		grid.rollOverColor = getUIColorObjectFromHexString("0xCEDBEF");
		grid.headerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xF7F7EF"),
				getUIColorObjectFromHexString("0xE7E7E7") };
		grid.headerColors = new Integer[] {
				getUIColorObjectFromHexString("0xF7F7EF"),
				getUIColorObjectFromHexString("0xE7E7E7") };
		grid.columnGroupRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xF7F7EF"),
				getUIColorObjectFromHexString("0xE7E7E7") };
		grid.columnGroupColors = new Integer[] {
				getUIColorObjectFromHexString("0xF7F7EF"),
				getUIColorObjectFromHexString("0xE7E7E7") };
		grid.pagerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xF7F7EF"),
				getUIColorObjectFromHexString("0xE7E7E7") };
		grid.pagerColors = new Integer[] {
				getUIColorObjectFromHexString("0xF7F7EF"),
				getUIColorObjectFromHexString("0xE7E7E7") };
		grid.footerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xF7F7EF"),
				getUIColorObjectFromHexString("0xE7E7E7") };
		grid.footerColors = new Integer[] {
				getUIColorObjectFromHexString("0xF7F7EF"),
				getUIColorObjectFromHexString("0xE7E7E7") };
		grid.filterRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xF7F7EF"),
				getUIColorObjectFromHexString("0xE7E7E7") };
		grid.filterColors = new Integer[] {
				getUIColorObjectFromHexString("0xF7F7EF"),
				getUIColorObjectFromHexString("0xE7E7E7") };
		grid.fixedColumnFillColors = new Integer[] {
				getUIColorObjectFromHexString("0xEFEFEF"),
				getUIColorObjectFromHexString("0xEFEFEF") };
		grid.activeCellColor = getUIColorObjectFromHexString("0xB7DBFF");
		grid.rendererRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xFFFFFF"),
				getUIColorObjectFromHexString("0xFFFFFF") };
		grid.rendererColors = new Integer[] {
				getUIColorObjectFromHexString("0xFFFFFF"),
				getUIColorObjectFromHexString("0xFFFFFF") };
		grid.textSelectedColor = getUIColorObjectFromHexString("0x000000");
		grid.textRollOverColor = getUIColorObjectFromHexString("0x000000");
		grid.borderColor = getUIColorObjectFromHexString("0x666666");
		grid.selectionColor = getUIColorObjectFromHexString("0xFFEFB5");// new
																		// Integer[]{
																		// getUIColorObjectFromHexString("0xFFEFB5"),getUIColorObjectFromHexString(0xFFDF8C)};
	}

	public void applyOfficeBlackStyle(FlexDataGrid grid) {
		
		grid.alternatingItemColors = new Integer[] {
				getUIColorObjectFromHexString("0x3f3f3f"),
				getUIColorObjectFromHexString("0x111111") };
		grid.alternatingTextColors = new Integer[] {
				getUIColorObjectFromHexString("0xFFFFFF"),
				getUIColorObjectFromHexString("0xFFFFFF") };
		grid.rollOverColor = getUIColorObjectFromHexString("0x848684");
		grid.headerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0x3f3f3f"),
				getUIColorObjectFromHexString("0x111111") };
		grid.headerColors = new Integer[] {
				getUIColorObjectFromHexString("0x3f3f3f"),
				getUIColorObjectFromHexString("0x111111") };
		grid.columnGroupRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0x3f3f3f"),
				getUIColorObjectFromHexString("0x111111") };
		grid.columnGroupColors = new Integer[] {
				getUIColorObjectFromHexString("0x3f3f3f"),
				getUIColorObjectFromHexString("0x111111") };
		grid.pagerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0x3f3f3f"),
				getUIColorObjectFromHexString("0x111111") };
		grid.pagerColors = new Integer[] {
				getUIColorObjectFromHexString("0x3f3f3f"),
				getUIColorObjectFromHexString("0x111111") };
		grid.footerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0x3f3f3f"),
				getUIColorObjectFromHexString("0x111111") };
		grid.footerColors = new Integer[] {
				getUIColorObjectFromHexString("0x3f3f3f"),
				getUIColorObjectFromHexString("0x111111") };
		grid.filterRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0x3f3f3f"),
				getUIColorObjectFromHexString("0x111111") };
		grid.filterColors = new Integer[] {
				getUIColorObjectFromHexString("0x3f3f3f"),
				getUIColorObjectFromHexString("0x111111") };
		grid.fixedColumnFillColors = new Integer[] {
				getUIColorObjectFromHexString("0xEFEFEF"),
				getUIColorObjectFromHexString("0xEFEFEF") };
		grid.activeCellColor = getUIColorObjectFromHexString("0x6f6f6f");
		grid.textSelectedColor = getUIColorObjectFromHexString("0x000000");
		grid.textRollOverColor = getUIColorObjectFromHexString("0x000000");
		grid.borderColor = getUIColorObjectFromHexString("0x666666");
		grid.selectionColor = getUIColorObjectFromHexString("0xFFEFB5");// new
																		// Integer[]{
																		// getUIColorObjectFromHexString("0xFFEFB5"),getUIColorObjectFromHexString(0xFFDF8C)};
		grid.headerStyleName = new FontInfo(null, 0, Color.WHITE);
		grid.footerStyleName = new FontInfo(null, 0, Color.WHITE);
		grid.columnGroupStyleName = new FontInfo(null, 0, Color.WHITE);
		grid.pagerStyleName= new FontInfo(null,0,Color.WHITE);
	}

	public void applyAndroidGrayStyle(FlexDataGrid grid) {
		/*  *//**
		 * Usually the toolbar root is the same as the images root, but for
		 * some custom themes, we have their own icons.
		 */
		
		grid.alternatingItemColors = new Integer[] {
				getUIColorObjectFromHexString("0xFFFFFF"),
				getUIColorObjectFromHexString("0xFFFCF5") };
		grid.alternatingTextColors = new Integer[] {
				getUIColorObjectFromHexString("0x000000"),
				getUIColorObjectFromHexString("0x000000") };
		grid.rollOverColor = getUIColorObjectFromHexString("0xCEDBEF");
		grid.headerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0x1C1E1D"),
				getUIColorObjectFromHexString("0x3A3B3D") };
		grid.headerColors = new Integer[] {
				getUIColorObjectFromHexString("0x1C1E1D"),
				getUIColorObjectFromHexString("0x3A3B3D") };
		grid.headerStyleName = new FontInfo(null, 14, Color.WHITE);
		grid.columnGroupRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0x1C1E1D"),
				getUIColorObjectFromHexString("0x3A3B3D") };
		grid.columnGroupColors = new Integer[] {
				getUIColorObjectFromHexString("0x1C1E1D"),
				getUIColorObjectFromHexString("0x3A3B3D") };
		grid.columnGroupStyleName = new FontInfo(null, 0, Color.WHITE);
		grid.pagerDrawTopBorder = true;
		grid.pagerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0x1C1E1D"),
				getUIColorObjectFromHexString("0x3A3B3D") };
		grid.pagerColors = new Integer[] {
				getUIColorObjectFromHexString("0x1C1E1D"),
				getUIColorObjectFromHexString("0x3A3B3D") };
		grid.pagerStyleName = new FontInfo(null, 0, Color.WHITE);
		grid.footerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0x1C1E1D"),
				getUIColorObjectFromHexString("0x3A3B3D") };
		grid.footerColors = new Integer[] {
				getUIColorObjectFromHexString("0x1C1E1D"),
				getUIColorObjectFromHexString("0x3A3B3D") };
		grid.footerDrawTopBorder = true;
		grid.footerVerticalGridLines = true;
		grid.footerHorizontalGridLines = true;
		grid.footerHorizontalGridLineColor = getUIColorObjectFromHexString("0xFABB39");
		grid.footerHorizontalGridLineThickness = 2;
		grid.filterPaddingBottom = 4;
		grid.filterRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0x1C1E1D"),
				getUIColorObjectFromHexString("0x3A3B3D") };
		grid.filterColors = new Integer[] {
				getUIColorObjectFromHexString("0x1C1E1D"),
				getUIColorObjectFromHexString("0x3A3B3D") };
		grid.filterHorizontalGridLineColor = getUIColorObjectFromHexString("0xFABB39");
		grid.filterHorizontalGridLines = true;
		grid.filterHorizontalGridLineThickness = 2;
		grid.filterDrawTopBorder = true;
		grid.fixedColumnFillColors = new Integer[] {
				getUIColorObjectFromHexString("0xEFEFEF"),
				getUIColorObjectFromHexString("0xEFEFEF") };
		grid.activeCellColor = getUIColorObjectFromHexString("0xB7DBFF");
		grid.rendererRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xFFFFFF"),
				getUIColorObjectFromHexString("0xFFFFFF") };
		grid.rendererColors = new Integer[] {
				getUIColorObjectFromHexString("0xFFFFFF"),
				getUIColorObjectFromHexString("0xFFFFFF") };
		grid.textSelectedColor = getUIColorObjectFromHexString("0x000000");
		grid.textRollOverColor = getUIColorObjectFromHexString("0x000000");
		grid.borderColor = getUIColorObjectFromHexString("0x666666");
		grid.footerStyleName = new FontInfo(null, 0, Color.WHITE);
		grid.pagerHorizontalGridLineColor = getUIColorObjectFromHexString("0xFABB39");
		grid.pagerHorizontalGridLines = true;
		grid.pagerHorizontalGridLineThickness = 4;
		grid.pagerDrawTopBorder = true;
		grid.pagerVerticalGridLines = true;
		grid.pagerVerticalGridLineThickness = 4;
		grid.pagerVerticalGridLineColor = getUIColorObjectFromHexString("0xFABB39");
		grid.selectionColor = getUIColorObjectFromHexString("0xCD4602");// new
																		// Integer[]{
																		// getUIColorObjectFromHexString("0xFABB39"),getUIColorObjectFromHexString("0xCD4602")};
	}

	public void applyMINIMALStyle(FlexDataGrid grid) {

		this.iconFilePrefix = "FLXS_MINIMAL";
		grid.backgroundColor = new Integer[] { getUIColorObjectFromHexString("0x80FFFFFF") };// Color.TRANSPARENT;//

		grid.pagerStyleName = new FontInfo(null, 0, Color.DKGRAY);
		grid.footerStyleName = new FontInfo(null, 0, Color.DKGRAY);
		grid.headerStyleName = new FontInfo(null, 0, Color.DKGRAY);
		grid.columnGroupStyleName = new FontInfo(null, 0, Color.DKGRAY);
		grid.pagerStyleName = new FontInfo(null, 0, Color.DKGRAY);										// [UIColor
																							// clearColor];
		// grid.enableMultiColumnSort = false;
		// grid.enableSplitHeader=false;
		grid.filterPaddingLeft = 5;
		grid.filterPaddingRight = 5;
		grid.filterPaddingTop = 5;
		grid.filterPaddingBottom = 5;

		grid.alternatingItemColors = new Integer[] {
				getUIColorObjectFromHexString("0xFFFFFF"),
				getUIColorObjectFromHexString("0xFFFFFF") };
		grid.alternatingTextColors = new Integer[] {
				getUIColorObjectFromHexString("0x000000"),
				getUIColorObjectFromHexString("0x000000") };

		grid.headerColors = new Integer[] {
				getUIColorObjectFromHexString("0xFFFFFF"),
				getUIColorObjectFromHexString("0xFFFFFF"),
				getUIColorObjectFromHexString("0xFFFFFF") }; 
		grid.headerHorizontalGridLines = false; 
		grid.columnGroupColors = new Integer[] {
				getUIColorObjectFromHexString("0xFFFFFF"),
				getUIColorObjectFromHexString("0xFFFFFF") };
		grid.columnGroupHorizontalGridLineColor = getUIColorObjectFromHexString("0x999999");
		grid.columnGroupHorizontalGridLines = true;
		grid.columnGroupDrawTopBorder = true;
		grid.columnGroupVerticalGridLines = true;

		grid.pagerDrawTopBorder = true;
		grid.footerColors = new Integer[] {
				getUIColorObjectFromHexString("0x333333"),
				getUIColorObjectFromHexString("0x333333") };
		grid.footerDrawTopBorder = true;
		grid.footerVerticalGridLines = true;
		grid.footerHorizontalGridLines = true;
		grid.footerColors = new Integer[] {
				getUIColorObjectFromHexString("0xFFFFFF"),
				getUIColorObjectFromHexString("0xFFFFFF") };

		grid.filterColors = new Integer[] {
				getUIColorObjectFromHexString("0xFFFFFF"),
				getUIColorObjectFromHexString("0xFFFFFF") };
		grid.filterHorizontalGridLineColor = getUIColorObjectFromHexString("0x999999");
		grid.filterHorizontalGridLines = true;
		grid.filterHorizontalGridLineThickness = 1;
		grid.filterDrawTopBorder = false;
		grid.filterVerticalGridLines = true;

		grid.fixedColumnFillColors = new Integer[] {
				getUIColorObjectFromHexString("0xe52929"),
				getUIColorObjectFromHexString("0xe52929") };
		grid.activeCellColor = getUIColorObjectFromHexString("0xe52929");
		grid.rendererColors = new Integer[] {
				getUIColorObjectFromHexString("0xe52929"),
				getUIColorObjectFromHexString("0xe52929") };
		grid.textSelectedColor = getUIColorObjectFromHexString("0x000000");
		grid.borderColor = getUIColorObjectFromHexString("0x999999");

		grid.footerStyleName = new FontInfo(null, 0, Color.WHITE);

		// Start Pager
		grid.pagerHorizontalGridLineColor = getUIColorObjectFromHexString("0x999999");
		grid.pagerHorizontalGridLines = true;
		grid.pagerHorizontalGridLineThickness = 1;
		grid.pagerVerticalGridLines = true;
		grid.pagerVerticalGridLineColor = getUIColorObjectFromHexString("0x999999");
		grid.pagerColors = new Integer[] {
				getUIColorObjectFromHexString("0xFFFFFF"),
				getUIColorObjectFromHexString("0xFFFFFF") };
		// End Pager

		grid.headerHorizontalGridLines = true;
		grid.headerVerticalGridLines = true;
		grid.verticalGridLines = true;
		grid.horizontalGridLineColor = getUIColorObjectFromHexString("0x999999");
		grid.verticalGridLineColor = getUIColorObjectFromHexString("0x999999");
		grid.headerHorizontalGridLineColor = getUIColorObjectFromHexString("0x999999");
		grid.headerVerticalGridLineColor = getUIColorObjectFromHexString("0x999999");
		grid.columnGroupHorizontalGridLineColor = getUIColorObjectFromHexString("0x999999");
		grid.columnGroupVerticalGridLineColor = getUIColorObjectFromHexString("0x999999");
		grid.headerSortSeparatorColor = getUIColorObjectFromHexString("0x999999");
		grid.selectionColor = getUIColorObjectFromHexString("0xe52929");// new
																		// Integer[]{
																		// getUIColorObjectFromHexString("0xe52929"),getUIColorObjectFromHexString("0xe52929")};
		grid.horizontalGridLines = true;
		grid.textSelectedColor = getUIColorObjectFromHexString("0xFFFFFF");
		grid.footerDrawTopBorder = false;
		grid.pagerDrawTopBorder = false;
	}

	public void applyGrayStyle(FlexDataGrid grid) {
		grid.pagerStyleName=new FontInfo(null, 0, Color.WHITE);
		grid.alternatingItemColors = new Integer[] {
				getUIColorObjectFromHexString("0xF9F9F9"),
				getUIColorObjectFromHexString("0xF3F3F3") };
		grid.alternatingTextColors = new Integer[] {
				getUIColorObjectFromHexString("0x111111"),
				getUIColorObjectFromHexString("0x111111") };
		grid.rollOverColor = getUIColorObjectFromHexString("0xCEDBEF");
		grid.headerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xF7F7EF"),
				getUIColorObjectFromHexString("0xE7E7E7") };
		grid.headerColors = new Integer[] {
				getUIColorObjectFromHexString("0xF2F2F4"),
				getUIColorObjectFromHexString("0x9898A4") };
		grid.columnGroupRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xF7F7EF"),
				getUIColorObjectFromHexString("0xE7E7E7") };
		grid.columnGroupColors = new Integer[] {
				getUIColorObjectFromHexString("0xF2F2F4"),
				getUIColorObjectFromHexString("0x9898A4") };
		grid.pagerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xF7F7EF"),
				getUIColorObjectFromHexString("0xE7E7E7") };
		grid.pagerColors = new Integer[] {
				getUIColorObjectFromHexString("0x908F9D"),
				getUIColorObjectFromHexString("0x12122C") };
		grid.footerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xF7F7EF"),
				getUIColorObjectFromHexString("0xE7E7E7") };
		grid.footerColors = new Integer[] {
				getUIColorObjectFromHexString("0x908F9D"),
				getUIColorObjectFromHexString("0x12122C") };
		grid.footerStyleName = new FontInfo(null, 0, Color.WHITE);
		grid.filterRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xF7F7EF"),
				getUIColorObjectFromHexString("0xE7E7E7") };
		grid.filterColors = new Integer[] {
				getUIColorObjectFromHexString("0x908F9D"),
				getUIColorObjectFromHexString("0x12122C") };
		grid.footerStyleName = new FontInfo(null, 0, Color.WHITE);
		grid.fixedColumnFillColors = new Integer[] {
				getUIColorObjectFromHexString("0xEFEFEF"),
				getUIColorObjectFromHexString("0xEFEFEF") };
		grid.activeCellColor = getUIColorObjectFromHexString("0xB7DBFF");
		grid.rendererRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xFFFFFF"),
				getUIColorObjectFromHexString("0xFFFFFF") };
		grid.rendererColors = new Integer[] {
				getUIColorObjectFromHexString("0xFFFFFF"),
				getUIColorObjectFromHexString("0xFFFFFF") };
		grid.textSelectedColor = getUIColorObjectFromHexString("0x000000");
		grid.textRollOverColor = getUIColorObjectFromHexString("0x000000");
		grid.borderColor = getUIColorObjectFromHexString("0x666666");
		grid.selectionColor = getUIColorObjectFromHexString("0xC7C8CD");// new
																		// Integer[]{
																		// getUIColorObjectFromHexString("0xC7C8CD"),getUIColorObjectFromHexString("0xC7C8CD")};
	}

	public void applyIvoryStyle(FlexDataGrid grid) {
		this.iconFilePrefix = "FLXS_iOSBLACK";

		grid.pagerStyleName = new FontInfo(null, 0, Color.DKGRAY);
		grid.footerStyleName = new FontInfo(null, 0, Color.DKGRAY);
		grid.headerStyleName = new FontInfo(null, 0, Color.DKGRAY);
		grid.columnGroupStyleName = new FontInfo(null, 0, Color.DKGRAY);

		grid.alternatingItemColors = new Integer[] {
				getUIColorObjectFromHexString("0xEFF0F2"),
				getUIColorObjectFromHexString("0xF1F1F1") };
		grid.alternatingTextColors = new Integer[] {
				getUIColorObjectFromHexString("0x020202"),
				getUIColorObjectFromHexString("0x020202") };
		grid.rollOverColor = getUIColorObjectFromHexString("0xFEFEFE");
		grid.headerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xF7F7EF"),
				getUIColorObjectFromHexString("0xE7E7E7") };
		grid.headerColors = new Integer[] {
				getUIColorObjectFromHexString("0xF7F7EF"),
				getUIColorObjectFromHexString("0xE7E7E7") };
		grid.columnGroupRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xFEFEFE"),
				getUIColorObjectFromHexString("0xFEFEFE") };
		grid.columnGroupColors = new Integer[] {
				getUIColorObjectFromHexString("0xFEFEFE"),
				getUIColorObjectFromHexString("0xFEFEFE") };
		grid.pagerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xFFFFFF"),
				getUIColorObjectFromHexString("0xFFFFFF") };
		grid.pagerColors = new Integer[] {
				getUIColorObjectFromHexString("0xFEFEFE"),
				getUIColorObjectFromHexString("0xF1F1F1") };
		grid.footerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xF7F7EF"),
				getUIColorObjectFromHexString("0xE7E7E7") };
		grid.footerColors = new Integer[] {
				getUIColorObjectFromHexString("0xFEFEFE"),
				getUIColorObjectFromHexString("0xFEFEFE") };
		grid.selectionColor = getUIColorObjectFromHexString("0xB5B5B5");// new
																		// Integer[]{
																		// getUIColorObjectFromHexString("0xB5B5B5"),getUIColorObjectFromHexString("0xB5B5B5")};
		grid.filterRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xF7F7EF"),
				getUIColorObjectFromHexString("0xE7E7E7") };
		grid.filterColors = new Integer[] {
				getUIColorObjectFromHexString("0xFEFEFE"),
				getUIColorObjectFromHexString("0xFEFEFE") };
		grid.fixedColumnFillColors = new Integer[] {
				getUIColorObjectFromHexString("0xEFEFEF"),
				getUIColorObjectFromHexString("0xEFEFEF") };
		grid.activeCellColor = getUIColorObjectFromHexString("0xFEFEFE");
		grid.rendererRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xFFFFFF"),
				getUIColorObjectFromHexString("0xFFFFFF") };
		grid.rendererColors = new Integer[] {
				getUIColorObjectFromHexString("0xFFFFFF"),
				getUIColorObjectFromHexString("0xFFFFFF") };
		grid.textSelectedColor = getUIColorObjectFromHexString("0x000000");
		grid.textRollOverColor = getUIColorObjectFromHexString("0x000000");
		grid.borderColor = getUIColorObjectFromHexString("0x666666");
	}

	public void applyGreenColorfulStyle(FlexDataGrid grid) {
		

		grid.pagerStyleName = new FontInfo(null, 0, Color.DKGRAY);
		grid.footerStyleName = new FontInfo(null, 0, Color.DKGRAY);
		grid.headerStyleName = new FontInfo(null, 0, Color.DKGRAY);
		grid.columnGroupStyleName = new FontInfo(null, 0, Color.DKGRAY);

		grid.alternatingItemColors = new Integer[] {
				getUIColorObjectFromHexString("0xB5B5B5"),
				getUIColorObjectFromHexString("0xDAFAF9") };
		grid.alternatingTextColors = new Integer[] {
				getUIColorObjectFromHexString("0x111111"),
				getUIColorObjectFromHexString("0x111111") };
		grid.rollOverColor = getUIColorObjectFromHexString("0xF7F7EF");
		grid.headerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xEBE27D"),
				getUIColorObjectFromHexString("0xDFCD4D") };
		grid.headerColors = new Integer[] {
				getUIColorObjectFromHexString("0xEBE27D"),
				getUIColorObjectFromHexString("0xDFCD4D") };
		grid.columnGroupRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xEBE27D"),
				getUIColorObjectFromHexString("0xDFCD4D") };
		grid.columnGroupColors = new Integer[] {
				getUIColorObjectFromHexString("0xEBE27D"),
				getUIColorObjectFromHexString("0xDFCD4D") };
		grid.pagerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xF7F7EF"),
				getUIColorObjectFromHexString("0xE7E7E7") };
		grid.pagerColors = new Integer[] {
				getUIColorObjectFromHexString("0x75B837"),
				getUIColorObjectFromHexString("0x5F9929") };
		grid.footerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xF7F7EF"),
				getUIColorObjectFromHexString("0xE7E7E7") };
		grid.footerColors = new Integer[] {
				getUIColorObjectFromHexString("0x75B837"),
				getUIColorObjectFromHexString("0x5F9929") };
		grid.filterRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xF7F7EF"),
				getUIColorObjectFromHexString("0xE7E7E7") };
		grid.filterColors = new Integer[] {
				getUIColorObjectFromHexString("0xF7F4C1"),
				getUIColorObjectFromHexString("0xF9F3BF") };
		grid.fixedColumnFillColors = new Integer[] {
				getUIColorObjectFromHexString("0xEFEFEF"),
				getUIColorObjectFromHexString("0xEFEFEF") };
		grid.activeCellColor = getUIColorObjectFromHexString("0xB7DBFF");
		grid.rendererRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xFFFFFF"),
				getUIColorObjectFromHexString("0xFFFFFF") };
		grid.rendererColors = new Integer[] {
				getUIColorObjectFromHexString("0xFFFFFF"),
				getUIColorObjectFromHexString("0xFFFFFF") };
		grid.textSelectedColor = getUIColorObjectFromHexString("0x000000");
		grid.textRollOverColor = getUIColorObjectFromHexString("0x000000");
		grid.borderColor = getUIColorObjectFromHexString("0x666666");
	}

	public void applyPinkColorfulStyles(FlexDataGrid grid) {
		

		grid.pagerStyleName = new FontInfo(null,0,Color.WHITE);
		grid.headerStyleName =  new FontInfo(null,0,Color.WHITE);
		grid.columnGroupStyleName =  new FontInfo(null,0,Color.WHITE);
		grid.footerStyleName =  new FontInfo(null,0,Color.WHITE);

		grid.alternatingItemColors = new Integer[] {
				getUIColorObjectFromHexString("0xE7BEFA"),
				getUIColorObjectFromHexString("0xF3DEFD") };
		grid.alternatingTextColors = new Integer[] {
				getUIColorObjectFromHexString("0x111111"),
				getUIColorObjectFromHexString("0x111111") };
		grid.rollOverColor = getUIColorObjectFromHexString("0xCEDBEF");
		grid.headerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0x9F73E6"),
				getUIColorObjectFromHexString("0xE7E7E7") };
		grid.headerColors = new Integer[] {
				getUIColorObjectFromHexString("0x9F73E6"),
				getUIColorObjectFromHexString("0x402A58") };
		grid.columnGroupRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0x9B6FE0"),
				getUIColorObjectFromHexString("0xE7E7E7") };
		grid.columnGroupColors = new Integer[] {
				getUIColorObjectFromHexString("0x986CDB"),
				getUIColorObjectFromHexString("0x402A58") };
		grid.pagerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0x268CD4"),
				getUIColorObjectFromHexString("0x092940") };
		grid.pagerColors = new Integer[] {
				getUIColorObjectFromHexString("0x268CD4"),
				getUIColorObjectFromHexString("0x092940") };
		grid.footerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0x268CD4"),
				getUIColorObjectFromHexString("0xE7E7E7") };
		grid.footerColors = new Integer[] {
				getUIColorObjectFromHexString("0x268CD4"),
				getUIColorObjectFromHexString("0x092940") };
		grid.filterRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xF7F7EF"),
				getUIColorObjectFromHexString("0xE7E7E7") };
		grid.filterColors = new Integer[] {
				getUIColorObjectFromHexString("0xF7F4C1"),
				getUIColorObjectFromHexString("0xF7F6C0") };
		grid.fixedColumnFillColors = new Integer[] {
				getUIColorObjectFromHexString("0xEFEFEF"),
				getUIColorObjectFromHexString("0xEFEFEF") };
		grid.activeCellColor = getUIColorObjectFromHexString("0xB7DBFF");
		grid.rendererRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xFFFFFF"),
				getUIColorObjectFromHexString("0xFFFFFF") };
		grid.rendererColors = new Integer[] {
				getUIColorObjectFromHexString("0xFFFFFF"),
				getUIColorObjectFromHexString("0xFFFFFF") };
		grid.textSelectedColor = getUIColorObjectFromHexString("0x000000");
		grid.textRollOverColor = getUIColorObjectFromHexString("0x000000");
		grid.borderColor = getUIColorObjectFromHexString("0x666666");
	}

	public void applyITunesStyles(FlexDataGrid grid) {
		

		grid.pagerStyleName =  new FontInfo(null,0,Color.WHITE);
		grid.headerStyleName = new FontInfo(null,0,Color.WHITE);
		grid.columnGroupStyleName =  new FontInfo(null,0,Color.WHITE);
		grid.footerStyleName = new FontInfo(null,0,Color.WHITE);

		grid.alternatingItemColors = new Integer[] {
				getUIColorObjectFromHexString("0xD8DAD9"),
				getUIColorObjectFromHexString("0xD8DAD9") };
		grid.alternatingTextColors = new Integer[] {
				getUIColorObjectFromHexString("0x111111"),
				getUIColorObjectFromHexString("0x111111") };
		grid.selectionColor = getUIColorObjectFromHexString("0xEAF1F9");// new
																		// Integer[]{
																		// getUIColorObjectFromHexString("0xEAF1F9"),getUIColorObjectFromHexString(0xEFF6FF)};
		grid.rollOverColor = getUIColorObjectFromHexString("0xEDF4FE");
		grid.headerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0x616169"),
				getUIColorObjectFromHexString("0x9598A1") };
		grid.headerColors = new Integer[] {
				getUIColorObjectFromHexString("0x616169"),
				getUIColorObjectFromHexString("0x9598A1") };
		grid.columnGroupRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0x616169"),
				getUIColorObjectFromHexString("0x9598A1") };
		grid.columnGroupColors = new Integer[] {
				getUIColorObjectFromHexString("0x616169"),
				getUIColorObjectFromHexString("0x9598A1") };
		grid.pagerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0x616169"),
				getUIColorObjectFromHexString("0x9598A1") };
		grid.pagerColors = new Integer[] {
				getUIColorObjectFromHexString("0x616169"),
				getUIColorObjectFromHexString("0x9598A1") };
		grid.footerRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0x616169"),
				getUIColorObjectFromHexString("0x9598A1") };
		grid.footerColors = new Integer[] {
				getUIColorObjectFromHexString("0x616169"),
				getUIColorObjectFromHexString("0x9598A1") };
		grid.filterRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0x616169"),
				getUIColorObjectFromHexString("0x9598A1") };
		grid.filterColors = new Integer[] {
				getUIColorObjectFromHexString("0x33342F"),
				getUIColorObjectFromHexString("0x363435") };
		grid.fixedColumnFillColors = new Integer[] {
				getUIColorObjectFromHexString("0xEFEFEF"),
				getUIColorObjectFromHexString("0xEFEFEF") };
		grid.activeCellColor = getUIColorObjectFromHexString("0xB7DBFF");
		grid.rendererRollOverColors = new Integer[] {
				getUIColorObjectFromHexString("0xFFFFFF"),
				getUIColorObjectFromHexString("0xFFFFFF") };
		grid.rendererColors = new Integer[] {
				getUIColorObjectFromHexString("0xFFFFFF"),
				getUIColorObjectFromHexString("0xFFFFFF") };
		grid.textSelectedColor = getUIColorObjectFromHexString("0x000000");
		grid.textRollOverColor = getUIColorObjectFromHexString("0x000000");
		grid.borderColor = getUIColorObjectFromHexString("0x666666");

	}
}
