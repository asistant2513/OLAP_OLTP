package com.example.bands.data;

import com.example.bands.config.DBConnection;
import com.example.bands.models.Band;
import com.example.bands.models.Member;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberDAO implements DAO<Member>{
    @Override
    public List<Member> getAll() {
        List<Member> list = new ArrayList<>();
        try(Connection connection = DBConnection.getConnection()){
            ResultSet rs = connection.createStatement().executeQuery("select * from members");
            while(rs.next()){
                Member tmp = new Member(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3));
                list.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Member getById(int id) {
        return null;
    }

    public List<Member> getAllById(int id){
        List<Member> list = new ArrayList<>();
        try(Connection connection = DBConnection.getConnection()){
            ResultSet rs = connection.createStatement().executeQuery("select * from members where band_id=" + id);
            while(rs.next()){
                Member tmp = new Member(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3));
                list.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(Member instance) {
        String sql = String.format("exec add_member @name = '%s', @b_id = '%d'",
                instance.getName(),
                instance.getBandId());
        try(Connection connection = DBConnection.getConnection()){
            connection.createStatement()
                    .execute(sql);
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Member instance) {
        String sql = String.format("exec update_member @id = %d, @name = '%s'",
                instance.getId(),
                instance.getName());
        try(Connection connection = DBConnection.getConnection()){
            connection.createStatement()
                    .execute(sql);
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void delete(Member instance) {

    }

    @Override
    public void deleteById(int id) {
        String sql = String.format("exec delete_member @id = %d",
                id);
        System.out.println(sql);
        try(Connection connection = DBConnection.getConnection()){
            connection.createStatement()
                    .execute(sql);
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
    }
}
