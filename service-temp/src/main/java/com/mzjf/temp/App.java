package com.test.nbf;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.Notification;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        JPushClient jpushClient = new JPushClient("31e87a5b155179930132c164", "ae303a6757cce13e8a5447c6", null, ClientConfig.getInstance());

        // For push, all you need do is to build PushPayload object.
        PushPayload payload = buildPushObject_ios_audienceMore_messageWithExtras();

        try {
            PushResult result = jpushClient.sendPush(payload);
            System.out.println("msg:"+result);
        } catch (APIConnectionException e) {
            // Connection error, should retry later
            System.out.println("msg:");
        } catch (APIRequestException e) {
            System.out.println("msg:");
        }
    }
       
    public static PushPayload buildPushObject_ios_audienceMore_messageWithExtras() {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setNotification(Notification.alert("nbf notification"))
                .setAudience(Audience.newBuilder()
                        .addAudienceTarget(AudienceTarget.alias("123"))
                        .build())
                .setMessage(Message.newBuilder()
                        .setTitle("123")
                        .setMsgContent("nbf msg")
                        .addExtra("from", "JPush")
                        .build())
                .build();
    }
}
