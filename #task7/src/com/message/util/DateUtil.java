package com.message.util;
import java.io.Serializable;  
import java.text.DateFormat;  
import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Calendar;  
import java.util.Date;  
  
/** 
 * ����ʱ���� 
 * 
 * <p>��Calendar�ķ�װ,�Ա���ʹ��</p> 
 * 
 * @author qsyang 
 * @version 1.0 
 */  
public class DateUtil implements Serializable {  
  
    /** 
     * yyyy-MM-dd HH:mm:ss ��ʽ 
     */  
    public static final String DEFAULT_DATE_TIME_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";  
    /** 
     * yyyy-MM-dd HH:mm ��ʽ 
     */  
    public static final String DEFAULT_DATE_TIME_HHmm_FORMAT_PATTERN = "yyyy-MM-dd HH:mm";  
    /** 
     * yyyy-MM-dd HH ��ʽ 
     */  
    public static final String DEFAULT_DATE_TIME_HH_FORMAT_PATTERN = "yyyy-MM-dd HH";  
    /** 
     * yyyy-MM-dd ��ʽ 
     */  
    public static final String DEFAULT_DATE_FORMAT_PATTERN = "yyyy-MM-dd";  
    /** 
     * HH:mm:ss ��ʽ 
     */  
    public static final String DEFAULT_TIME_FORMAT_PATTERN = "HH:mm:ss";  
    /** 
     * HH:mm ��ʽ 
     */  
    public static final String DEFAULT_TIME_HHmm_FORMAT_PATTERN = "HH:mm";  
    /** 
     * �� 
     * <p>����ͨ��DateUtil.now().get(DateUtil.YEAR_FIELD)����ȡ��ǰʱ�����</p> 
     */  
    public static final int YEAR_FIELD = java.util.Calendar.YEAR;  
    /** 
     * �� 
     * <p>����ͨ��DateUtil.now().get(DateUtil.MONTH_FIELD)����ȡ��ǰʱ�����</p> 
     */  
    public static final int MONTH_FIELD = java.util.Calendar.MONTH;  
    /** 
     * �� 
     * <p>����ͨ��DateUtil.now().get(DateUtil.DAY_FIELD)����ȡ��ǰʱ�����</p> 
     */  
    public static final int DAY_FIELD = java.util.Calendar.DATE;  
    /** 
     * Сʱ <p>����ͨ��DateUtil.now().get(DateUtil.HOUR_FIELD)����ȡ��ǰʱ���Сʱ</p> 
     */  
    public static final int HOUR_FIELD = java.util.Calendar.HOUR_OF_DAY;  
    /** 
     * ���� <p>����ͨ��DateUtil.now().get(DateUtil.MINUTE_FIELD)����ȡ��ǰʱ��ķ���</p> 
     */  
    public static final int MINUTE_FIELD = java.util.Calendar.MINUTE;  
    /** 
     * �� 
     * <p>����ͨ��DateUtil.now().get(DateUtil.SECOND_FIELD)����ȡ��ǰʱ�����</p> 
     */  
    public static final int SECOND_FIELD = java.util.Calendar.SECOND;  
    /** 
     * ���� <p>����ͨ��DateUtil.now().get(DateUtil.MILLISECOND_FIELD)����ȡ��ǰʱ��ĺ���</p> 
     */  
    public static final int MILLISECOND_FIELD = java.util.Calendar.MILLISECOND;  
    private java.util.Calendar c;   //������  
  
    /** 
     * ��ȡһ��DateUtil,��DateUtil��δ��ʼ��,��ʾ��ʱ����1970-1-1 00:00:00.000 
     * <p>Ҫ��ȡ��ǰϵͳʱ��,����DateUtil.now();</p> 
     */  
    public DateUtil() {  
        c = Calendar.getInstance();  
        c.clear();  
    }  
  
    /** 
     * ����ʱ�� <p>���Դ���һ��ʱ����󣬽��ᱻת��ΪDateUtil����</p> 
     * 
     * @param date ʱ����� 
     */  
    public DateUtil(java.util.Date date) {  
        c = Calendar.getInstance();  
        c.setTime(date);  
    }  
  
    /** 
     * ����ʱ�� <p>���Դ���һ���������󣬽��ᱻת��ΪDateUtil����</p> 
     * 
     * @param calendar �������� 
     */  
    public DateUtil(java.util.Calendar calendar) {  
        this.c = calendar;  
    }  
  
