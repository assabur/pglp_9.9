package DAO;

import java.sql.Connection;

public class DaoFActory {

	private final static Connection conn=ConnectionDerby.connection();
	//ConnectionDerby.connection();
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
			//System.out.println(" entrer dans get cercleDAO");
			return new DaoCercle(conn);
		}

		/**
		 * Retourne le DAO des Rectangles
		 * @return DaoRectangle
		 */
		public static DaoRectangle getRectangleDAO(){
			return new DaoRectangle(conn);
	
	}
		/**
		 * Retourne le DAO des carre
		 * @return DaoRectangle
		 */
		public static DaoCarre getCarreDAO(){
			return new DaoCarre(conn);
	
	}

}
