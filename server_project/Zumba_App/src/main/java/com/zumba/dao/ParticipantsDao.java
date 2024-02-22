package com.zumba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.zumba.bean.participants;
import com.zumba.resource.DbResource;

public class ParticipantsDao {
	public int storeParticipantsDetails(participants participant) {
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into participants(sname,age,phonenumber,batchid) values(?,?,?,?)");
			pstmt.setString(1, participant.getPname());
			pstmt.setInt(2, participant.getAge());
			pstmt.setString(3, participant.getPhonenumber());
			pstmt.setInt(4, participant.getBatchid());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("Participants insert error "+e.toString());
			return 0;

		}
	}

	public int updateParticipantsDetails(participants participant) {
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement("update participants set age = ? where participantid = ?");
			pstmt.setInt(2, participant.getParticipantid());
			pstmt.setInt(1, participant.getAge());
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println("Participants update error "+e.toString());
			return 0;

		}
	}


public int deleteParticipantsDetails(int participantid) {
	try {
		Connection con = DbResource.getDbConnection();
		PreparedStatement pstmt = con.prepareStatement("delete from participants where participantid = ?");
		pstmt.setInt(1, participantid);
		return pstmt.executeUpdate();
	} catch (Exception e) {
		System.err.println("Participants delete error "+e.toString());
		return 0;

	}
}

}
