package com.gc.util;


import com.gc.entity.Manager;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;



import javax.sql.DataSource;
import java.sql.*;

public class JDBCTools {
    private static DataSource dataSource;
    static  {
        dataSource = new ComboPooledDataSource("testc3p0");
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return connection;
    }

    public static void release(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if(connection != null) {
                connection.close();
            }
            if(statement != null) {
                statement.close();
            }
            if(resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {

            connection = dataSource.getConnection();
            String sql = "select * from manager";
            QueryRunner queryRunner = new QueryRunner();
            Manager manager = null;
            statement = connection.prepareStatement(sql);
             resultSet = statement.executeQuery();
            while(resultSet.next()) {
                manager = new Manager(resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                );
            }
            System.out.println(manager);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection, statement, resultSet);
        }
        System.out.println(connection);

    }
}
