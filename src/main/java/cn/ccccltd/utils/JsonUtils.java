package cn.ccccltd.utils;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.ccccltd.pojo.Bookrack;

/**
 * json工具类 将网页获得json数据转变为Book对象
 * @author 13013
 *
 */
public class JsonUtils {
	/**
	 * 将json数据反序列化为书架对象
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public static Bookrack jsonToPojo(String json) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper(); 
		mapper.setSerializationInclusion(Include.NON_NULL);
		Bookrack bookrack = mapper.readValue(json, Bookrack.class);  
		return bookrack;
	}
}
