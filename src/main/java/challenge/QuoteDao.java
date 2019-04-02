package challenge;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuoteDao {

	public Quote getQuote() throws SQLException {
		Statement statement = ConnectionFactory.createConnection().createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM 'scripts' WHERE actor is not null ORDER BY random() LIMIT 1");
		Quote quote = null;
		while (resultSet.next()) {
			quote = new Quote();
			quote.setActor(resultSet.getString("actor"));
			quote.setQuote(resultSet.getString("detail"));
			System.out.println(resultSet.getString("detail"));
			System.out.println(resultSet.getString("actor"));
			System.out.println(resultSet.getInt("index"));
		}
		return quote;
	}

	public Quote getQuoteByActor(String actor) throws SQLException {
		return null;
	}

}
