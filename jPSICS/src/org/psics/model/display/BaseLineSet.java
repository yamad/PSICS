package org.psics.model.display;

import java.util.ArrayList;

import org.psics.be.AddableTo;
import org.psics.quantity.annotation.Container;
import org.psics.quantity.annotation.IntegerNumber;
import org.psics.quantity.annotation.Label;
import org.psics.quantity.annotation.ModelType;
import org.psics.quantity.annotation.Quantity;
import org.psics.quantity.annotation.ReferenceToFile;
import org.psics.quantity.phys.NDNumber;
import org.psics.quantity.phys.NDValue;
import org.psics.quantity.units.Units;

@ModelType(info = "The data source and display style for line data", standalone = false,
		tag = "Line data source", usedWithin = { LineGraph.class })
public class BaseLineSet implements AddableTo {

	@Label(info = "Either one of the recognized color names (red, green, blue, magenta, " +
			"cyan etc) or a hex color such as #ff0000 (which would give red)", tag = "Color to plot the data in")
	public String color;

	@ReferenceToFile(fallback = "", required = true, tag = "The name of the file containing the data")
	public String file;

	@Label(info = "This is primarily for reference data from external sources. If the units used " +
			"in the reference data are differnt from those generated by psics, it can be rescaled " +
			"by setting this to a two element vector. For example, the value '[1, 1000]]' will cause " +
			"the data from the first column to be used as is, but the second column will" +
			" be multiplied by 1000 before plotting. This would " +
			"be needed, for example, if the reference data was in Volts and was to be compared with " +
			"PSICS output in milliVolts.", tag = "Optional rescaling to make the axes of the data match other items in the plot")
	public String rescale;

	@Label(info = "The label to use in the key. If it is not set, " +
			"the line will be labelled with the file name", tag = "label to go in key")
	public String label;

	@IntegerNumber(range = "", required = false, tag = "If set, shows just the specified column from the file")
	public NDNumber show = new NDNumber(-1);

	@Quantity(range = "(0.5, 10)", required = false, tag = "width for plotting lines",
			units = Units.none)
	public NDValue width = new NDValue(1.);


	@IntegerNumber(range = "(1, 100)", required = false, tag = "limits the number of " +
			"lines plotted from the file, defaulting to 20 if not specified")
	public NDNumber maxshow = new NDNumber(20);

	@Container(contentTypes = { DataComparison.class }, tag = "optional comparisons with reference data")
	public ArrayList<DataComparison> comparisons = new ArrayList<DataComparison>();

	@Container(contentTypes = { Stats.class }, tag = "optional comparisons with reference data")
	public ArrayList<Stats> stats = new ArrayList<Stats>();


	@Label(info = "Currently this can only take the single value 'mean' to have the mean " +
			"of all the columns plotted.", 
			tag = "Plot a function of the data rather than the points themselves.")
	public String function;

	public void add(Object obj) {

		if (obj instanceof DataComparison) {
			comparisons.add((DataComparison)obj);
		} else if (obj instanceof Stats) {
			stats.add((Stats)obj);
		}
	}


	public boolean hasComparisons() {
		return (comparisons != null && comparisons.size() > 0);
	}

	public ArrayList<DataComparison> getComparisons() {
		return comparisons;
	}

	public ArrayList<Stats> getStats() {
		return stats;
	}

	public String getColor() {
		return color;
	}

	public String getFileName() {
		return file;
	}

	public String getLabel() {
		return label;
	}

	public String getRescaling() {
		 return rescale;
	}

	
	public String getFunction() {
		return function;
	}
	
	
	public int getMaxshow() {
		return maxshow.getNativeValue();
	}

	public int getShow() {
		return show.getNativeValue();
	}

}
