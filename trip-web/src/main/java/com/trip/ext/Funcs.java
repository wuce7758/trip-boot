package com.trip.ext;

import com.trip.utils.DateUtil;
import com.trip.utils.StringUtil;
import jetbrick.template.JetAnnotations;

@JetAnnotations.Functions
public class Funcs {

    /**
     * 格式化日期
     *
     * @param unixTime
     * @return
     */
    public static String fmtdate(Long unixTime) {
        if (null != unixTime) {
            return DateUtil.formatDateByUnixTime(unixTime, "yyyy-MM-dd");
        }
        return "";
    }

    /**
     * 格式化日期
     *
     * @param unixTime
     * @param patten
     * @return
     */
    public static String fmtdate(Long unixTime, String patten) {
        if (null != unixTime && StringUtil.isNotBlank(patten)) {
            return DateUtil.formatDateByUnixTime(unixTime, patten);
        }
        return "";
    }

    public static String today(String patten) {
        return fmtdate((long) DateUtil.getCurrentUnixTime(), patten);
    }

    /**
     * 截取字符串个数
     *
     * @param str
     * @param count
     * @return
     */
    public static String str_count(String str, int count) {
        if (StringUtil.isNotBlank(str) && count > 0) {
            if (str.length() <= count) {
                return str;
            }
            return str.substring(0, count);
        }
        return "";
    }

    public static String timespan(Integer ctime) {
        return timespan(ctime.longValue());
    }


    /**
     * 显示时间，如果与当前时间差别小于一天，则自动用**秒(分，小时)前，如果大于一天则用format规定的格式显示
     *
     * @param ctime 时间
     * @return
     */
    public static String timespan(Long ctime) {
        String r = "";
        if (ctime == null)
            return r;

        long nowtimelong = System.currentTimeMillis();
        long ctimelong = DateUtil.getDateByUnixTime(ctime).getTime();
        long result = Math.abs(nowtimelong - ctimelong);

        // 20秒内
        if (result < 20000) {
            r = "刚刚";
        } else if (result >= 20000 && result < 60000) {
            // 一分钟内
            long seconds = result / 1000;
            r = seconds + "秒钟前";
        } else if (result >= 60000 && result < 3600000) {
            // 一小时内
            long seconds = result / 60000;
            r = seconds + "分钟前";
        } else if (result >= 3600000 && result < 86400000) {
            // 一天内
            long seconds = result / 3600000;
            r = seconds + "小时前";
        } else {
            long days = result / 3600000 / 24;
            r = days + "天前";
        }
        return r;
    }

}
