package com.technawabs.app.assignement.constants;

import java.io.Serializable;

public enum AppAnalyticEvents implements Serializable{

    USER_FCM_KEY("fcm_key"),
    FCM_RECEIVER_KEY("fcm_receiver"),
    FCM_SENDER_KEY("fcm_sender"),
    BUTTON_CLICKED_KEY("show_data");

     private String event;

     AppAnalyticEvents(String event){
         this.event = event;
     }

     public String getEvent(){
         return event;
     }

}
