package com.example.java5.service.impl;

import com.example.java5.model.Item;
import com.example.java5.service.ShoppingCartService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	Map<Integer, Item> map = new HashMap<>();

	@Override
	public Item add(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
	}

	@Override
	public Item update(Integer id, int qty) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
	}

	@Override
	public Collection<Item> getItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getAmount() {
		// TODO Auto-generated method stub
		return 0;
	}
}
