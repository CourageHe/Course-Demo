package player;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.DefaultListModel;

public class MusicPlayer extends JFrame implements ActionListener{

	private final String ImageDir ="resources/images/";
	private final String SongDir ="file:resources//songs//";
	private JPanel contentPane;
	//组件
	protected JButton btn_last = new JButton();
	protected JButton btn_player = new JButton();
	protected JButton btn_next = new JButton();
	protected JButton btn_model = new JButton();
	protected JLabel songLable = new JLabel("最佳播放，毋庸置疑");
	//歌曲列表
	protected   JList songsList = null;
	

	protected String[]stateImages= {"player-play.png","player-pause.png"};
	//歌曲文件名数组---String
	protected String[] SongNames={ "song1.wav","song2.wav","song3.wav","song4.wav"};
	
	//正在播放的歌曲
	AudioClip songs[] = null;
	AudioClip currentSong = null;
	int index=0; //当前歌曲在JList中的位置(序号)
	//播放音乐的线程
	protected Thread playerThread=null;
	boolean isPlayOrStop = true;//true代表播放状态
	boolean isLoop = false; //是否为循环状态

	public MusicPlayer() {
		setResizable(false);
		setFont(new Font("Adobe 楷体 Std R", Font.PLAIN, 12));
		setForeground(Color.YELLOW);
		setBackground(Color.LIGHT_GRAY);
		setTitle("音乐播放器");
		
//		this.setIconImage(new ImageIcon(ImageDir+"cjdx.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 331, 487);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 204, 255));
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, 331, 144);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//按钮透明
		btn_last.setOpaque(false);
		//去掉边框
		btn_last.setBorderPainted(false);
		btn_last.setForeground(Color.WHITE);
		btn_last.setBackground(Color.WHITE);
		btn_last.setBounds(14, 83, 48, 48);
		btn_last.setIcon(new ImageIcon(ImageDir+ "player-last.png"));
		panel.add(btn_last);
		
		btn_last.addMouseListener(new MyMouseListener(this));
		btn_player.setOpaque(false);
		btn_player.setBorder(null);
		btn_player.setForeground(Color.WHITE);
		btn_player.setBackground(Color.WHITE);
		btn_player.setBounds(139, 83, 48, 48);
		btn_player.setIcon(new ImageIcon(ImageDir+stateImages[0]));
		panel.add(btn_player);
		
		btn_next.setOpaque(false);
		btn_next.setForeground(Color.WHITE);
		btn_next.setBackground(Color.WHITE);
		btn_next.setBounds(262, 83, 48, 48);
		btn_next.setBorderPainted(false);
		btn_next.setIcon(new ImageIcon(ImageDir+"player-next.png"));
		panel.add(btn_next);
		
		
		songLable.setForeground(new Color(255, 204, 51));
		songLable.setFont(new Font("Adobe 楷体 Std R", Font.PLAIN, 18));
		songLable.setBackground(new Color(51, 204, 255));
		songLable.setBounds(14, 27, 193, 25);
		panel.add(songLable);
		
		btn_model.setOpaque(false);
		btn_model.setForeground(Color.WHITE);
		btn_model.setBackground(Color.WHITE);
		btn_model.setBounds(264, 27, 32, 32);
		btn_model.setIcon(new ImageIcon(ImageDir+"player-loop.png"));
		btn_model.setBorderPainted(false);
		panel.add(btn_model);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 144, 331, 308);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("   歌曲列表：");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setBackground(new Color(0, 255, 0));
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Adobe 楷体 Std R", Font.PLAIN, 18));
		scrollPane.setColumnHeaderView(lblNewLabel);
		
		
		DefaultListModel lm = new DefaultListModel();
		songsList = new JList(lm);
		songs = new AudioClip[SongNames.length];
	    for(int i=0;i<SongNames.length;i++){
	      lm.add(i,SongNames[i]);
	      songs[i] = loadSound(SongNames[i]);
	    }
		songsList.addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent e) {
			    currentSong.stop();
		        index = songsList.getSelectedIndex();
		        isPlayOrStop = true;
		        playerThread = new Thread( new MusicRun() );
		        playerThread.start();
			}
		});
		songsList.setFont(new Font("Adobe 楷体 Std R", Font.PLAIN, 18));
		songsList.setForeground(Color.ORANGE);
		
		scrollPane.setViewportView(songsList);
		
		//单开一个线程 专用于播放音乐
		playerThread = new Thread( new MusicRun() );
		playerThread.start();
		 
		
		btn_last.addActionListener(this);
		btn_next.addActionListener(this);
		btn_player.addActionListener(this);
		btn_model.addActionListener(this);
	}
	//这里可能有问题
	 private AudioClip loadSound(String fileName) {
		    try {
		      URL url = new URL(SongDir+fileName);
		      AudioClip au = Applet.newAudioClip(url);
		      return au;
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		    return null;
	 }
	
	 private class MusicRun implements Runnable{
	    public void run() {
	      currentSong = songs[index];
	      if(isLoop){
	        currentSong.loop();
	        songLable.setText("循环播放:"+SongNames[index]);
	      }
	      if (isPlayOrStop) {
	        currentSong.play();
	      }else {
	    	  currentSong.stop();
	      }
	      //在播放列表中选定当前歌曲
	      songsList.setSelectedIndex(index);
	      //把播放按钮的图标切换成“停止”
	      btn_player.setIcon( new ImageIcon(ImageDir+ "player-pause.png"));
	 
	      if(!isLoop){
	    	  songLable.setText("正在播放:"+SongNames[index]);
	      }
	    }
	  }
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusicPlayer frame = new MusicPlayer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void actionPerformed(ActionEvent e) {
		JButton btn= (JButton)e.getSource();
	      currentSong.stop();
		//上一首
		if(btn == btn_last) {
			index--;
		    if(index<0){
		    	index = SongNames.length-1;
		    }
		//停止/播放
		}else if(btn == btn_player) {
	        isPlayOrStop = !isPlayOrStop;
		//下一首
		}else if(btn == btn_next) {
		     index++;
		     index = index%SongNames.length;
			
		//改变模式
		}else if(btn == btn_model) {
			isLoop =!isLoop;
			if(!isLoop) {
				btn_model.setIcon(new ImageIcon(ImageDir+"player-loop.png"));
			}else{
				btn_model.setIcon(new ImageIcon(ImageDir+"player-first.png"));
			}
		}
		if(isPlayOrStop){//播放
		   playerThread = new Thread( new MusicRun() );
		   playerThread.start();
		 }else{//停止
		   songsList.setSelectedIndex(index);
		   songLable.setText("停止播放:"+SongNames[index]);
		   btn_player.setIcon( new ImageIcon(ImageDir+"player-play.png"));
		 }
	}
}
