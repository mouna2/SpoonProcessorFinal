mainPackage.DBDemo2.java is used to populate the database 
mypackage.DatabaseReading2.java is used to read the database 
GUI.TracesTable.java is used to read the database and create the user interface 
TableLog.txt contains the log of the GUI table 
Traces.txt contains the trace information 
data.txt contains the MethodCallsExecuted 
PredictionEvaluation contains the True Positives, True Negatives, False positives, false negatives for each prediction pattern 
We are only making predictions in case we are dealing with T's or N's, predictions are not made if we have E's 
Flags used in run configurations to run TracesTableJHotDraw, TracesTableGantt and TracesTableiTrust: -d64 -Xms8G -Xmx12G
Queries used in mysql workbench to replace all the null values within the gold2, SubjectT and SubjectN columns with "E":
-SET SQL_SAFE_UPDATES = 0;
-update databaseitrust.traces set traces.gold2 = "E" where traces.gold2 = "null";
-update databasechess.traces set traces.gold2 = "E" where traces.gold2 = "null";