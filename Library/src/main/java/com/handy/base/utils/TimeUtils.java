package com.handy.base.utils;


import com.handy.base.utils.constant.TimeConstants;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * <pre>
 *  author: Handy
 *  blog  : https://github.com/liujie045
 *  time  : 2017-4-18 10:14:23
 *  desc  : 时间相关工具类
 * </pre>
 */
public final class TimeUtils {

    /**
     * <p>在工具类中经常使用到工具类的格式化描述，这个主要是一个日期的操作类，所以日志格式主要使用 SimpleDateFormat的定义格式.</p>
     * 格式的意义如下： 日期和时间模式 <br>
     * <p>日期和时间格式由日期和时间模式字符串指定。在日期和时间模式字符串中，未加引号的字母 'A' 到 'Z' 和 'a' 到 'z'
     * 被解释为模式字母，用来表示日期或时间字符串元素。文本可以使用单引号 (') 引起来，以免进行解释。"''"
     * 表示单引号。所有其他字符均不解释；只是在格式化时将它们简单复制到输出字符串，或者在分析时与输入字符串进行匹配。
     * </p>
     * 定义了以下模式字母（所有其他字符 'A' 到 'Z' 和 'a' 到 'z' 都被保留）： <br>
     * <table border="1" cellspacing="1" cellpadding="1" summary="Chart shows format letters, date/time component,
     * presentation, and examples.">
     * <tr>
     * <th align="left">字母</th>
     * <th align="left">日期或时间元素</th>
     * <th align="left">表示</th>
     * <th align="left">示例</th>
     * </tr>
     * <tr>
     * <td><code>G</code></td>
     * <td>Era 标志符</td>
     * <td>Text</td>
     * <td><code>AD</code></td>
     * </tr>
     * <tr>
     * <td><code>y</code> </td>
     * <td>年 </td>
     * <td>Year </td>
     * <td><code>1996</code>; <code>96</code> </td>
     * </tr>
     * <tr>
     * <td><code>M</code> </td>
     * <td>年中的月份 </td>
     * <td>Month </td>
     * <td><code>July</code>; <code>Jul</code>; <code>07</code> </td>
     * </tr>
     * <tr>
     * <td><code>w</code> </td>
     * <td>年中的周数 </td>
     * <td>Number </td>
     * <td><code>27</code> </td>
     * </tr>
     * <tr>
     * <td><code>W</code> </td>
     * <td>月份中的周数 </td>
     * <td>Number </td>
     * <td><code>2</code> </td>
     * </tr>
     * <tr>
     * <td><code>D</code> </td>
     * <td>年中的天数 </td>
     * <td>Number </td>
     * <td><code>189</code> </td>
     * </tr>
     * <tr>
     * <td><code>d</code> </td>
     * <td>月份中的天数 </td>
     * <td>Number </td>
     * <td><code>10</code> </td>
     * </tr>
     * <tr>
     * <td><code>F</code> </td>
     * <td>月份中的星期 </td>
     * <td>Number </td>
     * <td><code>2</code> </td>
     * </tr>
     * <tr>
     * <td><code>E</code> </td>
     * <td>星期中的天数 </td>
     * <td>Text </td>
     * <td><code>Tuesday</code>; <code>Tue</code> </td>
     * </tr>
     * <tr>
     * <td><code>a</code> </td>
     * <td>Am/pm 标记 </td>
     * <td>Text </td>
     * <td><code>PM</code> </td>
     * </tr>
     * <tr>
     * <td><code>H</code> </td>
     * <td>一天中的小时数（0-23） </td>
     * <td>Number </td>
     * <td><code>0</code> </td>
     * </tr>
     * <tr>
     * <td><code>k</code> </td>
     * <td>一天中的小时数（1-24） </td>
     * <td>Number </td>
     * <td><code>24</code> </td>
     * </tr>
     * <tr>
     * <td><code>K</code> </td>
     * <td>am/pm 中的小时数（0-11） </td>
     * <td>Number </td>
     * <td><code>0</code> </td>
     * </tr>
     * <tr>
     * <td><code>h</code> </td>
     * <td>am/pm 中的小时数（1-12） </td>
     * <td>Number </td>
     * <td><code>12</code> </td>
     * </tr>
     * <tr>
     * <td><code>m</code> </td>
     * <td>小时中的分钟数 </td>
     * <td>Number </td>
     * <td><code>30</code> </td>
     * </tr>
     * <tr>
     * <td><code>s</code> </td>
     * <td>分钟中的秒数 </td>
     * <td>Number </td>
     * <td><code>55</code> </td>
     * </tr>
     * <tr>
     * <td><code>S</code> </td>
     * <td>毫秒数 </td>
     * <td>Number </td>
     * <td><code>978</code> </td>
     * </tr>
     * <tr>
     * <td><code>z</code> </td>
     * <td>时区 </td>
     * <td>General time zone </td>
     * <td><code>Pacific Standard Time</code>; <code>PST</code>; <code>GMT-08:00</code> </td>
     * </tr>
     * <tr>
     * <td><code>Z</code> </td>
     * <td>时区 </td>
     * <td>RFC 822 time zone </td>
     * <td><code>-0800</code> </td>
     * </tr>
     * </table>
     * <pre>
     *                                             HH:mm    15:44
     *                                            h:mm a    3:44 下午
     *                                           HH:mm z    15:44 CST
     *                                           HH:mm Z    15:44 +0800
     *                                        HH:mm zzzz    15:44 中国标准时间
     *                                          HH:mm:ss    15:44:40
     *                                        yyyy-MM-dd    2016-08-12
     *                                  yyyy-MM-dd HH:mm    2016-08-12 15:44
     *                               yyyy-MM-dd HH:mm:ss    2016-08-12 15:44:40
     *                          yyyy-MM-dd HH:mm:ss zzzz    2016-08-12 15:44:40 中国标准时间
     *                     EEEE yyyy-MM-dd HH:mm:ss zzzz    星期五 2016-08-12 15:44:40 中国标准时间
     *                          yyyy-MM-dd HH:mm:ss.SSSZ    2016-08-12 15:44:40.461+0800
     *                        yyyy-MM-dd'T'HH:mm:ss.SSSZ    2016-08-12T15:44:40.461+0800
     *                      yyyy.MM.dd G 'at' HH:mm:ss z    2016.08.12 公元 at 15:44:40 CST
     *                                            K:mm a    3:44 下午
     *                                  EEE, MMM d, ''yy    星期五, 八月 12, '16
     *                             hh 'o''clock' a, zzzz    03 o'clock 下午, 中国标准时间
     *                      yyyyy.MMMMM.dd GGG hh:mm aaa    02016.八月.12 公元 03:44 下午
     *                        EEE, d MMM yyyy HH:mm:ss Z    星期五, 12 八月 2016 15:44:40 +0800
     *                                     yyMMddHHmmssZ    160812154440+0800
     *                        yyyy-MM-dd'T'HH:mm:ss.SSSZ    2016-08-12T15:44:40.461+0800
     * EEEE 'DATE('yyyy-MM-dd')' 'TIME('HH:mm:ss')' zzzz    星期五 DATE(2016-08-12) TIME(15:44:40) 中国标准时间
     * </pre>
     * 注意：SimpleDateFormat不是线程安全的，线程安全需用{@code ThreadLocal<SimpleDateFormat>}
     */

