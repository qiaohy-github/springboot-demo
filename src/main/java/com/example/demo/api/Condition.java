package com.example.demo.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.lang.Nullable;

public class Condition {
    public Condition() {
    }

    public static <T> IPage<T> getPage(Query query) {
        Page<T> page = new Page((long) toInt(query.getCurrent(), 1), (long) toInt(query.getSize(), 10));
        String[] ascArr = toStrArray(",", query.getAscs());
        String[] descArr = ascArr;
        int var4 = ascArr.length;

        int var5;
        for (var5 = 0; var5 < var4; ++var5) {
            String asc = descArr[var5];
            page.addOrder(new OrderItem[]{OrderItem.asc(cleanIdentifier(asc))});
        }

        descArr = toStrArray(",", query.getDescs());
        String[] var8 = descArr;
        var5 = descArr.length;

        for (int var9 = 0; var9 < var5; ++var9) {
            String desc = var8[var9];
            page.addOrder(new OrderItem[]{OrderItem.desc(cleanIdentifier(desc))});
        }

        return page;
    }

    public static <T> QueryWrapper<T> getQueryWrapper(T entity) {
        return new QueryWrapper(entity);
    }

    public static int toInt(Integer str, final int defaultValue) {
        if (str == null) {
            return defaultValue;
        } else {
            try {
                return Integer.valueOf(str);
            } catch (NumberFormatException var3) {
                return defaultValue;
            }
        }
    }

    public static String[] toStrArray(String split, String str) {
        return StringUtils.isBlank(str) ? new String[0] : str.split(split);
    }

    public static String cleanIdentifier(@Nullable String param) {
        if (param == null) {
            return null;
        } else {
            StringBuilder paramBuilder = new StringBuilder();

            for(int i = 0; i < param.length(); ++i) {
                char c = param.charAt(i);
                if (Character.isJavaIdentifierPart(c)) {
                    paramBuilder.append(c);
                }
            }

            return paramBuilder.toString();
        }
    }

}