    /** 
     * ��ȡ��ǰϵͳʱ�� 
     * 
     * @return DateUtil ��ǰϵͳʱ�� 
     */  
    public static DateUtil now() {  
        Calendar calendar = Calendar.getInstance();  
        return new DateUtil(calendar);  
    }  
  
    /** 
     * �ú���������ʱ��, ʱ��Ļ�����1970-1-1 00:00:00.000; <p>����,new DateUtil(1000) 
     * ���ʾ1970-1-1 00:00:01.000;<br> �ø�����ʾ����ʱ����ǰ��ʱ��</p> 
     * 
     * @param milliseconds ���� 
     */  
    public DateUtil(long milliseconds) {  
        c = Calendar.getInstance();  
        c.setTimeInMillis(milliseconds);  
    }  
  
    /** 
     * ת��ΪDate���� 
     * 
     * @return Dateʱ�� 
     */  
    public Date toDate() {  
        return c.getTime();  
    }  
  
    /** 
     * ת���� �������� 
     * 
     * @return Calendar���� 
     */  
    public java.util.Calendar toCalendar() {  
        return c;  
    }  
  
    /** 
     * ת����java.sql.Date(yyyy-MM-dd)���� 
     * 
     * @return java.sql.Date���� 
     */  
    public java.sql.Date toSqlDate() {  
        return new java.sql.Date(c.getTimeInMillis());  
    }  
  
    /** 
     * ת��Ϊjava.sql.Time(hh:mm:ss)ʱ�� 
     * 
     * @return java.sql.Timeʱ�� 
     */  
    public java.sql.Time toSqlTime() {  
        return new java.sql.Time(c.getTimeInMillis());  
    }  
  
    /** 
     * ת��Ϊjava.sql.Timestamp(ʱ���) 
     * 
     * @return java.sql.Timestampʱ��� 
     */  
    public java.sql.Timestamp toSqlTimestamp() {  
        return new java.sql.Timestamp(c.getTimeInMillis());  
    }  
  
    /** 
     * ����ʱ�� <p>����DateUtil�е�DEFAULT_TIME_FORMAT_PATTERN����ת��Ϊhh:mm:ss��hh:mm��ʽ</p> 
     * 
     * @param time �ַ�����ʽʱ�� 
     * @return DateUtil ����ʱ����� 
     */  
    public static DateUtil parseTime(String time) throws java.text.ParseException {  
        try {  
            return DateUtil.parseDateUtil(time, DateUtil.DEFAULT_TIME_FORMAT_PATTERN);  
        } catch (ParseException e) {  
            return DateUtil.parseDateUtil(time, DateUtil.DEFAULT_TIME_HHmm_FORMAT_PATTERN);  
        }  
    }  
  
    /** 
     * �������� <p>����DateUtil�е�DEFAULT_DATE_FORMAT_PATTERN����ת��Ϊyyyy-MM-dd��ʽ</p> 
     * 
     * @param date �ַ�����ʽ���� 
     * @return DateUtil ����ʱ���� 
     */  
    public static DateUtil parseDate(String date) throws java.text.ParseException {  
        return DateUtil.parseDateUtil(date, DateUtil.DEFAULT_DATE_FORMAT_PATTERN);  
    }  
  
    /** 
     * ��������ʱ�� <p>����DateUtil�е�DEFAULT_DATE_TIME_FORMAT_PATTERN����ת��Ϊyyyy-MM-dd 
     * HH:mm:ss��ʽ</p> 
     * 
     * @param datetime �ַ�����ʽ����ʱ�� 
     * @return DateUtil ����ʱ����� 
     */  
    public static DateUtil parseDateUtil(String datetime) throws java.text.ParseException {  
        DateUtil result = null;  
        //���԰�yyyy-MM-dd HH:mm:ss����  
        try {  
            result = DateUtil.parseDateUtil(datetime, DateUtil.DEFAULT_DATE_TIME_FORMAT_PATTERN);  
        } catch (ParseException e) {  
            //��������  
            result = null;  
        }  
  
        //���԰�yyyy-MM-dd HH:mm����  
        if (null == result) {  
            try {  
                result = DateUtil.parseDateUtil(datetime, DateUtil.DEFAULT_DATE_TIME_HHmm_FORMAT_PATTERN);  
            } catch (ParseException e) {  
                //��������  
                result = null;  
            }  
        }  
  
        //���԰�yyyy-MM-dd HH����  
        if (null == result) {  
            try {  
                result = DateUtil.parseDateUtil(datetime, DateUtil.DEFAULT_DATE_TIME_HH_FORMAT_PATTERN);  
            } catch (ParseException e) {  
                //��������  
                result = null;  
            }  
        }  
  
        //���԰�yyyy-MM-dd����  
        if (null == result) {  
            try {  
                result = DateUtil.parseDate(datetime);  
            } catch (ParseException e) {  
                //��������  
                result = null;  
            }  
        }  
  
        //���԰�ʱ�����  
        if (null == result) {  
            result = DateUtil.parseTime(datetime);  
        }  
        return result;  
    }  
  