    private static final DateFormat DEFAULT_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    private static final String[] CHINESE_ZODIAC = {"猴", "鸡", "狗", "猪", "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊"};
    private static final String[] ZODIAC = {"水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "魔羯座"};
    private static final int[] ZODIAC_FLAGS = {20, 19, 21, 21, 21, 22, 23, 23, 23, 24, 23, 22};

    private TimeUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 将时间戳转为时间字符串
     * <p>格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param millis 毫秒时间戳
     * @return 时间字符串
     */
    public static String millis2String(long millis) {
        return millis2String(millis, DEFAULT_FORMAT);
    }

    /**
     * 将时间戳转为时间字符串
     * <p>格式为format</p>
     *
     * @param millis 毫秒时间戳
     * @param format 时间格式
     * @return 时间字符串
     */
    public static String millis2String(long millis, DateFormat format) {
        return format.format(new Date(millis));
    }

    /**
     * 将时间字符串转为时间戳
     * <p>time格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time 时间字符串
     * @return 毫秒时间戳
     */
    public static long string2Millis(String time) {
        return string2Millis(time, DEFAULT_FORMAT);
    }

    /**
     * 将时间字符串转为时间戳
     * <p>time格式为format</p>
     *
     * @param time   时间字符串
     * @param format 时间格式
     * @return 毫秒时间戳
     */
    public static long string2Millis(String time, DateFormat format) {
        try {
            return format.parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 将时间字符串转为Date类型
     * <p>time格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time 时间字符串
     * @return Date类型
     */
    public static Date string2Date(String time) {
        return string2Date(time, DEFAULT_FORMAT);
    }

    /**
     * 将时间字符串转为Date类型
     * <p>time格式为format</p>
     *
     * @param time   时间字符串
     * @param format 时间格式
     * @return Date类型
     */
    public static Date string2Date(String time, DateFormat format) {
        try {
            return format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将Date类型转为时间字符串
     * <p>格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param date Date类型时间
     * @return 时间字符串
     */
    public static String date2String(Date date) {
        return date2String(date, DEFAULT_FORMAT);
    }

    /**
     * 将Date类型转为时间字符串
     * <p>格式为format</p>
     *
     * @param date   Date类型时间
     * @param format 时间格式
     * @return 时间字符串
     */
    public static String date2String(Date date, DateFormat format) {
        return format.format(date);
    }

    /**
     * 将Date类型转为时间戳
     *
     * @param date Date类型时间
     * @return 毫秒时间戳
     */
    public static long date2Millis(Date date) {
        return date.getTime();
    }

    /**
     * 将时间戳转为Date类型
     *
     * @param millis 毫秒时间戳
     * @return Date类型时间
     */
    public static Date millis2Date(long millis) {
        return new Date(millis);
    }

    /**
     * 获取两个时间差（单位：unit）
     * <p>time0和time1格式都为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time0 时间字符串0
     * @param time1 时间字符串1
     * @param unit  单位类型
     *              <ul>
     *              <li>{@link TimeConstants#MSEC}: 毫秒</li>
     *              <li>{@link TimeConstants#SEC }: 秒</li>
     *              <li>{@link TimeConstants#MIN }: 分</li>
     *              <li>{@link TimeConstants#HOUR}: 小时</li>
     *              <li>{@link TimeConstants#DAY }: 天</li>
     *              </ul>
     * @return unit时间戳
     */
    public static long getTimeSpan(String time0, String time1, @TimeConstants.Unit int unit) {
        return getTimeSpan(time0, time1, DEFAULT_FORMAT, unit);
    }

    /**
     * 获取两个时间差（单位：unit）
     * <p>time0和time1格式都为format</p>
     *
     * @param time0  时间字符串0
     * @param time1  时间字符串1
     * @param format 时间格式
     * @param unit   单位类型
     *               <ul>
     *               <li>{@link TimeConstants#MSEC}: 毫秒</li>
     *               <li>{@link TimeConstants#SEC }: 秒</li>
     *               <li>{@link TimeConstants#MIN }: 分</li>
     *               <li>{@link TimeConstants#HOUR}: 小时</li>
     *               <li>{@link TimeConstants#DAY }: 天</li>
     *               </ul>
     * @return unit时间戳
     */
    public static long getTimeSpan(String time0, String time1, DateFormat format, @TimeConstants.Unit int unit) {
        return millis2TimeSpan(Math.abs(string2Millis(time0, format) - string2Millis(time1, format)), unit);
    }

    /**
     * 获取两个时间差（单位：unit）
     *
     * @param date0 Date类型时间0
     * @param date1 Date类型时间1
     * @param unit  单位类型
     *              <ul>
     *              <li>{@link TimeConstants#MSEC}: 毫秒</li>
     *              <li>{@link TimeConstants#SEC }: 秒</li>
     *              <li>{@link TimeConstants#MIN }: 分</li>
     *              <li>{@link TimeConstants#HOUR}: 小时</li>
     *              <li>{@link TimeConstants#DAY }: 天</li>
     *              </ul>
     * @return unit时间戳
     */
    public static long getTimeSpan(Date date0, Date date1, @TimeConstants.Unit int unit) {
        return millis2TimeSpan(Math.abs(date2Millis(date0) - date2Millis(date1)), unit);
    }

    /**
     * 获取两个时间差（单位：unit）
     *
     * @param millis0 毫秒时间戳0
     * @param millis1 毫秒时间戳1
     * @param unit    单位类型
     *                <ul>
     *                <li>{@link TimeConstants#MSEC}: 毫秒</li>
     *                <li>{@link TimeConstants#SEC }: 秒</li>
     *                <li>{@link TimeConstants#MIN }: 分</li>
     *                <li>{@link TimeConstants#HOUR}: 小时</li>
     *                <li>{@link TimeConstants#DAY }: 天</li>
     *                </ul>
     * @return unit时间戳
     */
    public static long getTimeSpan(long millis0, long millis1, @TimeConstants.Unit int unit) {
        return millis2TimeSpan(Math.abs(millis0 - millis1), unit);
    }

    /**
     * 获取合适型两个时间差
     * <p>time0和time1格式都为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time0     时间字符串0
     * @param time1     时间字符串1
     * @param precision 精度
     *                  <p>precision = 0，返回null</p>
     *                  <p>precision = 1，返回天</p>
     *                  <p>precision = 2，返回天和小时</p>
     *                  <p>precision = 3，返回天、小时和分钟</p>
     *                  <p>precision = 4，返回天、小时、分钟和秒</p>
     *                  <p>precision &gt;= 5，返回天、小时、分钟、秒和毫秒</p>
     * @return 合适型两个时间差
     */
    public static String getFitTimeSpan(String time0, String time1, int precision) {
        return millis2FitTimeSpan(Math.abs(string2Millis(time0, DEFAULT_FORMAT) - string2Millis(time1, DEFAULT_FORMAT)), precision);
    }

    /**
     * 获取合适型两个时间差
     * <p>time0和time1格式都为format</p>
     *
     * @param time0     时间字符串0
     * @param time1     时间字符串1
     * @param format    时间格式
     * @param precision 精度
     *                  <p>precision = 0，返回null</p>
     *                  <p>precision = 1，返回天</p>
     *                  <p>precision = 2，返回天和小时</p>
     *                  <p>precision = 3，返回天、小时和分钟</p>
     *                  <p>precision = 4，返回天、小时、分钟和秒</p>
     *                  <p>precision &gt;= 5，返回天、小时、分钟、秒和毫秒</p>
     * @return 合适型两个时间差
     */
    public static String getFitTimeSpan(String time0, String time1, DateFormat format, int precision) {
        return millis2FitTimeSpan(Math.abs(string2Millis(time0, format) - string2Millis(time1, format)), precision);
    }

    /**
     * 获取合适型两个时间差
     *
     * @param date0     Date类型时间0
     * @param date1     Date类型时间1
     * @param precision 精度
     *                  <p>precision = 0，返回null</p>
     *                  <p>precision = 1，返回天</p>
     *                  <p>precision = 2，返回天和小时</p>
     *                  <p>precision = 3，返回天、小时和分钟</p>
     *                  <p>precision = 4，返回天、小时、分钟和秒</p>
     *                  <p>precision &gt;= 5，返回天、小时、分钟、秒和毫秒</p>
     * @return 合适型两个时间差
     */
    public static String getFitTimeSpan(Date date0, Date date1, int precision) {
        return millis2FitTimeSpan(Math.abs(date2Millis(date0) - date2Millis(date1)), precision);
    }

    /**
     * 获取合适型两个时间差
     *
     * @param millis0   毫秒时间戳1
     * @param millis1   毫秒时间戳2
     * @param precision 精度
     *                  <p>precision = 0，返回null</p>
     *                  <p>precision = 1，返回天</p>
     *                  <p>precision = 2，返回天和小时</p>
     *                  <p>precision = 3，返回天、小时和分钟</p>
     *                  <p>precision = 4，返回天、小时、分钟和秒</p>
     *                  <p>precision &gt;= 5，返回天、小时、分钟、秒和毫秒</p>
     * @return 合适型两个时间差
     */
    public static String getFitTimeSpan(long millis0, long millis1, int precision) {
        return millis2FitTimeSpan(Math.abs(millis0 - millis1), precision);
    }

    /**
     * 获取当前毫秒时间戳
     *
     * @return 毫秒时间戳
     */
    public static long getNowMills() {
        return System.currentTimeMillis();
    }

    /**
     * 获取当前时间字符串
     * <p>格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @return 时间字符串
     */
    public static String getNowString() {
        return millis2String(System.currentTimeMillis(), DEFAULT_FORMAT);
    }

    /**
     * 获取当前时间字符串
     * <p>格式为format</p>
     *
     * @param format 时间格式
     * @return 时间字符串
     */
    public static String getNowString(DateFormat format) {
        return millis2String(System.currentTimeMillis(), format);
    }

    /**
     * 获取当前Date
     *
     * @return Date类型时间
     */
    public static Date getNowDate() {
        return new Date();
    }

    /**
     * 获取与当前时间的差（单位：unit）
     * <p>time格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time 时间字符串
     * @param unit 单位类型
     *             <ul>
     *             <li>{@link TimeConstants#MSEC}: 毫秒</li>
     *             <li>{@link TimeConstants#SEC }: 秒</li>
     *             <li>{@link TimeConstants#MIN }: 分</li>
     *             <li>{@link TimeConstants#HOUR}: 小时</li>
     *             <li>{@link TimeConstants#DAY }: 天</li>
     *             </ul>
     * @return unit时间戳
     */
    public static long getTimeSpanByNow(String time, @TimeConstants.Unit int unit) {
        return getTimeSpan(getNowString(), time, DEFAULT_FORMAT, unit);
    }

    /**
     * 获取与当前时间的差（单位：unit）
     * <p>time格式为format</p>
     *
     * @param time   时间字符串
     * @param format 时间格式
     * @param unit   单位类型
     *               <ul>
     *               <li>{@link TimeConstants#MSEC}: 毫秒</li>
     *               <li>{@link TimeConstants#SEC }: 秒</li>
     *               <li>{@link TimeConstants#MIN }: 分</li>
     *               <li>{@link TimeConstants#HOUR}: 小时</li>
     *               <li>{@link TimeConstants#DAY }: 天</li>
     *               </ul>
     * @return unit时间戳
     */
    public static long getTimeSpanByNow(String time, DateFormat format, @TimeConstants.Unit int unit) {
        return getTimeSpan(getNowString(format), time, format, unit);
    }

    /**
     * 获取与当前时间的差（单位：unit）
     *
     * @param date Date类型时间
     * @param unit 单位类型
     *             <ul>
     *             <li>{@link TimeConstants#MSEC}: 毫秒</li>
     *             <li>{@link TimeConstants#SEC }: 秒</li>
     *             <li>{@link TimeConstants#MIN }: 分</li>
     *             <li>{@link TimeConstants#HOUR}: 小时</li>
     *             <li>{@link TimeConstants#DAY }: 天</li>
     *             </ul>
     * @return unit时间戳
     */
    public static long getTimeSpanByNow(Date date, @TimeConstants.Unit int unit) {
        return getTimeSpan(new Date(), date, unit);
    }

    /**
     * 获取与当前时间的差（单位：unit）
     *
     * @param millis 毫秒时间戳
     * @param unit   单位类型
     *               <ul>
     *               <li>{@link TimeConstants#MSEC}: 毫秒</li>
     *               <li>{@link TimeConstants#SEC }: 秒</li>
     *               <li>{@link TimeConstants#MIN }: 分</li>
     *               <li>{@link TimeConstants#HOUR}: 小时</li>
     *               <li>{@link TimeConstants#DAY }: 天</li>
     *               </ul>
     * @return unit时间戳
     */
    public static long getTimeSpanByNow(long millis, @TimeConstants.Unit int unit) {
        return getTimeSpan(System.currentTimeMillis(), millis, unit);
    }

    /**
     * 获取合适型与当前时间的差
     * <p>time格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time      时间字符串
     * @param precision 精度
     *                  <ul>
     *                  <li>precision = 0，返回null</li>
     *                  <li>precision = 1，返回天</li>
     *                  <li>precision = 2，返回天和小时</li>
     *                  <li>precision = 3，返回天、小时和分钟</li>
     *                  <li>precision = 4，返回天、小时、分钟和秒</li>
     *                  <li>precision &gt;= 5，返回天、小时、分钟、秒和毫秒</li>
     *                  </ul>
     * @return 合适型与当前时间的差
     */
    public static String getFitTimeSpanByNow(String time, int precision) {
        return getFitTimeSpan(getNowString(), time, DEFAULT_FORMAT, precision);
    }

    /**
     * 获取合适型与当前时间的差
     * <p>time格式为format</p>
     *
     * @param time      时间字符串
     * @param format    时间格式
     * @param precision 精度
     *                  <ul>
     *                  <li>precision = 0，返回null</li>
     *                  <li>precision = 1，返回天</li>
     *                  <li>precision = 2，返回天和小时</li>
     *                  <li>precision = 3，返回天、小时和分钟</li>
     *                  <li>precision = 4，返回天、小时、分钟和秒</li>
     *                  <li>precision &gt;= 5，返回天、小时、分钟、秒和毫秒</li>
     *                  </ul>
     * @return 合适型与当前时间的差
     */
    public static String getFitTimeSpanByNow(String time, DateFormat format, int precision) {
        return getFitTimeSpan(getNowString(format), time, format, precision);
    }

    /**
     * 获取合适型与当前时间的差
     *
     * @param date      Date类型时间
     * @param precision 精度
     *                  <ul>
     *                  <li>precision = 0，返回null</li>
     *                  <li>precision = 1，返回天</li>
     *                  <li>precision = 2，返回天和小时</li>
     *                  <li>precision = 3，返回天、小时和分钟</li>
     *                  <li>precision = 4，返回天、小时、分钟和秒</li>
     *                  <li>precision &gt;= 5，返回天、小时、分钟、秒和毫秒</li>
     *                  </ul>
     * @return 合适型与当前时间的差
     */
    public static String getFitTimeSpanByNow(Date date, int precision) {
        return getFitTimeSpan(getNowDate(), date, precision);
    }

    /**
     * 获取合适型与当前时间的差
     *
     * @param millis    毫秒时间戳
     * @param precision 精度
     *                  <ul>
     *                  <li>precision = 0，返回null</li>
     *                  <li>precision = 1，返回天</li>
     *                  <li>precision = 2，返回天和小时</li>
     *                  <li>precision = 3，返回天、小时和分钟</li>
     *                  <li>precision = 4，返回天、小时、分钟和秒</li>
     *                  <li>precision &gt;= 5，返回天、小时、分钟、秒和毫秒</li>
     *                  </ul>
     * @return 合适型与当前时间的差
     */
    public static String getFitTimeSpanByNow(long millis, int precision) {
        return getFitTimeSpan(System.currentTimeMillis(), millis, precision);
    }

    /**
     * 获取友好型与当前时间的差
     * <p>time格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time 时间字符串
     * @return 友好型与当前时间的差
     * <ul>
     * <li>如果小于1秒钟内，显示刚刚</li>
     * <li>如果在1分钟内，显示XXX秒前</li>
     * <li>如果在1小时内，显示XXX分钟前</li>
     * <li>如果在1小时外的今天内，显示今天15:32</li>
     * <li>如果是昨天的，显示昨天15:32</li>
     * <li>其余显示，2016-10-15</li>
     * <li>时间不合法的情况全部日期和时间信息，如星期六 十月 27 14:21:20 CST 2007</li>
     * </ul>
     */
    public static String getFriendlyTimeSpanByNow(String time) {
        return getFriendlyTimeSpanByNow(time, DEFAULT_FORMAT);
    }

    /**
     * 获取友好型与当前时间的差
     * <p>time格式为format</p>
     *
     * @param time   时间字符串
     * @param format 时间格式
     * @return 友好型与当前时间的差
     * <ul>
     * <li>如果小于1秒钟内，显示刚刚</li>
     * <li>如果在1分钟内，显示XXX秒前</li>
     * <li>如果在1小时内，显示XXX分钟前</li>
     * <li>如果在1小时外的今天内，显示今天15:32</li>
     * <li>如果是昨天的，显示昨天15:32</li>
     * <li>其余显示，2016-10-15</li>
     * <li>时间不合法的情况全部日期和时间信息，如星期六 十月 27 14:21:20 CST 2007</li>
     * </ul>
     */
    public static String getFriendlyTimeSpanByNow(String time, DateFormat format) {
        return getFriendlyTimeSpanByNow(string2Millis(time, format));
    }

    /**
     * 获取友好型与当前时间的差
     *
     * @param date Date类型时间
     * @return 友好型与当前时间的差
     * <ul>
     * <li>如果小于1秒钟内，显示刚刚</li>
     * <li>如果在1分钟内，显示XXX秒前</li>
     * <li>如果在1小时内，显示XXX分钟前</li>
     * <li>如果在1小时外的今天内，显示今天15:32</li>
     * <li>如果是昨天的，显示昨天15:32</li>
     * <li>其余显示，2016-10-15</li>
     * <li>时间不合法的情况全部日期和时间信息，如星期六 十月 27 14:21:20 CST 2007</li>
     * </ul>
     */
    public static String getFriendlyTimeSpanByNow(Date date) {
        return getFriendlyTimeSpanByNow(date.getTime());
    }

    /**
     * 获取友好型与当前时间的差
     *
     * @param millis 毫秒时间戳
     * @return 友好型与当前时间的差
     * <ul>
     * <li>如果小于1秒钟内，显示刚刚</li>
     * <li>如果在1分钟内，显示XXX秒前</li>
     * <li>如果在1小时内，显示XXX分钟前</li>
     * <li>如果在1小时外的今天内，显示今天15:32</li>
     * <li>如果是昨天的，显示昨天15:32</li>
     * <li>其余显示，2016-10-15</li>
     * <li>时间不合法的情况全部日期和时间信息，如星期六 十月 27 14:21:20 CST 2007</li>
     * </ul>
     */
    public static String getFriendlyTimeSpanByNow(long millis) {
        long now = System.currentTimeMillis();
        long span = now - millis;
        if (span < 0)
            return String.format("%tc", millis);// U can read http://www.apihome.cn/api/java/Formatter.html to understand it.
        if (span < 1000) {
            return "刚刚";
        } else if (span < TimeConstants.MIN) {
            return String.format(Locale.getDefault(), "%d秒前", span / TimeConstants.SEC);
        } else if (span < TimeConstants.HOUR) {
            return String.format(Locale.getDefault(), "%d分钟前", span / TimeConstants.MIN);
        }
        // 获取当天00:00
        long wee = (now / TimeConstants.DAY) * TimeConstants.DAY - 8 * TimeConstants.HOUR;
        if (millis >= wee) {
            return String.format("今天%tR", millis);
        } else if (millis >= wee - TimeConstants.DAY) {
            return String.format("昨天%tR", millis);
        } else {
            return String.format("%tF", millis);
        }
    }

    /**
     * 获取与给定时间等于时间差的时间戳
     *
     * @param millis   给定时间
     * @param timeSpan 时间差的毫秒时间戳
     * @param unit     单位类型
     *                 <ul>
     *                 <li>{@link TimeConstants#MSEC}: 毫秒</li>
     *                 <li>{@link TimeConstants#SEC }: 秒</li>
     *                 <li>{@link TimeConstants#MIN }: 分</li>
     *                 <li>{@link TimeConstants#HOUR}: 小时</li>
     *                 <li>{@link TimeConstants#DAY }: 天</li>
     *                 </ul>
     * @return 与给定时间等于时间差的时间戳
     */
    public static long getMillis(long millis, long timeSpan, @TimeConstants.Unit int unit) {
        return millis + timeSpan2Millis(timeSpan, unit);
    }

    /**
     * 获取与给定时间等于时间差的时间戳
     * <p>time格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time     给定时间
     * @param timeSpan 时间差的毫秒时间戳
     * @param unit     单位类型
     *                 <ul>
     *                 <li>{@link TimeConstants#MSEC}: 毫秒</li>
     *                 <li>{@link TimeConstants#SEC }: 秒</li>
     *                 <li>{@link TimeConstants#MIN }: 分</li>
     *                 <li>{@link TimeConstants#HOUR}: 小时</li>
     *                 <li>{@link TimeConstants#DAY }: 天</li>
     *                 </ul>
     * @return 与给定时间等于时间差的时间戳
     */
    public static long getMillis(String time, long timeSpan, @TimeConstants.Unit int unit) {
        return getMillis(time, DEFAULT_FORMAT, timeSpan, unit);
    }

    /**
     * 获取与给定时间等于时间差的时间戳
     * <p>time格式为format</p>
     *
     * @param time     给定时间
     * @param format   时间格式
     * @param timeSpan 时间差的毫秒时间戳
     * @param unit     单位类型
     *                 <ul>
     *                 <li>{@link TimeConstants#MSEC}: 毫秒</li>
     *                 <li>{@link TimeConstants#SEC }: 秒</li>
     *                 <li>{@link TimeConstants#MIN }: 分</li>
     *                 <li>{@link TimeConstants#HOUR}: 小时</li>
     *                 <li>{@link TimeConstants#DAY }: 天</li>
     *                 </ul>
     * @return 与给定时间等于时间差的时间戳
     */
    public static long getMillis(String time, DateFormat format, long timeSpan, @TimeConstants.Unit int unit) {
        return string2Millis(time, format) + timeSpan2Millis(timeSpan, unit);
    }

    /**
     * 获取与给定时间等于时间差的时间戳
     *
     * @param date     给定时间
     * @param timeSpan 时间差的毫秒时间戳
     * @param unit     单位类型
     *                 <ul>
     *                 <li>{@link TimeConstants#MSEC}: 毫秒</li>
     *                 <li>{@link TimeConstants#SEC }: 秒</li>
     *                 <li>{@link TimeConstants#MIN }: 分</li>
     *                 <li>{@link TimeConstants#HOUR}: 小时</li>
     *                 <li>{@link TimeConstants#DAY }: 天</li>
     *                 </ul>
     * @return 与给定时间等于时间差的时间戳
     */
    public static long getMillis(Date date, long timeSpan, @TimeConstants.Unit int unit) {
        return date2Millis(date) + timeSpan2Millis(timeSpan, unit);
    }

    /**
     * 获取与给定时间等于时间差的时间字符串
     * <p>格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param millis   给定时间
     * @param timeSpan 时间差的毫秒时间戳
     * @param unit     单位类型
     *                 <ul>
     *                 <li>{@link TimeConstants#MSEC}: 毫秒</li>
     *                 <li>{@link TimeConstants#SEC }: 秒</li>
     *                 <li>{@link TimeConstants#MIN }: 分</li>
     *                 <li>{@link TimeConstants#HOUR}: 小时</li>
     *                 <li>{@link TimeConstants#DAY }: 天</li>
     *                 </ul>
     * @return 与给定时间等于时间差的时间字符串
     */
    public static String getString(long millis, long timeSpan, @TimeConstants.Unit int unit) {
        return getString(millis, DEFAULT_FORMAT, timeSpan, unit);
    }

    /**
     * 获取与给定时间等于时间差的时间字符串
     * <p>格式为format</p>
     *
     * @param millis   给定时间
     * @param format   时间格式
     * @param timeSpan 时间差的毫秒时间戳
     * @param unit     单位类型
     *                 <ul>
     *                 <li>{@link TimeConstants#MSEC}: 毫秒</li>
     *                 <li>{@link TimeConstants#SEC }: 秒</li>
     *                 <li>{@link TimeConstants#MIN }: 分</li>
     *                 <li>{@link TimeConstants#HOUR}: 小时</li>
     *                 <li>{@link TimeConstants#DAY }: 天</li>
     *                 </ul>
     * @return 与给定时间等于时间差的时间字符串
     */
    public static String getString(long millis, DateFormat format, long timeSpan, @TimeConstants.Unit int unit) {
        return millis2String(millis + timeSpan2Millis(timeSpan, unit), format);
    }

    /**
     * 获取与给定时间等于时间差的时间字符串
     * <p>time格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time     给定时间
     * @param timeSpan 时间差的毫秒时间戳
     * @param unit     单位类型
     *                 <ul>
     *                 <li>{@link TimeConstants#MSEC}: 毫秒</li>
     *                 <li>{@link TimeConstants#SEC }: 秒</li>
     *                 <li>{@link TimeConstants#MIN }: 分</li>
     *                 <li>{@link TimeConstants#HOUR}: 小时</li>
     *                 <li>{@link TimeConstants#DAY }: 天</li>
     *                 </ul>
     * @return 与给定时间等于时间差的时间字符串
     */
    public static String getString(String time, long timeSpan, @TimeConstants.Unit int unit) {
        return getString(time, DEFAULT_FORMAT, timeSpan, unit);
    }

    /**
     * 获取与给定时间等于时间差的时间字符串
     * <p>格式为format</p>
     *
     * @param time     给定时间
     * @param format   时间格式
     * @param timeSpan 时间差的毫秒时间戳
     * @param unit     单位类型
     *                 <ul>
     *                 <li>{@link TimeConstants#MSEC}: 毫秒</li>
     *                 <li>{@link TimeConstants#SEC }: 秒</li>
     *                 <li>{@link TimeConstants#MIN }: 分</li>
     *                 <li>{@link TimeConstants#HOUR}: 小时</li>
     *                 <li>{@link TimeConstants#DAY }: 天</li>
     *                 </ul>
     * @return 与给定时间等于时间差的时间字符串
     */
    public static String getString(String time, DateFormat format, long timeSpan, @TimeConstants.Unit int unit) {
        return millis2String(string2Millis(time, format) + timeSpan2Millis(timeSpan, unit), format);
    }

    /**
     * 获取与给定时间等于时间差的时间字符串
     * <p>格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param date     给定时间
     * @param timeSpan 时间差的毫秒时间戳
     * @param unit     单位类型
     *                 <ul>
     *                 <li>{@link TimeConstants#MSEC}: 毫秒</li>
     *                 <li>{@link TimeConstants#SEC }: 秒</li>
     *                 <li>{@link TimeConstants#MIN }: 分</li>
     *                 <li>{@link TimeConstants#HOUR}: 小时</li>
     *                 <li>{@link TimeConstants#DAY }: 天</li>
     *                 </ul>
     * @return 与给定时间等于时间差的时间字符串
     */
    public static String getString(Date date, long timeSpan, @TimeConstants.Unit int unit) {
        return getString(date, DEFAULT_FORMAT, timeSpan, unit);
    }

    /**
     * 获取与给定时间等于时间差的时间字符串
     * <p>格式为format</p>
     *
     * @param date     给定时间
     * @param format   时间格式
     * @param timeSpan 时间差的毫秒时间戳
     * @param unit     单位类型
     *                 <ul>
     *                 <li>{@link TimeConstants#MSEC}: 毫秒</li>
     *                 <li>{@link TimeConstants#SEC }: 秒</li>
     *                 <li>{@link TimeConstants#MIN }: 分</li>
     *                 <li>{@link TimeConstants#HOUR}: 小时</li>
     *                 <li>{@link TimeConstants#DAY }: 天</li>
     *                 </ul>
     * @return 与给定时间等于时间差的时间字符串
     */
    public static String getString(Date date, DateFormat format, long timeSpan, @TimeConstants.Unit int unit) {
        return millis2String(date2Millis(date) + timeSpan2Millis(timeSpan, unit), format);
    }

    /**
     * 获取与给定时间等于时间差的Date
     *
     * @param millis   给定时间
     * @param timeSpan 时间差的毫秒时间戳
     * @param unit     单位类型
     *                 <ul>
     *                 <li>{@link TimeConstants#MSEC}: 毫秒</li>
     *                 <li>{@link TimeConstants#SEC }: 秒</li>
     *                 <li>{@link TimeConstants#MIN }: 分</li>
     *                 <li>{@link TimeConstants#HOUR}: 小时</li>
     *                 <li>{@link TimeConstants#DAY }: 天</li>
     *                 </ul>
     * @return 与给定时间等于时间差的Date
     */
    public static Date getDate(long millis, long timeSpan, @TimeConstants.Unit int unit) {
        return millis2Date(millis + timeSpan2Millis(timeSpan, unit));
    }

    /**
     * 获取与给定时间等于时间差的Date
     * <p>time格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time     给定时间
     * @param timeSpan 时间差的毫秒时间戳
     * @param unit     单位类型
     *                 <ul>
     *                 <li>{@link TimeConstants#MSEC}: 毫秒</li>
     *                 <li>{@link TimeConstants#SEC }: 秒</li>
     *                 <li>{@link TimeConstants#MIN }: 分</li>
     *                 <li>{@link TimeConstants#HOUR}: 小时</li>
     *                 <li>{@link TimeConstants#DAY }: 天</li>
     *                 </ul>
     * @return 与给定时间等于时间差的Date
     */
    public static Date getDate(String time, long timeSpan, @TimeConstants.Unit int unit) {
        return getDate(time, DEFAULT_FORMAT, timeSpan, unit);
    }

    /**
     * 获取与给定时间等于时间差的Date
     * <p>格式为format</p>
     *
     * @param time     给定时间
     * @param format   时间格式
     * @param timeSpan 时间差的毫秒时间戳
     * @param unit     单位类型
     *                 <ul>
     *                 <li>{@link TimeConstants#MSEC}: 毫秒</li>
     *                 <li>{@link TimeConstants#SEC }: 秒</li>
     *                 <li>{@link TimeConstants#MIN }: 分</li>
     *                 <li>{@link TimeConstants#HOUR}: 小时</li>
     *                 <li>{@link TimeConstants#DAY }: 天</li>
     *                 </ul>
     * @return 与给定时间等于时间差的Date
     */
    public static Date getDate(String time, DateFormat format, long timeSpan, @TimeConstants.Unit int unit) {
        return millis2Date(string2Millis(time, format) + timeSpan2Millis(timeSpan, unit));
    }

    /**
     * 获取与给定时间等于时间差的Date
     *
     * @param date     给定时间
     * @param timeSpan 时间差的毫秒时间戳
     * @param unit     单位类型
     *                 <ul>
     *                 <li>{@link TimeConstants#MSEC}: 毫秒</li>
     *                 <li>{@link TimeConstants#SEC }: 秒</li>
     *                 <li>{@link TimeConstants#MIN }: 分</li>
     *                 <li>{@link TimeConstants#HOUR}: 小时</li>
     *                 <li>{@link TimeConstants#DAY }: 天</li>
     *                 </ul>
     * @return 与给定时间等于时间差的Date
     */
    public static Date getDate(Date date, long timeSpan, @TimeConstants.Unit int unit) {
        return millis2Date(date2Millis(date) + timeSpan2Millis(timeSpan, unit));
    }

    /**
     * 获取与当前时间等于时间差的时间戳
     *
     * @param timeSpan 时间差的毫秒时间戳
     * @param unit     单位类型
     *                 <ul>
     *                 <li>{@link TimeConstants#MSEC}: 毫秒</li>
     *                 <li>{@link TimeConstants#SEC }: 秒</li>
     *                 <li>{@link TimeConstants#MIN }: 分</li>
     *                 <li>{@link TimeConstants#HOUR}: 小时</li>
     *                 <li>{@link TimeConstants#DAY }: 天</li>
     *                 </ul>
     * @return 与当前时间等于时间差的时间戳
     */
    public static long getMillisByNow(long timeSpan, @TimeConstants.Unit int unit) {
        return getMillis(getNowMills(), timeSpan, unit);
    }

    /**
     * 获取与当前时间等于时间差的时间字符串
     * <p>格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param timeSpan 时间差的毫秒时间戳
     * @param unit     单位类型
     *                 <ul>
     *                 <li>{@link TimeConstants#MSEC}: 毫秒</li>
     *                 <li>{@link TimeConstants#SEC }: 秒</li>
     *                 <li>{@link TimeConstants#MIN }: 分</li>
     *                 <li>{@link TimeConstants#HOUR}: 小时</li>
     *                 <li>{@link TimeConstants#DAY }: 天</li>
     *                 </ul>
     * @return 与当前时间等于时间差的时间字符串
     */
    public static String getStringByNow(long timeSpan, @TimeConstants.Unit int unit) {
        return getStringByNow(timeSpan, DEFAULT_FORMAT, unit);
    }

    /**
     * 获取与当前时间等于时间差的时间字符串
     * <p>格式为format</p>
     *
     * @param timeSpan 时间差的毫秒时间戳
     * @param format   时间格式
     * @param unit     单位类型
     *                 <ul>
     *                 <li>{@link TimeConstants#MSEC}: 毫秒</li>
     *                 <li>{@link TimeConstants#SEC }: 秒</li>
     *                 <li>{@link TimeConstants#MIN }: 分</li>
     *                 <li>{@link TimeConstants#HOUR}: 小时</li>
     *                 <li>{@link TimeConstants#DAY }: 天</li>
     *                 </ul>
     * @return 与当前时间等于时间差的时间字符串
     */
    public static String getStringByNow(long timeSpan, DateFormat format, @TimeConstants.Unit int unit) {
        return getString(getNowMills(), format, timeSpan, unit);
    }

    /**
     * 获取与当前时间等于时间差的Date
     *
     * @param timeSpan 时间差的毫秒时间戳
     * @param unit     单位类型
     *                 <ul>
     *                 <li>{@link TimeConstants#MSEC}: 毫秒</li>
     *                 <li>{@link TimeConstants#SEC }: 秒</li>
     *                 <li>{@link TimeConstants#MIN }: 分</li>
     *                 <li>{@link TimeConstants#HOUR}: 小时</li>
     *                 <li>{@link TimeConstants#DAY }: 天</li>
     *                 </ul>
     * @return 与当前时间等于时间差的Date
     */
    public static Date getDateByNow(long timeSpan, @TimeConstants.Unit int unit) {
        return getDate(getNowMills(), timeSpan, unit);
    }

    /**
     * 判断是否今天
     * <p>time格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time 时间字符串
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isToday(String time) {
        return isToday(string2Millis(time, DEFAULT_FORMAT));
    }

    /**
     * 判断是否今天
     * <p>time格式为format</p>
     *
     * @param time   时间字符串
     * @param format 时间格式
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isToday(String time, DateFormat format) {
        return isToday(string2Millis(time, format));
    }

    /**
     * 判断是否今天
     *
     * @param date Date类型时间
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isToday(Date date) {
        return isToday(date.getTime());
    }

    /**
     * 判断是否今天
     *
     * @param millis 毫秒时间戳
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isToday(long millis) {
        long wee = (System.currentTimeMillis() / TimeConstants.DAY) * TimeConstants.DAY - 8 * TimeConstants.HOUR;
        return millis >= wee && millis < wee + TimeConstants.DAY;
    }

    /**
     * 判断是否闰年
     * <p>time格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time 时间字符串
     * @return {@code true}: 闰年<br>{@code false}: 平年
     */
    public static boolean isLeapYear(String time) {
        return isLeapYear(string2Date(time, DEFAULT_FORMAT));
    }

    /**
     * 判断是否闰年
     * <p>time格式为format</p>
     *
     * @param time   时间字符串
     * @param format 时间格式
     * @return {@code true}: 闰年<br>{@code false}: 平年
     */
    public static boolean isLeapYear(String time, DateFormat format) {
        return isLeapYear(string2Date(time, format));
    }

    /**
     * 判断是否闰年
     *
     * @param date Date类型时间
     * @return {@code true}: 闰年<br>{@code false}: 平年
     */
    public static boolean isLeapYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        return isLeapYear(year);
    }

    /**
     * 判断是否闰年
     *
     * @param millis 毫秒时间戳
     * @return {@code true}: 闰年<br>{@code false}: 平年
     */
    public static boolean isLeapYear(long millis) {
        return isLeapYear(millis2Date(millis));
    }

    /**
     * 判断是否闰年
     *
     * @param year 年份
     * @return {@code true}: 闰年<br>{@code false}: 平年
     */
    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    /**
     * 获取中式星期
     * <p>time格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time 时间字符串
     * @return 中式星期
     */
    public static String getChineseWeek(String time) {
        return getChineseWeek(string2Date(time, DEFAULT_FORMAT));
    }

    /**
     * 获取中式星期
     * <p>time格式为format</p>
     *
     * @param time   时间字符串
     * @param format 时间格式
     * @return 中式星期
     */
    public static String getChineseWeek(String time, DateFormat format) {
        return getChineseWeek(string2Date(time, format));
    }

    /**
     * 获取中式星期
     *
     * @param date Date类型时间
     * @return 中式星期
     */
    public static String getChineseWeek(Date date) {
        return new SimpleDateFormat("E", Locale.CHINA).format(date);
    }

    /**
     * 获取中式星期
     *
     * @param millis 毫秒时间戳
     * @return 中式星期
     */
    public static String getChineseWeek(long millis) {
        return getChineseWeek(new Date(millis));
    }

    /**
     * 获取美式星期
     * <p>time格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time 时间字符串
     * @return 美式星期
     */
    public static String getUSWeek(String time) {
        return getUSWeek(string2Date(time, DEFAULT_FORMAT));
    }

    /**
     * 获取美式星期
     * <p>time格式为format</p>
     *
     * @param time   时间字符串
     * @param format 时间格式
     * @return 美式星期
     */
    public static String getUSWeek(String time, DateFormat format) {
        return getUSWeek(string2Date(time, format));
    }

    /**
     * 获取美式星期
     *
     * @param date Date类型时间
     * @return 美式星期
     */
    public static String getUSWeek(Date date) {
        return new SimpleDateFormat("EEEE", Locale.US).format(date);
    }

    /**
     * 获取美式星期
     *
     * @param millis 毫秒时间戳
     * @return 美式星期
     */
    public static String getUSWeek(long millis) {
        return getUSWeek(new Date(millis));
    }

    /**
     * 获取星期索引
     * <p>注意：周日的Index才是1，周六为7</p>
     * <p>time格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time 时间字符串
     * @return 1...7
     * @see Calendar#SUNDAY
     * @see Calendar#MONDAY
     * @see Calendar#TUESDAY
     * @see Calendar#WEDNESDAY
     * @see Calendar#THURSDAY
     * @see Calendar#FRIDAY
     * @see Calendar#SATURDAY
     */
    public static int getWeekIndex(String time) {
        return getWeekIndex(string2Date(time, DEFAULT_FORMAT));
    }

    /**
     * 获取星期索引
     * <p>注意：周日的Index才是1，周六为7</p>
     * <p>time格式为format</p>
     *
     * @param time   时间字符串
     * @param format 时间格式
     * @return 1...7
     * @see Calendar#SUNDAY
     * @see Calendar#MONDAY
     * @see Calendar#TUESDAY
     * @see Calendar#WEDNESDAY
     * @see Calendar#THURSDAY
     * @see Calendar#FRIDAY
     * @see Calendar#SATURDAY
     */
    public static int getWeekIndex(String time, DateFormat format) {
        return getWeekIndex(string2Date(time, format));
    }

    /**
     * 获取星期索引
     * <p>注意：周日的Index才是1，周六为7</p>
     *
     * @param date Date类型时间
     * @return 1...7
     * @see Calendar#SUNDAY
     * @see Calendar#MONDAY
     * @see Calendar#TUESDAY
     * @see Calendar#WEDNESDAY
     * @see Calendar#THURSDAY
     * @see Calendar#FRIDAY
     * @see Calendar#SATURDAY
     */
    public static int getWeekIndex(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 获取星期索引
     * <p>注意：周日的Index才是1，周六为7</p>
     *
     * @param millis 毫秒时间戳
     * @return 1...7
     * @see Calendar#SUNDAY
     * @see Calendar#MONDAY
     * @see Calendar#TUESDAY
     * @see Calendar#WEDNESDAY
     * @see Calendar#THURSDAY
     * @see Calendar#FRIDAY
     * @see Calendar#SATURDAY
     */
    public static int getWeekIndex(long millis) {
        return getWeekIndex(millis2Date(millis));
    }

    /**
     * 获取月份中的第几周
     * <p>注意：国外周日才是新的一周的开始</p>
     * <p>time格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time 时间字符串
     * @return 1...5
     */
    public static int getWeekOfMonth(String time) {
        return getWeekOfMonth(string2Date(time, DEFAULT_FORMAT));
    }

    /**
     * 获取月份中的第几周
     * <p>注意：国外周日才是新的一周的开始</p>
     * <p>time格式为format</p>
     *
     * @param time   时间字符串
     * @param format 时间格式
     * @return 1...5
     */
    public static int getWeekOfMonth(String time, DateFormat format) {
        return getWeekOfMonth(string2Date(time, format));
    }

    /**
     * 获取月份中的第几周
     * <p>注意：国外周日才是新的一周的开始</p>
     *
     * @param date Date类型时间
     * @return 1...5
     */
    public static int getWeekOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.WEEK_OF_MONTH);
    }

    /**
     * 获取月份中的第几周
     * <p>注意：国外周日才是新的一周的开始</p>
     *
     * @param millis 毫秒时间戳
     * @return 1...5
     */
    public static int getWeekOfMonth(long millis) {
        return getWeekOfMonth(millis2Date(millis));
    }

    /**
     * 获取年份中的第几周
     * <p>注意：国外周日才是新的一周的开始</p>
     * <p>time格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time 时间字符串
     * @return 1...54
     */
    public static int getWeekOfYear(String time) {
        return getWeekOfYear(string2Date(time, DEFAULT_FORMAT));
    }

    /**
     * 获取年份中的第几周
     * <p>注意：国外周日才是新的一周的开始</p>
     * <p>time格式为format</p>
     *
     * @param time   时间字符串
     * @param format 时间格式
     * @return 1...54
     */
    public static int getWeekOfYear(String time, DateFormat format) {
        return getWeekOfYear(string2Date(time, format));
    }

    /**
     * 获取年份中的第几周
     * <p>注意：国外周日才是新的一周的开始</p>
     *
     * @param date Date类型时间
     * @return 1...54
     */
    public static int getWeekOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获取年份中的第几周
     * <p>注意：国外周日才是新的一周的开始</p>
     *
     * @param millis 毫秒时间戳
     * @return 1...54
     */
    public static int getWeekOfYear(long millis) {
        return getWeekOfYear(millis2Date(millis));
    }

    /**
     * 获取生肖
     * <p>time格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time 时间字符串
     * @return 生肖
     */
    public static String getChineseZodiac(String time) {
        return getChineseZodiac(string2Date(time, DEFAULT_FORMAT));
    }

    /**
     * 获取生肖
     * <p>time格式为format</p>
     *
     * @param time   时间字符串
     * @param format 时间格式
     * @return 生肖
     */
    public static String getChineseZodiac(String time, DateFormat format) {
        return getChineseZodiac(string2Date(time, format));
    }

    /**
     * 获取生肖
     *
     * @param date Date类型时间
     * @return 生肖
     */
    public static String getChineseZodiac(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return CHINESE_ZODIAC[cal.get(Calendar.YEAR) % 12];
    }

    /**
     * 获取生肖
     *
     * @param millis 毫秒时间戳
     * @return 生肖
     */
    public static String getChineseZodiac(long millis) {
        return getChineseZodiac(millis2Date(millis));
    }

    /**
     * 获取生肖
     *
     * @param year 年
     * @return 生肖
     */
    public static String getChineseZodiac(int year) {
        return CHINESE_ZODIAC[year % 12];
    }

    /**
     * 获取星座
     * <p>time格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time 时间字符串
     * @return 生肖
     */
    public static String getZodiac(String time) {
        return getZodiac(string2Date(time, DEFAULT_FORMAT));
    }

    /**
     * 获取星座
     * <p>time格式为format</p>
     *
     * @param time   时间字符串
     * @param format 时间格式
     * @return 生肖
     */
    public static String getZodiac(String time, DateFormat format) {
        return getZodiac(string2Date(time, format));
    }

    /**
     * 获取星座
     *
     * @param date Date类型时间
     * @return 星座
     */
    public static String getZodiac(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return getZodiac(month, day);
    }

    /**
     * 获取星座
     *
     * @param millis 毫秒时间戳
     * @return 星座
     */
    public static String getZodiac(long millis) {
        return getZodiac(millis2Date(millis));
    }

    /**
     * 获取星座
     *
     * @param month 月
     * @param day   日
     * @return 星座
     */
    public static String getZodiac(int month, int day) {
        return ZODIAC[day >= ZODIAC_FLAGS[month - 1]
                ? month - 1
                : (month + 10) % 12];
    }

    /**
     * 以unit为单位的时间长度转毫秒时间戳
     *
     * @param timeSpan 毫秒时间戳
     * @param unit     单位类型
     *                 <ul>
     *                 <li>{@link TimeConstants#MSEC}: 毫秒</li>
     *                 <li>{@link TimeConstants#SEC }: 秒</li>
     *                 <li>{@link TimeConstants#MIN }: 分</li>
     *                 <li>{@link TimeConstants#HOUR}: 小时</li>
     *                 <li>{@link TimeConstants#DAY }: 天</li>
     *                 </ul>
     * @return 毫秒时间戳
     */
    private static long timeSpan2Millis(long timeSpan, @TimeConstants.Unit int unit) {
        return timeSpan * unit;
    }

    /**
     * 毫秒时间戳转以unit为单位的时间长度
     *
     * @param millis 毫秒时间戳
     * @param unit   单位类型
     *               <ul>
     *               <li>{@link TimeConstants#MSEC}: 毫秒</li>
     *               <li>{@link TimeConstants#SEC }: 秒</li>
     *               <li>{@link TimeConstants#MIN }: 分</li>
     *               <li>{@link TimeConstants#HOUR}: 小时</li>
     *               <li>{@link TimeConstants#DAY }: 天</li>
     *               </ul>
     * @return 以unit为单位的时间长度
     */
    private static long millis2TimeSpan(long millis, @TimeConstants.Unit int unit) {
        return millis / unit;
    }

    /**
     * 毫秒时间戳转合适时间长度
     *
     * @param millis    毫秒时间戳
     *                  <p>小于等于0，返回null</p>
     * @param precision 精度
     *                  <ul>
     *                  <li>precision = 0，返回null</li>
     *                  <li>precision = 1，返回天</li>
     *                  <li>precision = 2，返回天和小时</li>
     *                  <li>precision = 3，返回天、小时和分钟</li>
     *                  <li>precision = 4，返回天、小时、分钟和秒</li>
     *                  <li>precision &gt;= 5，返回天、小时、分钟、秒和毫秒</li>
     *                  </ul>
     * @return 合适时间长度
     */
    private static String millis2FitTimeSpan(long millis, int precision) {
        if (millis < 0 || precision <= 0) return null;
        precision = Math.min(precision, 5);
        String[] units = {"天", "小时", "分钟", "秒", "毫秒"};
        if (millis == 0) return 0 + units[precision - 1];
        StringBuilder sb = new StringBuilder();
        int[] unitLen = {86400000, 3600000, 60000, 1000, 1};
        for (int i = 0; i < precision; i++) {
            if (millis >= unitLen[i]) {
                long mode = millis / unitLen[i];
                millis -= mode * unitLen[i];
                sb.append(mode).append(units[i]);
            }
        }
        return sb.toString();
    }
}