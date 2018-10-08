package com.yingzi.pi.app.resp;

/**
 * @ClassName: ResultBuilder
 * @author: 35191
 * @date: 2018-08-03
 */
public class ResultBuilder<T> {
	// 当正确时返回的值
	public static <T> RestResponse<T> success(T data) {
		RestResponse<T> result = new RestResponse<>();
		result.setCode(ExceptionEnum.SUCESS.getStatus());
		result.setMsg("success");
		result.setData(data);
		return result;
	}

	private ResultBuilder(){}

	public static <T> RestResponse<T> success() {
		return success(null);
	}

	// 当错误时返回的值
	public static <T> RestResponse<T> error(ExceptionEnum code, String msg) {
		RestResponse<T> result = new RestResponse<>();
		result.setCode(code.getStatus());
		result.setMsg(msg);
		return result;
	}
	public static <T> RestResponse<T> error(ExceptionEnum code) {
		RestResponse<T> result = new RestResponse<>();
		result.setCode(code.getStatus());
		result.setMsg(code.getComment());
		return result;
	}

	// 当错误时返回的值
	public static <T> RestResponse<T> error(String code, String msg) {
		RestResponse<T> result = new RestResponse<>();
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}
}
