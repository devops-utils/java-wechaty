package io.github.wechaty.example;

import io.github.wechaty.Wechaty;
import io.github.wechaty.WechatyOptions;
import io.github.wechaty.plugins.WechatyPlugins;
import io.github.wechaty.schemas.PuppetOptions;

public class MainWithPlugin {

    public static void main(String[] args) {

        PuppetOptions puppetOptions = new PuppetOptions();
        puppetOptions.setEndPoint("localhost:8788");
        puppetOptions.setToken("a5134f66-d585-4fd1-8974-26e1d3302c55");
        WechatyOptions wechatyOptions = new WechatyOptions();
        wechatyOptions.setPuppetOptions(puppetOptions);

        Wechaty bot = Wechaty.instance(wechatyOptions)
            .use(WechatyPlugins.ScanPlugin(), WechatyPlugins.DingDongPlugin(null))
            .start(true);

    }

}
