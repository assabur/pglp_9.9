package DAO;

import java.sql.Connection;
/*
 * classe DAO du projet
 */
public abstract class DAO_Figure <T> {
	
	protected Connection connect;
	public DAO_Figure(Connection connect)
	{
		this.connect=connect;
	}
	
	public abstract boolean create(T obj);
	public abstract T read(String name);
	public abstract boolean update(T obj);
	public abstract boolean delete(String name);


}
