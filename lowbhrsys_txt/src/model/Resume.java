/**
 * A program for JAVA��һ�ڿ���ҵ---ͼ�����ϵͳ
 * @version 1.2 2016-03-11
 * @author ���ʽ� 2014214225
 */
package model;

public class Resume {
	/**
	 *����
	 */
	private String name;
	/**
	 *���֤��
	 */
	private String id;
	/**
	 *ѧУ
	 */
	private String school;
	/**
	 *
	 * 0��������
	 * 1������ͨ��
	 * 2������ͨ��
	 * 3�����ͨ��
	 * 4������ͨ��
	 * 5����ǩԼ
	 * 6������ְ
	 */
	private int process;

	/**
	 *�߼�ɾ��
	 * 0 : ��չʾ
	 * 1 : չʾ
	 */
	private int deleteStatus;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public int getProcess() {
		return process;
	}

	public void setProcess(int process) {
		this.process = process;
	}

	public int getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(int deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public Resume(String name, String id, String school, int process) {
		this.name = name;
		this.id = id;
		this.school = school;
		this.process = process;
		this.deleteStatus = 0;
	}
}
