package model;

import java.util.ArrayList;

public class ActionResult {
	//������װ�����ݿ��в����õ��Ľ������������Ϣ
	private String isSuccess;
	private String failReason;
	private Object resultData;

	public String getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(String isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getFailReason() {
		return failReason;
	}

	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}

	public Object getResultData() {
		return resultData;
	}

	public void setResultData(ArrayList<Resume> resultData) {
		this.resultData = resultData;
	}
}
