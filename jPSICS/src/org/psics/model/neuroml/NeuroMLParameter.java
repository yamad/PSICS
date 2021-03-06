package org.psics.model.neuroml;


public class NeuroMLParameter {

		public String name;
		public double value;
		public String group;

		public boolean matches(String pnm) {
			return (pnm.equals(name));
		}


		public double getValue() {
			return value;
		}


		public String getName() {
			return name;
		}


		public String getGroup() {
			return group;
		}

}
