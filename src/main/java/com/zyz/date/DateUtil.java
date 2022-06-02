package com.zyz.date;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class DateUtil {

   // private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    public static final String yyyymmddhhmmss = "yyyy-MM-dd HH:mm:ss";
    public static final String yyyymmddC = "yyyy年MM月dd日";
    public static final String yyyymmddhhmm = "yyyy-MM-dd HH:mm";
    public static final String yyyymmdd = "yyyy-MM-dd";
    public static final String yyyymmddnointer = "yyyyMMdd";
    public static final String ddmmyyyy = "dd-MM-yyyy";
    public static final String eeemmmddyyyy = "EEE MMM. dd yyyy";
    public static final String birthdayString = "dd/MM/yyyy";
    public static final String onlyyyymmddhhmmss = "yyyyMMddHHmmss";
    public static final String UPDATE_TIME_PATTERN = "yyyy/MM/dd HH:mm";
    public static final long ONE_MIN = 1 * 60 * 1000;
    public static final long ONE_HOUR = 1 * 60 * 60 * 1000;
    public static final long ONE_DAY = 1 * 24 * 60 * 60 * 1000;

    public final static ThreadLocal<HashMap<String, SimpleDateFormat>> DATE_FORMAT_MAP = new ThreadLocal<HashMap<String, SimpleDateFormat>>() {
        @Override
        protected synchronized HashMap<String, SimpleDateFormat> initialValue() {
            return new HashMap<>();
        }
    };

    public static SimpleDateFormat getFormat(String format) {
        SimpleDateFormat sdf = DATE_FORMAT_MAP.get().get(format);
        if (sdf == null) {
            sdf = new SimpleDateFormat(format);
            DATE_FORMAT_MAP.get().put(format, sdf);
        }
        return sdf;
    }

    public static String format(Date date, String format) {
        return getFormat(format).format(date);
    }

    public static long getCurDate() {
        Date now = new Date();
        return now.getTime();
    }

    public static int getIntervalHour(long _time1, long _time2) {
        long _time = Math.round(_time1 - _time2);
        int hour = Math.round(_time / ONE_HOUR);
        return hour;
    }

    public static int getIntervalMin(long _time1, long _time2) {
        long _time = Math.round(_time1 - _time2);
        int hour = Math.round(_time / ONE_MIN);
        return hour;
    }

    public static int getNowHour() {
        Calendar time = Calendar.getInstance();
        int hour = time.get(Calendar.HOUR_OF_DAY);
        return hour;
    }

    public static String getDateYMDHMS(Date date) {
        String nowTime = getFormat(yyyymmddhhmmss).format(date);
        return nowTime;
    }

    public static String getDateyyyyMMdd(Date date) {
        String nowTime = getFormat(yyyymmddC).format(date);
        return nowTime;
    }

    public static String getDatehms(String date_value) {
        String nowTime = null;
        try {
            Date date = getFormat(yyyymmddhhmm).parse(date_value);
            nowTime = getFormat(yyyymmddhhmmss).format(date.getTime());
        } catch (ParseException e) {
            // logger.error("format date error the string {}. errpr {}", date_value, e);
        }
        return nowTime;
    }

    public static String getNextNDay(String beginDate, int n) {
        String nextDate = beginDate;
        Calendar c = Calendar.getInstance();

        try {
            c.setTime(getFormat("yyyy-MM-dd").parse(beginDate));
            c.add(Calendar.DATE, n);
            nextDate = getFormat(yyyymmdd).format(c.getTime());
        } catch (ParseException e) {
            // logger.error("error beginDate=" + beginDate + ", n=" + n, e);
        }

        return nextDate;
    }

    public static String addNDay(String beginDate, int n) {
        String nextDate = beginDate;
        Calendar c = Calendar.getInstance();

        try {
            c.setTime(getFormat(yyyymmddhhmm).parse(beginDate));
            c.add(Calendar.DATE, n);
            nextDate = getFormat(yyyymmddhhmm).format(c.getTime());
        } catch (ParseException e) {
            // logger.error("error beginDate=" + beginDate, e);
        }

        return nextDate;
    }

    public static Date getNextNDate(int n) {

        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        c.add(Calendar.DAY_OF_MONTH, n);

        return c.getTime();
    }

    /**
     * 当前时间是否是这一天的前几个小时
     *
     * @param hours
     * @return
     */
    public static boolean isHoursBeforeOneDay(int hours) {
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);
        if (hour < hours) {
            return true;
        }
        return false;
    }

    /**
     * 传入日期n个单位后的日期
     *
     * @param now
     * @param n
     * @param unit Calendar.MINUTE这种格式
     * @return
     */
    public static Date getNextNDate(Date now, int n, int unit) {
        Calendar c = Calendar.getInstance();
        c.setTime(now);
        c.add(unit, n);
        return c.getTime();
    }

    public static Calendar convertCalendar(String _dateValue) {
        Date _date = convertDate(_dateValue);
        if (_date == null) {
            return null;
        }
        Calendar ca = Calendar.getInstance();
        ca.setTime(_date);
        return ca;
    }

    public static Date addDay(String _dateValue, int _day) {
        Calendar c = convertCalendar(_dateValue);
        c.add(Calendar.DAY_OF_YEAR, _day);
        return c.getTime();
    }

    public static Date addDay(Date _date, int _day) {
        if (_day == 0) {
            return _date;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(_date);
        c.add(Calendar.DAY_OF_YEAR, _day);
        return c.getTime();
    }

    public static Date addHour(String _dateValue, int _hour) {
        Calendar c = Calendar.getInstance();
        Date _date = convertDate(_dateValue);
        c.setTime(_date);
        c.add(Calendar.HOUR_OF_DAY, _hour);
        return c.getTime();
    }

    public static Date addHour(Date _date, int _hour) {
        Calendar c = Calendar.getInstance();
        c.setTime(_date);
        c.add(Calendar.HOUR_OF_DAY, _hour);
        return c.getTime();
    }

    public static String addHourByNow(int _hour) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.HOUR_OF_DAY, _hour);
        return getDateYMDHMS(c.getTime());
    }

    public static String addMin(String _dateValue, int _min) {
        Calendar c = Calendar.getInstance();
        Date _date = convertDate2(_dateValue);
        c.setTime(_date);
        c.add(Calendar.MINUTE, _min);
        return getFormat(yyyymmddhhmmss).format(c.getTime());
    }

    public static Date convertDate1(String _dateValue) {
        Date date = null;
        if (StringUtils.isNotEmpty(_dateValue)) {
            try {
                date = getFormat(yyyymmdd).parse(_dateValue);
            } catch (Exception e) {
                //logger.warn("DateTool: " + _dateValue);
            }
        }
        return date;
    }

    public static Date convertDate2(String _dateValue) {
        Date date = null;
        if (StringUtils.isNotEmpty(_dateValue)) {
            try {
                date = getFormat(yyyymmddhhmm).parse(_dateValue);
            } catch (Exception e) {
               // logger.warn("DateTool: " + _dateValue);
            }
        }
        return date;
    }

    public static Date convertDate3(String _dateValue) {
        Date date = null;
        if (StringUtils.isNotEmpty(_dateValue)) {
            try {
                date = getFormat(yyyymmddhhmmss).parse(_dateValue);
            } catch (Exception e) {
               // logger.warn("DateTool: " + _dateValue);
            }
        }
        return date;
    }

    public static Date convertDate(String _dateValue) {
        if (_dateValue.length() > 10) {
            return convertDate2(_dateValue);
        } else {
            return convertDate1(_dateValue);
        }
    }

    public static boolean afterCurrentDate(String _dateValue) {
        Date _currentDate = new Date();
        Date _date = convertDate(_dateValue);
        return _date.after(_currentDate);
    }

    public static boolean beforeCurrentDate(String _dateValue) {
        Date _currentDate = new Date();
        Date _date = convertDate(_dateValue);
        return _date.before(_currentDate);
    }

    public static String getNextNDay(int day) {
        String date = null;
        try {
            Calendar now = Calendar.getInstance();
            now.add(Calendar.DAY_OF_MONTH, day);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.format(now.getTime());
        } catch (Exception e) {
            // logger.error("get next day error. ", e);
        }
        return date;
    }

    /**
     * 计算时间天数，上取整
     *
     * @param start
     * @param end
     * @return
     */
    public static int daysInterval(Date start, DateTime end) {
        return daysInterval(start, end.toDate());
    }

    /**
     * 计算时间天数，上取整
     *
     * @param start
     * @param end
     * @return
     */
    public static int daysInterval(Date start, Date end) {
        if (start == null || end == null) {
            return 7;
        }
        long duration = end.getTime() - start.getTime();
        Double dayDouble = (duration + 0.0) / ONE_DAY;
        return (int) Math.ceil(dayDouble);
    }

    /**
     * 计算月份间隔
     *
     * @param start
     * @param end
     * @return
     */