    /** 
     * ��ָ����pattern�����ַ��� <p>pattern���÷��μ�java.text.SimpleDateFormat</p> 
     * 
     * @param datetime �ַ�����ʽ����ʱ�� 
     * @param pattern ���ڽ������� 
     * @return DateUtil ����ʱ����� 
     * @see java.text.SimpleDateFormat 
     */  
    public static DateUtil parseDateUtil(String datetime, String pattern) throws java.text.ParseException {  
        SimpleDateFormat fmt = (SimpleDateFormat) DateFormat.getDateInstance();  
        fmt.applyPattern(pattern);  
        return new DateUtil(fmt.parse(datetime));  
    }  
  
    /** 
     * ת��Ϊ DEFAULT_DATE_FORMAT_PATTERN (yyyy-MM-dd) ��ʽ�ַ��� 
     * 
     * @return yyyy-MM-dd��ʽ�ַ��� 
     */  
    public String toDateString() {  
        return toDateUtilString(DateUtil.DEFAULT_DATE_FORMAT_PATTERN);  
    }  
  
    /** 
     * ת��Ϊ DEFAULT_TIME_FORMAT_PATTERN (HH:mm:ss) ��ʽ�ַ��� 
     * 
     * @return HH:mm:ss ��ʽ�ַ��� 
     */  
    public String toTimeString() {  
        return toDateUtilString(DateUtil.DEFAULT_TIME_FORMAT_PATTERN);  
    }  
  
    /** 
     * ת��Ϊ DEFAULT_DATE_TIME_FORMAT_PATTERN (yyyy-MM-dd HH:mm:ss) ��ʽ�ַ��� 
     * 
     * @return yyyy-MM-dd HH:mm:ss ��ʽ�ַ��� 
     */  
    public String toDateUtilString() {  
        return toDateUtilString(DateUtil.DEFAULT_DATE_TIME_FORMAT_PATTERN);  
    }  
  
    /** 
     * ʹ������ת��pattern <p>pattern���÷��μ�java.text.SimpleDateFormat</p> 
     * 
     * @param pattern ���ڽ������� 
     * @return ������ת���������ʱ���ַ��� 
     */  
    public String toDateUtilString(String pattern) {  
        SimpleDateFormat fmt = (SimpleDateFormat) DateFormat.getDateInstance();  
        fmt.applyPattern(pattern);  
        return fmt.format(c.getTime());  
    }  
  
    /** 
     * ��ȡDateUtil����ʾʱ���ĳ��������ֵ 
     * 
     * @param field int ȡֵΪ:<br> DateUtil.YEAR_FIELD -- �������<br> 
     * DateUtil.MONTH_FIELD -- �����·�,һ�·ݷ���1,���·ݷ���2,��������<br> DateUtil.DAY_FIELD -- 
     * ���ص�ǰ����(�����е�)<br> DateUtil.HOUR_FIELD -- ����Сʱ��(�����е�),24Сʱ��<br> 
     * DateUtil.MINUTE_FIELD -- ���ط�����(��Сʱ�е�)<br> DateUtil.SECOND_FIELD -- 
     * ��������(�������е�)<br> DateUtil.MILLISECOND_FIELD -- ���غ�����(�����е�) 
     * @return int field��Ӧ��ֵ 
     */  
    public int get(int field) {  
        //�·���Ҫ+1(�·ݴ�0��ʼ)  
        if (DateUtil.MONTH_FIELD == field) {  
            return c.get(field) + 1;  
        } else {  
            return c.get(field);  
        }  
    }  
  
