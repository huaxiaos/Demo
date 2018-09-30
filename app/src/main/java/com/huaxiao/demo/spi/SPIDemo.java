package com.huaxiao.demo.spi;

import com.huaxiao.demo.utils.LogUtils;
import com.huaxiao.smartspi.IDisplay;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Created by sunhuaxiao on 2018/9/30.
 */
public class SPIDemo {

    public static void run() {
        ServiceLoader<IDisplay> loader = ServiceLoader.load(IDisplay.class);
        Iterator iterator = loader.iterator();
        while (iterator.hasNext()) {
            String value = ((IDisplay) iterator.next()).display();
            LogUtils.i("SPI", value);
        }
    }

}
