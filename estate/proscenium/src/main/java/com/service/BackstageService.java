package com.service;

import java.util.List;

import org.pojo.Buliding;
import org.pojo.Grou;
import org.pojo.Home;
import org.pojo.Homeimg;
import org.pojo.Management;
import org.pojo.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.BackstageDao;
@Service("backstageservice")
public class BackstageService {
	@Autowired
	private BackstageDao bsd;
	
	public List<Grou> findGrou(){
		return bsd.findGrou();
	}
	
	public List<Management> findManage(Integer id){
		return bsd.findManage(id);//
	}
	public List<Management> findManage2(Integer id){
		return bsd.findManage2(id);//
	}
	//�޸Ĺ���
	public void updateManage(Management man){
		bsd.updateManage(man);
	}
	//ɾ��
	public void delManage(Integer man){
		bsd.delManage(man);
	}
	//�������
	public void addManage(Management m){
		bsd.addManage(m);
	}
	//�����Ȧ
		public void addManage2(Management m){
			bsd.addManage2(m);
		}
		
		/********************************************************************************/
		//��ѯ���з�Դ����
	public List<Home> findHome(){
		return bsd.findHome();
	}
	public List<Buliding> findBuild(Integer id){
		return bsd.findBulid(id);
	}
	public void updateBuild(Buliding id){
		bsd.updateBulid(id);
	}
	public void deleteBulid(Integer  id){
		bsd.deleteBulid(id);
	}
	
	/*************��������*******************************************************************/
	//��ѯ��������
		public List<Rate> findRate(){
			return bsd.findRate();
		}
		
		//��Ӱ�������
		@Transactional
		public void saverate(Rate rate) {
			bsd.save(rate);
		}
		
		//������ѯ��������
		public Rate loadrate(Integer id){
			return bsd.loadrate(id);//
		}
		
		//�޸İ�������
		public  void updaterate(Rate rate) {
			bsd.updaterate(rate);
		}
		//ɾ����������
		public void del(Integer id) {
			bsd.del(id);
		};
		
		/*****************************************************************/
	    //��¥�����
		public void addbuil(Buliding b){
			bsd.addbuil(b);
		}
		//״̬�����б��ѯ
		public List<Management> findzt(){
			return bsd.findzt();
		}
		//���������б��ѯ
			public List<Management> findqy(){
				return bsd.findqy();
			}
		//��Ȧ�����б��ѯ
			public List<Management > findsq(Integer mid){
				return bsd.findsq(mid);
			}
		//¥�������б��ѯ
			public List<Management> findlx(){
				return bsd.findlx();
			}
		//���������б��ѯ
			public List<Management> findleix(){
				return bsd.findleix();
			}
			//���������б��ѯ
			public List<Management> findzhx(){
				return bsd.findzhx();
			}
			//�·�¥���޸ļ���
			public Buliding loadbiu(Integer id){
				return bsd.loadbiu(id);
			}
			//�·�¥���޸�
			public void updatebiu(Buliding biu){
			 bsd.updatebiu(biu);
			}
			/*************���ͼƬ****************************************************/
			
			public void addImg(Homeimg img){
				bsd.addImg(img);
			}

}
