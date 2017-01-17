/*
 * Copyright (c) 2014-2015 XXX, Inc. All Rights Reserved.
 */

package com.mzjf.common.utils;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import com.mzjf.common.service.entity.UserEntity;

public class BatchProvider {
    public String insertAll(@SuppressWarnings("rawtypes") Map map) {
        @SuppressWarnings("unchecked")
        List<UserEntity> users = (List<UserEntity>) map.get("list");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO user ");
        sb.append("(name) ");
        sb.append("VALUES ");
        MessageFormat mf = new MessageFormat("(#'{'list[{0}].name})");
        for (int i = 0; i < users.size(); i++) {
            sb.append(mf.format(new Object[] { i }));
            if (i < users.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
