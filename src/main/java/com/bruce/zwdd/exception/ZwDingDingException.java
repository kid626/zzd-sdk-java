package com.bruce.zwdd.exception;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName zzd-sdk-java
 * @Date 2021/7/29 9:38
 * @Author fzh
 */
public class ZwDingDingException extends RuntimeException {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public ZwDingDingException() {
		// TODO Auto-generated constructor stub
	}

	public ZwDingDingException(Throwable msg) {
		super(msg);
	}

	public ZwDingDingException(String msg) {
		super(msg);
	}

	public ZwDingDingException(String msg, Throwable e) {
		super(msg, e);
	}
}