/*    public static int monthInterval(String start, DateTime end) {
        return Months.monthsBetween(DateTimeUtil.toDateTime(start, DateTimeUtil.DateTimeUtilFormat.yyyy_MM_dd), end)
                .getMonths();
    }*/

    /**
     * 计算年份间隔
     *
     * @param start
     * @param end
     * @return
     */
/*    public static int yearsInterval(String start, DateTime end) {
        return Years.yearsBetween(DateTimeUtil.toDateTime(start, DateTimeUtil.DateTimeUtilFormat.yyyy_MM_dd), end)
                .getYears();
    }*/

    /**
     * 计算date1和date2之间的跨天数 (默认取绝对值)
     *
     * @param date1 格式： yyyy-MM-dd
     * @param date2 格式： yyyy-MM-dd
     * @return
     */
    public static int daysInterval(String date1, String date2) {
        return daysInterval(date1, date2, true);
    }

    /**
     * 计算date1和date2之间的跨天数
     *
     * @param date1 格式： yyyy-MM-dd
     * @param date2 格式： yyyy-MM-dd
     * @param abs 是否对跨天数取绝对值
     * @return
     */
    public static int daysInterval(String date1, String date2, boolean abs) {
        if (StringUtils.isEmpty(date1) || StringUtils.isEmpty(date2)) {
            return 0;
        }
        try {
            Date d1 = convertDate1(date1);
            Date d2 = convertDate1(date2);
            long t1 = d1.getTime();
            long t2 = d2.getTime();
            long interval = t2 - t1;
            if (abs) {
                interval = Math.abs(interval);
            }
            return (int) (interval / ONE_DAY);
        } catch (Exception e) {
            return 0;
        }
    }

    public static int getHourDelta(String date1, String date2) {
        if (StringUtils.isEmpty(date1) || StringUtils.isEmpty(date2)) {
            return 0;
        }
        try {
            Date d1 = convertDate2(date1);
            Date d2 = convertDate2(date2);
            long t1 = d1.getTime();
            long t2 = d2.getTime();
            return getIntervalHour(t1, t2);
        } catch (Exception e) {
            return 0;
        }
    }

    public static boolean compareTime(String date1, String date2) {
        if (StringUtils.isEmpty(date1) || StringUtils.isEmpty(date2)) {
            return false;
        }
        try {
            Date d1 = convertDate2(date1);
            Date d2 = convertDate2(date2);
            return d1.before(d2);
        } catch (Exception e) {
            return false;
        }
    }

    public static String timestamp2Str(Timestamp time, String formatStr) {
        String timeStr = null;
        if (time != null) {
            Date date = new Date();
            date.setTime(time.getTime());
            timeStr = getFormat(formatStr).format(date);
        }
        return timeStr;
    }

    public static String getdmyDate(String _dateValue) {
        String dateStr = null;
        if (StringUtils.isNotEmpty(_dateValue)) {
            try {
                Date date = getFormat(yyyymmddnointer).parse(_dateValue);
                dateStr = getFormat(ddmmyyyy).format(date);
            } catch (Exception e) {
               // logger.warn("DateTool: " + _dateValue);
            }
        }
        return dateStr;
    }

    public static String getdmy2Date(String _dateValue) {
        String dateStr = null;
        if (StringUtils.isNotEmpty(_dateValue)) {
            try {
                Date date = getFormat(yyyymmdd).parse(_dateValue);
                dateStr = getFormat(ddmmyyyy).format(date);
            } catch (Exception e) {
                // logger.warn("DateTool: " + _dateValue);
            }
        }
        return dateStr;
    }

    public static String getymdDate(String _dateValue) {
        String dateStr = null;
        if (StringUtils.isNotEmpty(_dateValue)) {
            try {
                Date date = getFormat(ddmmyyyy).parse(_dateValue);
                dateStr = getFormat(yyyymmdd).format(date);
            } catch (Exception e) {
              //  logger.warn("DateTool: " + _dateValue);
            }
        }
        return dateStr;
    }

    public static String formatTimeStr(String time) {
        String fTime = "";
        if (StringUtils.isNotEmpty(time) && time.length() == 4) {
            fTime = time.substring(0, 2) + ":" + time.substring(2);
        } else {
           // logger.error("tts search return time format is error, time is {}", time);
          //  QMonitor.recordOne("itts_search_return_time_format_error");
        }
        return fTime;
    }

    public static String calflightTime(short time) {
        String flightTime = "";
        if (time > 0) {
            flightTime = time / 60 + "h" + time % 60 + "m";
        }
        return flightTime;
    }

    public static int computeWorkStatus(String startTime, String endTime, String startSatTime, String endSatTime) {
        Date todayDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String todayString = simpleDateFormat.format(todayDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(todayDate);
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        if (week == 1) {// 说明是周日
            return 1;
        } else if (week == 7) {// 说明是周六
            startTime = todayString.substring(0, 10) + " " + startSatTime;
            endTime = todayString.substring(0, 10) + " " + endSatTime;
        } else {
            startTime = todayString.substring(0, 10) + " " + startTime;
            endTime = todayString.substring(0, 10) + " " + endTime;
        }
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = simpleDateFormat.parse(startTime);
            endDate = simpleDateFormat.parse(endTime);
        } catch (ParseException e) {
           // logger.error("DateUtil: compute WorkStatus error.", e);
        }

        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTime(startDate);
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(endDate);

        if (calendar.before(calendarStart) || calendar.after(calendarEnd)) {
            return 1;
        }
        return 0;
    }

    public static String convertToWeekMonDateYear(String dateString) {
        SimpleDateFormat simpleDateFormat = DateUtil.getFormat(yyyymmdd);
        try {
            Date date = simpleDateFormat.parse(dateString);
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(eeemmmddyyyy, Locale.US);
            return simpleDateFormat1.format(date);
        } catch (ParseException e) {
           // logger.error("DateUtil: covert To weekMonDateYear Error", e);
        }
        return dateString;
    }

    public static String convertToddmmyyyy(String birthday) {
        SimpleDateFormat simpleDateFormat = DateUtil.getFormat(yyyymmdd);
        try {
            Date date = simpleDateFormat.parse(birthday);
            simpleDateFormat = DateUtil.getFormat(birthdayString);
            return simpleDateFormat.format(date);

        } catch (ParseException e) {
           // logger.error("DateUtil: convertToddmmyyyy Error", e);
        }
        return birthday;
    }

    public static String convertToddmmyyyyWithBar(String string) {
        SimpleDateFormat simpleDateFormat = DateUtil.getFormat(yyyymmdd);
        try {
            Date date = simpleDateFormat.parse(string);
            simpleDateFormat = DateUtil.getFormat(ddmmyyyy);
            return simpleDateFormat.format(date);

        } catch (ParseException e) {
          //  logger.error("DateUtil: convertToddmmyyyy Error", e);
        }
        return string;
    }

    public static String convertToyyyymmdd(String ddmmyyyyString) {
        SimpleDateFormat simpleDateFormat = DateUtil.getFormat(ddmmyyyy);
        try {
            Date date = simpleDateFormat.parse(ddmmyyyyString);
            simpleDateFormat = DateUtil.getFormat(yyyymmdd);
            return simpleDateFormat.format(date);
        } catch (ParseException e) {
           // logger.error("DateUtil: convertToyyyyddmm");
        }
        return ddmmyyyy;
    }

    public static String getCurDateYYYYMMDDHHMMSS() {
        SimpleDateFormat simpleDateFormat = DateUtil.getFormat(onlyyyymmddhhmmss);
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    public static int getDayOfWeek(String date, String dateFormat) {
        SimpleDateFormat sdf = getFormat(dateFormat);
        try {
            Date dateD = sdf.parse(date);
            Calendar cal = Calendar.getInstance();
            cal.setTime(dateD);
            return cal.get(Calendar.DAY_OF_WEEK);
        } catch (ParseException e) {
           // logger.error("get week of day error. {}", e);
        }
        return 0;
    }

    public static List<LocalDate> getDaysBetween(String fromDate, String toDate, String DateFormat) {
        LocalDate statDate = LocalDate.parse(fromDate, DateTimeFormat.forPattern(DateFormat));
        LocalDate endDate = LocalDate.parse(toDate, DateTimeFormat.forPattern(DateFormat));
        List<LocalDate> dates = new ArrayList<LocalDate>();
        int days = Days.daysBetween(statDate, endDate).getDays();
        for (int i = 0; i <= days; i++) {
            LocalDate d = statDate.withFieldAdded(DurationFieldType.days(), i);
            dates.add(d);
        }
        return dates;
    }

    public static boolean verifyAfterZeroTime(Date createTime) {

        if (createTime != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            Date TodayZeroTime = calendar.getTime();
            if (createTime.after(TodayZeroTime)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 得到昨天的日期
     *
     * @return 格式：xxxx-xx-xx
     */
    public static String getYesterdayDate() {
        String yesterday = addHourByNow(-24);
        yesterday = yesterday.substring(0, 10);
        return yesterday;
    }

    /**
     * 返回该日期起点
     *
     * @param date xxxx-xx-xx
     * @return xxxx-xx-xx 00:00:00
     */
    public static String getDateStart(String date) {
        return date + " 00:00:00";
    }

    /**
     * 返回该日期的结束
     *
     * @param date 2015-08-17
     * @return 2015-08-18 00:00:00
     */
    public static String getDateEnd(String date) {
        Date tmpDate = convertDate(date);
        Date dayafter = addDay(tmpDate, 1);
        return getDateYMDHMS(dayafter);
    }

    /**
     * 获取昨天的起始时间，比如今天是 2015-08-20 返回 2015-08-19 00:00:00
     *
     * @return
     */
    public static String getYesterdayStart() {
        String yesterday = addHourByNow(-24);
        String yesterdayBegin = yesterday.substring(0, 10) + " 00:00:00";
        return yesterdayBegin;
    }

    /**
     * 返回昨天的结束时间，比如今天是2015-08-20 返回 015-08-20 00:00:00
     *
     * @return
     */
    public static String getYesterdayEnd() {
        String dateYMDHMS = getDateYMDHMS(new Date());
        String yesterdayEnd = dateYMDHMS.substring(0, 10) + " 00:00:00";
        return yesterdayEnd;
    }

    public static void main1(String[] args) {
        Date end = new Date();
        Date start1 = new Date(end.getTime() - TimeUnit.DAYS.toMillis(1));
        Date start2 = new Date(end.getTime() - TimeUnit.DAYS.toMillis(1) + 1);
        int du1 = daysInterval(start1, end);
        int du2 = daysInterval(start2, end);
        System.out.println(du1);
        System.out.println(du2);
    }
}
