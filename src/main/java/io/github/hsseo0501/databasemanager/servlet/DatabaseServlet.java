package io.github.hsseo0501.databasemanager.servlet;

import io.github.hsseo0501.databasemanager.service.ConnectionService;
import io.github.hsseo0501.databasemanager.util.DatabaseUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

@WebServlet("/database")
public class DatabaseServlet extends HttpServlet {

    @Autowired
    ConnectionService connectionService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = null;

        try {
            String vendor = request.getParameter("vendor").trim();
            String url = request.getParameter("url").trim();
            String id = request.getParameter("id").trim();
            String password = request.getParameter("password").trim();
            String query = request.getParameter("query").trim();

            connection = connectionService.getConnection(vendor, url, id, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            printResultSet(response, resultSet);
        } catch (Exception e) {
            printError(response, e.getMessage());
        } finally {
            DatabaseUtil.close(resultSet);
            DatabaseUtil.close(statement);
            DatabaseUtil.close(connection);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    private void printResultSet(HttpServletResponse response, ResultSet resultSet) throws Exception {
        PrintWriter out = response.getWriter();
        StringBuffer buffer = new StringBuffer();

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();

        buffer.append("<html><body><table border=1 cellspacing=0 cellpadding=0>");

        buffer.append("<TR>");
        for (int i = 1; i <= columnCount; i++) {
            buffer.append("<TH>")
                    .append(resultSetMetaData.getColumnName(i))
                    .append("(type: " + resultSetMetaData.getColumnTypeName(i) + ")")
                    .append("</TH>");
        }
        buffer.append("</TR>");

        while (resultSet.next()) {
            buffer.append("<TR>");
            for (int i = 1; i <= columnCount; i++) {
                buffer.append("<TH>");
                buffer.append(resultSet.getObject(i));
                buffer.append("</TH>");
            }
            buffer.append("</TR>");
        }

        buffer.append("</table></body></html>");
        out.println(buffer.toString());
    }

    private void printError(HttpServletResponse response, String message) {
        try {
            PrintWriter out = response.getWriter();
            StringBuffer buffer = new StringBuffer();
            buffer.append("<html><body>");
            buffer.append(message);
            buffer.append("</body></html>");
            out.println(buffer);
        } catch (Exception ignore) {
        }
    }

}
