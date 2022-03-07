package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Entity.BookInformation;
import Utility.SQLHelper;

import static Utility.SQLHelper.getConnection;

import Exception.ExistException;

public class BookInformationDao {
    static Connection connection  = null;
    static PreparedStatement pStatement = null;
    static ResultSet rSet = null;
	static int result = 0;
    
    public static ResultSet queryBooksById(int Bid) {
        connection = getConnection();
        String sqlString = "select * from BookInformation where Bid = ?";
        try {
			pStatement = connection.prepareStatement(sqlString);
			pStatement.setInt(1, Bid);
			rSet = pStatement.executeQuery();
			return rSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return rSet;
    }


    public static ResultSet queryBooksByName(String BName) {
        connection = getConnection();
        String sqlString = "select * from BookInformation where Bname like ?";
        try {
			pStatement = connection.prepareStatement(sqlString);
			pStatement.setString(1, "%" + BName + "%");
			rSet = pStatement.executeQuery();
			return rSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return rSet;
    }
    public static ResultSet queryBooksByDate(Date BinDate) {
        connection = getConnection();
        String sqlString = "select * from BookInformation where BinDate like ?";
        try {
			pStatement = connection.prepareStatement(sqlString);
			pStatement.setDate(1, BinDate);
			rSet = pStatement.executeQuery();
			return rSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return rSet;
    }
    public static ResultSet queryBooksByReaderName1(String BreaderName) {
    	connection = getConnection();
    	String sqlString = "select * from BookInformation where BreaderName = ?";
    	try {
			pStatement = connection.prepareStatement(sqlString);
			pStatement.setString(1, BreaderName);
			rSet = pStatement.executeQuery();
			return rSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return rSet;
    }
    public static ResultSet queryBooksByReaderName2(String BreaderName) {
    	connection = getConnection();
    	String sqlString = "select * from BookInformation where BreaderName = ? and Bstatus = 0";
    	try {
			pStatement = connection.prepareStatement(sqlString);
			pStatement.setString(1, BreaderName);
			rSet = pStatement.executeQuery();
			return rSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return rSet;
    }
    public static ResultSet queryBooksByReaderName3(String BreaderName) {
    	connection = getConnection();
    	String sqlString = "select * from BookInformation where BreaderName = ? and Bstatus = 1";
    	try {
			pStatement = connection.prepareStatement(sqlString);
			pStatement.setString(1, BreaderName);
			rSet = pStatement.executeQuery();
			return rSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return rSet;
    }
    public static ResultSet queryBooks() {
		try {
			connection = getConnection();
			
			String sql = "select * from bookinformation";
			pStatement = connection.prepareStatement(sql); 
													
			rSet = pStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rSet;
	}
	public static ResultSet queryTable() {
		try {
			connection = getConnection();

			String query = "select * from bookinformation";
			pStatement = connection.prepareStatement(query,
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);

			rSet = pStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rSet;
	}

	public static int insertTable(BookInformation bookInformation) {
		try {
			connection = SQLHelper.getConnection();

			String insert = "insert into bookinformation values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pStatement = connection.prepareStatement(insert);

			pStatement.setInt(1, bookInformation.getBid());
			pStatement.setString(2, bookInformation.getBname());
			pStatement.setInt(3, bookInformation.getBnumber());
			pStatement.setString(4, bookInformation.getBwriter());
			pStatement.setString(5, bookInformation.getBpublish());
			pStatement.setString(6, bookInformation.getBposition());
			pStatement.setString(7, bookInformation.getBstatus());
			pStatement.setInt(8, bookInformation.getBreaderID());
			pStatement.setString(9, bookInformation.getBinDate());
			pStatement.setDate(10, bookInformation.getBborrowDate());
			pStatement.setDate(11, bookInformation.getBreturnDate());



			return pStatement.executeUpdate();
		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println(e.getErrorCode());
//			System.out.println(e.getSQLState());

			if (e.getSQLState().equals("23000")) {
				throw new ExistException();
			}

			return 0;
		}
	}

	public static int deleteTable(BookInformation bookInformation) {
		try {
			getConnection();

			String delete = "delete from bookinformation where bid=?;";

			pStatement = connection.prepareStatement(delete);

			pStatement.setInt(1, bookInformation.getBid());

			return pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

			return 0;
		} finally {
			if (pStatement != null) {
				try {
					pStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static int updateTable(BookInformation bookInformation) {
		try {
			getConnection();

			String update = "update bookinformation set BNAME=?,BNUMBER=?,BWRITER=?,BOOKPUBLISH=?,BPOSITION=?,BSTATUS=?,BREADERNAME=?,BINDATE=?,BBORROWDATE=?,BRETURNDATE=? where BID = ?";

			pStatement = connection.prepareStatement(update);

			pStatement.setString(1, bookInformation.getBname());
			pStatement.setInt(2, bookInformation.getBnumber());
			pStatement.setString(3, bookInformation.getBwriter());
			pStatement.setString(4, bookInformation.getBpublish());
			pStatement.setString(5, bookInformation.getBposition());
			pStatement.setString(6, bookInformation.getBstatus());
			pStatement.setInt(7, bookInformation.getBreaderID());
			pStatement.setString(8, bookInformation.getBinDate());
			pStatement.setDate(9, bookInformation.getBborrowDate());
			pStatement.setDate(10, bookInformation.getBreturnDate());
			pStatement.setInt(11, bookInformation.getBid());


			return pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

			return 0;
		} finally {
			if (pStatement != null) {
				try {
					pStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void bnumber() {
		try {
			getConnection();
			String findnumber = "select  count(*)  as number , Bname from bookinformation group by BNAME";
			pStatement = connection.prepareStatement(findnumber);
			ResultSet rs = pStatement.executeQuery();
			while(rs.next()) {
				int number = rs.getInt("number");
				String name = rs.getString("Bname");
				setNumber(number, name);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void setNumber(int number, String name) {
		try {
			getConnection();
			String sql = "update bookinformation set BNUMBER = ? where Bname = ?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, number);
			pStatement.setString(2, name);
			pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static ResultSet ReaderQueryTable() {
		try {
			getConnection();

			String query = "select * from BookInformation ";
			pStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rSet = pStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rSet;
	}

	public static ResultSet ReaderQueryTable1(String Bwriter1, String Bname1) {
		try {
			getConnection();

			String query1 = "select * from BookInformation where Bname like ? and Bwriter like ?;";
			pStatement = connection.prepareStatement(query1, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			pStatement.setString(1, '%' + Bname1 + '%');
			pStatement.setString(2, '%' + Bwriter1 + '%');

			rSet = pStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rSet;

	}

	public static ResultSet ReaderQueryTable2(String Bwriter2) {
		try {
			getConnection();

			String query2 = "select * from BookInformation where Bname like ?;";
			pStatement = connection.prepareStatement(query2, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			pStatement.setString(1, '%' + Bwriter2 + '%');
			rSet = pStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rSet;
	}

	public static ResultSet ReaderQueryTable3(String Bname3) {
		try {
			getConnection();

			String query3 = "select * from BookInformation where Bwriter like ?;";
			pStatement = connection.prepareStatement(query3, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			pStatement.setString(1, '%' + Bname3 + '%');
			rSet = pStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rSet;
	}

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");



	public static int BorrowBook(BookInformation bookinformation) {
		try {
			getConnection();
			/// ???
			String borrow = "update BookInformation set Bstatus=?,Bnumber=?,BborrowDate=?,BreturnDate=?,BreaderName = ? where Bid=? ";
			pStatement = connection.prepareStatement(borrow);
			pStatement.setString(1, bookinformation.getBstatus());
			pStatement.setInt(2, bookinformation.getBnumber());
			pStatement.setDate(3, bookinformation.getBborrowDate());
			pStatement.setDate(4, bookinformation.getBreturnDate());/// ????
			pStatement.setInt(5, bookinformation.getBreaderID());
			pStatement.setInt(6, bookinformation.getBid());
			return pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}


	public static int ReturnBook(BookInformation bookinformation) {
		try {
			getConnection();

			String back = "update BookInformation set Bstatus=?,Bnumber=?,BreturnDate=?,BreaderName=? where Bid=? ";
			pStatement = connection.prepareStatement(back);
			pStatement.setString(1, bookinformation.getBstatus());
			pStatement.setInt(2, bookinformation.getBnumber());
			pStatement.setDate(3, bookinformation.getBreturnDate());/// ????
			pStatement.setInt(4, bookinformation.getBreaderID());
			pStatement.setInt(5, bookinformation.getBid());
			return pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int IfBorrowReader(int id) { //// ????/!!!!1
		try {
			getConnection();

			String ifnotreader = "select BreaderID from BookInformation where Bid=?";
			pStatement = connection.prepareStatement(ifnotreader);
			pStatement.setInt(1, id);
			ResultSet resultSet = pStatement.executeQuery();
			if (resultSet.next()) {
				int bidnew = resultSet.getInt(1);
				return bidnew;
			}else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	public static String Ifnotcan(int id) { //// ????/!!!!1
		try {
			getConnection();

			String ifnotcan = "select Bstatus from BookInformation where Bid=?";
			pStatement = connection.prepareStatement(ifnotcan);
			pStatement.setInt(1, id);
			ResultSet resultSet = pStatement.executeQuery();
			if (resultSet.next()) {
				String can = resultSet.getString(1);
				System.out.println(can);
				return can;
			}else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static LocalDateTime Bookreturnneed(int id) {
		try {
			getConnection();

			String need = "select BborrowDate from BookInformation where Bid=? ";
			pStatement = connection.prepareStatement(need);
			pStatement.setInt(1, id);

			ResultSet resultSet = pStatement.executeQuery();
			if (resultSet.next()) {
				Date dateString = resultSet.getDate(1);
				return LocalDateTime.parse(dateString.toString() + "T00:00:00");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int queryBooksNumberInLibrary1(int Bid) {
		try {
			getConnection();
			int result = 0;

			ResultSet rs = queryBooksById(Bid);
			String sqlString = "select * from BookInformation where Bname = ? and Bstatus = '未借阅'";
			String name = null;

			if (rs.next()) {
				name = rs.getString("Bname");
			}
			pStatement = connection.prepareStatement(sqlString);
			pStatement.setString(1,name);
			rSet = pStatement.executeQuery();
			while(rSet.next()) {
				result ++ ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static int queryBooksNumberInLibrary2(String Bname) {
		try {
			getConnection();
			int result = 0;

			String sqlString = "select * from BookInformation where Bname like ? and Bstatus = '未借阅'";
			pStatement = connection.prepareStatement(sqlString);
			pStatement.setString(1,"%" + Bname + "%");
			rSet = pStatement.executeQuery();
			while(rSet.next()) {
				result ++ ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
