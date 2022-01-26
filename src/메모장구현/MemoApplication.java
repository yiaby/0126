package 메모장구현;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale.FilteringMode;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

//자바는 하나의 클래스만 상속 받을 수 있다.※다중 상속 허용 안함
//자바는 인터페이스를 하나가 아니라 여러개를 자식에세 구현시킬 수 있다.
public class MemoApplication extends JFrame implements ActionListener {
	// 준비 단계
	JFrame main_fr = new JFrame("메모장 만들기");
	FileDialog saveOpen;
	FileDialog readOpen;
	JTextArea area;

	// 생성자
	public MemoApplication() {
		// 위도우 실행창 화면 구미기
		JMenuBar main_br = new JMenuBar();
		JMenu file = new JMenu("파일");
		JMenuItem file_load = new JMenuItem("열기");
		JMenuItem file_save = new JMenuItem("저장");
		area = new JTextArea();
		// 열기, 저장 이라는 JMenuItem 객체를 클릭하면 => 이벤트가 발생했다 의미
		// file_load가 가리키는 객체와 this는 이벤트 핸들러 리스너 객체를 연결시켜놓겠다 의미
		file_load.addActionListener(this);
		file_save.addActionListener(this);

		// 컴퍼넌트 붙이기
		file.add(file_load);
		file.add(file_save);
		main_br.add(file);
		main_fr.setJMenuBar(main_br);
		main_fr.add(area);

		main_fr.setBounds(300, 300, 500, 400);
		main_fr.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 개발자가 채워넣기
		String itemPressed = e.getActionCommand();
		if (itemPressed.equals("저장")) {
			String name = saveName(); // 사용자 정의 메소드 호출
			// 파일에 저장 시 반드시 예외처리 해줘야 한다.
			try {
				save(name); // 사용자 정의 메소드 호출
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
		if (itemPressed.equals("열기")) {
			String name = readName(); // 사용자 정의 메소드 호출
			// 파일에 저장 시 반드시 예외처리 해줘야 한다.
			try {
				read(name); // 사용자 정의 메소드 호출
			} catch (Exception ex) {
				System.out.println(ex);
			}}
	}// end actionPerformed()
	public String readName() {
		readOpen = new FileDialog(main_fr, "문서열기", FileDialog.LOAD);
		readOpen.setVisible(true);
		String filedir = readOpen.getDirectory();
		String fileName = readOpen.getFile();
		String readfilename;
		readfilename = filedir + "//" + fileName;
		return readfilename;
	}
	public void read(String readfile) throws IOException {
		//파일 입출력 중 저장 시 고속으로 읽게 하기 위해서
		BufferedReader read = new BufferedReader(new FileReader(readfile));
		area.setText("");
		String line = read.readLine();
		
		while(line != null) {
			area.append(line+ "\n");
			line = read.readLine();
		}
		
		
		
		read.close(); // 자원 해제
	}

	
	
	public void save(String savefile) throws IOException {
	//파일 입출력 중 저장 시 고속으로 저장 시키기 위해서
		
		BufferedWriter save = new BufferedWriter(new FileWriter(savefile));
		String line = area.getText();
		save.write(line);
		save.close(); // 자원 해제
	}

	public String saveName() {
		saveOpen = new FileDialog(main_fr, "문서저장", FileDialog.SAVE);
		saveOpen.setVisible(true);
		String filedir = saveOpen.getDirectory();
		String fileName = saveOpen.getFile();
		String savefilename;
		savefilename = filedir + "//" + fileName + ".txt";
		return savefilename;
	}

	public static void main(String[] args) {
		// 객체 생성
		MemoApplication ma = new MemoApplication();

	}

}
