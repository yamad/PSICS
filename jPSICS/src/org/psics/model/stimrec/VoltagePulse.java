package org.psics.model.stimrec;

import org.psics.num.CalcUnits;
import org.psics.num.CommandProfile;
import org.psics.quantity.annotation.ModelType;
import org.psics.quantity.annotation.Quantity;
import org.psics.quantity.phys.Time;
import org.psics.quantity.phys.Voltage;
import org.psics.quantity.units.Units;


@ModelType(info = "A square voltage step", standalone = false, tag = "", usedWithin = { VoltageProfile.class })
public class VoltagePulse extends VProfileFeature {


	@Quantity(range = "[0, 1000)", required = false, tag = "duration of the pulse", units = Units.ms)
	public Time duration;


	@Quantity(range = "(-50, 50)", required = false, tag = "potential to maintain during pulse",
			units = Units.mV)
	public Voltage to;




		public void exportTo(CommandProfile cp) {
			 if (repeatAfter != null && repeatAfter.nonzero()) {
				 cp.addRepeatingBox(CalcUnits.getTimeValue(start), CalcUnits.getVoltageValue(to),
						 	CalcUnits.getTimeValue(duration), CalcUnits.getTimeValue(repeatAfter));

			 } else {
				 cp.addBox(CalcUnits.getTimeValue(start), CalcUnits.getVoltageValue(to),
						 CalcUnits.getTimeValue(duration));
			 }

		}


}
