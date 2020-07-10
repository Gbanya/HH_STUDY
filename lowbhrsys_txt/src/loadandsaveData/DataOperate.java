package loadandsaveData;

import java.io.*;
import java.util.LinkedList;
import model.Resume;

@SuppressWarnings("all")
public class DataOperate {
	//�ж��ļ����ڣ��������򴴽�
	public static File createFile(String filePath) {
		File f = new File(filePath);
		try {
			if (!f.exists()) {
				f.createNewFile();
				System.out.println("�ļ��Ѵ���");
			}
			else {
				System.out.println("�ļ��Ѵ���");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return f;
	}

	public static void loadData(LinkedList<Resume> resumeList) {
		File f = createFile("./workerlist.txt");
		try (
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				){
					String data = br.readLine();
					while(data!=null) {
							String[] str = data.split(",");
							String workerName =str[0];
							String workerId =str[1];
							String workerSchool = str[2];
							int process = Integer.parseInt(str[3]);
							Resume book = new Resume(workerName, workerId, workerSchool, process);
							resumeList.add(book);
							data = br.readLine();
			}
		}
		catch(IOException exception) {
			exception.printStackTrace();
		}
	}

	public static void saveData(LinkedList<Resume> resumeList)
	{
		try(
				PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("./workerlist.txt",false)));//����д��
				) {
			int workerCount = resumeList.size();
			for (int i = 0; i < workerCount; i++) {
				printWriter.println(resumeList.get(i).getName()+","+resumeList.get(i).getId()+","+resumeList.get(i).getSchool()+","+resumeList.get(i).getProcess());
			}
			printWriter.flush();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}