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
	public String updateBatch(batch batch) {
		if(db.updateBatchDetails(batch)>0) {
			return "batch info updated successfully";
		}else {
			return "batch info didn't update";
		}
	}
	
	public String deleteBatch(int id) {
		if(db.deleteBatchDetails(id)>0) {
			return "batch deleted successfully";
		}else {
			return "batch cannot be deleted";
		}
	}
	
	public List<batch> findAllBatch(){
		return db.findAllBatchInfo();
	}
	public List<Object[]> findBatchAndStudentInfo() {
		return db.findBatchAndStudentInfo();
	}
}
