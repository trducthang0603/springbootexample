package com.example.javaprojectbuild.config;

import okhttp3.*;

import java.io.IOException;

public class LineNotificationSender {

    private static final String LINE_API_URL = "https://notify-api.line.me/api/notify";
    private static final String CHANNEL_ACCESS_TOKEN = "WjGmA8wTZLcuFoZ01UBMOBiGm8pLyG4sIJXYg19yDpF";

    private static final String STICKER_PACKAGE_ID = "446";
    private static final String STICKER_ID = "1988";

    public static void main(String[] args) {
        String message = "Hello, this is a Line notification with a sticker!";
        sendLineNotification(message, STICKER_PACKAGE_ID, STICKER_ID);
    }
    private static void sendLineNotification(String message, String stickerPackageId, String stickerId) {
        OkHttpClient client = new OkHttpClient();


        MultipartBody.Builder requestBodyBuilder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("message", message)
                .addFormDataPart("stickerPackageId", stickerPackageId)
                .addFormDataPart("stickerId", stickerId);

        Request request = new Request.Builder()
                .url(LINE_API_URL)
                .post(requestBodyBuilder.build())
                .addHeader("Authorization", "Bearer " + CHANNEL_ACCESS_TOKEN)
                .build();



        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }
}
