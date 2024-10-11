package org.example.demo.dao;

// User Dao (data access object) 는 db의 데이터에 접근하기 위한 객체

import org.example.demo.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo_db"; // demo_db 커넥터 이름
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    private static final String INSERT_USERS_SQL = "INSERT INTO users (name, email, country) VALUES(?,?,?)";
    // static 클래스안에서 정적
    // final 상수 ( 대문자 )
    // private 접근 제어자
    //crud
    private static final String SELECT_USERS_BY_ID = "SELECT id, name, email, country FROM users WHERE id = ?";
    private static final String SELECT_ALL_USERS = "SELECT * FROM users";
    private static final String DELETE_USERS_SQL = "DELETE FROM users WHERE id = ?";
    private static final String UPDATE_USERS_SQL = "UPDATE users SET name = ?, email = ?, country = ? WHERE id = ?";

    // 빈 생성자 만들기
    public  UserDao () {}

    // DB 연결
    protected Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // crud 실행
    // 1. create
    public void insertUser(User user) throws SQLException {
        try (Connection conn = getConnection();
            // preparedStatement 객체를 통해 sql 에 데이터를 바인딩
            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_USERS_SQL)) {
            // 3개의 물음표가 있었다
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            // 쿼리문 실행
            preparedStatement.executeUpdate();

        }
    }
    public User selectUser(int id) throws SQLException {
        User user = null; // 조회한 사용자 정보를 저장할 객체
        try (Connection conn = getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(SELECT_USERS_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery(); // 쿼리 실행 후 결과 집합을 반환해줄꺼

            // 결과 집합에서 데이터가 존재하면 사용자 객체를 생성시켜 줄것이다.
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country); // 라벨로 하나씩 뜰고와서 담아주고
            }

        }
        return user; // 담은걸 반환시켜줄것이다. 조회된 사용자 반환 (없으면 null)
    }
    // 3.
    public List<User> selectAllUsers() throws SQLException {
        List<User> users = new ArrayList<>(); // 사용자 목록을 저장할 리스트

        try (Connection conn = getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(SELECT_USERS_BY_ID)) {
            ResultSet rs = preparedStatement.executeQuery(); // 쿼리 실행 후 결과 집합을 반환해줄꺼

        // 결과 집합에서 데이터가 존재하면 사용자 객체를 생성시켜 줄것이다.
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String country = rs.getString("country");
            users.add(new User(id, name, email, country));
        }

    }
        return users; // 담은걸 반환시켜줄것이다. 조회된 사용자 반환 (없으면 null)
    }

    // 4. Update
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated; // 업데이트 여부 확인
        try (Connection conn = getConnection();
             // preparedStatement 객체를 통해 sql 에 데이터를 바인딩
             PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_USERS_SQL)) {
            // 3개의 물음표가 있었다
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getId());
            // executeupdate() 메서드를 사용해 sql 실행 및 수정된 행 수 반환
            rowUpdated = preparedStatement.executeUpdate() > 0; // 행이 업데이트 된 경우 true를 반환
        }
        return rowUpdated; // 반환
    }

    // 5. delete
    public boolean deleteUserById(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection conn = getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(DELETE_USERS_SQL)) {
            preparedStatement.setInt(1, id);

            // 몇개에 행에 대하여 영향을 미쳤는지
            rowDeleted = preparedStatement.executeUpdate() > 0;

        }
        return rowDeleted;
    }
}
