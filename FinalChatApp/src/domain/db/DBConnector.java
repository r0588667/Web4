package domain.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector {
	private Connection connection;
	private volatile static DBConnector uniqueinstance;
	private DBConnector(Properties properties){
		init(properties);
	}
	public static DBConnector getInstance(Properties properties){
		if(uniqueinstance == null){
			synchronized (DBConnector.class) {
				if(uniqueinstance == null){
					uniqueinstance = new DBConnector(properties);
				}
			}
		}
		return uniqueinstance;
	}
	
	private void init(Properties properties) throws DBException{
		String url = properties.getProperty("url");
		try{
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url,properties);

			}
		catch(SQLException e){
			throw new DBException(e.getLocalizedMessage());
		}
		catch(ClassNotFoundException e){
			throw new DBException(e.getLocalizedMessage());
		}
	}
	public Connection getConnection(){
		return connection;
	}
	public void setConnection(Connection connection){
		this.connection = connection;
	}
	public void closeConnection(){
	try{
		connection.close();
	}
	catch(Exception e){
		e.printStackTrace();
	}
	}

}
