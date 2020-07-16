package util;

import model.ActionResult;
import model.ResumeList;


/**
 * @author : liudeqing4191
 * @program : util\Protocol.java
 * @description : ���ݷ������������ �γɷ��ؿͻ��˵ı���
 * @date : 2020/7/16 13:30
 */

public class Protocol {
    public Protocol() {

    }

    /*
     * ��ActionResult���������԰�ActionResult.isSuccess+"/n"+failReason����ActionResult.isSuccess+"/n"+��ActionResult.resultData
     * �õ����ַ�������ʽ��д
     * ��forѭ����õ�ActionResult.resultData���ַ���
     * */
    public String addResumeMessage(ActionResult ar) {
        String str;
        String isSuccess = ar.isSuccess;
        if (isSuccess.equals("Success")) {
            str = isSuccess + "/n";
        } else {
            str = isSuccess + "/n" + ar.failReason;
        }
        return str;
    }

    public String deleteResumeMessage(ActionResult ar) {
        String str;
        String isSuccess = ar.isSuccess;
        if (isSuccess.equals("Success")) {
            str = isSuccess + "/n";
        } else {
            str = isSuccess + "/n" + ar.failReason;
        }
        return str;
    }

    public String updataResumeMessage(ActionResult ar) {
        String str;
        String isSuccess = ar.isSuccess;
        if (isSuccess.equals("Success")) {
            str = isSuccess + "/n";
        } else {
            str = isSuccess + "/n" + ar.failReason;
        }
        return str;
    }

    public String searchResumeMessage(ActionResult ar) {
        String str;
        String isSuccess = ar.isSuccess;
        if (isSuccess.equals("Success")) {
            ResumeList resumes = (ResumeList) ar.resultData;
            str = isSuccess + "/n";
            //forѭ���õ�ActionResult.resultData�ַ���Ӧ���ַ���
            int resumesize = resumes.size();
            for (int i = 0; i < resumesize; i++) {
                String bookstring =
                        resumes.get(i).getId() + "," +
                                resumes.get(i).getName() + "," +
                                resumes.get(i).getSchool() + "," +
                                resumes.get(i).getProcess() + "," +
                                resumes.get(i).getDeleteStatus() + ";";
                str = str + bookstring;
            }
        } else {
            str = isSuccess + "/n" + ar.failReason;
        }
        return str;
    }

}
