package Chess;

public class PredictionEvaluation {
	int TruePositive=0; 
	int TrueNegative=0; 
	int FalsePositive=0; 
	int FalseNegative=0;
	public int getTruePositive() {
		return TruePositive;
	}
	public void setTruePositive(int truePositive) {
		TruePositive = truePositive;
	}
	public int getTrueNegative() {
		return TrueNegative;
	}
	public void setTrueNegative(int trueNegative) {
		TrueNegative = trueNegative;
	}
	public int getFalsePositive() {
		return FalsePositive;
	}
	public void setFalsePositive(int falsePositive) {
		FalsePositive = falsePositive;
	}
	public int getFalseNegative() {
		return FalseNegative;
	}
	public void setFalseNegative(int falseNegative) {
		FalseNegative = falseNegative;
	}
	public PredictionEvaluation(int truePositive, int trueNegative, int falsePositive, int falseNegative) {
		super();
		TruePositive = truePositive;
		TrueNegative = trueNegative;
		FalsePositive = falsePositive;
		FalseNegative = falseNegative;
	}
	public PredictionEvaluation() {
		// TODO Auto-generated constructor stub
	} 
	
	public String ComparePredictionToGold(String gold, String prediction) {
		if(gold.equals("T") && prediction.equals("T")) {
			return "TP"; 
		}
		else if(gold.equals("N") && prediction.equals("N")) {
			return "TN"; 
		}
		else if(gold.equals("T") && prediction.equals("N")) {
			return "FN"; 
		}
		else if(gold.equals("N") && prediction.equals("T")) {
			return "FP"; 
		}
		else {
			return null; 
		}
	}
	
	public void UpdateCounters(String value, PredictionEvaluation predictionEvaluation) {
		if(value!=null) {
			if(value.equals("TP")) {
				predictionEvaluation.TruePositive++; 
			}else if(value.equals("TN")) {
				predictionEvaluation.TrueNegative++; 
			}else if(value.equals("FN")) {
				predictionEvaluation.FalseNegative++; 
			}else if(value.equals("FP")) {
				predictionEvaluation.FalsePositive++; 

			}
		System.out.println(predictionEvaluation.toString());
		}
		
	}
	@Override
	public String toString() {
		return "PredictionEvaluation [TruePositive=" + TruePositive + ", TrueNegative=" + TrueNegative
				+ ", FalsePositive=" + FalsePositive + ", FalseNegative=" + FalseNegative + "]";
	}
	
	
	
}
