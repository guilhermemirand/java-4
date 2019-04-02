package challenge;

import java.sql.*;

public class QuoteDao {

	private Quote executeQueryToGetOne(PreparedStatement preparedStatement) throws  SQLException {
		Quote quote = null;
		try (ResultSet resultSet = preparedStatement.executeQuery()) {
			if (resultSet.next()) {
				quote = new Quote();
				quote.setActor(resultSet.getString("actor"));
				quote.setQuote(resultSet.getString("detail"));
			}
		}
		return quote;
	}

	public Quote getQuote() throws SQLException {
		Quote quote = null;
		String sql = "SELECT * FROM scripts WHERE actor is not null ORDER BY random() LIMIT 1";
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
			quote = this.executeQueryToGetOne(preparedStatement);
		}
		return quote;
	}

	public Quote getQuoteByActor(String actor) throws SQLException {
		Quote quote = null;
		String sql = "SELECT * FROM scripts WHERE actor = ? ORDER BY random() LIMIT 1";
		try (Connection conn = ConnectionFactory.createConnection();
			 PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
			preparedStatement.setString(1, actor);
			quote = this.executeQueryToGetOne(preparedStatement);
		}
		return quote;
	}

}