    /** 
     * ������ 1970-1-1 0:0:0 ����ʱ��ĺ����� 
     * 
     * @return long ������ 
     */  
    public long getTimeInMillis() {  
        return c.getTimeInMillis();  
    }  
  
    /** 
     * ����field�ֶε�ֵ 
     * 
     * @param field int ȡֵΪ:<br> DateUtil.YEAR_FIELD -- ���<br> 
     * DateUtil.MONTH_FIELD -- �·�,һ�·ݴ�1��ʼ<br> DateUtil.DAY_FIELD -- 
     * ��ǰ����(�����е�)<br> DateUtil.HOUR_FIELD -- Сʱ��(�����е�),24Сʱ��<br> 
     * DateUtil.MINUTE_FIELD -- ������(��Сʱ�е�)<br> DateUtil.SECOND_FIELD -- 
     * ����(�������е�)<br> DateUtil.MILLISECOND_FIELD -- ������(�����е�) 
     * @param value 
     */  
    public void set(int field, int value) {  
        //�·���Ҫ-1(�·ݴ�0��ʼ)  
        if (DateUtil.MONTH_FIELD == field) {  
            c.set(field, value - 1);  
        } else {  
            c.set(field, value);  
        }  
    }  
  
    /** 
     * ����DateUtil���ڵ���/��/�� 
     * 
     * @param year �� 
     * @param month �� 
     * @param day �� 
     */  
    public void set(int year, int month, int day) {  
        set(DateUtil.YEAR_FIELD, year);  
        set(DateUtil.MONTH_FIELD, month);  
        set(DateUtil.DAY_FIELD, day);  
    }  
  
    /** 
     * ����DateUtil���ڵ���/��/��/Сʱ 
     * 
     * @param year �� 
     * @param month �� 
     * @param day �� 
     * @param hour Сʱ 
     */  
    public void set(int year, int month, int day, int hour) {  
        set(year, month, day);  
        set(DateUtil.HOUR_FIELD, hour);  
    }  
  
    /** 
     * ����DateUtil���ڵ���/��/��/Сʱ/���� 
     * 
     * @param year �� 
     * @param month �� 
     * @param day �� 
     * @param hour Сʱ 
     * @param minute ���� 
     */  
    public void set(int year, int month, int day, int hour, int minute) {  
        set(year, month, day, hour);  
        set(DateUtil.MINUTE_FIELD, minute);  
    }  
  
    /** 
     * ����DateUtil���ڵ���/��/��/Сʱ/����/�� 
     * 
     * @param year �� 
     * @param month �� 
     * @param day �� 
     * @param hour Сʱ 
     * @param minute ���� 
     * @param second �� 
     */  
    public void set(int year, int month, int day, int hour, int minute, int second) {  
        set(year, month, day, hour, minute);  
        set(DateUtil.SECOND_FIELD, second);  
    }  
  
    /** 
     * ����DateUtil���ڵ���/��/��/Сʱ/����/��/���� 
     * 
     * @param year �� 
     * @param month �� 
     * @param day �� 
     * @param hour Сʱ 
     * @param minute ���� 
     * @param second �� 
     * @param milliSecond ���� 
     */  
    public void set(int year, int month, int day, int hour, int minute, int second, int milliSecond) {  
        set(year, month, day, hour, minute, second);  
        set(DateUtil.MILLISECOND_FIELD, milliSecond);  
    }  
  
    /** 
     * ��fieldֵ������� <p>add() �Ĺ��ܷǳ�ǿ��add ���Զ� DateUtil ���ֶν��м��㡣<br> 
     * �����Ҫ��ȥֵ����ôʹ�ø���ֵ�Ϳ����ˣ��� add(field, -value)��<br> 
     * ���ߵ���DateUtil.reduce(int,int)�����������</p> 
     * 
     * @param field int ȡֵΪ:<br>   DateUtil.YEAR_FIELD -- ���<br> 
     *   DateUtil.MONTH_FIELD -- �·�,һ�·ݴ�1��ʼ<br> 
     *   DateUtil.DAY_FIELD -- ��ǰ����(�����е�)<br> 
     *   DateUtil.HOUR_FIELD -- Сʱ��(�����е�),24Сʱ��<br> 
     *   DateUtil.MINUTE_FIELD -- ������(��Сʱ�е�)<br> 
     *   DateUtil.SECOND_FIELD -- ����(�������е�)<br> 
     *   DateUtil.MILLISECOND_FIELD -- ������(�����е�) 
     * @param amount ����(�������С��0��Ϊ���) 
     */  
    public void add(int field, int amount) {  
        c.add(field, amount);  
    }  
  
