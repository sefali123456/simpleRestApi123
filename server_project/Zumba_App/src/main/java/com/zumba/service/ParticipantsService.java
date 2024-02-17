package com.zumba.service;

import com.zumba.bean.batch;
//import com.zumba.bean.batch;
import com.zumba.bean.participants;
//import com.zumba.dao.BatchDao;
import com.zumba.dao.ParticipantsDao;


public class ParticipantsService {
	
	ParticipantsDao pd = new ParticipantsDao();
	public String storeParticipant(participants participant) {
		if(pd.storeParticipantsDetails(participant)>0) {
			return "Participants details stored successfully";
		}else {
			return "Participants details didn't store";
		}
	}
	public String updateParticipant(participants participant) {
		if(pd.updateParticipantsDetails(participant)>0) {
			return "Participant info updated successfully";
		}else {
			return "Participant info didn't update";
		}
	}
	
	public String deleteParticipant(int id) {
		if(pd.deleteParticipantsDetails(id)>0) {
			return "Participant deleted successfully";
		}else {
			return "Participant cannot be deleted";
		}
	}
}
