package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. 어떤 데이터베이스에 연결할지를 String으로 작성
        String connectionString = "jdbc:sqlite:db.sqlite";

        // 2. 해당 데이터베이스에 연결
        try(Connection connection = DriverManager.getConnection(connectionString)) {
            System.out.println("Connection Success!");

            // 3. 데이터베이스 연결 객체로부터 Statement 객체를 받는다
            Statement statement = connection.createStatement();
            // 4. excute를 이용한 간단한 SQL 문을 사용한다
            statement.execute("""
            DROP TABLE IF EXISTS user;
            """);
            statement.execute("""
            CREATE TABLE user(
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                username TEXT,
                password TEXT,
                first_name TEXT,
                last_name TEXT,
                email TEXT
            );
            """);
            // 서로 다른 사용자 계정 3개 입력
            statement.execute("""
                INSERT INTO user(username, password, first_name, last_name, email)
                VALUES ('Alex', 'aaaa', 'Alex', 'Rod', 'a-rod@gmail.com');
            """);
            statement.execute("""
                INSERT INTO user(username, password, first_name, last_name, email)
                VALUES ('Brad', 'bbbb', 'Brad', 'Snyder', 'brad@gmail.com');
            """);
            statement.execute("""
                INSERT INTO user(username, password, first_name, last_name, email)
                VALUES ('Chad', 'cccc', 'Chad', 'Bradford', 'moneyball@gmail.com');
            """);

            String insertSql = """
                INSERT INTO user(username, password, first_name, last_name, email)
                VALUES ('%s', '%s', 'Chad', 'Bradford', 'moneyball@gmail.com');
            """;
            Scanner scanner = new Scanner(System.in);
            String username = scanner.nextLine();
            String password = scanner.nextLine();
            insertSql = String.format(insertSql, username, password);
            statement.execute(insertSql);

            // SELECT
            String selectSql = """
            SELECT * FROM user WHERE id = 1;
            """;
             // 조회하는 쿼리는 ResultSet으로 데이터를 받음
            // ResultSet은 결과 테이블을 살펴볼 수 있게 도와주는 인터페이스
            ResultSet resultSet = statement.executeQuery(selectSql);
            if (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
                System.out.println(resultSet.getString("first_name"));
                System.out.println(resultSet.getString("email"));
            } else {
                System.out.println("Could not Found");
            }
            // 다음 줄이 없으면 next()는 false를 반환
            selectSql = """
            SELECT * FROM user;
            """;
            resultSet = statement.executeQuery(selectSql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
                System.out.println(resultSet.getString("first_name"));
                System.out.println(resultSet.getString("email"));
            }

            String updateSql = """
                UPDATE user
                SET first_name = 'Alexander'
                WHERE id = 1;
            """;

            // executeUpdate는 내가 실행한 SQL문의 결과로 바뀐 줄의 갯수를 반환한다
            int rows = statement.executeUpdate(updateSql);
            System.out.println("rows affected: " + rows);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}