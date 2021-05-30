package com.example.bands.data;

import com.example.bands.config.DBConnection;
import com.example.bands.models.Band;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BandDAO implements DAO<Band> {

    @Override
    public List<Band> getAll() {
        List<Band> list = new ArrayList<>();
        try(Connection connection = DBConnection.getConnection()){
            ResultSet rs = connection.createStatement().executeQuery("select * from bands");
            while(rs.next()){
                Band tmp = new Band(rs.getInt(1),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getString(4),
                                    rs.getInt(5));
                list.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Band getById(int id) {
        Band b = null;
        try(Connection connection = DBConnection.getConnection()){
            ResultSet rs = connection.createStatement()
                            .executeQuery("select * from bands b where b.id = " + id);
            if(rs.next()){
                b = new Band(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5));
            }
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
        return b;
    }

    @Override
    public void save(Band instance) {
        String sql = String.format("exec add_band @name = '%s', @country = '%s', @genre = '%s', @year = %d",
                instance.getName(),
                instance.getCountry(),
                instance.getGenre(),
                instance.getYear());
        try(Connection connection = DBConnection.getConnection()){
            connection.createStatement()
                    .execute(sql);
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Band instance) {
        String sql = String.format("exec update_band @id = %d, @name = '%s', @country = '%s', @genre = '%s', @year = %d",
                instance.getId(),
                instance.getName(),
                instance.getCountry(),
                instance.getGenre(),
                instance.getYear());
        try(Connection connection = DBConnection.getConnection()){
            connection.createStatement()
                    .execute(sql);
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void delete(Band instance) {
        String sql = String.format("exec del_band @id = %d",
                instance.getId());
        try(Connection connection = DBConnection.getConnection()){
            connection.createStatement()
                    .execute(sql);
        }
        catch(SQLException exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = String.format("exec del_band @id = %d",
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
