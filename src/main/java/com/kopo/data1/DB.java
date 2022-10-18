package com.kopo.data1;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {
	
	//database 연결
	//1. open : url넣고 진행하거나 환경변수 설정해 get connection 사용
	//2. create : database별로 create문이 다르기 때문에 사용할 database 확인(primary key나 auto_increment, data type 등 다르다) 
	
	//커넥션 (null을 안잡아도 되지만 정확도 높이기 위해 넣어도 상관없다)
	private Connection connection = null;
	
	//open
	private void open() {
		try {
			//sqlite
			//String dbUrl = "jdbc:sqlite:c:/tomcat/data1.db";
			//this.connection = DriverManager.getConnection(dbUrl);

			//mysql
//			URI dbUri = new URI(System.getenv("JAWSDB_URL"));
			
//			String username = dbUri.getUserInfo().split(":")[0];
//			String password = dbUri.getUserInfo().split(":")[1];
//
//			String dbUrl = "jdbc:mysql://xvkxiq45j6xpcvdw:o8uoqq6emsom4qmc@jbb8y3dri1ywovy2.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/dx7nzd8183onvipf";
//			this.connection = DriverManager.getConnection(dbUrl, "xvkxiq45j6xpcvdw", "o8uoqq6emsom4qmc");
			
			//postgres
			URI dbUri = new URI(System.getenv("DATABASE_URL"));
			String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";
			String username = dbUri.getUserInfo().split(":")[0];
			String password = dbUri.getUserInfo().split(":")[1];

			this.connection = DriverManager.getConnection(dbUrl, username, password);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//close
	private void close() {
		try {
			if(this.connection != null) {
				this.connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//세가지 db별로 만들어야함(statement)
	//변수명 두단어 이상으로 만들기(예약어가 있을 수 있음), DB한정 : `사용해 컬럼명에 묶으면 예약어 안부딛친다.
	public boolean createTable() {
		boolean isSuccess = false;
		this.open();
		try {
			Statement statement = this.connection.createStatement();
			
			//sqlite
//			String sqlString = "CREATE TABLE user(`idx` INTEGER PRIMARY KEY AUTOINCREMENT, `type` TEXT, `id` TEXT, `password` TEXT, `name` TEXT, `phone` TEXT, `address` TEXT, `created` TEXT, `updated` TEXT)";
//			statement.execute(sqlString);
//			sqlString = "CREATE TABLE product(`idx` INTEGER PRIMARY KEY AUTOINCREMENT, `name` TEXT, `price` TEXT, `quantity` TEXT, `created` TEXT, `updated` TEXT)";
//			statement.execute(sqlString);
//			sqlString = "INSERT INTO user(`type`, `id`, `password`) VALUES('admin', 'admin', 'a1234');";
//			statement.execute(sqlString);
//			statement.close();
			
			//mysql
//			String sqlString = "CREATE TABLE user(`idx` int not null AUTO_INCREMENT PRIMARY KEY, `type` varchar(100), `id` varchar(100), `password` varchar(300), `name` varchar(100), `phone` varchar(100), `address` varchar(100), `created` datetime, `updated` datetime)";
//			statement.execute(sqlString);
//			sqlString = "CREATE TABLE product(`idx` int not null AUTO_INCREMENT PRIMARY KEY, `name` varchar(100), `price` int, `quantity` int, `created` datetime, `updated` datetime)";
//			statement.execute(sqlString);
//			sqlString = "INSERT INTO user(`type`, `id`, `password`) VALUES('admin', 'admin', 'a1234');";
//			statement.execute(sqlString);		
//			statement.close();
			
			//postgres
			String sqlString = "CREATE TABLE user(`idx` serial PRIMARY KEY, `type` varchar(100), `id` varchar(100), `password` varchar(300), `name` varchar(100), `phone` varchar(100), `address` varchar(100), `created` timestamp, `updated` timestamp)";
			statement.execute(sqlString);
			sqlString = "CREATE TABLE product(`idx` serial PRIMARY KEY, `name` varchar(100), `price` int, `quantity` int, `created` timestamp, `updated` timestamp)";
			statement.execute(sqlString);
			sqlString = "INSERT INTO user(`type`, `id`, `password`) VALUES('admin', 'admin', 'a1234');";
			statement.execute(sqlString);		
			statement.close();
			
			isSuccess = true;
		} catch (Exception e) {
			e.printStackTrace();
			isSuccess = false;
		}
		this.close();
		return isSuccess;
	}
	

}
