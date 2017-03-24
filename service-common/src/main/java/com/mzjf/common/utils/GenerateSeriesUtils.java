/*
 * Copyright (c) 2017-2018 , Inc. All Rights Reserved.
 */
package com.mzjf.common.utils;

import java.util.Arrays;
import java.util.List;

import com.mzjf.common.service.entity.content.CommentPraise;
import com.mzjf.common.service.entity.content.Content;
import com.mzjf.common.service.models.user.UserModel;


/**
 * @author niebiaofei
 *
 */
public class GenerateSeriesUtils {

    public static <T> void generate(Class<T> clazz) {
        GenerateFuncUtils.generateEquals(clazz);
        GenerateFuncUtils.generateHashCode(clazz);
        GenerateFuncUtils.generateToString(clazz);
        System.out.println("\n\n\n");
        GenerateMapperUtils.generateMapper(clazz);
    }

    public static void main(String args[]) {
        generate(UserModel.class);
//        List<Class<?>> list = Arrays.asList(CommentPraise.class, Content.class);
//        for (Class<?> clazz : list) {
//            GenerateMapperUtils.generateMapper(clazz);
//            System.out.println("\n\n");
//        }
    }
}
