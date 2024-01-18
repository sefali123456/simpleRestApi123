package com.zumba.service;

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

}
