package DAO;

import java.sql.Connection;

public class DaoFActory {

	private final static Connection conn=ConnectionDerby.connection();
		/**
		 * Retourne le DAO des Triangles
		 * @return DAOTriagle
		 */
		public static DaoTriangle getTriangleDAO(){
			return new DaoTriangle(conn);
		}
		
		public static DaoComposite getCompositePerso(){
			return new DaoComposite(conn);
		}
		
		/**
		 * Retourne le DAO des cercles
		 * @return DaoCercle
		 */
		public static DaoCercle getCerlcleDAO(){
			return new DaoCercle(conn);
		}

		/**
		 * Retourne le DAO des Rectangles
		 * @return DaoRectangle
		 */
		public static DaoRectangle getRectangleDAO(){
			return new DaoRectangle(conn);
	

		
	}

}
