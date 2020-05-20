package DAO;

import java.sql.Connection;

public class DaoComposite extends DAO_Figure<DaoComposite> {

	public DaoComposite(Connection conn) {
		// TODO Auto-generated constructor stub
		super(conn);
	}

	@Override
	public boolean create(DaoComposite obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DaoComposite read(Object name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(DaoComposite obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String name) {
		// TODO Auto-generated method stub
		return false;
	}

}