    /** 
     * ��fieldֵ������� <p>��add() �Ĺ��ܽ��з�װ��add ���Զ� Calendar ���ֶν��м��㡣<br> 
     * �����Ҫ��ȥֵ����ôʹ�ø���ֵ�Ϳ����ˣ��� add(field, -value)��<br> 
     * ��ϸ�÷��μ�Calendar.add(int,int)</p> 
     * 
     * @param field int ȡֵΪ:<br>   DateUtil.YEAR_FIELD -- ���<br> 
     *   DateUtil.MONTH_FIELD -- �·�,һ�·ݴ�1��ʼ<br> 
     *   DateUtil.DAY_FIELD -- ��ǰ����(�����е�)<br> 
     *   DateUtil.HOUR_FIELD -- Сʱ��(�����е�),24Сʱ��<br> 
     *   DateUtil.MINUTE_FIELD -- ������(��Сʱ�е�)<br> 
     *   DateUtil.SECOND_FIELD -- ����(�������е�)<br> 
     *   DateUtil.MILLISECOND_FIELD -- ������(�����е�) 
     * @param amount ����(�������С��0��Ϊ���) 
     */  
    public void reduce(int field, int amount) {  
        c.add(field, -amount);  
    }  
  
    /** 
     * �жϴ� DateUtil ��ʾ��ʱ���Ƿ���ָ�� Object ��ʾ��ʱ��֮�󣬷����жϽ���� <p>�˷�����Ч�ڣ�compareTo(when) 
     * > 0<br> ���ҽ��� when ��һ�� DateUtil ʵ��ʱ�ŷ��� true������÷������� false�� 
     * 
     * @param when Ҫ�Ƚϵ� Object 
     * @return ����� DateUtil ��ʱ���� when ��ʾ��ʱ��֮���򷵻� true�����򷵻� false�� 
     */  
    public boolean after(Object when) {  
        if (when instanceof DateUtil) {  
            return c.after(((DateUtil) when).c);  
        }  
        return c.after(when);  
    }  
  
    /** 
     * �жϴ� DateUtil ��ʾ��ʱ���Ƿ���ָ�� Object ��ʾ��ʱ��֮ǰ�������жϽ���� <p>�˷�����Ч�ڣ�compareTo(when) 
     * < 0<br> ���ҽ��� when ��һ�� DateUtil ʵ��ʱ�ŷ��� true������÷������� false��</p> 
     * 
     * @param when Ҫ�Ƚϵ� Object 
     * @return ����� Calendar ��ʱ���� when ��ʾ��ʱ��֮ǰ���򷵻� true�����򷵻� false�� 
     */  
    public boolean before(Object when) {  
        if (when instanceof DateUtil) {  
            return c.before(((DateUtil) when).c);  
        }  
        return c.before(when);  
    }  
  
    /** 
     * ���������ش˶����һ������ 
     * 
     * @return ����ʱ����� 
     */  
    @Override  
    public Object clone() {  
        return new DateUtil((Calendar) c.clone());  
    }  
  
    /** 
     * ���ظô������Ĺ�ϣ�� 
     * 
     * @return �˶���Ĺ�ϣ��ֵ�� 
     * @see Object 
     */  
    @Override  
    public int hashCode() {  
        return c.hashCode();  
    }  
  
    /** 
     * ���� DateUtil ��ָ�� Object �Ƚϡ� 
     * 
     * @param obj - Ҫ��֮�ȽϵĶ��� 
     * @return ����˶������ obj���򷵻� true�����򷵻� false�� 
     * @see Object 
     */  
    @Override  
    public boolean equals(Object obj) {  
        if (obj instanceof DateUtil) {  
            return c.equals(((DateUtil) obj).toCalendar());  
        }  
        if (obj instanceof Calendar) {  
            return c.equals(obj);  
        }  
        if (obj instanceof java.util.Date) {  
            return c.getTime().equals(obj);  
        }  
        return false;  
    }  
}  