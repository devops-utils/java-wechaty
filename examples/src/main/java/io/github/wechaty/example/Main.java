package io.github.wechaty.example;


import io.github.wechaty.Wechaty;
import io.github.wechaty.WechatyOptions;
import io.github.wechaty.schemas.PuppetOptions;
import io.github.wechaty.user.Room;
import io.github.wechaty.utils.QrcodeUtils;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.concurrent.ExecutionException;


public class Main {

    public static void main(String[] args){

        System.out.println("start");

        PuppetOptions puppetOptions = new PuppetOptions();
        puppetOptions.setEndPoint("localhost:8788");
        puppetOptions.setToken("a5134f66-d585-4fd1-8974-26e1d3302c55");
        WechatyOptions wechatyOptions = new WechatyOptions();
        wechatyOptions.setPuppetOptions(puppetOptions);
        Wechaty bot = Wechaty.instance(wechatyOptions)
            .onScan((qrcode, statusScanStatus, data) -> System.out.println(QrcodeUtils.getQr(qrcode)))
            .onLogin(user -> System.out.println(user))
            .onMessage(message -> {
                Room room = message.room();
                String text = message.text();
                if (StringUtils.equals(text, "#ding")) {
                    if (room != null) {
                        room.say("dong");
                    }
                }
            }).start(false);

//    }

//        Room room = bot.room();
//
//        RoomQueryFilter roomQueryFilter = new RoomQueryFilter();
//
//        roomQueryFilter.setTopic("ChatOps - Donut");
//
//        Future<List<Room>> all = room.findAll(roomQueryFilter);
//
//        List<Room> rooms = all.get();
//
//        Room room1 = rooms.get(0);
//
//        FileBox fileBox = FileBox.fromFile("dong.jpg", "dong.jpg");
//
//        room1.say(fileBox).get();

    }


}
