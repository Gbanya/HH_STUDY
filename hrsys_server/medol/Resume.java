package medol;

/**
 * @program: HH_STUDY
 * @description:
 * @author: qiu haoran
 * @create: 2020-07-20 20:45
 */
public class Resume {
    public String resumeName;
    public String resumeId;
    public int resumeSchool;
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
    public int resumeprocess;

    /**
     *�߼�ɾ��
     * 0 : bu zhanshi * 1  չʾ
     */
    public int deleteStatus;
    public Resume(String resumeName, String resumeId, int resumeSchool,int resumeprocess,int deleteStatus) {
        this.resumeName = resumeName;
        this.resumeId = resumeId;
        this.resumeSchool = resumeSchool;
        this.resumeprocess = resumeprocess;
        this.deleteStatus = deleteStatus;
    }
}