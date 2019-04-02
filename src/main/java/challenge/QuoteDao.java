package challenge;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuoteDao {

	public Quote getQuote() throws SQLException {
		Statement statement = ConnectionFactory.createConnection().createStatement();
		ResultSet resultSet = statement.executeQuery("select * from scripts");
		this.writeMetaData(resultSet);
		return null;
	}

	private void writeMetaData(ResultSet resultSet) throws SQLException {
		//  Now get some metadata from the database
		// Result set get the result of the SQL query

		System.out.println("The columns in the table are: ");

		System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
		for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
			System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
		}
	}

	public Quote getQuoteByActor(String actor) throws SQLException {
		return null;
	}

}
