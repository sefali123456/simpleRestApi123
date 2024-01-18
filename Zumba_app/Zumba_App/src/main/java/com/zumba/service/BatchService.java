package com.zumba.service;

import java.util.List;

import com.zumba.bean.batch;
import com.zumba.dao.BatchDao;

public class BatchService {

	BatchDao db = new BatchDao();
	public String storeBatch(batch batch) {
		if(db.storeBatchDetails(batch)>0) {
			return "Batch details stored successfully";
		}else {
			return "Batch details didn't store";
		}
	}
	
	public List<batch> findAllBatch(){
		return db.findAllBatchInfo();
	}
}
