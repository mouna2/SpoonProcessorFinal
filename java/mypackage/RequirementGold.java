package mypackage;

import java.util.List;

public class RequirementGold {
	public Requirement2 Requirement=new Requirement2(); 
	public String gold="";
	public Requirement2 getRequirement() {
		return Requirement;
	}
	public void setRequirement(Requirement2 requirement) {
		Requirement = requirement;
	}
	public String getGold() {
		return gold;
	}
	public void setGold(String gold) {
		this.gold = gold;
	}
	public RequirementGold(Requirement2 requirement, String gold) {
		super();
		Requirement = requirement;
		this.gold = gold;
	}
	public RequirementGold() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RequirementGold [Requirement=" + Requirement + ", gold=" + gold + "]           ";
	}
	
	public boolean EqualsListRequirementsGold(List<RequirementGold> list1, List<RequirementGold> list2) {
		boolean val=true; 
		int ListSize1=list1.size(); 
		int ListSize2=list2.size(); 
		for(int i=0; i<ListSize1; i++) {
			if((list1.get(i).gold.equals(list2.get(i).gold))==false&& (list1.get(i).Requirement.ID.equals(list2.get(i).Requirement.ID)==false)) {
				return false; 
			}
		}
		
		
		return val;
		
	}
	
	
}
