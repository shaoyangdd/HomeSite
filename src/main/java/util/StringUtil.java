package util;

/**
 * <p>Description: 字符串工具类</p>
 * @author kangshaofei
 * @date 2016年1月17日
 */
public class StringUtil {
	
	/**
	 * 判断字符串   为 null 或   ""
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		return str==null||"".equals(str);
	}
	
	/**
	 * 判断字符串 不为    null 或   ""
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}
}
