package util;

/**
 * <p>Description: �ַ���������</p>
 * @author kangshaofei
 * @date 2016��1��17��
 */
public class StringUtil {
	
	/**
	 * �ж��ַ���   Ϊ null ��   ""
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		return str==null||"".equals(str);
	}
	
	/**
	 * �ж��ַ��� ��Ϊ    null ��   ""
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}
}
