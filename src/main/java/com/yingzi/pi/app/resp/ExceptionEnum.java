package com.yingzi.pi.app.resp;

/**
 * @ClassName: ExceptionEnum
 * @author: 35191
 * @date: 2018-08-03
 */
public enum ExceptionEnum {
	SUCESS("00000", "成功"), 
	ERROR("00500", "内部服务异常"),
	PARAMERROR("40002","参数缺失"),
	SNERROR("40003","亲，当前场景不支持该二维码！"),
	SNNOEXIST("40004","亲，当前场景不支持该二维码！"),
	SNNOTEXIST("40006","亲，该二维码还未绑定！"),
	SNEXIST("40004","“亲，当前场景二维码已绑定！"),
	LOCBINDING("40005","亲，当前位置已绑定！");
	private String status;
	private String comment;
	/**
	 * @param status
	 * @param comment
	 */
	private ExceptionEnum(String status, String comment) {
		this.status = status;
		this.comment = comment;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
}
