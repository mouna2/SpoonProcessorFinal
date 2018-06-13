package mypackage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CheckGoldDifferences {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Connection conn = null;
		RequirementGold reqgoldcopy = new RequirementGold();
		DatabaseReading2 DatabaseReading = new DatabaseReading2();
		conn = DatabaseReading.getConnection();
		Statement st = conn.createStatement();
		Statement st2 = conn.createStatement();

		MethodTrace2 methodtrace2 = new MethodTrace2();
		List<RequirementGold> calleecopy = new ArrayList<RequirementGold>();
		HashMap<Integer, MethodTrace2> methodtracehashmap = methodtrace2.ReadClassesRepresentations(conn);
		List<MethodTrace2> methodtraces = new ArrayList<MethodTrace2>(methodtracehashmap.values());
		int countmethodtraces = 1;
		for (MethodTrace2 methodtrace : methodtraces) {
			List<List<RequirementGold>> CalleesList = new ArrayList<List<RequirementGold>>();
			List<List<RequirementGold>> CallersList = new ArrayList<List<RequirementGold>>();
			List<List<RequirementGold>> CalleesListExecuted = new ArrayList<List<RequirementGold>>();
			List<List<RequirementGold>> CallersListExecuted = new ArrayList<List<RequirementGold>>();
			String methodID=methodtrace.MethodRepresentation.methodid; 
			for (Method2Representation callee : methodtrace.calleesList) {

				List<RequirementGold> requirementsgold = new ArrayList<RequirementGold>();
				for (RequirementGold reqgold : callee.requirementsGold) {
					requirementsgold.add(reqgold);

				}
				CalleesList.add(requirementsgold);
			}

			for (Method2Representation caller : methodtrace.callersList) {

				List<RequirementGold> requirementsgold = new ArrayList<RequirementGold>();
				for (RequirementGold reqgold : caller.requirementsGold) {
					requirementsgold.add(reqgold);

				}
				CallersList.add(requirementsgold);
			}

			for (Method2Representation callerExecuted : methodtrace.callersListExecuted) {

				List<RequirementGold> requirementsgold = new ArrayList<RequirementGold>();
				for (RequirementGold reqgold : callerExecuted.requirementsGold) {
					requirementsgold.add(reqgold);

				}
				CallersListExecuted.add(requirementsgold);
			}

			for (Method2Representation calleeExecuted : methodtrace.calleesListExecuted) {

				List<RequirementGold> requirementsgold = new ArrayList<RequirementGold>();
				for (RequirementGold reqgold : calleeExecuted.requirementsGold) {
					requirementsgold.add(reqgold);

				}
				CalleesListExecuted.add(requirementsgold);
			}

			int count = 0;
			for (List<RequirementGold> callee : CalleesList) {

				if (count == 0) {
					calleecopy = callee;
				}
				System.out.println(countmethodtraces + "  " + methodtrace.MethodRepresentation.methodid + " "
					+ methodtrace.MethodRepresentation.methodname);
				countmethodtraces++;
				if (reqgoldcopy.EqualsListRequirementsGold(calleecopy, callee)) {
					System.out.println( calleecopy);
					
					System.out.println(callee);
					System.out.println("********************EQUAL****************");
					 System.out.println(countmethodtraces+" "+
					 methodtrace.MethodRepresentation.methodid+
					 methodtrace.MethodRepresentation.methodname+" "+callee.toString());
					calleecopy = callee;
				} else {
					System.out.println("CALLEE COPY:     " + calleecopy);
					System.out.println("CALLEE:     " + callee);
					System.out.println("********************NOT EQUAL****************");
				}
				count++;

			}
			count = 0;
			System.out.println(methodID+" NEW ");
			for (List<RequirementGold> callee : CallersList) {
				System.out.println(callee.toString());
				if (count == 0) {
					calleecopy = callee;
				}
				System.out.println(countmethodtraces + "  " + methodtrace.MethodRepresentation.methodid + " "
						+ methodtrace.MethodRepresentation.methodname);
				countmethodtraces++;
				if (reqgoldcopy.EqualsListRequirementsGold(calleecopy, callee)) {

					System.out.println("********************EQUAL****************");
					 System.out.println(countmethodtraces+" "+
					 methodtrace.MethodRepresentation.methodid+
					 methodtrace.MethodRepresentation.methodname+" "+callee.toString());
					calleecopy = callee;
				} else {
					System.out.println("CALLEE COPY:     " + calleecopy);
					System.out.println("CALLEE:     " + callee);
					System.out.println("********************NOT EQUAL****************");
				}
				count++;

			}

			count = 0;
			for (List<RequirementGold> callee : CalleesListExecuted) {

				if (count == 0) {
					calleecopy = callee;
				}
				System.out.println(countmethodtraces + "  " + methodtrace.MethodRepresentation.methodid + " "
						+ methodtrace.MethodRepresentation.methodname);
				countmethodtraces++;
				if (reqgoldcopy.EqualsListRequirementsGold(calleecopy, callee)) {

					System.out.println("********************EQUAL****************");
					 System.out.println(countmethodtraces+" "+
					 methodtrace.MethodRepresentation.methodid+
					 methodtrace.MethodRepresentation.methodname+" "+callee.toString());
					calleecopy = callee;
				} else {
					System.out.println("CALLEE COPY:     " + calleecopy);
					System.out.println("CALLEE:     " + callee);
					System.out.println("********************NOT EQUAL****************");
				}
				count++;

			}

			count = 0;
			for (List<RequirementGold> callee : CallersListExecuted) {

				if (count == 0) {
					calleecopy = callee;
				}
				System.out.println(countmethodtraces + "  " + methodtrace.MethodRepresentation.methodid + " "
						+ methodtrace.MethodRepresentation.methodname);
				countmethodtraces++;
				if (reqgoldcopy.EqualsListRequirementsGold(calleecopy, callee)) {

					System.out.println("********************EQUAL****************");
					 System.out.println(countmethodtraces+" "+
					 methodtrace.MethodRepresentation.methodid
					 +methodtrace.MethodRepresentation.methodname+" "+callee.toString());
					calleecopy = callee;
				} else {
					System.out.println("CALLEE COPY:     " + calleecopy);
					System.out.println("CALLEE:     " + callee);
					System.out.println("********************NOT EQUAL****************");
				}
				count++;

			}

		}
	}

}
