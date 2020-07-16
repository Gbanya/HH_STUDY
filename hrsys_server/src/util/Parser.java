package util;

import bean.Operation;
import bean.Resume;

/**
 * �����࣬���ͻ��˴�������Ϣ��װΪOperation��
 *
 * Todo ����Client�е�Protocol��ϲ������ΪЭ�鹤�߰�
 */
public class Parser {

    public Parser() {
    }

    /**
     * ��/��ǰΪ�������ͣ���/����Ϊ��������
     * �˹����в�������ͬ��ΪResume����
     * ���������ɡ������ֿ�
     * @param message �ͻ��˴������Ϣ
     * @return Operation���󣬰��������������������
     */
    public Operation<Resume> parseOperation(String message) {
        Operation<Resume> resumeOperation;

        String operation = message.split("/")[0];
        if ("quit".equals(operation)) {
            resumeOperation = new Operation<>(operation);
        } else if ("queryAll".equals(operation)) {
            resumeOperation = new Operation<>(operation);
        } else if ("query".equals(operation) || "delete".equals(operation)) {
            String[] properties = message.split("/")[1].split(",");
            Resume resume = new Resume();
            resume.setName(properties[0]);
            resumeOperation = new Operation<>(operation, resume);
        } else {
            String[] properties = message.split("/")[1].split(",");
            Resume resume = new Resume();
            resume.setName(properties[0]);
            resume.setId(properties[1]);
            resume.setSchool(properties[2]);
            resumeOperation = new Operation<>(operation, resume);
        }


        return resumeOperation;
    }
}
