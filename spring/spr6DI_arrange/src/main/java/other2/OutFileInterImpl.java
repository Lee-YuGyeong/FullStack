package other2;

import java.io.FileWriter;

public class OutFileInterImpl implements OutFileInter{
	
	private String filePath;	//경로명 및 파일명 기억
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public void outFile(String msg) {
		//	메세지를 실제로 파일로 출력하기
		try {
			FileWriter writer = new FileWriter(filePath);
			writer.write(msg);
			writer.close();
			System.out.println("파일 저장 완료");
		} catch (Exception e) {
			System.out.println("outFile err " + e);
		}
	}
}
