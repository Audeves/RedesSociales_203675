/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.List;
import persistencia.ConnectionFactory;

/**
 *
 * @author Luis
 */
public abstract class BaseRepository <T>{
    
    private final ConnectionFactory connectionFactory;

    public BaseRepository(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }
   
    public abstract T find(int id) throws Exception;
    
    public abstract List<T> getAll() throws Exception;
    
    public abstract List<T> getAllWith(String referencia) throws Exception;
    
    public abstract void add(T objeto) throws Exception;
    
    public abstract void update(T objeto) throws Exception;
    
    public abstract void delete(int id) throws Exception;

    public ConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }
    
    
}
