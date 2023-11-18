package modules.util;

import com.google.gson.Gson;
import modules.entity.JsonObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 谷歌翻译工具类
 */
public class GoogleTranslateUtil {

    public static void main(String[] args) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("path")) {
            JsonObject json = gson.fromJson(reader, JsonObject.class);
            System.out.println("键：" + json.getKey()+ "，值：" + json.getValue());

            // 修改属性值

            // 将修改后的对象重新写入JSON文件
            try (FileWriter writer = new FileWriter("person.json")) {
                gson.toJson(json, writer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
