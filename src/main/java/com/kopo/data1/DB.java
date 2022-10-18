package com.kopo.data1;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {
	
	//database 연결
	//1. open : url넣고 진행하거나 환경변수 설정해 get connection 사용 (환경변수는 헤로쿠 업로드 후에 사용가능, 처음부터 환경변수 잡으면 null point)
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
//			URI jdbUri = new URI(System.getenv("JAWSDB_URL"));
//			
//		    String username = jdbUri.getUserInfo().split(":")[0];
//		    String password = jdbUri.getUserInfo().split(":")[1];
//		    String port = String.valueOf(jdbUri.getPort());
//		    String dbUrl = "jdbc:mysql://" + jdbUri.getHost() + ":" + port + jdbUri.getPath();
//		    
//		    this.connection = DriverManager.getConnection(dbUrl, username, password);
			
//			String dbUrl = "jdbc:mysql://jbb8y3dri1ywovy2.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/dx7nzd8183onvipf";		
//			this.connection = DriverManager.getConnection(dbUrl, "wpgysegsiwavtg", "20ac82850bd0f1a19506999d18d5b2226840c42cdba8a2d2e267683d097e8f95");
			
			//postgres
//		    URI dbUri = new URI(System.getenv("DATABASE_URL"));
//
//		    String username = dbUri.getUserInfo().split(":")[0];
//		    String password = dbUri.getUserInfo().split(":")[1];
//		    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";
//
//		    Connection connection = DriverManager.getConnection(dbUrl, username, password);
			
			String dbUrl = "jdbc:postgresql://ec2-23-20-140-229.compute-1.amazonaws.com:5432/de3jk8c59btl03";		
			this.connection = DriverManager.getConnection(dbUrl, "wpgysegsiwavtg", "20ac82850bd0f1a19506999d18d5b2226840c42cdba8a2d2e267683d097e8f95");
	
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
			
			//postgres: user 테이블명 인식 못함, ` 인식 못함
			//postgres
			String sqlString = "CREATE TABLE user_table(idx SERIAL PRIMARY KEY, type varchar(100), id varchar(100), password varchar(300), name varchar(100), phone varchar(20), address varchar(100), created timestamp, updated timestamp)";			
			statement.execute(sqlString);
			sqlString = "CREATE TABLE product_table(idx SERIAL PRIMARY KEY, name varchar(100), price int, quantity int, created timestamp, updated timestamp)";
			statement.execute(sqlString);
			sqlString = "INSERT INTO user_table(type, id, password) VALUES ('admin', 'admin', 'a1234')";
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
