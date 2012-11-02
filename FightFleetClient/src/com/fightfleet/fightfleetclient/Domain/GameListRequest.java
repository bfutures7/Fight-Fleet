package com.fightfleet.fightfleetclient.Domain;

import java.util.UUID;

public class GameListRequest {
	Integer m_UserID;
	UUID m_UUID;
	
	public GameListRequest(Integer userID, UUID uuid){
		m_UserID = userID;
		m_UUID = uuid;
	}
	
	public UUID GetUUID(){
		return m_UUID;
	}
	
	public Integer GetUserID(){
		return m_UserID;
	}
}