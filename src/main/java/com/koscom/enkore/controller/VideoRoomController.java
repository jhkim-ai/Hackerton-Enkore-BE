package com.koscom.enkore.controller;

import com.koscom.enkore.dto.TestSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/socket")
@RequiredArgsConstructor
//@CrossOrigin(origins = {"http://localhost:8181"}, allowCredentials = "true")
public class VideoRoomController {

    // 테스트용 세션 리스트.
    private final ArrayList<TestSession> sessionIdList;
//    private final SimpMessagingTemplate template;

    // check
    // 실시간으로 들어온 세션 감지하여 전체 세션 리스트 반환
    @MessageMapping("/video/joined-room-info")
    @SendTo("/sub/video/joined-room-info")
    private ArrayList<TestSession> joinRoom(@Header("simpSessionId") String sessionId, JSONObject ob) {

        // 현재 들어온 세션 저장.
        sessionIdList.add(new TestSession((String) ob.get("from"), sessionId));
        System.out.println(sessionIdList);
        return sessionIdList;
    }

//    @GetMapping("/test")
//    public String test(){
//
//        log.info("qweqwe");
//        return "qwe";
//    }

    // check
    // caller의 정보를 다른 callee들에게 쏴준다.
    @MessageMapping("/video/caller-info")
    @SendTo("/sub/video/caller-info")
    private Map<String, Object> caller(JSONObject ob) {

        log.info(ob.toJSONString());

        // caller의 정보를 소켓으로 쏴준다.
        Map<String, Object> data = new HashMap<>();
        data.put("toCall", ob.get("toCall"));
        data.put("from", ob.get("from"));
        data.put("signal", ob.get("signal"));
        System.out.println(data);
        return data;
    }

    // check
    // caller와 callee의 signaling을 위해 callee 정보를 쏴준다.
    @MessageMapping("/video/callee-info")
    @SendTo("/sub/video/callee-info")
    private Map<String, Object> answerCall(JSONObject ob) {

        log.info(ob.toJSONString());

        // accepter의 정보를 소켓으로 쏴준다.
        Map<String, Object> data = new HashMap<>();
        data.put("signal", ob.get("signal"));
        data.put("from", ob.get("from"));
        data.put("to", ob.get("to"));
        System.out.println(data);
        return data;
    }

//    @MessageMapping("/video/audio-sentiment")
//    @SendTo("/sub/video/audio-sentiment")
//    public Map<String, Object> getAudioSentiment(@RequestBody Map<String, String> map) throws ParseException {
//
//        HttpHeaders headers = new HttpHeaders();
//        RestTemplate restTemplate = new RestTemplate();
//        String resultMessage = restTemplate.postForObject("/audio-sentiment", new HttpEntity<>(map, headers), String.class);
//
//        JSONParser parser = new JSONParser();
//        Object obj = parser.parse(resultMessage);
//        JSONObject jsonObj = (JSONObject) obj;
//
//        // {from : senderId, }
//        Map<String, Object> returnData = new HashMap<>();
//        returnData.put("from", map.get("from"));
//        returnData.put("resultOfAudioSentiment", jsonObj);
//        return returnData;
//    }

//    @MessageMapping("/video/chat")
//    @SendTo("/sub/video/chat")
//    public Map<String, String> listenAndSendChat(@RequestBody Map<String, String> map) throws ParseException {
//
//        return map;
//    }

//    @EventListener
//    private void handleSessionConnected(SessionConnectEvent event) {
//
//    }

//    @EventListener
//    private void handleSessionDisconnect(SessionDisconnectEvent event) {
//
//        String removedID = "";
//
//        // close된 세션의 id 저장.
//        for (TestSession session : sessionIdList) {
//            if (session.getSessionId().equals(event.getSessionId())) {
//                removedID = session.getId();
//                sessionIdList.remove(session);
//                break;
//            }
//        }
//
//        //종료 세션 id 전달.
//        template.convertAndSend("/sub/video/close-session", removedID);
//
//    }

}
