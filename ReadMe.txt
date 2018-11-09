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
-update databaseitrust.traces set traces.goldfinal = "E" where traces.goldfinal = "null";
-update databasechess.traces set traces.goldfinal = "E" where traces.goldfinal = "null";
-After creating the database, need to run the following query on MySQLWorkBench:  
ALTER TABLE databasejhotdraw.traces ADD COLUMN gold2 VARCHAR(15) AFTER gold3;
ALTER TABLE databasegantt.traces ADD COLUMN gold2 VARCHAR(15) AFTER gold3;
ALTER TABLE databasechess.traces ADD COLUMN gold3 VARCHAR(15) AFTER gold2;
ALTER TABLE databasechess.traces ADD COLUMN gold4 VARCHAR(15) AFTER gold2;
ALTER TABLE databaseitrust.traces ADD COLUMN gold3 VARCHAR(15) AFTER gold2;
ALTER TABLE databaseitrust.traces ADD COLUMN gold4 VARCHAR(15) AFTER gold2;

Here is the list of the database files to be run in order to populate the databases for each program: 
-DBDemo3JHotDraw3 followed by AddSubjectTSubjectNJHotDraw, AddGold3Gold4JHotDraw,  AddGold3Gold4JHotDrawTRACESCLASSES
-DBDemo3iTrust followed by AddGold2Column, AddGold2ColumnTRACESCLASSES
-DBDemo3Gantt followed by AddSubjectTSubjectNGANTT, AddGold3Gold4Gantt,  AddGold3Gold4GanttTRACESCLASSES
-DBDemoChess followed by AddGold2Column, AddGold2ColumnTRACESCLASSES



TableLog needs to be adapted depending on whether we are interested in Gold, Gold2, Gold3 or Gold4 for each one of the four programs 

Chess: Gold, Gold2	
iTrust: Gold, Gold2	
Gantt: Gold, Gold3, Gold4
JHOTDRAW: Gold, Gold3, Gold4


query to know how many methods belong to classes that trace: 

SELECT DISTINCT  traces.methodid FROM databasegantt.traces INNER JOIN databasegantt.tracesclasses where traces.classid=tracesclasses.classid and tracesclasses.gold='T';






Java Files to be executed to produce predictions for Chess: 
-TracesTableChessFinal: Merged executed calls + parsed calls 
-TracesTableChessFinal_EXECUTED_CALLS: executed calls
-TracesTableChessFinal_PARSED_CALLS: parsed calls 

Java Files to be executed to produce predictions for iTrust: 
-TracesTableiTrustGold2PredictionFINAL: Merged executed calls + parsed calls 
-TracesTableiTrustGold2PredictionFINAL_EXECUTED_CALLS: executed calls
-TracesTableiTrustGold2PredictionFINAL_PARSED_CALLS: parsed calls

Java Files to be executed to produce predictions for Gantt: 
-TracesTableGanttFinal: Merged executed calls + parsed calls 
-TracesTableGanttFinal_EXECUTED_CALLS: executed calls
-TracesTableGanttFinal_PARSED_CALLS: parsed calls  

Java Files to be executed to produce predictions for JHotDraw: 
-TracesTableJHotDrawFinal: Merged executed calls + parsed calls 
-TracesTableJHotDrawFinal_EXECUTED_CALLS: executed calls
-TracesTableJHotDrawFinal_PARSED_CALLS: parsed calls 
