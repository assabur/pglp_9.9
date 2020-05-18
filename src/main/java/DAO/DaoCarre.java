package DAO;

import java.sql.Connection;

import Formes.Carre;

public class DaoCarre extends DAO_Figure<Carre>{

	public DaoCarre(Connection conn) {
		// TODO Auto-generated constructor stub
		super(conn);
	}

	@Override
	public boolean create(Carre obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Carre read(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Carre obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String name) {
		// TODO Auto-generated method stub
		return false;
	}

}
