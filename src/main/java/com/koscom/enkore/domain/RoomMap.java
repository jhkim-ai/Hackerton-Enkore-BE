package com.koscom.enkore.domain;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class RoomMap {

    private static RoomMap roomMap = new RoomMap();
    private Map<String, Room> sessionIdToRoomMap = new HashMap<>();
    public RoomMap() {
        sessionIdToRoomMap.put("1", new Room("1"));
        sessionIdToRoomMap.put("2", new Room("2"));
        sessionIdToRoomMap.put("3", new Room("3"));
        sessionIdToRoomMap.put("4", new Room("4"));
    }

    public static RoomMap getInstance(){
        return roomMap;
    }
}
