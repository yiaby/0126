package �޸��屸��;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/*
 * ������ ���α׷�(GUI)
 * ������ �ý��� ���ø����̼� ���� �� �޴� �����
 */
public class MenuMain extends JFrame {
	// �غ� �ܰ�
	JFrame main_fr = new JFrame("������ �ý��� �޴� �����");
	JMenuBar mb;
	JMenu file, sort, help;
	JMenuItem fopen, fsave, fexit, proinfo;
	JCheckBoxMenuItem sno, sname, schul, sjoB;

	// ������ ����
	public MenuMain() {
     mb = new JMenuBar();
     
     file = new JMenu("����");
     sort = new JMenu("����");
     help = new JMenu("����");
     
     fopen = new JMenuItem("����");
     fsave = new JMenuItem("����");
     fexit = new JMenuItem("�ݱ�");
     //���� �׷�ȭ => ��� �ϳ��� üũ �� �� �ִ�.
     ButtonGroup bg = new ButtonGroup();
     sno = new JCheckBoxMenuItem("��ȣ");
     sname = new JCheckBoxMenuItem("�̸�");
     schul = new JCheckBoxMenuItem("�������");
     sjoB = new JCheckBoxMenuItem("����");

     bg.add(sno);
     bg.add(sname);
     bg.add(schul);
     bg.add(sjoB);

     
     proinfo = new JMenuItem("���α׷� ����");
    
     //��ü ���̱�
     file.add(fopen);
     file.add(fsave);
     file.addSeparator();//���м�
     file.add(fexit);
     
     sort.add(sno);
     sort.add(sname);
     sort.add(schul);
     sort.add(sjoB);
     
     help.add(proinfo);
     
     mb.add(file);
     mb.add(sort);
     mb.add(help);
     
     main_fr.setJMenuBar(mb);
     main_fr.setBounds(200,200,500,300);
     main_fr.setVisible(true);
     
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// ��ü ����
		MenuMain menuMain = new MenuMain();
	}

}
