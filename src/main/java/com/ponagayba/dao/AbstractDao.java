package com.ponagayba.dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractDao implements AutoCloseable {

    protected final Connection connection;

    public AbstractDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
