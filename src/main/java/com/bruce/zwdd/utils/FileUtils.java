package com.bruce.zwdd.utils;

import com.alibaba.fastjson.JSONObject;
import com.bruce.zwdd.enums.TokenTypeEnum;
import com.bruce.zwdd.model.ZwddToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class FileUtils {


    private static final String FILEPATH = "TOKEN";
    private static final String ACCESS_TOKEN_FILE_NAME = "access_token";
    private static final String JSAPI_TOKEN_FILE_NAME = "jsapi_token";


    /**
     * ZwddToken 写入文件
     *
     * @param accessToken ZwddToken
     * @param tokenType   TokenTypeEnum
     */
    public synchronized static void write2File(ZwddToken accessToken, TokenTypeEnum tokenType) {
        String fileName = getFileName(tokenType);
        if (StringUtils.isBlank(fileName)) {
            return;
        }
        BufferedWriter writer = null;
        File filePath = new File(FILEPATH);
        if (!filePath.exists() && !filePath.isDirectory()) {
            filePath.mkdirs();
        }
        File file = new File(FILEPATH + File.separator + fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                log.error("create file exception:{}", e.getMessage());
                return;
            }
        }
        List<ZwddToken> zwddTokenList = read(tokenType);
        if (CollectionUtils.isEmpty(zwddTokenList)) {
            zwddTokenList = new ArrayList<>();
        }
        zwddTokenList.add(accessToken);
        try {
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(JSONObject.toJSONString(zwddTokenList));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 读取
     *
     * @param tokenType TokenTypeEnum
     * @return token
     */
    public static List<ZwddToken> read(TokenTypeEnum tokenType) {
        String fileName = getFileName(tokenType);
        if (StringUtils.isBlank(fileName)) {
            return null;
        }
        File file = new File(FILEPATH + File.separator + fileName);
        if (!file.exists()) {
            return null;
        }
        BufferedReader reader;
        StringBuilder sb = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                sb.append(tempString);
            }
            reader.close();
        } catch (IOException e) {
            return null;
        }
        return JSONObject.parseArray(sb.toString(), ZwddToken.class);
    }

    /**
     * 通过appKey获取对应的 accessToken
     *
     * @param tokenType TokenTypeEnum
     * @param appKey    appKey
     * @return 相应的 value
     */
    public static ZwddToken getValue(TokenTypeEnum tokenType, String appKey) {
        List<ZwddToken> list = read(tokenType);
        if (CollectionUtils.isNotEmpty(list)) {
            list = list.stream().filter((zwddToken) -> appKey.equals(zwddToken.getAppKey())).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(list)) {
                return list.get(0);
            }
        }
        return null;
    }

    private static String getFileName(TokenTypeEnum tokenType) {
        switch (tokenType) {
            case JSAPI_TOKEN:
                return JSAPI_TOKEN_FILE_NAME;
            case ACCESS_TOKEN:
                return ACCESS_TOKEN_FILE_NAME;
            default:
                return null;
        }
    }


}
