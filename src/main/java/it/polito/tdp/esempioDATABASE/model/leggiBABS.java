package it.polito.tdp.esempioDATABASE.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class leggiBABS {
	public static void main (String args[])
	{
		leggiBABS babs=new leggiBABS();
		babs.run();
	}
	
	public void run()
	{
		String jdbcURL="jdbc:mariadb://localhost/babs?user=root&password=12Marco1998";
		try 
		{
			Connection conn=DriverManager.getConnection(jdbcURL);
			String sql="SELECT name FROM station WHERE landmark= ? ";
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1, "Palo Alto");
			ResultSet res=st.executeQuery();
			while(res.next())
			{
				String nomeStazione=res.getString("name");
				System.out.println(nomeStazione);
			}
			conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
