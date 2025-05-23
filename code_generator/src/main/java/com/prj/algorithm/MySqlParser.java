package com.prj.algorithm;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class MySqlParser {
    public static List<DbTableDefinition> parse(String host, int port, String user, String password, String database) {
        List<DbTableDefinition> tables = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = String.format("jdbc:mysql://%s:%d/%s?serverTimezone=Asia/Shanghai", host, port, database);
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                DatabaseMetaData metaData = conn.getMetaData();
                ResultSet rs = metaData.getTables(database, null, "%", new String[]{"TABLE"});
                while (rs.next()) {
                    String tableName = rs.getString("TABLE_NAME");
                    DbTableDefinition table = new DbTableDefinition();
                    table.setName(tableName);
                    ResultSet columns = metaData.getColumns(database, null, tableName, "%");
                    List<DbColumnDefinition> columnList = new ArrayList<>();
                    while (columns.next()) {
                        DbColumnDefinition column = new DbColumnDefinition();
                        column.setName(columns.getString("COLUMN_NAME"));
                        column.setType(columns.getString("TYPE_NAME"));
                        column.setLength(columns.getInt("COLUMN_SIZE"));
                        column.setScale(columns.getInt("DECIMAL_DIGITS"));
                        column.setIsNullable("YES".equals(columns.getString("IS_NULLABLE")));
                        column.setDefaultValue(columns.getString("COLUMN_DEF"));
                        ResultSet primaryKeys = metaData.getPrimaryKeys(database, null, tableName);
                        while (primaryKeys.next()) {
                            if (column.getName().equals(primaryKeys.getString("COLUMN_NAME"))) {
                                column.setIsPrimaryKey(true);
                                break;
                            }
                        }
                        primaryKeys.close();
                        columnList.add(column);
                    }
                    columns.close();
                    table.setColumns(columnList);
                    tables.add(table);
                }
                rs.close();
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL驱动加载失败", e);
        } catch (SQLException e) {
            throw new RuntimeException("数据库连接或查询失败", e);
        }
        return tables;
    }
    public static void main(String[] args) {
        List<DbTableDefinition> tables = parse("localhost", 3306, "root", "root", "code_generator");
        for(DbTableDefinition table : tables){
            System.out.println(table.getName() + " " + table.getPascalCaseName());
            for(DbColumnDefinition column : table.getColumns()){
                System.out.println(column.getName() + " " + column.getPascalCaseName() + " " + column.getType() + " " + column.getLength() + " " + column.getScale() + " " + column.getIsNullable() + " " + column.getDefaultValue() + " " + column.getIsPrimaryKey());
            }
        }
    }
}
