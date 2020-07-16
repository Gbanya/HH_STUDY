package model;

/**
 * @author liudeqing4191
 * @date 2020/07/06
 * @project HR_SYS_1.0
 **/
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
     * * 0��������
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
     * 0 : bu zhanshi
     * 1  չʾ
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

    public Resume(String name, String id) {
        this.name = name;
        this.id = id;
        this.process=0;
        this.deleteStatus=0;
    }

}
