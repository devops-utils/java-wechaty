package io.github.wechaty.example;

import io.github.wechaty.Wechaty;
import io.github.wechaty.plugins.WechatyPlugins;

public class MainWithPlugin {

    public static void main(String[] args) {

        Wechaty bot = Wechaty.instance("a5134f66-d585-4fd1-8974-26e1d3302c55")
            .use(WechatyPlugins.ScanPlugin(), WechatyPlugins.DingDongPlugin(null))
            .start(true);

    }

}
