package service.impl;

import java.util.List;

import dao.impl.PorderDaoImpl;
import model.Porder;
import service.PorderService;

public class PorderServiceImpl implements PorderService {
	
	private static PorderDaoImpl porderdaoimpl = new PorderDaoImpl();

	@Override
	public void addPorder(Porder porder) {
		if(porder.getLavender() >= 0 && porder.getBabysbreath() >= 0 && porder.getRose() >= 0) {
			porderdaoimpl.add(porder);
		}
		
	}

	@Override
	public String AllPorder() {
		List<Porder> l = porderdaoimpl.selectAll();
		String show = "";
		
		for(Porder p : l) {
			int sum = p.getLavender() * 99 + p.getBabysbreath() * 199 + p.getRose() * 299;
			
			show = show + "訂單編號:" + p.getOrder_no() +
					"\t客戶名稱:" + p.getName() +
					"\t收件人名稱:" + p.getRecipient() +
					"\t訂單日期:" + p.getOrder_date() +
					"\t送貨日期:" + p.getDelivery_date() +
					"\t吉他:" + p.getLavender() +
					"\t貝斯:" + p.getBabysbreath() +
					"\t鼓:" + p.getRose() +
					"\t金額:" + sum + "元\n";
		}
		
		return show;
	}

	@Override
	public List<Porder> findAllPorder() {
		return porderdaoimpl.selectAll();
	}

	@Override
	public Porder findByOrderNo(String orderno) {
		Porder porder = null;
		if (orderno != null) {
			List<Porder> l = porderdaoimpl.selectByOrderNo(orderno);
			if (l.size() > 0) {
				porder = l.get(0);
			}
		}
		return porder;
	}

	@Override
	public String findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePorder(String name, String orderno) {
		Porder p = findByOrderNo(orderno);
		p.setName(name);
		porderdaoimpl.update(p);
		
	}

	@Override
	public void updatePorder(String recipient, String delivery_date, int lavender, int babysbreath, int rose,
			String orderno) {
		Porder p = findByOrderNo(orderno);
		p.setDelivery_date(delivery_date);
		p.setRecipient(recipient);
		p.setLavender(lavender);
		p.setBabysbreath(babysbreath);
		p.setRose(rose);
		porderdaoimpl.update(p);
		
	}

	@Override
	public void updtaePorder(Porder porder) {
		Porder p = findByOrderNo(porder.getOrder_no());
		
	}

	@Override
	public void deletePorderByOrderNo(String orderno) {
		if (orderno != null) {
			porderdaoimpl.delete(orderno);
		}
		
	}

	@Override
	public void updatePorder(Porder porder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Porder> findOrdersByName(String name) {
		List<Porder> orders = porderdaoimpl.selectByName(name);
		return orders;
	}

	
}
