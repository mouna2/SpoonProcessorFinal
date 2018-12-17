package ALGO;

import java.sql.SQLException;
import java.util.HashMap;

import Chess.PredictionEvaluation;
import mypackage.MethodTrace;

public class PrecisionRecall {

	
	
	/************************************************************************************************************************************************/
	/************************************************************************************************************************************************/
	/**
	 * @param ownerClassPredictionValues **********************************************************************************************************************************************/

	public void WriteInDatabaseAndComputePrecisionAndRecallOwner(
			HashMap<String, MethodTrace> methodtraces2HashMap2,
			PredictionEvaluation Pattern, String ProgramName,  PredictionValues ownerClassPredictionValues) throws SQLException {
		// TODO Auto-generated method stub
//		Pattern.ResetCounters(Pattern);

		for (String mykey : methodtraces2HashMap2.keySet()) {
			MethodTrace methodTrace = methodtraces2HashMap2.get(mykey);
			
			if(ProgramName.equals("gantt")|| ProgramName.equals("jhotdraw")){
				if (methodTrace.getGoldfinal() != null && methodTrace.getPrediction() != null 
						&& methodtraces2HashMap2.get(mykey).isSubjectDeveloperEqualityFlag()
						&& !methodTrace.isTraceSet() ) {
					String Result = Pattern.ComparePredictionToGold(methodTrace.getGoldfinal().trim(),
							methodTrace.getPrediction().trim());
					Pattern.UpdateCounters(Result, Pattern);
					if(!Result.equals("E")) {
						methodTrace.setTraceSet(true);
					}


				}
				
				ownerClassPredictionValues.ComputePredictionValues(ownerClassPredictionValues, methodTrace.getPrediction().trim());

			}else if(ProgramName.equals("chess")|| ProgramName.equals("itrust") ) {
				System.out.println(methodTrace.getPrediction());
				System.out.println(methodTrace.getGoldfinal());
				System.out.println(methodTrace.isTraceSet());
				if (methodTrace.getGoldfinal() != null && methodTrace.getPrediction() != null 
						&& !methodTrace.isTraceSet()) {
					String Result = Pattern.ComparePredictionToGold(methodTrace.getGoldfinal().trim(),
							methodTrace.getPrediction().trim());
					Pattern.UpdateCounters(Result, Pattern);
					if(!Result.equals("E")) {
						methodTrace.setTraceSet(true);

					}
				


				}
				ownerClassPredictionValues.ComputePredictionValues(ownerClassPredictionValues, methodTrace.getPrediction().trim());

			}
			methodtraces2HashMap2.put(mykey, methodTrace); 
		

			


		}
		Pattern.toString();

	}
}
