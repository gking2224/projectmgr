package demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

public class TestDataExtractor {
    
    public static void main(String[] args)
            throws ClassNotFoundException, SQLException, FileNotFoundException,
            IOException, DatabaseUnitException {
    Class.forName("com.mysql.jdbc.Driver");
     
    Connection jdbcConnection = DriverManager.getConnection(
            "jdbc:mysql://localhost/demo", "gk", "gkd3m0");
    IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);
     
    QueryDataSet partialDataSet = new QueryDataSet(connection);
     
    // Mention all the tables here for which you want data to be extracted
    // take note of the order to prevent FK constraint violation when re-inserting
    partialDataSet.addTable("roletype");
    partialDataSet.addTable("rolesubtype");
    partialDataSet.addTable("orgunit");
    partialDataSet.addTable("project");
    partialDataSet.addTable("budget");
    partialDataSet.addTable("resource");
    partialDataSet.addTable("forecast");
     
    // XML file into which data needs to be extracted
    FlatXmlDataSet.write(partialDataSet, new FileOutputStream("src/test/resources/test-dataset_temp.xml"));
    System.out.println("Dataset written");
    }
}
