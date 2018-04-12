package backEnd;

/**
 * Provides the constant variables required for creating a connection with MySQL.
 * 
 * @author Rainer Lim and Thomas Vy
 * @version 1.0
 * @since April 3, 2018
 *
 */
public interface ConnectionConstants {
	/**
	 * Connection information for the database.
	 */
	public final String connectionInfo = "jdbc:mysql://localhost:3306/MoshirBase";
	/**
	 * The Data base name.
	 */
	public final String databaseName = "MoshirBase";

}
