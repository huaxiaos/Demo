package com.huaxiao.demo.spider;

import android.os.Environment;

import com.huaxiao.demo.helper.ThreadHelper;
import com.huaxiao.demo.utils.FileUtils;
import com.huaxiao.demo.utils.JsonUtils;
import com.huaxiao.demo.utils.LogUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description TODO
 * Author sunhuaxiao
 * Date 2018/3/1
 */

public class SpiderLocalFile {

    private static final String TAG = "SpiderLocalFile";

    private static class PYXData {
        public Data data;

        public static class Data {
            public String video_url;
            public String title;
            public String img_url;
        }
    }

    private static class KKData {
        public Data data;

        public static class Data {
            public List<TimelineData> timeline;
        }

        public static class TimelineData {
            public ThemeData theme;
        }

        public static class ThemeData {
            public String name;
            public String cover_url;
            public List<FragmentData> fragment;
        }

        public static class FragmentData {
            public String video;
        }
    }

    public static class TargetData {
        public String film_url;
        public String title;
        public String channel_name;
        public String img_url;
    }

    public static void start() {
        ThreadHelper.getInstance().getGlobalThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                String path = Environment.getExternalStorageDirectory().getPath() + File.separator + "huaxiao";
                File file = new File(path);
                File[] files = file.listFiles();

//                List<PYXData> datas = new ArrayList<>();
//                for (File f : files) {
//                    LogUtils.i(TAG, "f name " + f.getName());
//                    String json = FileUtils.readSDFile(f);
//                    PYXData pyxData = JsonUtils.parseObject(json, PYXData.class);
//                    LogUtils.i(TAG, "film url " + pyxData.data.film_url);
//                    datas.add(pyxData);
//                }

                // kaka
                List<TargetData> datas = new ArrayList<>();
                for (File f : files) {
                    LogUtils.i(TAG, "f name " + f.getName());
                    String fileName = f.getName();
                    String channelName = "";
                    if (fileName.contains("jbp")) {
                        channelName = "剧本配";
                    } else if (fileName.contains("dm")) {
                        channelName = "动漫";
                    } else if (fileName.contains("gf")) {
                        channelName = "古风";
                    } else if (fileName.contains("hzq")) {
                        channelName = "合作区";
                    } else if (fileName.contains("mf")) {
                        channelName = "模仿";
                    }

                    String json = FileUtils.readSDFile(f);
                    PYXData pyxData = JsonUtils.parseObject(json, PYXData.class);

                    TargetData targetData = new TargetData();
                    targetData.title = pyxData.data.title;
                    targetData.img_url = pyxData.data.img_url;
                    targetData.film_url = pyxData.data.video_url;
                    targetData.channel_name = channelName;
                    datas.add(targetData);
                }

                String target = JsonUtils.parseObject(datas);
                LogUtils.i(TAG, "target " + target);

                String targetPath = Environment.getExternalStorageDirectory().getPath() + File.separator + "huaxiao" + File.separator + "target";
                File targetFile = new File(targetPath);
                try {
                    targetFile.createNewFile();
                    FileUtils.writeSDFile(targetFile, target);
                    LogUtils.i(TAG, "finish");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
