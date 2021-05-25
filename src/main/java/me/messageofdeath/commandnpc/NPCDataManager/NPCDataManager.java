package me.messageofdeath.commandnpc.NPCDataManager;

import java.util.ArrayList;
import java.util.List;

public class NPCDataManager {

	private final ArrayList<NPCData> data;
	
	public NPCDataManager() {
		this.data = new ArrayList<>();
	}
	
	public void addNPCData(NPCData data) {
		if(!this.hasNPCData(data.getId())) {
			this.data.add(data);
		}
	}
	
	public void removeNPCData(int id) {
		if(this.hasNPCData(id)) {
			this.data.remove(this.getNPCData(id));
		}
	}
	
	public boolean hasNPCData(int id) {
		return this.getNPCData(id) != null;
	}
	
	public NPCData getNPCData(int id) {
		for(NPCData data : this.data) {
			if(data.getId() == id) {
				return data;
			}
		}
		return null;
	}
	
	public List<NPCData> getNPCDatas() {
		return new ArrayList<>(this.data);
	}
}
