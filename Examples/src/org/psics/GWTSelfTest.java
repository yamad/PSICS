package org.psics;

import java.io.File;

import org.psics.be.E;
//import org.psics.examples.chowwhite.ChowWhite;
//import org.psics.examples.cianmar30.CM30;
//import org.psics.examples.location.CellLoc;
//import org.psics.examples.mainen.Mainen;
import org.psics.examples.cwvclamp.CWVclamp;
import org.psics.examples.meanvariance.MeanVariance;
import org.psics.examples.migca1.MigCA1;
import org.psics.examples.minor.Minor;
import org.psics.examples.onsurface.OnSurface;
//import org.psics.examples.migca1.MigCA1;
//import org.psics.examples.multirec.MultiRec;
//import org.psics.examples.psd.PSD;
import org.psics.examples.rallpack1.RP1;
import org.psics.examples.rallpack2.RP2;
import org.psics.examples.rallpack3.RP3;
//import org.psics.examples.rallpack3stoch.RP3stoch;
//import org.psics.examples.raster.RasterEx;
//import org.psics.examples.smartrec.SmartRec;
import org.psics.examples.smalldt.SmallDt;
import org.psics.examples.smartrec.SmartRec;
import org.psics.examples.somaspikes.SomaSpikes;
import org.psics.examples.stimtest.StimTest;
import org.psics.examples.stochdet.StochDet;
import org.psics.examples.synapticstim.SynapticStim;
import org.psics.examples.vcsteps.VCSteps;
import org.psics.pnative.FileFPSICS;
import org.psics.pnative.GridEngine;
//import org.psics.run.PSICSImport;
import org.psics.run.PSICSModel;
import org.psics.run.Reporter;
import org.psics.util.JUtil;


public class GWTSelfTest {

	
	public void run() {

		FileFPSICS.setModeExistingExec();

		 
			File f = new File("psics-out");
			f.mkdir();
			 
 
			runTestComponent(new File(f, "rallpack1"), RP1.class, "run.xml");
 
			E.info("reindexing...");
			Reporter.mkindex(f);
		
	    E.info("PSICS finished");
	}

 
	  
	private static void runTestComponent(File dir, Class<?> root, String modelName) {

		E.info("output going to " + dir);

		dir.mkdir();
		PSICSModel pm = new PSICSModel(root, modelName);
		pm.setDestinationFolder(dir);
		// JUtil.extractStaticFieldResources(root, dir);
 
		pm.runJava();
	}
 
	
}
