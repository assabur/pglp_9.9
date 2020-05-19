package DAO;

import java.sql.Connection;

public class DaoFActory {

	private final static Connection conn=ConnectionDerby.connection();
		/**
		 * Retourne le DAO des Triangles
		 * @return DAOTriagle
		 */
		public static DaoTriangle getTriangleDAO(String variable){
			return new DaoTriangle(conn,variable);
		}
		
		public static DaoComposite getCompositePerso(){
			return new DaoComposite(conn);
		}
		
		/**
		 * Retourne le DAO des cercles
		 * @return DaoCercle
		 */
		public static DaoCercle getCerlcleDAO(){
			System.out.println(" entrer dans get cercleDAO");
			return new DaoCercle(conn);
		}

		/**
		 * Retourne le DAO des Rectangles
		 * @return DaoRectangle
		 */
		public static DaoRectangle getRectangleDAO(String variable){
			return new DaoRectangle(conn,variable);
	
	}

}
