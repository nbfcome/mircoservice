/*
 * Copyright (c) 2017-2018 , Inc. All Rights Reserved.
 */
package com.mzjf.common.utils;

import java.util.Arrays;
import java.util.List;

import com.mzjf.common.service.entity.CommentPraise;
import com.mzjf.common.service.entity.Content;


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
//        generate(Object.class);
        List<Class<?>> list = Arrays.asList(CommentPraise.class, Content.class);
        for (Class<?> clazz : list) {
            GenerateMapperUtils.generateMapper(clazz);
            System.out.println("\n\n");
        }
    }
}
