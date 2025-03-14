package org.codenova.spring.repository;

import lombok.AllArgsConstructor;
import org.codenova.spring.model.Drama;
import org.codenova.spring.model.Movie;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class DramaRepository {

    /*
      executeUpdate() 를 해야되는 작업 : insert, update, delete은 template.update()
      executeQuery() 를 해야되는 작업 : select은 template.query()
    */
    private JdbcTemplate jdbcTemplate;

    public boolean create(Drama drama) {
        String sql = "insert into movies(title, broadcaster, mainActor, release_date) values(?,?,?,?)";

        int r = jdbcTemplate.update(sql,
                drama.getTitle(), drama.getBroadcaster(), drama.getMainActor(), drama.getReleaseDate());

        return r > 0 ? true : false;
    }

    public List<Drama> findAll() {
        String sql = "select * from dramas";
        List<Drama> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Drama.class));
        return list;
    }

    public Drama findById(int id){
        String sql = "select * from dramas where id = ?";
        List<Drama> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Drama.class), id);
        return list.size() == 0 ? null : list.get(0);
    }
}