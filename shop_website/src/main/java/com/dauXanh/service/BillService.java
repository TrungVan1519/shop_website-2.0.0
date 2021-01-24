package com.dauXanh.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dauXanh.dao.BillDAO;
import com.dauXanh.dto.Page;
import com.dauXanh.entity.Bill;

@Service
@Transactional
public class BillService {

	@Autowired
	BillDAO<Bill> billDAO;

	public List<Bill> findAll(Page page) throws Exception {
		return billDAO.findAll(null, null, page);
	}

	public Bill findById(int id) throws Exception {
		return billDAO.findById(Bill.class, id);
	}

	public boolean save(Bill bill) throws Exception {
		bill.setCreatedAt(new Date());
		bill.setUpdatedAt(new Date());

		return billDAO.save(bill);
	}

	public boolean update(Bill bill) throws Exception {
		bill.setCreatedAt(bill.getCreatedAt());
		bill.setUpdatedAt(new Date());

		return billDAO.update(bill);
	}

	public boolean deleteById(int id) {
		return billDAO.deleteById(Bill.class, id);
	}
}
