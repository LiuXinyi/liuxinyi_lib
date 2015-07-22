package net.liuxinyi.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPreferencesUtil {
    private static SharedPreferencesUtil instance;
    /**
     * 首选项设置
     */
    public SharedPreferences sharedPreferences;

    public static void init(Context context, String name) {
	if (instance == null) {
	    instance = new SharedPreferencesUtil(context, name);
	}
    }

    public static SharedPreferencesUtil getInstance() {
	if (instance == null) {
	    throw new NullPointerException("no init SharedPreferencesUtil");
	}
	return instance;

    }

    private SharedPreferencesUtil(Context context, String name) {
	sharedPreferences = context.getSharedPreferences(name,
		Context.MODE_PRIVATE);
    }

    public void keepShared(String key, String value) {
	Editor editor = sharedPreferences.edit();
	editor.putString(key, value);
	editor.commit();
    }

    public void keepShared(String key, Integer value) {
	Editor editor = sharedPreferences.edit();
	editor.putInt(key, value);
	editor.commit();
    }

    public void keepShared(String key, long value) {
	Editor editor = sharedPreferences.edit();
	editor.putLong(key, value);
	editor.commit();
    }

    public void keepShared(String key, int value) {
	Editor editor = sharedPreferences.edit();
	editor.putInt(key, value);
	editor.commit();
    }

    /**
     * ������ѡ������
     * 
     * @param key
     * @param value
     */
    public void keepShared(String key, boolean value) {
	Editor editor = sharedPreferences.edit();
	editor.putBoolean(key, value);
	editor.commit();
    }

    /**
     * ��ѯָ��key û�з���null
     * 
     * @param key
     * @return
     */
    public String queryValue(String key, String defvalue) {
	String value = sharedPreferences.getString(key, defvalue);
	// if ("".equals(value)) {
	// return "";
	// }

	return value;
    }

    /**
     * ��ѯָ��key û�з���null
     * 
     * @param key
     * @return
     */
    public String queryValue(String key) {
	String value = sharedPreferences.getString(key, "");
	if ("".equals(value)) {
	    return "";
	}

	return value;
    }

    public Integer queryIntValue(String key) {
	int value = sharedPreferences.getInt(key, 0);

	return value;
    }

    /**
     * 
     * @param key
     * @return
     */
    public boolean queryBooleanValue(String key) {
	return sharedPreferences.getBoolean(key, false);
    }

    /**
     * 
     * @param key
     * @return
     */
    public long queryLongValue(String key) {
	return sharedPreferences.getLong(key, 0);
    }

    /**
     * �������
     * 
     * @return
     */
    public boolean deleteAllValue() {

	return sharedPreferences.edit().clear().commit();
    }

    /**
     * ����Key�����
     * 
     * @param key
     */
    public void deleteValue(String key) {
	sharedPreferences.edit().remove(key).commit();
    }
}
